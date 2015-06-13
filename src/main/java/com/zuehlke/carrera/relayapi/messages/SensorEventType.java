package com.zuehlke.carrera.relayapi.messages;

/**
 * Specifies the type of a RaceTrackEvent
 */
public enum SensorEventType {

    /**
     * Sensor-Data directly from the Car.
     */
    CAR_SENSOR_DATA,

    /**
     * The relay track has sent a start-passed event (round start/end toggle, issued from the light barrier)
     */
    ROUND_PASSED,

    /**
     * Occurs once, when a race starts
     */
    RACE_STARTED,

    /**
     * Occurs once, when a race stops
     */
    RACE_STOPPED
}
