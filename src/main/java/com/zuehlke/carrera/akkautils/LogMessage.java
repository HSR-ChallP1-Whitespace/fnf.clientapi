package com.zuehlke.carrera.akkautils;

import akka.actor.UntypedActor;

/**
 *  A log message 'knows' the sending actor
 */
public class LogMessage {

    private final Class<? extends UntypedActor> source;
    private final String message;

    public LogMessage(Class<? extends UntypedActor> source, String message) {
        this.source = source;
        this.message = message;
    }

    public Class<? extends UntypedActor> getSource() {
        return source;
    }

    public String getMessage() {
        return message;
    }
}
