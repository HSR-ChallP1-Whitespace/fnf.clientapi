package com.zuehlke.carrera.clientapi.seralize;

public interface Serializer {

    <T> T deserialize(String message, Class<T> messageType);

    String serialize(Object o);
}
