package com.zuehlke.carrera.timeseries;

/**
 * represents the observation of type T with value v at point in time t
 */
public class Observation<T> {
    public final long t;
    public final T v;

    public Observation(long t, T v) {
        this.t = t;
        this.v = v;
    }
}
