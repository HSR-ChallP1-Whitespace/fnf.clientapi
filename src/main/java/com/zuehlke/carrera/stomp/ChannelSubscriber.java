package com.zuehlke.carrera.stomp;

import com.zuehlke.carrera.api.client.MessageReceiver;

/**
 * Links the name of a stomp channel to a consumer
 */
public class ChannelSubscriber {

    private final String channel;
    private final MessageReceiver consumer;

    public ChannelSubscriber(String channel, MessageReceiver consumer) {
        this.channel = channel;
        this.consumer = consumer;
    }

    public String getChannel() {
        return channel;
    }

    public MessageReceiver getConsumer() {
        return consumer;
    }
}
