package com.zuehlke.carrera.api.client;

public interface MessageReceiver {

    void receive(byte[] message);
}
