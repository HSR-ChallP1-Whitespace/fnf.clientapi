package com.zuehlke.carrera.api;

import com.zuehlke.carrera.relayapi.messages.*;

import java.util.function.Consumer;

public interface PilotApi extends Api {

    void announce(PilotLifeSign message);

    void powerControl(PowerControl message);

    void onRaceStart(Consumer<RaceStartMessage> onRaceStart);

    void onRaceStop(Consumer<RaceStopMessage> onRaceStop);

    void onVelocity(Consumer<VelocityMessage> onVelocity);

    void onPenalty(Consumer<PenaltyMessage> onPenalty);

    void onSensor(Consumer<SensorEvent> onSensor);

    void onRoundPassed(Consumer<RoundTimeMessage> onRoundPassed);
}
