package com.zuehlke.carrera.relayapi.messages;

/**
 * This message is sent to the race track when a race has stopped
 * Created by wgi.
 */
public class RaceStopMessage extends StandardMessage {

    private String trackId;
    private String teamId;
    private long timeStamp;
    private RaceType raceType;

    public RaceStopMessage(String trackId, String teamId, long timeStamp, RaceType raceType) {
        this.trackId = trackId;
        this.teamId = teamId;
        this.timeStamp = timeStamp;
        this.raceType = raceType;
    }

    /**
     * Empty constructor for serialisation
     */
    public RaceStopMessage() {
    }

    public RaceStopMessage(String trackId) {
        this.trackId = trackId;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public RaceType getRaceType() {
        return raceType;
    }

    public void setRaceType(RaceType raceType) {
        this.raceType = raceType;
    }
}
