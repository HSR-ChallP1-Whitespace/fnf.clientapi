package com.zuehlke.carrera.api;

import com.zuehlke.carrera.api.channel.RaceChannelNames;
import com.zuehlke.carrera.api.client.Client;
import com.zuehlke.carrera.api.seralize.Serializer;
import com.zuehlke.carrera.relayapi.messages.*;

import java.util.function.Consumer;

public class SimulatorApiImpl implements SimulatorApi {
    private final ApiConnection connection;
    private final RaceChannelNames names;

    public SimulatorApiImpl(RaceChannelNames names, Client client, Serializer serializer) {
        this.names = names;
        this.connection = new ApiConnection(client, serializer);
    }

    @Override
    public void announce(RaceTrack message) {
        connection.publishTo(names.announce(), message);
    }

    @Override
    public void sensor(SensorEvent message) {
        connection.publishTo(names.sensor(), message);
    }

    @Override
    public void velocity(VelocityMessage message) {
        connection.publishTo(names.velocity(), message);
    }

    @Override
    public void penalty(PenaltyMessage message) {
        connection.publishTo(names.penalty(), message);
    }

    @Override
    public void roundPassed(RoundPassedMessage message) {
        connection.publishTo(names.roundPassed(), message);
    }

    @Override
    public void onPowerControl(Consumer<PowerControl> onPowerControl) {
        connection.subscribeTo(names.powerControl(), onPowerControl, PowerControl.class);
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
    public void connect(String url) {
        connection.connect(url);
    }

    @Override
    public void disconnect() {
        connection.disconnect();
    }
}
