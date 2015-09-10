package com.zuehlke.carrera.api;

import com.zuehlke.carrera.api.channel.PilotToRelayChannelNames;
import com.zuehlke.carrera.api.channel.RaceChannelNames;
import com.zuehlke.carrera.api.client.Client;
import com.zuehlke.carrera.api.client.ClientFactory;
import com.zuehlke.carrera.api.client.ClientType;
import com.zuehlke.carrera.api.seralize.Serializer;
import com.zuehlke.carrera.api.seralize.SerializerFactory;
import com.zuehlke.carrera.api.seralize.SerializerType;

import java.util.Properties;


/**
 * Created by arbe on 01.09.2015.
 */
public class PilotApiFactory {

    public static final String TEAM_ID_KEY = "teamId";
    public static final String ACCESS_CODE_KEY = "accessCode";
    public static final String CLIENT_KEY = "client";
    public static final String SERIALIZER_KEY = "serializer";

    public static final String CLIENT_STOMP = "stomp";
    public static final String CLIENT_RABBIT = "rabbit";

    public static final String SERIALIZER_JACKSON = "jackson";
    public static final String SERIALIZER_THRIFT = "thrift";


    public static PilotApi create(Properties properties) {

        String teamId = properties.getProperty(TEAM_ID_KEY);
        String accessCode = properties.getProperty(ACCESS_CODE_KEY);
        String clientType = properties.getProperty(CLIENT_KEY);
        String serializerType = properties.getProperty(SERIALIZER_KEY);

        RaceChannelNames raceChannelNames = new PilotToRelayChannelNames(teamId);

        Client client = ClientFactory.getClient(findClientType(clientType), teamId, accessCode);
        System.out.println(client);
        Serializer serializer = SerializerFactory.getSerializer(findSerializerType(serializerType));
        ApiConnection apiConnection = new ApiConnection(client, serializer);
        return new PilotApiImpl(apiConnection, raceChannelNames);

    }

    private static ClientType findClientType(String serializerType) {
        if (serializerType.equals(CLIENT_RABBIT)) {
            return ClientType.RABBIT_CLIENT;
        } else {
            return ClientType.STOMP_CLIENT;
        }
    }

    private static SerializerType findSerializerType(String serializerType) {
        if (serializerType.equals(SERIALIZER_JACKSON)) {
            return SerializerType.JACKSON_SERIALIZER.JACKSON_SERIALIZER;
        } else {
            return SerializerType.THRIFT_SERIALIZER;
        }
    }
}
