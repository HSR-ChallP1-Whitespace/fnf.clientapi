package com.zuehlke.carrera.connection;

import com.zuehlke.carrera.relayapi.messages.*;

import java.util.function.Consumer;

public class RabbitConnectionFactoryTowardsPilots implements ConnectionFactoryTowardsPilots {

    private final TowardsPilotApi towardsPilotApi;

    public RabbitConnectionFactoryTowardsPilots(TowardsPilotApi towardsPilotApi) {
        this.towardsPilotApi = towardsPilotApi;
    }

    @Override
    public TowardsPilotsConnection create(Consumer<PowerControl> onPowerControl) {
        TowardsPilotsConnection connection = new TowardsPilotsConnection() {
            @Override
            public void sendSensorEvent(SensorEvent event) {
                towardsPilotApi.sensor(event);
            }

            @Override
            public void sendVelocity(VelocityMessage message) {
                towardsPilotApi.velocity(message);
            }

            @Override
            public void sendPenalty(PenaltyMessage message) {
                towardsPilotApi.penalty(message);
            }

            @Override
            public void sendRoundPassed(RoundTimeMessage message) {
                towardsPilotApi.roundPassed(message);
            }

            @Override
            public void sendRaceStart(RaceStartMessage message) {
                towardsPilotApi.raceStart(message);
            }

            @Override
            public void sendRaceStop(RaceStopMessage message) {
                towardsPilotApi.raceStop( message );
            }

            @Override
            public void connect( String url ) {
                towardsPilotApi.connect( url );
            }
        };
        towardsPilotApi.onPowerControl(onPowerControl);

        return connection;
    }
}
