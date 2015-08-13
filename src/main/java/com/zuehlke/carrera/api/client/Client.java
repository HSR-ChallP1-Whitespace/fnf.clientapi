package com.zuehlke.carrera.api.client;

public interface Client {

    void connect(String url);

    void disconnect();

    void publish(String channelName, String message);

    void subscribe(String channelName, MessageReceiver receiver);
}
