package com.zuehlke.carrera.api.client;

import com.zuehlke.carrera.api.client.rabbit.RabbitClient;
import com.zuehlke.carrera.lightstomp.StompClient;

/**
 * Created by arbe on 28.08.2015.
 */
public class ClientFactory {


    public static Client getClient(ClientType clientType, String teamId,String accessCode) {

        Client client = null;

        switch (clientType) {
            case STOMP_CLIENT:
                client = new StompClient(teamId,accessCode);
                break;
            case RABBIT_CLIENT:
                client = new RabbitClient(teamId,accessCode);
                break;
        }

        return client;
    }


}
