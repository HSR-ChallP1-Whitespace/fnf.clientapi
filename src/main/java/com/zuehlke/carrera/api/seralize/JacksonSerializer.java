package com.zuehlke.carrera.api.seralize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JacksonSerializer implements Serializer {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T deserialize(String message, Class<T> messageType) {
        try {
            return trySerialize(message, messageType);
        } catch (IOException e) {
            throw new DeserializationException("Could not deserialize message", e);
        }
    }

    private <T> T trySerialize(String message, Class<T> messageType) throws IOException {
        return mapper.readValue(message.getBytes(), messageType);
    }

    @Override
    public String serialize(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new SerializationException("Could not deserialize message", e);
        }
    }
}
