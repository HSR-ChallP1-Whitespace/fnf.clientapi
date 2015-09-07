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
     * create a empty sensor data
     */
    public static final SensorEvent Empty = createEmptyCarSensor();
    private String raceTrackId;
    private long timeStamp;
    private int[] a;
    private int[] g;
    private int[] m;
    private int t;
    /**
     * Empty constructor for serialisation
     */
    protected SensorEvent() {
    }

    /**
     * Prototype constructor
     *
     * @param prototype The prototype instance. Must not be null!
     */
    public SensorEvent(SensorEvent prototype) {
        if (prototype == null) throw new IllegalArgumentException("prototype must not be null!");

        prototype(prototype);
    }

    /**
     * Creates a new RaceTrackEvent
     *
     * @param raceTrackId The id of the race-track from which this event originates.
     * @param timeStamp   the event time stamp
     */
    public SensorEvent(String raceTrackId, long timeStamp) {
        this.raceTrackId = raceTrackId;
        this.timeStamp = timeStamp;
    }

    /**
     * Creates a Sensor-Event of Car-Sensor Data
     *
     * @param raceTrackId The id of the race-track from which this event originates.
     * @param acc         acceleration vector
     * @param gyr         gyrometer vector
     * @param mag         magnetic field vector
     * @param timeStamp   time stamp
     */
    public SensorEvent(String raceTrackId, int[] acc, int[] gyr, int[] mag, long timeStamp) {
        this.raceTrackId = raceTrackId;
        this.a = Arrays.copyOf(acc, acc.length);
        this.g = Arrays.copyOf(gyr, gyr.length);
        this.m = Arrays.copyOf(mag, mag.length);
        this.timeStamp = timeStamp;
    }

    /**
     * @return a new, empty Car-Sensor Event
     */
    public static SensorEvent createEmptyCarSensor() {
        return new SensorEvent(null, new int[3], new int[3], new int[3], 0);
    }

    /**
     * @return the X, Y, Z Acceleration
     */
    public int[] getA() {
        return a;
    }

    /**
     * @return the X, Y, Z Gyro Data
     */
    public int[] getG() {
        return g;
    }

    /**
     * @return the X, Y, Z Magnitude
     */
    public int[] getM() {
        return m;
    }

    /**
     * @return the time-stamp when this event happened
     */
    @Transient
    public long getTimeStamp() {
        return timeStamp;
    }

    /**
     * @return the timestamp relative to the start of the series
     */
    public int getT() {
        return t;
    }

    /**
     * calculate the distance between the start time and the timestamp
     * saves a lot of disk space!
     *
     * @param offSet the offset to be be used to calculate the relative timestamp
     */
    public void offSetTime(long offSet) {
        t = (int) (timeStamp - offSet);
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

    /**
     * @return the id of the track
     */
    public String getRaceTrackId() {
        return raceTrackId;
    }


    /**
     * Returns a copy of this object with the raceTrackId set to the given value
     *
     * @param raceTrackId race track id
     * @return the given event, now on the given race track
     */
    public SensorEvent withRaceTrackId(String raceTrackId) {
        SensorEvent copy = new SensorEvent(this);
        copy.raceTrackId = raceTrackId;
        return copy;
    }


    /**
     * Copies all values from the given prototype to this instance
     *
     * @param prototype a prototype event to use
     */
    protected void prototype(SensorEvent prototype) {

        if (prototype == null) throw new IllegalArgumentException("prototype must not be null!");

        this.raceTrackId = prototype.getRaceTrackId();

        if (prototype.getA() != null) {
            this.a = Arrays.copyOf(prototype.getA(), prototype.getA().length);
        } else {
            this.a = null;
        }
        if (prototype.getG() != null) {
            this.g = Arrays.copyOf(prototype.getG(), prototype.getG().length);
        } else {
            this.g = null;
        }

        if (prototype.getM() != null) {
            this.m = Arrays.copyOf(prototype.getM(), prototype.getM().length);
        } else {
            this.m = null;
        }

        this.timeStamp = prototype.getTimeStamp();
    }

    public SensorEvent valueObject() {

        return new SensorEvent(null, a, g, m, timeStamp);
    }

    public void setT(int t) {
        this.t = t;
    }
}
