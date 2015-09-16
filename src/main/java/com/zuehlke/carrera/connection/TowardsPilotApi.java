package com.zuehlke.carrera.connection;

import com.zuehlke.carrera.api.Api;
import com.zuehlke.carrera.relayapi.messages.*;

import java.util.function.Consumer;

/**
 *  the "inverse" of the PilotApi
 */
public interface TowardsPilotApi extends Api {

    void sensor(SensorEvent message);

    void velocity(VelocityMessage message);

    void penalty(PenaltyMessage message);

    void roundPassed(RoundTimeMessage message);

    void raceStart(RaceStartMessage message);

    void raceStop(RaceStopMessage message);

    void onPowerControl(Consumer<PowerControl> onPowerControl);


}
