package com.zuehlke.carrera.relayapi.messages;

/**
 * Represents a training request from a certain team's pilot application.
 */
public class TrainingRequest {

    private String team;
    private String accessCode;
    private String design;
    private String description;
    private boolean recordData;

    public TrainingRequest() {
    }

    public TrainingRequest(String team, String accessCode, String design, String description, boolean recordData ) {
        this.team = team;
        this.accessCode = accessCode;
        this.design = design;
        this.description = description;
        this.recordData = recordData;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRecordData() {
        return recordData;
    }

    public void setRecordData(boolean recordData) {
        this.recordData = recordData;
    }
}
