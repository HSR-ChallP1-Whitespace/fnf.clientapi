package com.zuehlke.carrera.serialization;

import com.zuehlke.carrera.api.seralize.JacksonSerializer;
import com.zuehlke.carrera.api.seralize.Serializer;
import com.zuehlke.carrera.relayapi.messages.RaceStartMessage;
import com.zuehlke.carrera.relayapi.messages.RaceType;
import com.zuehlke.carrera.relayapi.messages.RoundPassedMessage;
import com.zuehlke.carrera.relayapi.messages.SensorEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class JacksonSerializationTest {
    private Serializer serializer;

    @Before
    public void setUp() {
        serializer = new JacksonSerializer();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void serializationRoundPassedPessage()  {

        String trackId = "1";
        long currentTime = System.currentTimeMillis();

        RoundPassedMessage roundPassedMessage = new RoundPassedMessage(trackId,currentTime);

        byte[] serializedObject = serializer.serialize(roundPassedMessage);

        RoundPassedMessage deserializedObject = serializer.deserialize(serializedObject, RoundPassedMessage.class);

        assertEquals(trackId, deserializedObject.getRaceTrackId());
        assertEquals(currentTime,deserializedObject.getTimeStamp());

    }

    @Test
    public void serializationRaceStartMessage() {

        String trackId = "1";
        RaceType raceType = RaceType.COMPETITION;
        String teamID = "team12";
        String description = "test";
        long timeStamp = System.currentTimeMillis();
        boolean recordData = false;

        RaceStartMessage raceStartMessage = new RaceStartMessage(trackId,raceType,teamID,timeStamp,description,recordData);


        byte[] serializedObject = serializer.serialize(raceStartMessage);

        RaceStartMessage deserializedObject = serializer.deserialize(serializedObject, RaceStartMessage.class);

        assertEquals(trackId, deserializedObject.getTrackId());
        assertEquals(raceType,RaceType.COMPETITION);
        assertEquals(teamID,deserializedObject.getTeamId());
        assertEquals(description,deserializedObject.getDescription());
        assertEquals(timeStamp,deserializedObject.getTimestamp());
        assertEquals(recordData,deserializedObject.isRecordData());

    }

    @Test
    public void serializationSensorEvent(){


        String trackId = "1";
        long timeStamp = System.currentTimeMillis();
        int[] a = {1,2,3};
        int[] g = {4,5,6};
        int[] m = {7,8,9};
        int t = 0;
        SensorEvent sensorEvent = new SensorEvent(trackId,a,g,m,timeStamp);
        sensorEvent.setT(t);

        byte[] serializedObject = serializer.serialize(sensorEvent);
        SensorEvent deserializedObject = serializer.deserialize(serializedObject, SensorEvent.class);

        assertEquals(trackId,deserializedObject.getRaceTrackId());
        assertEquals(timeStamp, deserializedObject.getTimeStamp());
        assertArrayEquals(a, deserializedObject.getA());
        assertArrayEquals(g, deserializedObject.getG());
        assertArrayEquals(m, deserializedObject.getM());
        assertEquals(t,deserializedObject.getT());

    }




}
