package com.zuehlke.carrera.lightstomp.stompSocket;

import com.zuehlke.carrera.lightstomp.StompFrame;

public interface IStompSocket {

    /**
     * @return true if this socket is connected
     */
    boolean isConnected();

    /**
     * @param listener the listener to listen on the connection
     */
    void connect(ISocketListener listener);

    /**
     * Send the given Frame
     * @param request the request frame
     */
    void sendFrame(StompFrame request);

    /**
     * @return the host to which this socket is connected
     */
    String getHost();

}
