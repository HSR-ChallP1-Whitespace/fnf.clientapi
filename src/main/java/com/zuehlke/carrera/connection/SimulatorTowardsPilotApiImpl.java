package com.zuehlke.carrera.connection;


import com.zuehlke.carrera.api.ApiConnection;
import com.zuehlke.carrera.api.channel.RaceChannelNames;
import com.zuehlke.carrera.api.client.Client;
import com.zuehlke.carrera.api.seralize.Serializer;
import com.zuehlke.carrera.relayapi.messages.*;

import java.util.function.Consumer;

/**
 *
 */
public class SimulatorTowardsPilotApiImpl implements TowardsPilotApi {

    RaceChannelNames names;
    ApiConnection connection;

    public SimulatorTowardsPilotApiImpl(Client client, RaceChannelNames names, Serializer serializer) {
        this.names = names;
        this.connection = new ApiConnection(client, serializer);
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
    public void roundPassed(RoundTimeMessage message) {
        connection.publishTo(names.roundPassed(), message);
    }

    @Override
    public void raceStart(RaceStartMessage message) {
        connection.publishTo(names.raceStart(), message);
    }

    @Override
    public void raceStop(RaceStopMessage message) {
        connection.publishTo(names.raceStop(), message);
    }

    @Override
    public void onPowerControl(Consumer<PowerControl> onPowerControl) {
        connection.subscribeTo(names.powerControl(), onPowerControl, PowerControl.class);
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
