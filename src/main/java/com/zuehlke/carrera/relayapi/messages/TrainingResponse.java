package com.zuehlke.carrera.relayapi.messages;

/**
 *  the response to a training request. This goes back to the pilot;
 */
public class TrainingResponse {

    private boolean success;
    private String description;

    public TrainingResponse(boolean success, String description) {
        this.success = success;
        this.description = description;
    }

    public TrainingResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
