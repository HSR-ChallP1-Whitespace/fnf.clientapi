package com.zuehlke.carrera.api.channel;

public class NewsChannelNames {
    private static final String TOPIC_NEWS = "/topic/simulator/news";
    private static final String TOPIC_CLOCK = "/topic/simulator/clock";

    public String data() {
        return TOPIC_NEWS;
    }

    public String tick() {
        return TOPIC_CLOCK;
    }
}
