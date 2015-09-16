package com.zuehlke.carrera.connection;


import com.zuehlke.carrera.relayapi.messages.*;

/**
 * This interface describes methods to send messages to any pilot
 */
public interface TowardsPilotsConnection {

    void sendSensorEvent (SensorEvent event);
    void sendVelocity (VelocityMessage message);
    void sendPenalty (PenaltyMessage message);
    void sendRoundPassed (RoundTimeMessage message);
    void sendRaceStart (RaceStartMessage message);
    void sendRaceStop (RaceStopMessage message);
    void connect( String url );
}
