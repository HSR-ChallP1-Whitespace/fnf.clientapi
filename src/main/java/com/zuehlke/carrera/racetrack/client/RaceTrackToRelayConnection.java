package com.zuehlke.carrera.racetrack.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zuehlke.carrera.relayapi.messages.*;
import com.zuehlke.carrera.stomp.ParamUtil;
import com.zuehlke.carrera.stomp.RelayConnection;
import com.zuehlke.carrera.lightstomp.ISTOMPListener;
import com.zuehlke.carrera.lightstomp.StompClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * Manages the WebSocket connection to the backend
 * and provides an easy to use wrapper API to interact with
 * the relay server.
 *
 *
 */
public class RaceTrackToRelayConnection extends RelayConnection {

    private static final Logger LOG = LoggerFactory.getLogger(RaceTrackToRelayConnection.class);

    // outbound channels
    private static final String CHANNEL_ANNOUNCE = "/app/racetracks/announce";
    private static final String CHANNEL_SENSOR_EVENTS = "/app/racetracks/events";
    private static final String CHANNEL_VELOCITY = "/app/racetracks/velocity";
    private static final String CHANNEL_PENALTY = "/app/racetracks/penalty";
    private static final String CHANNEL_ROUND_PASSED = "/app/racetracks/roundPassed";

    // inbound channels
    private static final String CHANNEL_SPEED_TEMPLATE = "/topic/racetracks/{id}/speed";
    private static final String CHANNEL_START_TEMPLATE = "/topic/racetracks/{id}/start";
    private static final String CHANNEL_STOP_TEMPLATE = "/topic/racetracks/{id}/stop";

    private final Consumer<PowerControl> onSpeedControl;
    private final Consumer<RaceStartMessage> onRaceStart;
    private final Consumer<RaceStopMessage> onRaceStop;
    private final RaceTrackType raceTrackType;

    /**
     * Creates a new RelayClientConnection over web-socket.
     *
     * @param relayUrl The WebSocket url (ws://) to the relay server
     * @param racetrackId The unique name of this race-track
     * @param user The user name for the backend server (may be null)
     * @param password The password name for the backend server (may be null)
     * @param onSpeedControl A call-back when a SpeedControl from the backend arrives.
     */
    public RaceTrackToRelayConnection(String relayUrl, String racetrackId, RaceTrackType type, String user, String password,
                                      Consumer<PowerControl> onSpeedControl,
                                      Consumer<RaceStartMessage> onRaceStart,
                                      Consumer<RaceStopMessage> onRaceStop){

        super(relayUrl, racetrackId, user, password);
        this.raceTrackType = type;

        if(racetrackId == null) throw new IllegalArgumentException("raceTrackId must not be NULL!");
        if(onSpeedControl == null) throw new IllegalArgumentException("onSpeedControl must not be NULL!");
        if(onRaceStart == null) throw new IllegalArgumentException("onRaceStart must not be NULL!");
        if(onRaceStop == null) throw new IllegalArgumentException("onRaceStop must not be NULL!");

        this.onSpeedControl = onSpeedControl;
        this.onRaceStart = onRaceStart;
        this.onRaceStop = onRaceStop;
    }

    /**
     * Send an announce message to the backend server
     * to notify it about the existence of this race-track.
     *
     * Note: The backend expects announce-messages from a racetrack in an interval below 1 second,
     * thus this method should be called repeatedly on a distinct timer thread.
     *
     * @param optionalUrl
     */
    public void announce(String optionalUrl) {

        if(client != null && client.isConnected()) {
            RaceTrack announceMessage = new RaceTrack(raceTrackType, clientId);
            //RaceTrack announceMessage = new RaceTrack(clientId, RaceTrackType.SIMULATOR);
            announceMessage.setLink(optionalUrl);
            try {
                client.stompSend(CHANNEL_ANNOUNCE, mapper.writeValueAsString(announceMessage));
            } catch (JsonProcessingException e) {
                LOG.error("Can not JSON serialize announceMessage: " + announceMessage, e);
            }
        }
    }

    /**
     * Send the given SensorEvent to the backend.
     * @param sensorEvent
     * @return
     */
    public boolean send(SensorEvent sensorEvent) {
        if(sensorEvent == null) throw new IllegalArgumentException("sensorEvent must not be NULL!");
        return sendObject(CHANNEL_SENSOR_EVENTS, sensorEvent);
    }

    public boolean send(VelocityMessage velocity) {
        if(velocity == null) throw new IllegalArgumentException("velocity must not be NULL!");
        return sendObject(CHANNEL_VELOCITY, velocity);
    }

    public boolean send(PenaltyMessage penaltyMessage) {
        if(penaltyMessage == null) throw new IllegalArgumentException("penaltyMessage must not be NULL!");
        return sendObject(CHANNEL_PENALTY, penaltyMessage);
    }

    public boolean send(RoundPassedMessage roundPassedMessage) {
        if(roundPassedMessage == null) throw new IllegalArgumentException("round-passed Message must not be NULL!");
        return sendObject(CHANNEL_ROUND_PASSED, roundPassedMessage);
    }



    /**
     * Try to connect to the backend using a STOMP client
     */
    protected synchronized void connect(){
        connecting = true;
        client = null;
        try {
            LOG.info("Trying to connect to " + relayUrl + " as user " + user + " ...");

            StompClient.connectOverWebSocket(relayUrl, user, password, new ISTOMPListener() {

                @Override
                public void connectionSuccess(StompClient stompClient) {

                    LOG.info("STOMP Connected to relay server!");
                    client = stompClient;

                    String speedChannel = ParamUtil.paramUrl(CHANNEL_SPEED_TEMPLATE, clientId);

                    LOG.info("Subscribing to channel '" + speedChannel + "'");
                    client.subscribe(speedChannel, RaceTrackToRelayConnection.this::onSpeedMessage);

                    /*
                    String pingChannel = ParamUtil.paramUrl(CHANNEL_PING_TEMPLATE, racetrackId);
                    LOG.info("Subscribing to channel '" + pingChannel + "'");
                    client.subscribe(pingChannel, RelayConnection.this::onPingMessage);
                    */

                    String startChannel = ParamUtil.paramUrl(CHANNEL_START_TEMPLATE, clientId);
                    LOG.info("Subscribing to channel '" + startChannel + "'");
                    client.subscribe(startChannel, RaceTrackToRelayConnection.this::onStartMessage);

                    String stopChannel = ParamUtil.paramUrl(CHANNEL_STOP_TEMPLATE, clientId);
                    LOG.info("Subscribing to channel '" + stopChannel + "'");
                    client.subscribe(stopChannel, RaceTrackToRelayConnection.this::onStopMessage);

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

        }catch (Throwable e){
            LOG.error("Can not connect to relay!", e);
            client = null;
            connecting = false;
        }
    }


    private void onSpeedMessage(String message){
        try {
            PowerControl control = mapper.readValue(message, PowerControl.class);
            onSpeedControl.accept(control);
        } catch (IOException e) {
            LOG.error("Could not parse JSON from STOMP message: " +System.lineSeparator()+ message, e);
        }
    }

    private void onStartMessage(String message){
        try {
            RaceStartMessage start = mapper.readValue(message, RaceStartMessage.class);
            onRaceStart.accept(start);
        } catch (IOException e) {
            LOG.error("Could not parse JSON from STOMP message: " +System.lineSeparator()+ message, e);
        }
    }

    private void onStopMessage(String message){
        try {
            RaceStopMessage stop = mapper.readValue(message, RaceStopMessage.class);
            onRaceStop.accept(stop);
        } catch (IOException e) {
            LOG.error("Could not parse JSON from STOMP message: " +System.lineSeparator()+ message, e);
        }
    }


}
