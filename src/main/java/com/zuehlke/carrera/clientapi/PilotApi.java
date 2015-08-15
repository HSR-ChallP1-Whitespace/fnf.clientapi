package com.zuehlke.carrera.clientapi;

import com.zuehlke.carrera.relayapi.messages.*;

import java.util.function.Consumer;

public interface PilotApi {

    void connect(String url);

    void disconnect();

    void announce(PilotLifeSign pilot);

    void powerControl(PowerControl powerControl);

    void onRaceStart(Consumer<RaceStartMessage> onRaceStart);

    void onRaceStop(Consumer<RaceStopMessage> onRaceStop);

    void onVelocity(Consumer<VelocityMessage> onVelocity);

    void onPenalty(Consumer<PenaltyMessage> onPenalty);

    void onSensor(Consumer<SensorEvent> onSensor);

    void onRoundPassed(Consumer<RoundPassedMessage> onRoundPassed);
}
