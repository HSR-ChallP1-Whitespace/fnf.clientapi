package com.zuehlke.carrera.relayapi.messages;

/**
 */
public class StandardMessage {

    protected long timestamp;

    public StandardMessage () {
        timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
