package com.zuehlke.carrera.clientapi;

import com.zuehlke.carrera.clientapi.client.Client;
import com.zuehlke.carrera.clientapi.client.MessageReceiver;

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
