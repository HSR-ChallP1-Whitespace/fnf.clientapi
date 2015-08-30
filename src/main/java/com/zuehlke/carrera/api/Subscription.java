package com.zuehlke.carrera.api;

import com.zuehlke.carrera.api.client.Client;
import com.zuehlke.carrera.api.client.MessageReceiver;

class Subscription {
    private final String channelName;
    private final MessageReceiver receiver;

    public Subscription(String channelName, MessageReceiver receiver) {
        this.channelName = channelName;
        this.receiver = receiver;
    }

    public void subscribe(Client client) {
        client.subscribe(channelName, receiver);
    }
}
