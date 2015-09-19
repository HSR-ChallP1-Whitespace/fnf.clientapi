package com.zuehlke.carrera.relayapi.messages;

/**
 * represents a run request from the competition manager
 */
public class RunRequest {

    private String team;
    private String accessCode;
    private String pilotProtocol;
    private String pilotEncoding;
    private String track;
    private Long furiousRunId;
    private RaceActivityMetadata metaData;


    public RunRequest(String team, String accessCode, String pilotProtocol, String pilotEncoding,
                      String track, RaceActivityMetadata metaData, Long furiousRunId) {
        this.team = team;
        this.accessCode = accessCode;
        this.pilotProtocol = pilotProtocol;
        this.pilotEncoding = pilotEncoding;
        this.track = track;
        this.metaData = metaData;
        this.furiousRunId = furiousRunId;
    }

    public RunRequest() {
    } // for Serialization

    public String getPilotProtocol() {
        return pilotProtocol;
    }

    public void setPilotProtocol(String pilotProtocol) {
        this.pilotProtocol = pilotProtocol;
    }

    public String getPilotEncoding() {
        return pilotEncoding;
    }

    public void setPilotEncoding(String pilotEncoding) {
        this.pilotEncoding = pilotEncoding;
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

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public Long getFuriousRunId() {
        return furiousRunId;
    }

    public void setFuriousRunId(Long furiousRunId) {
        this.furiousRunId = furiousRunId;
    }

    public RaceActivityMetadata getMetaData() {
        return metaData;
    }

    public void setMetaData(RaceActivityMetadata metaData) {
        this.metaData = metaData;
    }
}
