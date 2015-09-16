package com.zuehlke.carrera.connection;

import com.zuehlke.carrera.relayapi.messages.PowerControl;

import java.util.function.Consumer;

public interface ConnectionFactoryTowardsPilots {

    TowardsPilotsConnection create(Consumer<PowerControl> onPowerControl);
}
