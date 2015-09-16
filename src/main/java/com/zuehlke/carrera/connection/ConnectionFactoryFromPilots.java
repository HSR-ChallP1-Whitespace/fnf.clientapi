package com.zuehlke.carrera.connection;

import com.zuehlke.carrera.javapilot.services.PilotToRelayConnection;
import com.zuehlke.carrera.relayapi.messages.*;

import java.util.function.Consumer;

public interface ConnectionFactoryFromPilots {

    PilotToRelayConnection create(Consumer<RaceStartMessage> onRaceStart,
                                  Consumer<RaceStopMessage> onRaceStop,
                                  Consumer<SensorEvent> onSensor,
                                  Consumer<VelocityMessage> onVelocity,
                                  Consumer<PenaltyMessage> onPenalty,
                                  Consumer<RoundTimeMessage> onRoundPassed);
}
