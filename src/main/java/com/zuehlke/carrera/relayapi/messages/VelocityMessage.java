package com.zuehlke.carrera.relayapi.messages;


import org.springframework.data.annotation.Transient;

/**
 * represents a velocity message as received from one of the light barriers
 */
public class VelocityMessage {

    private String racetrackId;
    private long timeStamp;
    private double velocity;
    private String sourceId;
    private int t;

    public VelocityMessage() {
    }

    public VelocityMessage(String racetrackId, long timeStamp, double velocity, String sourceId) {
        this.racetrackId = racetrackId;
        this.timeStamp = timeStamp;
        this.velocity = velocity;
        this.sourceId = sourceId;
    }

    ;

    public int getT() {
        return t;
    }

    public String getRacetrackId() {
        return racetrackId;
    }

    public void setRacetrackId(String racetrackId) {
        this.racetrackId = racetrackId;
    }

    @Transient
    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    @Override
    public String toString() {
        return String.format("from %s at %d: velocity = %f.", racetrackId, timeStamp, velocity);
    }

    /**
     * @return a copy of this without the racetrackId for storage purposes where the racetrack is known from the context
     */
    public VelocityMessage valueObject() {
        return new VelocityMessage(null, timeStamp, velocity, sourceId);
    }

    public void offSetTime(long startTime) {
        t = (int) (timeStamp - startTime);
    }

    public String getSourceId() {
        return sourceId;
    }
}
