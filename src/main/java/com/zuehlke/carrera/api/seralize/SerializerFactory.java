package com.zuehlke.carrera.api.seralize;

/**
 * Created by arbe on 31.08.2015.
 */
public class SerializerFactory {

    public static Serializer getSerializer(SerializerType serializerType) {

        Serializer serializer = null;

        switch (serializerType) {
            case JACKSON_SERIALIZER:
                serializer = new JacksonSerializer();
                break;
            case THRIFT_SERIALIZER:
                serializer = new ThriftSerializer();
                break;
        }
        return serializer;
    }
}
