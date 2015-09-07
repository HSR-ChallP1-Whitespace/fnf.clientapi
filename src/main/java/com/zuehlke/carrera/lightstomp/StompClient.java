package com.zuehlke.carrera.lightstomp;

import com.zuehlke.carrera.api.client.Client;
import com.zuehlke.carrera.api.client.ClientConnectionException;
import com.zuehlke.carrera.api.client.MessageReceiver;
import com.zuehlke.carrera.lightstomp.impl.StompWebSocket;
import com.zuehlke.carrera.lightstomp.stompSocket.ISocketListener;
import com.zuehlke.carrera.lightstomp.stompSocket.IStompSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * A simple STOMP client.
 */
public class StompClient implements Client {

    private final static Logger LOG = LoggerFactory.getLogger(StompClient.class);
    private String teamId;
    private String accessCode;
    private IStompSocket socket;
    private final SubscriptionRouter subscriptionRouter = new SubscriptionRouter();
    private ISTOMPListener listener;
    private boolean isConnected = false;


    @Override
    public void connect(String url) {

        this.listener = listener;
        if (isConnected) {
            return;
        }
        try {
            LOG.debug("Starting connection to stomp on " + url);
            tryConnect(url);
        } catch (URISyntaxException e) {
            LOG.debug("Could not connect stomp client", e);
            throw new ClientConnectionException("Could not connect stomp client", e);
        }

    }

    private void tryConnect(String url) throws URISyntaxException {
        URI serverUrl = new URI(url);

        ISTOMPListener listener = new ISTOMPListener() {

            @Override
            public void connectionSuccess(StompClient connection) {

            }

            @Override
            public void connectionFailed(Throwable cause) {

            }

            @Override
            public void disconnected(String reason) {

            }
        };

        this.listener = listener;
        socket = new StompWebSocket(serverUrl);
        socket.connect(new SocketListener(teamId, accessCode));
    }

    @Override
    public void disconnect() {
        socket.disconnect();

    }

    @Override
    public void publish(String channelName, byte[] message) {
        stompSend(channelName, new String(message));
    }


    /**
     * Creates a new StompClient using the given socket
     *
     * @param socket   A STOMP socket implementation to wrap this client around.
     * @param user     The STOMP user (can be left null if not required)
     * @param password The password for the STOMP user
     * @param listener A listener which receives basic protocol events such as connected / disconnected.
     */
    private StompClient(IStompSocket socket, final String user, final String password, ISTOMPListener listener) {
        this.listener = listener;
        this.socket = socket;
        this.socket.connect(new SocketListener(user, password));
    }

    private class SocketListener implements ISocketListener {

        private final String user;
        private final String password;

        public SocketListener(String user, String password) {

            this.user = user;
            this.password = password;
        }

        @Override
        public void connected() {
            // The underling socket has connected, now we can connect with the
            // STOMP protocol
            stompConnect(user, password);
        }

        @Override
        public void onStompFrameReceived(StompFrame frame) {
            stompFrameReceived(frame);
        }

        @Override
        public void closed(String reason) {
            // The underling socket died
            LOG.debug("Underling Websocket has closed: " + reason);
            handleServerDisconnected(reason);
        }

        @Override
        public void connectionFailed(Throwable e) {
            LOG.debug("Underling Websocket could not connect!", e);
            handleCanNotConnect(e);
        }

    }

    public StompClient(String teamId, String accessCode) {

        this.teamId = teamId;
        this.accessCode = accessCode;
    }

    /**
     * Builds a Stomp Client which uses STOMP over Websocket
     *
     * @param uri      the target uri
     * @param listener a listener for the connection
     * @return the stomp client
     */
    public static StompClient connectOverWebSocket(String uri, ISTOMPListener listener) {
        return connectOverWebSocket(uri, null, null, listener);
    }

    public static StompClient connectOverWebSocket(String uri, String user, String password, ISTOMPListener listener) {
        StompWebSocket socket;
        try {

            URI serverUrl = new URI(uri);
            socket = new StompWebSocket(serverUrl);
            return new StompClient(socket, user, password, listener);

        } catch (URISyntaxException e) {
            LOG.debug("Could not parse URI!", e);
            listener.connectionFailed(e);
        }
        return null;
    }

    /**
     * @return true if the STOMP protocol has had a successful handshake
     */
    public boolean isConnected() {
        return isConnected;
    }


    /**
     * Send the given text message to the given channel
     *
     * @param channel the channel
     * @param message the message
     */
    public void stompSend(String channel, String message) {
        StompFrame request = new StompFrame(
                FrameType.SEND, channel)
                .withBody(message);
        sendStompFrame(request);
    }

    /**
     * Subscribe to the given channel.
     * For all subsequent messages sent to the specified channel, the given message listener will be invoked.
     *
     * @param channel  the channel
     * @param listener the listener
     */
    @Override
    public void subscribe(String channel, MessageReceiver listener) {

        // We use a global unique id for the subscription to simplify subscription mapping on
        // our side.
        String subscriptionId = UUID.randomUUID().toString();

        StompFrame subscriptionRequest = new StompFrame(FrameType.SUBSCRIBE)
                .withHeader("id", subscriptionId)
                .withHeader("destination", channel)
                .withHeader("ack", "auto") // The client does not send ACK for received messages
                ;
        sendStompFrame(subscriptionRequest);

        subscriptionRouter.register(channel, listener);
    }


    /**
     * Connect to the Websocket using a HTTP header with credentials.
     *
     * @param user     username
     * @param password credentials
     */
    private void stompConnect(String user, String password) {
        StompFrame request = new StompFrame(FrameType.CONNECT)
                .withHeader("accept-version", "1.0,1.1,2.0")
                .withHeader("host", socket.getHost());

        if (user != null) {
            request.withHeader("login", user);
        }
        if (password != null) {
            request.withHeader("passcode", password);
        }

        sendStompFrame(request);
    }

    private void sendStompFrame(StompFrame request) {
        socket.sendFrame(request);
    }

    /**
     * Occurs when we receive a stomp from the server
     *
     * @param frame the incoming frame
     */
    private void stompFrameReceived(StompFrame frame) {

        switch (frame.getType()) {

            case CONNECTED:
                handleServerConnected();
                break;

            case ERROR:
                handleServerError(frame);
                break;

            case RECEIPT:
                LOG.error("Receipt handling not supported in this version!");
                break;

            case MESSAGE:
                handleServerMessage(frame);
                break;

            default:
                LOG.error("Unexpected STOMPFrame-COMMAND received: " + frame.getType());
        }
    }

    private void handleServerMessage(StompFrame frame) {
        String channel = frame.getHeaderValue("destination");
        if (channel != null) {
            subscriptionRouter.routeMessage(channel, frame.getBody().getBytes());
        } else {
            LOG.warn("Message frame was missing destination!");
        }
    }

    private void handleServerError(StompFrame frame) {
        LOG.debug("Received Error - connection will die now!" + System.lineSeparator() + frame);
        handleServerDisconnected("STOMP ERROR FRAME: " + frame.getBody());
    }

    private void handleServerConnected() {
        isConnected = true;
        fireAll(l -> l.connectionSuccess(this));
    }

    private void handleServerDisconnected(String cause) {
        isConnected = false;
        fireAll(l -> l.disconnected(cause));
    }

    private void handleCanNotConnect(Throwable cause) {
        isConnected = false;
        fireAll(l -> l.connectionFailed(cause));
    }

    private void fireAll(Consumer<ISTOMPListener> action) {
        action.accept(listener);
    }


}
