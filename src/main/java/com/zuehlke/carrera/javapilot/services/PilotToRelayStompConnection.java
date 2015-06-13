package com.zuehlke.carrera.javapilot.services;

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
 */
public class PilotToRelayStompConnection extends RelayConnection implements PilotToRelayConnection {

    private static final Logger LOG = LoggerFactory.getLogger(PilotToRelayStompConnection.class);

    // out bound channels
    public static final String CHANNEL_ANNOUNCE = "/app/pilots/announce";
    public static final String CHANNEL_POWER = "/app/pilots/power";

    // inbound channels
    private static final String CHANNEL_START_TEMPLATE = "/topic/pilots/{id}/start";
    private static final String CHANNEL_STOP_TEMPLATE = "/topic/pilots/{id}/stop";
    private static final String SENSOR_TEMPLATE = "/topic/pilots/{id}/sensor";
    private static final String VELOCITY_TEMPLATE = "/topic/pilots/{id}/velocity";
    private static final String PENALTY_TEMPLATE = "/topic/pilots/{id}/penalty";

    private final Consumer<RaceStopMessage> onRaceStop;
    private final Consumer<RaceStartMessage> onRaceStart;
    private final Consumer<SensorEvent> onSensor;
    private final Consumer<VelocityMessage> onVelocityMessage;
    private final Consumer<PenaltyMessage> onPenaltyMessage;

    public PilotToRelayStompConnection(String relayUrl, String clientId, String user, String password,
                                       Consumer<RaceStartMessage> onRaceStart,
                                       Consumer<RaceStopMessage> onRaceStop,
                                       Consumer<SensorEvent> onSensor,
                                       Consumer<VelocityMessage> onVelocityMessage,
                                       Consumer<PenaltyMessage> onPenaltyMessage) {
        super(relayUrl, clientId, user, password);

        this.onRaceStart = onRaceStart;
        this.onRaceStop = onRaceStop;
        this.onSensor = onSensor;
        this.onVelocityMessage = onVelocityMessage;
        this.onPenaltyMessage = onPenaltyMessage;
    }

    @Override
    protected void connect() {
        connecting = true;
        client = null;
        try {
            LOG.info("Trying to connect to " + relayUrl + " as user " + user + " ...");

            StompClient.connectOverWebSocket(relayUrl, user, password, new ISTOMPListener() {

                @Override
                public void connectionSuccess(StompClient stompClient) {

                    LOG.info("STOMP Connected to relay server!");
                    client = stompClient;

                    String startChannel = ParamUtil.paramUrl(CHANNEL_START_TEMPLATE, clientId);
                    LOG.info("Subscribing to channel '" + startChannel + "'");
                    client.subscribe(startChannel, PilotToRelayStompConnection.this::onStartMessage);

                    String stopChannel = ParamUtil.paramUrl(CHANNEL_STOP_TEMPLATE, clientId);
                    LOG.info("Subscribing to channel '" + stopChannel + "'");
                    client.subscribe(stopChannel, PilotToRelayStompConnection.this::onStopMessage);

                    String sensorChannel = ParamUtil.paramUrl(SENSOR_TEMPLATE, clientId);
                    LOG.info("Subscribing to channel '" + sensorChannel + "'");
                    client.subscribe(sensorChannel, PilotToRelayStompConnection.this::onSensorMessage);

                    String velocityChannel = ParamUtil.paramUrl(VELOCITY_TEMPLATE, clientId);
                    LOG.info("Subscribing to channel '" + velocityChannel + "'");
                    client.subscribe(velocityChannel, PilotToRelayStompConnection.this::onVelocityMessage);

                    String penaltyChannel = ParamUtil.paramUrl(PENALTY_TEMPLATE, clientId);
                    LOG.info("Subscribing to channel '" + penaltyChannel + "'");
                    client.subscribe(penaltyChannel, PilotToRelayStompConnection.this::onPenaltyMessage);

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

    /**
     * Send an announce message to the backend server
     * to notify it about the existence of this race-track.
     *
     * Note: The backend expects announce-messages from a racetrack in an interval < 1 second,
     * thus this method should be called repeatedly on a distinct timer thread.
     *
     * @param optionalUrl
     */
    @Override
    public void announce(String optionalUrl) {

        if(client != null && client.isConnected()) {
            Object announceMessage = null;
            try {
                client.stompSend(CHANNEL_ANNOUNCE, mapper.writeValueAsString(announceMessage));
            } catch (JsonProcessingException e) {
                LOG.error("Can not JSON serialize announceMessage: " + announceMessage, e);
            }
        }
    }

    @Override
    public void send(PowerControl powerControl) {
        try {
            client.stompSend( CHANNEL_POWER, mapper.writeValueAsString(powerControl));
        } catch (JsonProcessingException e) {
            LOG.error("Can not JSON serialize announceMessage: " + powerControl, e);
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

    private void onSensorMessage(String message ){
        try {
            SensorEvent sensorEvent = mapper.readValue(message, SensorEvent.class);
            onSensor.accept(sensorEvent);
        } catch (IOException e) {
            LOG.error("Could not parse JSON from STOMP message: " +System.lineSeparator()+ message, e);
        }
    }

    private void onVelocityMessage(String message ){
        try {
            VelocityMessage velocityMessage = mapper.readValue(message, VelocityMessage.class);
            onVelocityMessage.accept(velocityMessage);
        } catch (IOException e) {
            LOG.error("Could not parse JSON from STOMP message: " +System.lineSeparator()+ message, e);
        }
    }

    private void onPenaltyMessage(String message ){
        try {
            PenaltyMessage penaltyMessage = mapper.readValue(message, PenaltyMessage.class);
            onPenaltyMessage.accept(penaltyMessage);
        } catch (IOException e) {
            LOG.error("Could not parse JSON from STOMP message: " +System.lineSeparator()+ message, e);
        }
    }
}
