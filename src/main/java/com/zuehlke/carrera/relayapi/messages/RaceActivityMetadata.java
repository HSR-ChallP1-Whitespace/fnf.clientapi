package com.zuehlke.carrera.relayapi.messages;


import java.util.HashSet;
import java.util.Set;

public class RaceActivityMetadata {

    private String competitionName;

    private Set<String> tags = new HashSet<>();

    private String raceType; // like "Training Run No 1"

    private String description; // any additional description

    public RaceActivityMetadata() {} // for JSON Serialization

    public RaceActivityMetadata(String competitionName, Set<String> tags,
                                String raceType, String description) {
        this.competitionName = competitionName;
        this.raceType = raceType;
        this.tags = tags;
        this.description = description;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRaceType() {
        return raceType;
    }

    public void setRaceType(String raceType) {
        this.raceType = raceType;
    }
}
