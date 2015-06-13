package com.zuehlke.carrera.relayapi.messages;

import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.Arrays;

/**
 * A Event which gets fired when something happens on the relay track.
 * This event is also frequently sent over network and used by the
 * Akka system as message.
 */
public class SensorEvent implements Serializable {

    /**
     * Returns a empty sensor data
     */
    public static final SensorEvent Empty = createEmptyCarSensor();

    /**
     * Creates a new, empty Car-Sensor Event
     * @return
     */
    public static SensorEvent createEmptyCarSensor(){
        return new SensorEvent(null, new int[3], new int[3], new int[3], 0);
    }

    private String raceTrackId;
    private long timeStamp;
    private int[] a;
    private int[] g;
    private int[] m;
    private int t;

    /**
     * Empty constructor for serialisation
     */
    protected SensorEvent(){
    }

    /**
     * Prototype constructor
     * @param prototype The prototype instance. Must not be null!
     */
    public SensorEvent(SensorEvent prototype){
        if(prototype == null) throw new IllegalArgumentException("prototype must not be null!");

        prototype(prototype);
    }

    /**
     * Creates a new RaceTrackEvent
     * @param raceTrackId The id of the race-track from which this event originates.
     * @param timeStamp the event time stamp
     */
    public SensorEvent( String raceTrackId, long timeStamp ){
        this.raceTrackId = raceTrackId;
        this.timeStamp = timeStamp;
    }

    /**
     * Creates a Sensor-Event of Car-Sensor Data
     * @param raceTrackId The id of the race-track from which this event originates.
     * @param acc
     * @param gyr
     * @param mag
     * @param timeStamp
     */
    public SensorEvent(String raceTrackId, int[] acc, int[] gyr, int[] mag, long timeStamp){
        this.raceTrackId = raceTrackId;
        this.a = Arrays.copyOf(acc, acc.length);
        this.g = Arrays.copyOf(gyr, gyr.length);
        this.m = Arrays.copyOf(mag, mag.length);
        this.timeStamp = timeStamp;
    }


    /**
     * Gets the X, Y, Z Acceleration
     * @return
     */
    public int[] getA(){
        return a;
    }

    /**
     * Gets the X, Y, Z Gyro Data
     * @return
     */
    public int[] getG(){
        return g;
    }

    /**
     * Gets the X, Y, Z Magnitude
     * @return
     */
    public int[] getM(){
        return m;
    }

    /**
     * Get the time-stamp when this event happened
     * @return
     */
    @Transient
    public long getTimeStamp() {
        return timeStamp;
    }

    public int getT() {
        return t;
    }

    /** calculate the distance between the start time and the timestamp
     *  saves a lot of disk space!
     */
    public void offSetTime ( long offSet ) {
        t = (int)(timeStamp - offSet);
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                ", raceTrackId=" + raceTrackId +
                ", timeStamp=" + timeStamp +
                ", acc=" + Arrays.toString(a) +
                ", gyr=" + Arrays.toString(g) +
                ", mag=" + Arrays.toString(m) +
                '}';
    }

    public String getRaceTrackId() {
        return raceTrackId;
    }


    /**
     * Returns a copy of this object with the raceTrackId set to the given value
     * @param raceTrackId
     * @return
     */
    public SensorEvent withRaceTrackId(String raceTrackId) {
        SensorEvent copy = new SensorEvent(this);
        copy.raceTrackId = raceTrackId;
        return copy;
    }


    /**
     * Copies all values from the prototype to this instance
     * @param prototype
     */
    protected void prototype(SensorEvent prototype){

        if(prototype == null) throw new IllegalArgumentException("prototype must not be null!");

        this.raceTrackId = prototype.getRaceTrackId();

        if(prototype.getA() != null) {
            this.a = Arrays.copyOf(prototype.getA(), prototype.getA().length);
        }else{
            this.a = null;
        }
        if(prototype.getG() != null) {
            this.g = Arrays.copyOf(prototype.getG(), prototype.getG().length);
        }else{
            this.g = null;
        }

        if(prototype.getM() != null) {
            this.m = Arrays.copyOf(prototype.getM(), prototype.getM().length);
        }else{
            this.m = null;
        }

        this.timeStamp = prototype.getTimeStamp();
    }

    public SensorEvent valueObject() {

        return new SensorEvent(null, a, g, m, timeStamp);
    }
}
