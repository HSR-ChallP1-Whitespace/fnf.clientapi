package com.zuehlke.carrera.api.channel;

import com.zuehlke.carrera.stomp.ParamUtil;

public class PilotToSimulatorChannelNames implements RaceChannelNames {
    private static final String ANNOUNCE = "/app/racetracks/announce";
    private static final String SENSOR = "/app/racetracks/events";
    private static final String VELOCITY = "/app/racetracks/velocity";
    private static final String PENALTY = "/app/racetracks/penalty";
    private static final String ROUND_PASSED = "/app/racetracks/roundPassed";
    private static final String POWER_TEMPLATE = "/topic/racetracks/{id}/speed";
    private static final String START_TEMPLATE = "/topic/racetracks/{id}/start";
    private static final String STOP_TEMPLATE = "/topic/racetracks/{id}/stop";
    private final String clientId;

    public PilotToSimulatorChannelNames(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String raceStart() {
        return ParamUtil.paramUrl(START_TEMPLATE, clientId);
    }

    @Override
    public String raceStop() {
        return ParamUtil.paramUrl(STOP_TEMPLATE, clientId);
    }

    @Override
    public String sensor() {
        return SENSOR;
    }

    @Override
    public String velocity() {
        return VELOCITY;
    }

    @Override
    public String penalty() {
        return PENALTY;
    }

    @Override
    public String roundPassed() {
        return ROUND_PASSED;
    }

    @Override
    public String announce() {
        return ANNOUNCE;
    }

    @Override
    public String powerControl() {
        return ParamUtil.paramUrl(POWER_TEMPLATE, clientId);
    }
}
