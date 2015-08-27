package com.zuehlke.carrera.javapilot.services;

import com.zuehlke.carrera.relayapi.messages.PowerControl;

/**
 */
public interface PilotToRelayConnection {
    void announce(String optionalUrl);

    void send(PowerControl powerControl);

    void ensureConnection();
}
