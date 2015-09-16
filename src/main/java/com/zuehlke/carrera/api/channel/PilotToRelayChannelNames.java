package com.zuehlke.carrera.api.channel;

import com.zuehlke.carrera.stomp.ParamUtil;

public class PilotToRelayChannelNames implements RaceChannelNames {
    private static final String START_TEMPLATE = "/topic/pilots/{id}/start";
    private static final String STOP_TEMPLATE = "/topic/pilots/{id}/stop";
    private static final String SENSOR_TEMPLATE = "/topic/pilots/{id}/sensor";
    private static final String VELOCITY_TEMPLATE = "/topic/pilots/{id}/velocity";
    private static final String PENALTY_TEMPLATE = "/topic/pilots/{id}/penalty";
    private static final String ROUND_PASSED_TEMPLATE = "/topic/pilots/{id}/roundtime";
    private static final String ANNOUNCE = "/app/pilots/announce";
    private static final String POWER = "/app/pilots/power";
    private final String clientId;

    public PilotToRelayChannelNames(String clientId) {
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
        return ParamUtil.paramUrl(SENSOR_TEMPLATE, clientId);
    }

    @Override
    public String velocity() {
        return ParamUtil.paramUrl(VELOCITY_TEMPLATE, clientId);
    }

    @Override
    public String penalty() {
        return ParamUtil.paramUrl(PENALTY_TEMPLATE, clientId);
    }

    @Override
    public String roundPassed() {
        return ParamUtil.paramUrl(ROUND_PASSED_TEMPLATE, clientId);
    }

    @Override
    public String announce() {
        return ParamUtil.paramUrl(ANNOUNCE, clientId);
    }

    @Override
    public String powerControl() {
        return ParamUtil.paramUrl(POWER, clientId);
    }
}
