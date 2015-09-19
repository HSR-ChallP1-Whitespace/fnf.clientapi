package com.zuehlke.carrera.relayapi.messages;


/**
 * This message is sent to the race track when a competition or training has been started
 * Created by wgi
 */
public class RaceStartMessage extends StandardMessage {

    private String trackId;
    private String type;
    private String teamId;
    private String description;
    private boolean recordData;
    private RaceActivityMetadata metadata;

    // for serialization purposes
    public RaceStartMessage() {
    }

    public RaceStartMessage(String trackId, String type, String teamId, long timestamp,
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public void setDescription(String description) {
        this.description = description;
    }

    public RaceActivityMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(RaceActivityMetadata metadata) {
        this.metadata = metadata;
    }
}
