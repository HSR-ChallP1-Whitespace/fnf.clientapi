package com.zuehlke.carrera.relayapi.messages;


/**
 * This message is sent to the race track when a competition or training has been started
 * Created by wgi
 */
public class RaceStartMessage extends StandardMessage {

    private String trackId;
    private RaceType type;
    private String teamId;
    private String description;
    private boolean recordData;

    // for serialization purposes
    public RaceStartMessage() {
    }

    public RaceStartMessage(String trackId, RaceType type, String teamId, long timestamp,
                            String description, boolean recordData) {
        this.trackId = trackId;
        this.type = type;
        this.teamId = teamId;
        this.timestamp = timestamp;
        this.description = description;
        this.recordData = recordData;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public RaceType getType() {
        return type;
    }

    public void setType(RaceType type) {
        this.type = type;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getDescription() {
        return description;
    }

    public boolean isRecordData() {
        return recordData;
    }

    public void setRecordData(boolean recordData) {
        this.recordData = recordData;
    }
}
