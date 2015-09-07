package com.zuehlke.carrera.api.seralize;

import org.apache.thrift.TException;

/**
 * Created by arbe on 25.08.2015.
 */
public class ThriftSerializer implements Serializer {

    ThriftMapper thriftMapper = new ThriftMapper();

    @Override
    public byte[] serialize(Object o) {

        byte[] serializedObject = null;
        try {
            serializedObject = thriftMapper.writeValueAsBytes(o);

        } catch (TException e) {
            throw new SerializationException("Could not serialize message", e);
        }
        return serializedObject;
    }

    @Override
    public <T> T deserialize(byte[] message, Class<T> messageType) {
        T deserializeObject = null;
        try {
            deserializeObject = thriftMapper.readValue(message, messageType);
        } catch (TException e) {
            throw new DeserializationException("Could not deserialize message", e);
        }
        return deserializeObject;
    }
}
