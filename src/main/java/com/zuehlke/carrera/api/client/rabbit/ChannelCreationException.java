package com.zuehlke.carrera.api.client.rabbit;

public class ChannelCreationException extends RuntimeException {

    public ChannelCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
