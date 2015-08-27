package com.zuehlke.carrera.api.client.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class ChannelRegistry {
    private final Map<String, Channel> channels = new HashMap<>();

    public Channel getOrCreate(String channelName, Connection connection) {
        if (!channels.containsKey(channelName)) {
            Channel channel = createChannel(channelName, connection);
            channels.put(channelName, channel);
        }
        return channels.get(channelName);
    }

    private Channel createChannel(String channelName, Connection connection) {
        try {
            return tryCreateChannel(channelName, connection);
        } catch (IOException e) {
            throw new ChannelCreationException("Could not create rabbit channel", e);
        }
    }

    private Channel tryCreateChannel(String channelName, Connection connection) throws IOException {
        Channel channel = connection.createChannel();
        boolean durable = true;
        boolean exclusive = false;
        boolean autoDelete = false;
        channel.queueDeclare(channelName, durable, exclusive, autoDelete, null);
        return channel;
    }

    public void shutdown() {
        for (Channel channel : channels.values()) {
            tryShutdown(channel);
        }
    }

    private void tryShutdown(Channel channel) {
        try {
            channel.close();
        } catch (IOException | TimeoutException ignored) {
        }
    }
}
