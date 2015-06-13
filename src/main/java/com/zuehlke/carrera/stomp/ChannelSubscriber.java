package com.zuehlke.carrera.stomp;

import com.zuehlke.carrera.lightstomp.MessageListener;

/**
 *    Links the name of a stomp channel to a consumer
 */
public class ChannelSubscriber {

    private final String channel;
    private final MessageListener consumer;

    public ChannelSubscriber ( String channel, MessageListener consumer ) {
        this.channel = channel;
        this.consumer = consumer;
    }

    public String getChannel() {
        return channel;
    }

    public MessageListener getConsumer() {
        return consumer;
    }
}
