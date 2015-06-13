package com.zuehlke.carrera.relayapi.messages;

/**
 *  signals a finished round that will be used for race evaluation
 */
public class RoundTimeMessage {

    private long timestamp;
    private long roundDuration;
    private String team;
    private String track;

    public RoundTimeMessage(){}

    public RoundTimeMessage(String track, String team, long timestamp, long roundDuration) {
        this.timestamp = timestamp;
        this.track = track;
        this.team = team;
        this.roundDuration = roundDuration;
    }

    public long getRoundDuration() {
        return roundDuration;
    }

    public String getTeam() {
        return team;
    }

    public String getTrack() {
        return track;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setRoundDuration(long roundDuration) {
        this.roundDuration = roundDuration;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setTrack(String track) {
        this.track = track;
    }
}
