package com.zuehlke.carrera.javapilot.services;

/**
 *  Used to announce the availability of a stomp endpoint to the relay station
 */
public class EndpointAnnouncement {

    private final String url;

    public EndpointAnnouncement(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
