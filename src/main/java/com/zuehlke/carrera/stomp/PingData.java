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
     * @return the stomp client id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the id of the message
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