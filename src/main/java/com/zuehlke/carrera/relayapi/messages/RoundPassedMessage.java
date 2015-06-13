package com.zuehlke.carrera.relayapi.messages;

/**
 * signifies that the starting point light barrier has been passed
 */
public class RoundPassedMessage {

    private long timeStamp;
    private String raceTrackId;

    public RoundPassedMessage(){}

    public RoundPassedMessage( String raceTrackId, long timeStamp) {
        this.timeStamp = timeStamp;
        this.raceTrackId = raceTrackId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getRaceTrackId() {
        return raceTrackId;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setRaceTrackId(String raceTrackId) {
        this.raceTrackId = raceTrackId;
    }
}
