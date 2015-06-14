package com.zuehlke.carrera.relayapi.messages;

/**
 * Represents a race-track.
 * This can either be a virtual one (simulator) or a real track.
 */
public class RaceTrack {

    private String idName;
    private RaceTrackType type;
    private ConnectionStatus status = ConnectionStatus.Unknown;
    private String link = null;

    /**
     * Empty constructor for serialisation
     */
    protected RaceTrack(){

    }

    /**
     * Creates a new RaceTrack
     * @param type The type of the track.
     * @param idName the name of the track
     */
    public RaceTrack(RaceTrackType type, String idName ){
        this.type = type;
        this.idName = idName;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public ConnectionStatus getStatus() {
        return status;
    }

    public void setStatus(ConnectionStatus status) {
        this.status = status;
    }

    public RaceTrackType getType() {
        return type;
    }

    public void setType(RaceTrackType type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }



    @Override
    public String toString() {
        return "RaceTrack{" +
                ", type=" + type +
                '}';
    }


    /**
     *
     * @param o the other object
     * @return true if both race tracks have the same id, for it's supposed to be unique
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaceTrack raceTrack = (RaceTrack) o;

        return !(idName != null ? !idName.equals(raceTrack.idName) : raceTrack.idName != null);

    }

    @Override
    public int hashCode() {
        return idName != null ? idName.hashCode() : 0;
    }
}
