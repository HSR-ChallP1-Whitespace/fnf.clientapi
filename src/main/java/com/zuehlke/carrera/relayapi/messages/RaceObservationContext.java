package com.zuehlke.carrera.relayapi.messages;

public class RaceObservationContext {

    private String teamId;
    private String trackId;
    private RaceType raceType;
    private long startTime;
    private String observable;

    public RaceObservationContext(String teamId, String trackId, String observable, RaceType raceType, long startTime) {
        this.teamId = teamId;
        this.trackId = trackId;
        this.observable = observable;
        this.startTime = startTime;
        this.raceType = raceType;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getTrackId() {
        return trackId;
    }

    public RaceType getRaceType() {
        return raceType;
    }

    public long getStartTime() {
        return startTime;
    }

    public String getObservable() {
        return observable;
    }
}
