package com.zuehlke.carrera.relayapi.messages;

/**
 * Represents a training setup where a certain team's bot is connected to a track until manually taken off.
 */
public class Training {

    private String team;
    private String track;
    private RaceTrackType raceTrackType;
    private String description;
    private boolean recordData;

    public Training(RaceTrackType raceTrackType, String team, String track, String description, boolean recordData) {
        this.team = team;
        this.track = track;
        this.raceTrackType = raceTrackType;
        this.description = description;
        this.recordData = recordData;
    }

    public Training() {
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public RaceTrackType getRaceTrackType() {
        return raceTrackType;
    }

    public void setRaceTrackType(RaceTrackType raceTrackType) {
        this.raceTrackType = raceTrackType;
    }

    public String getDescription() {
        return description;
    }

    public boolean isRecordData() {
        return recordData;
    }
}
