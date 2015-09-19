package com.zuehlke.carrera.relayapi.messages;

import com.zuehlke.carrera.timeseries.Observation;
import com.zuehlke.carrera.timeseries.TimeSeries;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * represents all relevant data collected during a trainging or race
 */
public class RaceEventData {

    /**
     * Assume that a first guess at the position of an observation in the time series
     * is "good enough" if it lands within this distance from the target value;
     * See javadoc of TimeSeries for a better understanding of what that means.
     */
    private static final int GOOD_GUESS_DISTANCE = 10;

    private String id;
    private long startTime;
    private String teamId;
    private String trackId;
    private String raceType;

    private List<SensorEvent> sensorEvents = new ArrayList<>();
    private List<PowerControl> powerControls = new ArrayList<>();
    private List<VelocityMessage> velocityMessages = new ArrayList<>();

    public RaceEventData(long startTime, String teamId, String trackId, String raceType) {
        this.startTime = startTime;
        this.teamId = teamId;
        this.trackId = trackId;
        this.raceType = raceType;
    }

    public void addEvent(SensorEvent event) {
        sensorEvents.add(event.valueObject());
    }

    public void addEvent(PowerControl control) {
        powerControls.add(control.valueObject());
    }

    public void add(VelocityMessage message) {
        velocityMessages.add(message.valueObject());
    }

    public List<SensorEvent> getSensorEvents() {
        return sensorEvents;
    }

    public List<PowerControl> getPowerControls() {
        return powerControls;
    }

    public long getStartTime() {
        return startTime;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getTrackId() {
        return trackId;
    }

    public String getRaceType() {
        return raceType;
    }

    public void sortAll() {

        sensorEvents.sort((o1, o2) -> o1.getTimeStamp() < o2.getTimeStamp() ? -1 :
                o1.getTimeStamp() == o2.getTimeStamp() ? 0 : 1);

        powerControls.sort((o1, o2) -> o1.getTimeStamp() < o2.getTimeStamp() ? -1 :
                o1.getTimeStamp() == o2.getTimeStamp() ? 0 : 1);

        velocityMessages.sort((o1, o2) -> o1.getTimeStamp() < o2.getTimeStamp() ? -1 :
                o1.getTimeStamp() == o2.getTimeStamp() ? 0 : 1);
    }

    public void offSetAll() {

        sensorEvents.forEach(e -> e.offSetTime(startTime));
        powerControls.forEach(p -> p.offSetTime(startTime));
        velocityMessages.forEach(v -> v.offSetTime(startTime));

    }

    public List<VelocityMessage> getVelocityMessages() {
        return velocityMessages;
    }

    public TimeSeries<RaceObservationContext, Integer> getAsTimeSeries(ObservableType type, boolean sort) {
        List<Observation<Integer>> observations = new ArrayList<>();
        RaceObservationContext context = new RaceObservationContext(teamId, trackId, type.name(), raceType, startTime);

        if (type.isSensorEventType()) {
            for (SensorEvent event : sensorEvents) {
                long t = event.getT(); //imeStamp() - context.getStartTime();
                switch (type) {
                    case ACC0:
                        observations.add(new Observation<>(t, event.getA()[0]));
                        break;
                    case ACC1:
                        observations.add(new Observation<>(t, event.getA()[1]));
                        break;
                    case ACC2:
                        observations.add(new Observation<>(t, event.getA()[2]));
                        break;
                    case MAG0:
                        observations.add(new Observation<>(t, event.getM()[0]));
                        break;
                    case MAG1:
                        observations.add(new Observation<>(t, event.getM()[1]));
                        break;
                    case MAG2:
                        observations.add(new Observation<>(t, event.getM()[2]));
                        break;
                    case GYR0:
                        observations.add(new Observation<>(t, event.getG()[0]));
                        break;
                    case GYR1:
                        observations.add(new Observation<>(t, event.getG()[1]));
                        break;
                    case GYR2:
                        observations.add(new Observation<>(t, event.getG()[2]));
                        break;
                }
            }
        } else {
            if (type == ObservableType.POWER) {
                observations.addAll(powerControls.stream().map(control -> new Observation<>(
                        control.getT(), //TimeStamp() - context.getStartTime(),
                        (int) control.getP())).collect(Collectors.toList()));

            } else if (type == ObservableType.VELO) {
                observations.addAll(velocityMessages.stream().map(
                        velocityMessage -> new Observation<>(
                                velocityMessage.getT(), //imeStamp() - context.getStartTime(),
                                (int) velocityMessage.getVelocity())).collect(Collectors.toList()));
            }
        }

        TimeSeries<RaceObservationContext, Integer> result =
                new TimeSeries<>(context, observations, sort, GOOD_GUESS_DISTANCE);


        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
