package com.zuehlke.carrera.relayapi.messages;

import org.springframework.data.annotation.Transient;

import java.io.Serializable;

/**
 * A Power Control contains the power value which controls the
 * digital power value of a race car.
 *
 * Created by wgiersche on 06/09/14.
 */
public class PowerControl implements Serializable {

    private String teamId;
    private String accessCode;
    private int p;
    private long timeStamp;
    private int t;

    /**
     * Empty Constructor for Serialisation
     */
    protected PowerControl() {
    }


    /**
     * Creates a new SpeedControl with the given power
     */
    public PowerControl(int p, String teamId, String accessCode, long timestamp) {

        this.p = p;
        this.accessCode = accessCode;
        this.teamId = teamId;
        this.timeStamp = timestamp;
    }

    /**
     * create a mere value object for storage purposes where the context is known otherwise.
     * @param p the original power
     * @param timeStamp the original timestamp;
     */
    private PowerControl(int p, long timeStamp) {
        this.p = p;
        this.timeStamp = timeStamp;
    }

    public int getP() {
        return p;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public int getT() {
        return t;
    }

    public String toString(){
        return getP() + "";
    }

    @Transient
    public long getTimeStamp() {
        return timeStamp;
    }

    public PowerControl valueObject() {

        return new PowerControl(p, timeStamp);
    }

    public void offSetTime ( long offset ) {
        t = (int)(timeStamp - offset);
    }
}
