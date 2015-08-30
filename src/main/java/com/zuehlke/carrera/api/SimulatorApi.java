package com.zuehlke.carrera.api;

import com.zuehlke.carrera.relayapi.messages.*;

import java.util.function.Consumer;

public interface SimulatorApi extends Api {

    void announce(RaceTrack message);

    void sensor(SensorEvent message);

    void velocity(VelocityMessage message);

    void penalty(PenaltyMessage message);

    void roundPassed(RoundPassedMessage message);

    void onPowerControl(Consumer<PowerControl> onPowerControl);

    void onRaceStart(Consumer<RaceStartMessage> onRaceStart);

    void onRaceStop(Consumer<RaceStopMessage> onRaceStop);
}
