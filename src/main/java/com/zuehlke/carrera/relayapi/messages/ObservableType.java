package com.zuehlke.carrera.relayapi.messages;

/**
 * There are nine observables delivered by the razor:
 * ACC: lateral acceleration
 * GYR: gyro acceleration
 * MAG: magnetic field
 * CURRENT from the motor unit
 * VELO from light barriers
 * POWER from the pilot
 */
public enum ObservableType {
    INVALID,
    CURRENT,
    VELO,
    POWER,
    ACC0,
    GYR0,
    MAG0,
    ACC1,
    GYR1,
    MAG1,
    ACC2,
    GYR2,
    MAG2;

    public boolean isSensorEventType() {
        return ordinal() >= ACC0.ordinal();
    }
}
