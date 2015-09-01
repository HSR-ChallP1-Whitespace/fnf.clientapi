package com.zuehlke.carrera.lightstomp.stompSocket;

import com.zuehlke.carrera.lightstomp.StompFrame;

/**
 * Socket listener interface for the stomp api
 */
public interface ISocketListener {

    /**
     * Occurs when this socket has successfully connected.
     */
    void connected();

    /**
     * Occurs when a STOMP Frame has arrived
     *
     * @param frame the frame
     */
    void onStompFrameReceived(StompFrame frame);

    /**
     * Occurs when the socket has been closed
     *
     * @param reason a description of the reason
     */
    void closed(String reason);

    /**
     * Occurs when no connection to the socket could be established.
     *
     * @param exception the exception thrown during the connection attempt
     */
    void connectionFailed(Throwable exception);

}
