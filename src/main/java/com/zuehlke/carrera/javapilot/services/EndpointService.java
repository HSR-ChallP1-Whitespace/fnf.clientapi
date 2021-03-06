package com.zuehlke.carrera.javapilot.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Determines the url of this application
 */
@Service
public class EndpointService implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(EndpointService.class);

    private String address;
    private int port;
    private String httpEndpoint = null;

    public EndpointService() {
        setAddress();
    }

    @Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent embeddedServletContainerInitializedEvent) {
        port = embeddedServletContainerInitializedEvent.getEmbeddedServletContainer().getPort();
        httpEndpoint = "http://" + address + ":" + port;
        LOG.info("Server is running on port " + port);
    }

    public String getHttpEndpoint() {
        return httpEndpoint;
    }

    private void setAddress() {
        try {
            address = InetAddress.getLocalHost().getCanonicalHostName();
        } catch (UnknownHostException e) {
            LOG.error("", e);
        }
    }
}
