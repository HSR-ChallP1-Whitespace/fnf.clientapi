package com.zuehlke.carrera.api.seralize;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;

/**
 * Created by arbe on 25.08.2015.
 */
public class ThriftSerializer implements Serializer {


    TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory();

    @Override
    public byte[] serialize(Object o) {


        byte[] serializedObject = null;
        try {
            ThriftMapper thriftMapper = new ThriftMapper(factory);
            serializedObject = thriftMapper.writeValueAsBytes(o);

        } catch (TException e) {
            throw new SerializationException("Could not serialize message", e);
        }
        return serializedObject;
    }

    @Override
    public synchronized <T> T deserialize(byte[] message, Class<T> messageType) {
        T deserializeObject = null;
        try {
            ThriftMapper thriftMapper = new ThriftMapper(factory);
            deserializeObject = thriftMapper.readValue(message, messageType);
        } catch (TException e) {
            throw new DeserializationException("Could not deserialize message", e);
        }
        return deserializeObject;
    }
}
