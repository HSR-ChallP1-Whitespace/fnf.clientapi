package com.zuehlke.carrera.lightstomp;

/**
 * Listener for STOMP messages
 */
public interface MessageListener {
    /**
     * Occurs when a STOMP message is received by the client.
     * @param message the message
     */
    void messageReceived(String message);
}
