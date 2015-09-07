package com.zuehlke.carrera.api.seralize;

public interface Serializer {

    <T> T deserialize(byte[] message, Class<T> messageType);

    byte[] serialize(Object o);
}
