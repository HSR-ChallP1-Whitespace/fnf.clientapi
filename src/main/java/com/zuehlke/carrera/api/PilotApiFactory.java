package com.zuehlke.carrera.api;

import com.zuehlke.carrera.api.channel.PilotToRelayChannelNames;
import com.zuehlke.carrera.api.channel.RaceChannelNames;
import com.zuehlke.carrera.api.client.Client;
import com.zuehlke.carrera.api.client.ClientFactory;
import com.zuehlke.carrera.api.client.ClientType;
import com.zuehlke.carrera.api.seralize.Serializer;
import com.zuehlke.carrera.api.seralize.SerializerFactory;
import com.zuehlke.carrera.api.seralize.SerializerType;


/**
 * Created by arbe on 01.09.2015.
 */
public class PilotApiFactory {

    public static PilotApi create() {

        String teamId = System.getProperty("teamId");
        String accessCode = System.getProperty("accessCode");
        String clientType = System.getProperty("client", "rabbit");
        String serializerType = System.getProperty("serializer", "jackson");

        RaceChannelNames raceChannelNames = new PilotToRelayChannelNames(teamId);

        Client client = ClientFactory.getClient(findClientType(clientType), teamId, accessCode);
        System.out.println(client);
        Serializer serializer = SerializerFactory.getSerializer(findSerializerType(serializerType));
        ApiConnection apiConnection = new ApiConnection(client, serializer);
        return new PilotApiImpl(apiConnection, raceChannelNames);

    }

    private static ClientType findClientType(String serializerType) {
        if (serializerType.equals("rabbit")) {
            return ClientType.RABBIT_CLIENT;
        } else {
            return ClientType.STOMP_CLIENT;
        }
    }

    private static SerializerType findSerializerType(String serializerType) {
        if (serializerType.equals("jackson")) {
            return SerializerType.JACKSON_SERIALIZER.JACKSON_SERIALIZER;
        } else {
            return SerializerType.THRIFT_SERIALIZER;
        }
    }
}
