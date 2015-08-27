package com.zuehlke.carrera.relayapi.messages;

/**
 * represents a life sign from a pilot to the relay station
 */
public class PilotLifeSign {

    private String teamId;
    private String accessCode;
    private String optionalUrl;
    private long timestamp;

    public PilotLifeSign() {
    } // for serialization purposes

    public PilotLifeSign(String teamId, String accessCode, String optionalUrl, long timestamp) {
        this.timestamp = timestamp;
        this.teamId = teamId;
        this.accessCode = accessCode;
        this.optionalUrl = optionalUrl;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getOptionalUrl() {
        return optionalUrl;
    }

    public void setOptionalUrl(String optionalUrl) {
        this.optionalUrl = optionalUrl;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
