package com.zuehlke.carrera.javapilot.akka;

/**
 * Created by wgiersche on 01/05/15.
 */
public class PowerAction {
    private final int powerValue;

    public PowerAction(int powerValue) {
        this.powerValue = powerValue;
    }

    public int getPowerValue() {
        return powerValue;
    }
}
