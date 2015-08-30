package com.zuehlke.carrera.api;

import com.zuehlke.carrera.api.client.Client;
import com.zuehlke.carrera.api.seralize.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class ApiConnection {
    private static final Logger LOG = LoggerFactory.getLogger(ApiConnection.class);
    private final List<Subscription> subscriptions = new ArrayList<>();
    private final Client client;
    private final Serializer serializer;

    public ApiConnection(Client client, Serializer serializer) {
        this.client = client;
        this.serializer = serializer;
    }

    public void connect(String url) {
        client.connect(url);
        for(Subscription subscription : subscriptions) {
            subscription.subscribe(client);
        }
    }

    public void disconnect() {
        client.disconnect();
    }

    public void publishTo(String channelName, Object message) {
        if(client.isConnected()) {
            LOG.info("Publishing to " + channelName);
            client.publish(channelName, serializer.serialize(message));
            return;
        }
        LOG.info("Publishing to " + channelName + " skipped, not connected yet");
    }

    public <T> void subscribeTo(String channelName, Consumer<T> onMessage, Class<T> messageType) {
        LOG.info("Subscribing to " + channelName);
        subscriptions.add(subscriptionFor(channelName, onMessage, messageType));
    }

    private <T> Subscription subscriptionFor(String channel, Consumer<T> consumer, Class<T> messageType) {
        return new Subscription(channel, message -> {
            LOG.info("Receiving message in channel " + channel);
            consumer.accept(serializer.deserialize(message, messageType));
        });
    }
}
