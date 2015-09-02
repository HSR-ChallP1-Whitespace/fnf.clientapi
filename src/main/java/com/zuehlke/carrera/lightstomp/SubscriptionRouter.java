package com.zuehlke.carrera.lightstomp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages listener registration and mapping.
 * Routes STOMP Messages to the registered listener.
 */
class SubscriptionRouter {

    private final Map<String, List<MessageListener>> channelToListenerMap = new HashMap<>();


    /**
     * Register a route
     *
     * @param channel  The channel
     * @param listener the listener
     */
    public synchronized void register(String channel, MessageListener listener) {

        // Channel map
        List<MessageListener> listeners = channelToListenerMap.get(channel);
        if (listeners == null) {
            listeners = new ArrayList<>();
            channelToListenerMap.put(channel, listeners);
        }
        listeners.add(listener);
    }

    /**
     * Routes the given message to the given channel and notify all
     * listeners of this channel.
     *
     * @param channel the id of the simulator or pilot to route to
     * @param message the message to be routed
     */
    public synchronized void routeMessage(String channel, String message) {
        List<MessageListener> listeners = channelToListenerMap.get(channel);
        if (listeners != null) {
            for (MessageListener l : listeners) {
                l.messageReceived(message);
            }
        }
    }

}
