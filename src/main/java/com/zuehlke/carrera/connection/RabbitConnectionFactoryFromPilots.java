package com.zuehlke.carrera.connection;

import com.zuehlke.carrera.api.PilotApi;
import com.zuehlke.carrera.javapilot.services.PilotToRelayConnection;
import com.zuehlke.carrera.relayapi.messages.*;

import java.util.function.Consumer;

public class RabbitConnectionFactoryFromPilots implements ConnectionFactoryFromPilots {
    private final PilotApi pilotApi;
    private final String pilotName;
    private final String accessCode;
    private final String rabbitUrl;

    public RabbitConnectionFactoryFromPilots(PilotApi pilotApi, String pilotName, String accessCode, String rabbitUrl ) {
        this.pilotApi = pilotApi;
        this.pilotName = pilotName;
        this.accessCode = accessCode;
        this.rabbitUrl = rabbitUrl;
    }

    @Override
    public PilotToRelayConnection create(Consumer<RaceStartMessage> onRaceStart,
                                         Consumer<RaceStopMessage> onRaceStop,
                                         Consumer<SensorEvent> onSensor,
                                         Consumer<VelocityMessage> onVelocity,
                                         Consumer<PenaltyMessage> onPenalty,
                                         Consumer<RoundTimeMessage> onRoundPassed ) {
        PilotToRelayConnection connection = new PilotToRelayConnection() {
            @Override
            public void announce(String optionalUrl) {
                PilotLifeSign lifeSign = new PilotLifeSign(pilotName,
                        accessCode, optionalUrl, System.currentTimeMillis());
                pilotApi.announce(lifeSign);
            }

            @Override
            public void send(PowerControl powerControl) {
                pilotApi.powerControl(powerControl);
            }

            @Override
            public void ensureConnection() {
                pilotApi.connect(rabbitUrl);
            }
        };
        pilotApi.onRaceStart(onRaceStart);
        pilotApi.onRaceStop(onRaceStop);
        pilotApi.onSensor(onSensor);
        pilotApi.onVelocity(onVelocity);
        pilotApi.onPenalty(onPenalty);
        pilotApi.onRoundPassed(onRoundPassed);
        return connection;
    }
}
