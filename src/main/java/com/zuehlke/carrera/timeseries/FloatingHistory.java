package com.zuehlke.carrera.timeseries;

import org.apache.commons.math3.stat.StatUtils;

/**
 * provides a floating  history of a certain size
 * the oldest entry is evicted and the new one taken into the history.
 * Note that the very first value always initiates the history as if
 * all former values also have been the same.
 * Basically a ring implementation of a fixed-size queue with some extra semantics and statics on the current queue
 */
public class FloatingHistory {

    private final double[] values;
    private int currentIndex = 0;
    private double size;
    private boolean first = true;

    public FloatingHistory(int size) {
        this.size = size;
        values = new double[size];
    }

    /**
     * @param nextValue the most recent value to push into the queue (ring)
     * @return the currently least recent value
     */
    public double shift(double nextValue) {

        if (first) {
            for (int i = 0; i < size; i++) {
                values[i] = nextValue;
            }
        }
        first = false;
        double former = values[currentIndex];
        values[currentIndex] = nextValue;
        currentIndex++;
        if (currentIndex == size) {
            currentIndex = 0;
        }
        return former;
    }

    public double currentMean() {
        return StatUtils.mean(values);
    }

    public double currentStDev() {
        return Math.sqrt(StatUtils.variance(values));
    }
}
