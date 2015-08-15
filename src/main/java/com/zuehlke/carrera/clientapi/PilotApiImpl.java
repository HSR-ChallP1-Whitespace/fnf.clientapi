package com.zuehlke.carrera.clientapi;

import com.zuehlke.carrera.clientapi.channel.ChannelNames;
import com.zuehlke.carrera.clientapi.client.Client;
import com.zuehlke.carrera.clientapi.seralize.Serializer;
import com.zuehlke.carrera.relayapi.messages.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PilotApiImpl implements PilotApi {
    private static final Logger LOG = LoggerFactory.getLogger(PilotApiImpl.class);
    private final List<Subscription> subscriptions = new ArrayList<>();
    private final Client client;
    private final ChannelNames names;
    private final Serializer serializer;

    public PilotApiImpl(Client client, ChannelNames names, Serializer serializer) {
        this.names = names;
        this.client = client;
        this.serializer = serializer;
    }

    @Override
    public void connect(String url) {
        client.connect(url);
        for(Subscription subscription : subscriptions) {
            subscription.subscribe(client);
        }
    }

    @Override
    public void disconnect() {
        client.disconnect();
    }

    @Override
    public void announce(PilotLifeSign pilotLifeSign) {
        LOG.info("Publishing to " + names.announce());
        client.publish(names.announce(), serializer.serialize(pilotLifeSign));
    }

    @Override
    public void powerControl(PowerControl powerControl) {
        LOG.info("Publishing to " + names.powerControl());
        client.publish(names.powerControl(), serializer.serialize(powerControl));
    }

    @Override
    public void onRaceStart(Consumer<RaceStartMessage> onRaceStart) {
        LOG.info("Subscribing to " + names.raceStart());
        subscriptions.add(subscriptionFor(names.raceStart(), onRaceStart, RaceStartMessage.class));
    }

    @Override
    public void onRaceStop(Consumer<RaceStopMessage> onRaceStop) {
        LOG.info("Subscribing to " + names.raceStop());
        subscriptions.add(subscriptionFor(names.raceStop(), onRaceStop, RaceStopMessage.class));
    }

    @Override
    public void onVelocity(Consumer<VelocityMessage> onVelocity) {
        LOG.info("Subscribing to " + names.velocity());
        subscriptions.add(subscriptionFor(names.velocity(), onVelocity, VelocityMessage.class));
    }

    @Override
    public void onPenalty(Consumer<PenaltyMessage> onPenalty) {
        LOG.info("Subscribing to " + names.penalty());
        subscriptions.add(subscriptionFor(names.penalty(), onPenalty, PenaltyMessage.class));
    }

    @Override
    public void onSensor(Consumer<SensorEvent> onSensor) {
        LOG.info("Subscribing to " + names.sensor());
        subscriptions.add(subscriptionFor(names.sensor(), onSensor, SensorEvent.class));
    }

    @Override
    public void onRoundPassed(Consumer<RoundPassedMessage> onRoundPassed) {
        LOG.info("Subscribing to " + names.roundPassed());
        subscriptions.add(subscriptionFor(names.roundPassed(), onRoundPassed, RoundPassedMessage.class));
    }

    private <T> Subscription subscriptionFor(String channel, Consumer<T> consumer, Class<T> messageType) {
        return new Subscription(channel, message -> {
            LOG.info("Receiving message in channel " + channel);
            consumer.accept(serializer.deserialize(message, messageType));
        });
    }
}
