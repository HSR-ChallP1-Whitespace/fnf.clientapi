package com.zuehlke.carrera.stomp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zuehlke.carrera.lightstomp.ISTOMPListener;
import com.zuehlke.carrera.lightstomp.StompClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;


/**
 * Base class for Stomp connections to the relay
 */
public abstract class RelayConnection {

    protected static final String CHANNEL_PING_TEMPLATE = "/topic/clients/{id}/ping";
    protected static final String CHANNEL_PING = "/app/ping";
    protected static final ObjectMapper mapper = new ObjectMapper(); // create Json mapper once, reuse
    private static final Logger LOG = LoggerFactory.getLogger(RelayConnection.class);
    protected final String relayUrl;
    protected final String user;
    protected final String password;
    protected final String clientId;

    protected StompClient client;
    protected volatile boolean connecting = false;

    private long lastWarning = 0;


    public RelayConnection(String relayUrl, String clientId, String user, String password) {

        if (relayUrl == null) throw new IllegalArgumentException("relayUrl must not be NULL!");

        this.relayUrl = relayUrl;
        this.clientId = clientId;
        this.user = user;
        this.password = password;
    }

    /**
     * Ensures the connection to the relay server is established.
     * <p>
     * If this client is not yet connected, or the connection was lost,
     * this method will try to (re)connect to the backend.
     */
    public synchronized void ensureConnection() {

        if (connecting) {
            LOG.debug("Already trying to connect, skipping...");
            return;
        }

        if (client == null || !client.isConnected()) {
            connect();
        } else {
            LOG.debug("Already connected, everything fine.");
        }
    }

    protected abstract void connect();

    /**
     * Try to connect to the backend using a STOMP client
     *
     * @param subscribers the list of subscribers for incoming messages
     */
    protected synchronized void connect(List<ChannelSubscriber> subscribers) {
        connecting = true;
        client = null;
        try {
            LOG.info("Trying to connect to " + relayUrl + " as user " + user + " ...");

            StompClient.connectOverWebSocket(relayUrl, user, password, new ISTOMPListener() {

                @Override
                public void connectionSuccess(StompClient stompClient) {

                    LOG.info("STOMP Connected to relay server!");
                    client = stompClient;

                    String pingChannel = ParamUtil.paramUrl(CHANNEL_PING_TEMPLATE, clientId);
                    LOG.info("Subscribing to channel '" + pingChannel + "'");
                    client.subscribe(pingChannel, RelayConnection.this::onPingMessage);

                    for (ChannelSubscriber subscriber : subscribers) {
                        String channel = subscriber.getChannel();
                        LOG.info("Subscribing to channel '" + channel + "'");
                        client.subscribe(channel, subscriber.getConsumer());
                    }
                    connecting = false;
                }

                @Override
                public void connectionFailed(Throwable e) {
                    LOG.warn("Could not connect with STOMP to relay: " + e.getMessage());
                    client = null;
                    connecting = false;
                }

                @Override
                public void disconnected(String error) {
                    LOG.warn("Lost STOMP connection to relay: " + error);
                    client = null;
                    connecting = false;
                }
            });

        } catch (Throwable e) {
            LOG.error("Can not connect to relay!", e);
            client = null;
            connecting = false;
        }
    }

    private void onPingMessage(String message) {
        try {
            PingData ping = mapper.readValue(message, PingData.class);

            // We got a ping challenge. We just have to return this object.
            if (!sendObject(CHANNEL_PING, ping)) {
                LOG.warn("Failed to respond to ping challenge, sending back ping-data failed.");
            }

        } catch (IOException e) {
            LOG.error("Could not parse JSON from STOMP message: " + System.lineSeparator() + message, e);
        }
    }

    /**
     * Send the given message to the given STOMP channel
     *
     * @param channel The Stomp channel
     * @param message The message object (will be serialized into JSON)
     * @return Returns true if the STOMP message has been sent successfully
     */
    protected boolean sendObject(String channel, Object message) {
        if (channel == null) throw new IllegalArgumentException("channel must not be NULL!");
        if (message == null) throw new IllegalArgumentException("message must not be NULL!");

        StompClient myClient = client;
        if (myClient != null && myClient.isConnected()) {
            try {
                String jsonMessage = mapper.writeValueAsString(message);
                myClient.stompSend(channel, jsonMessage);
                return true;
            } catch (JsonProcessingException e) {
                LOG.error("Can not send message since JSON serialisation failed!", e);
            }
        } else {
            long now = System.currentTimeMillis();
            if (lastWarning < now - 5000) {
                LOG.warn("Can not send message to channel (" + channel + ") since no connection is available.");
            }
            lastWarning = now;
        }
        return false;
    }


}
