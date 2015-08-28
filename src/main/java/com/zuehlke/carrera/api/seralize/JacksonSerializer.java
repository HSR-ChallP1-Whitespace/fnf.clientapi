package com.zuehlke.carrera.api.seralize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JacksonSerializer implements Serializer {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T deserialize(byte[] message, Class<T> messageType) {
        try {
            return trySerialize(message, messageType);
        } catch (IOException e) {
            throw new DeserializationException("Could not deserialize message", e);
        }
    }

    private <T> T trySerialize(byte[] message, Class<T> messageType) throws IOException {
        return mapper.readValue(message, messageType);
    }

    @Override
    public byte[] serialize(Object o) {
        try {
            return mapper.writeValueAsBytes(o);
        } catch (JsonProcessingException e) {
            throw new SerializationException("Could not serialize message", e);
        }
    }
}
