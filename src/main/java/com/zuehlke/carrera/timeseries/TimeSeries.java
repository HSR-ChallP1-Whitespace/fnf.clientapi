package com.zuehlke.carrera.timeseries;

import java.util.List;

/**
 *
 */
public class TimeSeries<CONTEXT, TYPE extends Comparable<TYPE>> {

    private final CONTEXT context;

    private final int i0; // earliest index
    private final int ie; // latest index
    private final List<Observation<TYPE>> observations;
    private long earliest;
    private long latest;
    private long averagePeriod; // the average period between the observations
    private long totalPeriod; // the period of the represented period
    private TYPE minVal;
    private TYPE maxVal;

    // number of averages that a time at "good" index guess may be from intended time;
    private int goodGuessDistance;

    public TimeSeries(CONTEXT context, List<Observation<TYPE>> observations, boolean sort, int goodGuessDistance) {

        this.context = context;
        this.observations = observations;
        i0 = 0;
        ie = observations.size() - 1;
        if (observations.size() > 0) {
            if (sort) {
                observations.sort((o1, o2) -> (int) Math.signum(o1.t - o2.t));
            }
            earliest = observations.get(0).t;
            latest = observations.get(ie).t;
            totalPeriod = latest - earliest;
            averagePeriod = totalPeriod / observations.size();
            this.goodGuessDistance = goodGuessDistance;
            determineBoundaries();
        }
    }

    public TimeSeries(TimeSeries<CONTEXT, TYPE> original, int start, int end, int goodGuessDistance) {
        this.context = original.context;
        this.observations = original.observations;
        i0 = start;
        ie = end;
        if (observations.size() > 0) {
            earliest = observations.get(0).t;
            latest = observations.get(ie).t;
            totalPeriod = latest - earliest;
            averagePeriod = totalPeriod / observations.size();
            this.goodGuessDistance = goodGuessDistance;
            determineBoundaries();
        }
    }

    public Observation<TYPE> getFirst() {
        if (observations.size() > 0) {
            return observations.get(i0);
        } else {
            return null;
        }
    }

    /**
     * retrieve the last observation
     *
     * @return the latest observation
     */
    public Observation<TYPE> getLast() {
        if (observations.size() > 0) {
            return observations.get(ie);
        } else {
            return null;
        }
    }

    public Observation<TYPE> getObservationAtIndex(int index) {
        if ((index < i0) || (index > ie)) {
            throw new IndexOutOfBoundsException("index " + index + " not within range [" + i0 + ", " + ie + "]");
        }
        return observations.get(index);
    }

    public Observation<TYPE> getObservationBeforeOrAt(long t) {
        return observations.get(indexBeforeOrAt(t));
    }

    public Observation<TYPE> getObservationAfterOrAt(long t) {
        return observations.get(indexAfterOrAt(t));
    }


    public TimeSeries<CONTEXT, TYPE> subSeries(long start, long end) {
        return new TimeSeries<>(this, indexAfterOrAt(start), indexBeforeOrAt(end), goodGuessDistance);
    }

    // assume even distribution of the time series. If that fails, fall back to binary search.
    private int closestIndexLeftOrRight(long t) {
        int guessedIndex = (int) ((ie - i0) * (t - earliest) / totalPeriod);
        // if we're not close enough, fall back to binary search
        if (Math.abs(observations.get(guessedIndex).t - t) > goodGuessDistance * averagePeriod) {
            guessedIndex = binarySearch(t);

        } else {
            guessedIndex = closeUp(guessedIndex, t);
        }
        return guessedIndex;
    }

    private int indexBeforeOrAt(long end) {

        int guessedIndex = closestIndexLeftOrRight(end);

        if (observations.get(guessedIndex).t > end) {
            guessedIndex--;
        } else {
            // if we're on the leftmost of a number of coincidental values, step to rightmost.
            while (observations.get(guessedIndex).t == observations.get(guessedIndex + 1).t) {
                guessedIndex++;
            }
        }
        return guessedIndex;
    }


    private int indexAfterOrAt(long start) {

        int guessedIndex = closestIndexLeftOrRight(start);

        if (observations.get(guessedIndex).t < start) {
            guessedIndex++;
        }
        return guessedIndex;
    }


    /**
     * returns the leftmost index with closest t to the left or right, depending on where the original guess was
     */
    private int closeUp(int guessedIndex, long time) {
        while (observations.get(guessedIndex + 1).t <= time) {
            guessedIndex++;
        }
        while (observations.get(guessedIndex - 1).t >= time) {
            guessedIndex--;
        }
        return guessedIndex;
    }

    /**
     * binary search
     * will always find the index of the latest point in time closest to s
     *
     * @param time the point in time, the index of which we're searching
     * @return the index with time earlier or at time s
     */
    private int binarySearch(long time) {
        int step = observations.size() / 4;
        int guessedIndex = observations.size() / 2;

        for (; ; ) {
            if (observations.get(guessedIndex).t <= time && observations.get(guessedIndex + 1).t >= time) {
                break;
            }
            if (observations.get(guessedIndex).t < time) {
                guessedIndex += step;
            } else {
                guessedIndex -= step;
            }
            step /= 2;
        }
        while (observations.get(guessedIndex - 1).t >= time) {
            guessedIndex--;
        }
        return guessedIndex;
    }

    private void determineBoundaries() {
        observations.forEach(this::checkBoundaries);
    }

    private void checkBoundaries(Observation<TYPE> observation) {
        if (maxVal == null) {
            maxVal = observation.v;
        }
        if (minVal == null) {
            minVal = observation.v;
        }
        if (observation.v.compareTo(maxVal) > 0) {
            maxVal = observation.v;
        } else if (observation.v.compareTo(minVal) < 0) {
            minVal = observation.v;
        }
    }

    public CONTEXT getContext() {
        return context;
    }

    public List<Observation<TYPE>> getObservations() {
        return observations;
    }

    public TYPE getMinVal() {
        return minVal;
    }

    public TYPE getMaxVal() {
        return maxVal;
    }

    public long getEarliest() {
        return earliest;
    }

    public long getLatest() {
        return latest;
    }

    public int getSize() {
        return ie - i0 + 1;
    }

    public void observe(long timestamp, TYPE value) {
        Observation<TYPE> observation = new Observation<>(timestamp, value);
        observations.add(observation);
        checkBoundaries(observation);
    }
}
