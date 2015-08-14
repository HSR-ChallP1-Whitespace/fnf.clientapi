package com.zuehlke.carrera.api;

import com.zuehlke.carrera.api.channel.RaceChannelNames;
import com.zuehlke.carrera.api.client.Client;
import com.zuehlke.carrera.api.seralize.Serializer;
import com.zuehlke.carrera.relayapi.messages.*;

import java.util.function.Consumer;

public class PilotApiImpl implements PilotApi {
    private final RaceChannelNames names;
    private final ApiConnection connection;

    public PilotApiImpl(Client client, RaceChannelNames names, Serializer serializer) {
        this.names = names;
        this.connection = new ApiConnection(client, serializer);
    }

    @Override
    public void announce(PilotLifeSign message) {
        connection.publishTo(names.announce(), message);
    }

    @Override
    public void powerControl(PowerControl message) {
        connection.publishTo(names.powerControl(), message);
    }

    @Override
    public void onRaceStart(Consumer<RaceStartMessage> onRaceStart) {
        connection.subscribeTo(names.raceStart(), onRaceStart, RaceStartMessage.class);
    }

    @Override
    public void onRaceStop(Consumer<RaceStopMessage> onRaceStop) {
        connection.subscribeTo(names.raceStop(), onRaceStop, RaceStopMessage.class);
    }

    @Override
    public void onVelocity(Consumer<VelocityMessage> onVelocity) {
        connection.subscribeTo(names.velocity(), onVelocity, VelocityMessage.class);
    }

    @Override
    public void onPenalty(Consumer<PenaltyMessage> onPenalty) {
        connection.subscribeTo(names.penalty(), onPenalty, PenaltyMessage.class);
    }

    @Override
    public void onSensor(Consumer<SensorEvent> onSensor) {
        connection.subscribeTo(names.sensor(), onSensor, SensorEvent.class);
    }

    @Override
    public void onRoundPassed(Consumer<RoundPassedMessage> onRoundPassed) {
        connection.subscribeTo(names.roundPassed(), onRoundPassed, RoundPassedMessage.class);
    }

    @Override
    public void connect(String url) {
        connection.connect(url);
    }

    @Override
    public void disconnect() {
        connection.disconnect();
    }
}
