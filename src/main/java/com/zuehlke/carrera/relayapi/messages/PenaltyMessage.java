package com.zuehlke.carrera.relayapi.messages;

public class PenaltyMessage {

    private double actualSpeed;
    private double speedLimit;
    private int penalty_ms;
    private String barrier;
    private String raceTrack;

    public PenaltyMessage() {}

    public PenaltyMessage(String raceTrack, String barrier, double actualSpeed, double speedLimit, int penalty_ms) {
        this.raceTrack = raceTrack;
        this.barrier = barrier;
        this.actualSpeed = actualSpeed;
        this.speedLimit = speedLimit;
        this.penalty_ms = penalty_ms;
    }

    public double getActualSpeed() {
        return actualSpeed;
    }

    public void setActualSpeed(double actualSpeed) {
        this.actualSpeed = actualSpeed;
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(double speedLimit) {
        this.speedLimit = speedLimit;
    }

    public int getPenalty_ms() {
        return penalty_ms;
    }

    public void setPenalty_ms(int penalty_ms) {
        this.penalty_ms = penalty_ms;
    }

    public String getBarrier() {
        return barrier;
    }

    public void setBarrier(String barrier) {
        this.barrier = barrier;
    }

    public String getRaceTrack() {
        return raceTrack;
    }

    public void setRaceTrack(String raceTrack) {
        this.raceTrack = raceTrack;
    }
}
