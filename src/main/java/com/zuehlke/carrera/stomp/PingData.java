package com.zuehlke.carrera.stomp;

/**
 * The payload of a STOMP ping challenge/response round trip.
 *
 * The id value uniquely identifies a STOMP client.
 * The message-id value identifies a single ping-data message.
 *
 */
public class PingData {
    private String id;
    private int messageId;

    /**
     * Empty constructor for serialisation
     */
    protected PingData(){ }

    public PingData(String id, int messageId) {
        this.id = id;
        this.messageId = messageId;
    }

    /**
     * The id of the ping target, i.e. the stomp client id.
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * The id of this ping message.
     * @return
     */
    public int getMessageId() {
        return messageId;
    }


    @Override
    public String toString() {
        return "PingData{" +
                "id='" + id + '\'' +
                ", messageId=" + messageId +
                '}';
    }
}