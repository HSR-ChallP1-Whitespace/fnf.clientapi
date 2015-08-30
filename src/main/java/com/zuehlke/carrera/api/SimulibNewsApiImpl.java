package com.zuehlke.carrera.api;

import com.zuehlke.carrera.api.channel.NewsChannelNames;
import com.zuehlke.carrera.api.client.Client;
import com.zuehlke.carrera.api.seralize.Serializer;

public class SimulibNewsApiImpl implements SimulibNewsApi {
    private final NewsChannelNames names;
    private final ApiConnection connection;

    public SimulibNewsApiImpl(NewsChannelNames names, Client client, Serializer serializer) {
        this.names = names;
        this.connection = new ApiConnection(client, serializer);
    }

    @Override
    public void data(Object message) {
        connection.publishTo(names.data(), message);
    }

    @Override
    public void tick(Object message) {
        connection.publishTo(names.tick(), message);
    }
}
