package com.zuehlke.carrera.timeseries;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TimeSeriesTest {

    @Test
    public void testAlmostEvenlyDistibutedSeries() {

        List<Observation<Double>> obs = createAlmostEvenlyDistributedSeries();

        TimeSeries<String, Double> ts = new TimeSeries<>("Test", obs, false, 3);

        TimeSeries<String, Double> sub = ts.subSeries(28, 48);

        Assert.assertEquals(9, sub.getSize());
        Assert.assertTrue(7.0 == sub.getFirst().v); // t == 29
        Assert.assertTrue(15.0 == sub.getLast().v); // t == 48 - double occurrence

        // Boundaries spot-on
        TimeSeries<String, Double> sub1 = sub.subSeries(37, 47);
        Assert.assertEquals(5, sub1.getSize());
        Assert.assertTrue(9.0 == sub1.getFirst().v); // t == 37
        Assert.assertTrue(13.0 == sub1.getLast().v); // t == 47 - double occurrence
    }

    @Test
    public void testUnEvenlyDistibutedSeries() {

        List<Observation<Double>> obs = createUnevenlyDistributedSeries();

        // intentionally small good guess distance to force binary search
        TimeSeries<String, Double> ts = new TimeSeries<>("Test", obs, false, 3);

        TimeSeries<String, Double> sub = ts.subSeries(510, 524);

        Assert.assertEquals(7, sub.getSize());
        Assert.assertTrue(14.0 == sub.getFirst().v); // t ==
        Assert.assertTrue(20.0 == sub.getLast().v); // t == 48 - double occurrence

    }


    private List<Observation<Double>> createUnevenlyDistributedSeries() {
        List<Observation<Double>> obs = new ArrayList<>();
        obs.add(new Observation<>(20, 1.0));
        obs.add(new Observation<>(30, 2.0));
        obs.add(new Observation<>(31, 3.0));
        obs.add(new Observation<>(300, 4.0));
        obs.add(new Observation<>(305, 5.0));
        obs.add(new Observation<>(306, 6.0));
        obs.add(new Observation<>(310, 7.0));
        obs.add(new Observation<>(320, 8.0));
        obs.add(new Observation<>(350, 9.0));
        obs.add(new Observation<>(350, 10.0));
        obs.add(new Observation<>(400, 11.0));
        obs.add(new Observation<>(500, 12.0));
        obs.add(new Observation<>(503, 13.0));
        obs.add(new Observation<>(510, 14.0));
        obs.add(new Observation<>(511, 15.0));
        obs.add(new Observation<>(513, 16.0));
        obs.add(new Observation<>(514, 17.0));
        obs.add(new Observation<>(515, 18.0));
        obs.add(new Observation<>(520, 19.0));
        obs.add(new Observation<>(523, 20.0));
        obs.add(new Observation<>(525, 21.0));
        obs.add(new Observation<>(526, 22.0));
        obs.add(new Observation<>(530, 23.0));
        obs.add(new Observation<>(550, 24.0));
        return obs;
    }

    private List<Observation<Double>> createAlmostEvenlyDistributedSeries() {
        List<Observation<Double>> obs = new ArrayList<>();
        obs.add(new Observation<>(20, 1.0));
        obs.add(new Observation<>(22, 2.0));
        obs.add(new Observation<>(24, 3.0));
        obs.add(new Observation<>(25, 4.0));
        obs.add(new Observation<>(26, 5.0));
        obs.add(new Observation<>(27, 6.0));
        obs.add(new Observation<>(29, 7.0));
        obs.add(new Observation<>(34, 8.0));
        obs.add(new Observation<>(37, 9.0));
        obs.add(new Observation<>(38, 10.0));
        obs.add(new Observation<>(40, 11.0));
        obs.add(new Observation<>(41, 12.0));
        obs.add(new Observation<>(47, 13.0));
        obs.add(new Observation<>(48, 14.0));
        obs.add(new Observation<>(48, 15.0));
        obs.add(new Observation<>(50, 16.0));
        obs.add(new Observation<>(51, 17.0));
        obs.add(new Observation<>(55, 18.0));
        obs.add(new Observation<>(60, 19.0));
        obs.add(new Observation<>(61, 20.0));
        obs.add(new Observation<>(62, 21.0));
        obs.add(new Observation<>(65, 22.0));
        obs.add(new Observation<>(70, 23.0));
        obs.add(new Observation<>(71, 24.0));
        return obs;
    }

}
