package com.zuehlke.carrera.api.seralize;

import com.zuehlke.carrera.relayapi.messages.*;
import com.zuehlke.carrera.ressource.thrift.*;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arbe on 25.08.2015.
 */
public class ThriftMapper {

    private TSerializer thriftSerializer = new TSerializer(new TBinaryProtocol.Factory());
    private TDeserializer thriftDeserializer = new TDeserializer(new TBinaryProtocol.Factory());

    public <T> T readValue(byte[] message, Class<T> messageType) throws TException {


        T deserializedObject = null;
        if (PenaltyMessage.class.isAssignableFrom(messageType)) {

            PenaltyMessageThrift penaltyMessageThrift = new PenaltyMessageThrift();
            thriftDeserializer.deserialize(penaltyMessageThrift, message);

            PenaltyMessage penaltyMessage = new PenaltyMessage(penaltyMessageThrift.getRaceTrack(),
                    penaltyMessageThrift.getBarrier(), penaltyMessageThrift.getActualSpeed(), penaltyMessageThrift
                    .getSpeedLimit(), penaltyMessageThrift.getPenalty_ms());

            deserializedObject = (T) penaltyMessage;
        } else if (PilotLifeSign.class.isAssignableFrom(messageType)) {

            PilotLifeSignThrift pilotLifeSignThrift = new PilotLifeSignThrift();
            thriftDeserializer.deserialize(pilotLifeSignThrift, message);

            PilotLifeSign pilotLifeSign = new PilotLifeSign(pilotLifeSignThrift.getTeamId(), pilotLifeSignThrift
                    .getAccessCode(), pilotLifeSignThrift.getOptionalUrl(), pilotLifeSignThrift.getTimestamp());

            deserializedObject = (T) pilotLifeSign;
        } else if (PowerControl.class.isAssignableFrom(messageType)) {
            PowerControlThrift powerControlThrift = new PowerControlThrift();
            thriftDeserializer.deserialize(powerControlThrift, message);

            PowerControl powerControl = new PowerControl(powerControlThrift.getP(), powerControlThrift.getTeamId(),
                    powerControlThrift.getAccessCode(), powerControlThrift.getTimeStamp());

            powerControl.setT(powerControlThrift.getT());

            deserializedObject = (T) powerControl;

        } else if (RaceStartMessage.class.isAssignableFrom(messageType)) {

            RaceStartMessageThrift raceStartMessageThrift = new RaceStartMessageThrift();
            thriftDeserializer.deserialize(raceStartMessageThrift, message);

            RaceStartMessage raceStartMessage = new RaceStartMessage(raceStartMessageThrift.getTrackId(),
                    getRaceTypeThrift(raceStartMessageThrift.getType()), raceStartMessageThrift.getTeamId(),
                    raceStartMessageThrift.getTimestamp(), raceStartMessageThrift.getDescription(),
                    raceStartMessageThrift.isRecordData());

            deserializedObject = (T) raceStartMessage;
        } else if (RaceStopMessage.class.isAssignableFrom(messageType)) {

            RaceStopMessageThrift raceStopMessageThrift = new RaceStopMessageThrift();
            thriftDeserializer.deserialize(raceStopMessageThrift, message);

            RaceStopMessage raceStopMessage = new RaceStopMessage(raceStopMessageThrift.getTrackId(),
                    raceStopMessageThrift.getTeamId(), raceStopMessageThrift.getTimeStamp(), getRaceTypeThrift
                    (raceStopMessageThrift.getRaceType()));


            deserializedObject = (T) raceStopMessage;

        } else if (RoundPassedMessage.class.isAssignableFrom(messageType)) {

            RoundPassedMessageThrift roundPassedMessageThrift = new RoundPassedMessageThrift();
            thriftDeserializer.deserialize(roundPassedMessageThrift, message);

            RoundPassedMessage roundPassedMessage = new RoundPassedMessage(roundPassedMessageThrift.getRaceTrackId(),
                    roundPassedMessageThrift.getTimeStamp());

            deserializedObject = (T) roundPassedMessage;

        } else if (SensorEvent.class.isAssignableFrom(messageType)) {

            SensorEventThrift sensorEventThrift = new SensorEventThrift();
            thriftDeserializer.deserialize(sensorEventThrift, message);


            SensorEvent sensorEvent = new SensorEvent(sensorEventThrift.getRaceTrackId(), convertIntListToArray
                    (sensorEventThrift.getA()), convertIntListToArray(sensorEventThrift.getG()), convertIntListToArray
                    (sensorEventThrift.getM()), sensorEventThrift.getTimeStamp());

            sensorEvent.setT(sensorEventThrift.getT());

            deserializedObject = (T) sensorEvent;


        } else if (VelocityMessage.class.isAssignableFrom(messageType)) {

            VelocityMessageThrift velocityMessageThrift = new VelocityMessageThrift();
            thriftDeserializer.deserialize(velocityMessageThrift, message);


            VelocityMessage velocityMessage = new VelocityMessage(velocityMessageThrift.getRacetrackId(),
                    velocityMessageThrift.getTimeStamp(), velocityMessageThrift.getVelocity(), velocityMessageThrift.getSourceId());

            deserializedObject = (T) velocityMessage;
        } else {
            System.out.println("no matching type for serialization");
        }

        return deserializedObject;
    }


    public byte[] writeValueAsBytes(Object object) throws TException {
        byte[] serilazedObject = null;

        if (object instanceof PenaltyMessage) {

            PenaltyMessage penaltyMessage = (PenaltyMessage) object;
            PenaltyMessageThrift penaltyMessageThrift = new PenaltyMessageThrift();

            penaltyMessageThrift.setActualSpeed(penaltyMessage.getActualSpeed());
            penaltyMessageThrift.setBarrier(penaltyMessage.getBarrier());
            penaltyMessageThrift.setPenalty_ms(penaltyMessage.getPenalty_ms());
            penaltyMessageThrift.setRaceTrack(penaltyMessage.getRaceTrack());
            penaltyMessageThrift.setSpeedLimit(penaltyMessage.getSpeedLimit());

            serilazedObject = thriftSerializer.serialize(penaltyMessageThrift);

        } else if (object instanceof PilotLifeSign) {

            PilotLifeSign pilotLifeSign = (PilotLifeSign) object;
            PilotLifeSignThrift pilotLifeSignThrift = new PilotLifeSignThrift();

            pilotLifeSignThrift.setTimestamp(pilotLifeSign.getTimestamp());
            pilotLifeSignThrift.setTeamId(pilotLifeSign.getTeamId());
            pilotLifeSignThrift.setOptionalUrl(pilotLifeSign.getOptionalUrl());
            pilotLifeSignThrift.setAccessCode(pilotLifeSign.getAccessCode());

            serilazedObject = thriftSerializer.serialize(pilotLifeSignThrift);

        } else if (object instanceof PowerControl) {

            PowerControl powerControl = (PowerControl) object;
            PowerControlThrift powerControlThrift = new PowerControlThrift();

            powerControlThrift.setAccessCode(powerControl.getAccessCode());
            powerControlThrift.setTeamId(powerControl.getTeamId());
            powerControlThrift.setT(powerControl.getT());
            powerControlThrift.setP(powerControl.getP());
            powerControlThrift.setTimeStamp(powerControl.getTimeStamp());

            serilazedObject = thriftSerializer.serialize(powerControlThrift);

        } else if (object instanceof RaceStartMessage) {

            RaceStartMessage raceStartMessage = (RaceStartMessage) object;
            RaceStartMessageThrift raceStartMessageThrift = new RaceStartMessageThrift();

            raceStartMessageThrift.setTrackId(raceStartMessage.getTrackId());
            RaceTypeThrift raceTypeThrift = getRaceType(raceStartMessage.getType());
            raceStartMessageThrift.setType(raceTypeThrift);
            raceStartMessageThrift.setRecordData(raceStartMessage.isRecordData());
            raceStartMessageThrift.setTeamId(raceStartMessage.getTeamId());
            raceStartMessageThrift.setDescription(raceStartMessage.getDescription());
            raceStartMessageThrift.setTimestamp(raceStartMessage.getTimestamp());

            serilazedObject = thriftSerializer.serialize(raceStartMessageThrift);


        } else if (object instanceof RaceStopMessage) {

            RaceStopMessage raceStopMessage = (RaceStopMessage) object;
            RaceStopMessageThrift raceStopMessageThrift = new RaceStopMessageThrift();

            raceStopMessageThrift.setTeamId(raceStopMessage.getTeamId());
            raceStopMessageThrift.setTrackId(raceStopMessage.getTrackId());
            raceStopMessageThrift.setRaceType(getRaceType(raceStopMessage.getRaceType()));
            raceStopMessageThrift.setTimeStamp(raceStopMessage.getTimeStamp());

            serilazedObject = thriftSerializer.serialize(raceStopMessageThrift);

        } else if (object instanceof RoundPassedMessage) {

            RoundPassedMessage roundPassedMessage = (RoundPassedMessage) object;
            RoundPassedMessageThrift roundPassedMessageThrift = new RoundPassedMessageThrift();

            roundPassedMessageThrift.setTimeStamp(roundPassedMessage.getTimeStamp());
            roundPassedMessageThrift.setRaceTrackId(roundPassedMessage.getRaceTrackId());

            serilazedObject = thriftSerializer.serialize(roundPassedMessageThrift);

        } else if (object instanceof SensorEvent) {

            SensorEvent sensorEvent = (SensorEvent) object;
            SensorEventThrift sensorEventThrift = new SensorEventThrift();

            sensorEventThrift.setRaceTrackId(sensorEvent.getRaceTrackId());
            sensorEventThrift.setTimeStamp(sensorEvent.getTimeStamp());
            sensorEventThrift.setT(sensorEvent.getT());
            sensorEventThrift.setA(convertIntArrayToList(sensorEvent.getA()));
            sensorEventThrift.setG(convertIntArrayToList(sensorEvent.getG()));
            sensorEventThrift.setM(convertIntArrayToList(sensorEvent.getM()));

            serilazedObject = thriftSerializer.serialize(sensorEventThrift);

        } else if (object instanceof VelocityMessage) {

            VelocityMessage velocityMessage = (VelocityMessage) object;
            VelocityMessageThrift velocityMessageThrift = new VelocityMessageThrift();

            velocityMessageThrift.setTimeStamp(velocityMessage.getTimeStamp());
            velocityMessageThrift.setRacetrackId(velocityMessage.getRacetrackId());
            velocityMessageThrift.setVelocity(velocityMessage.getVelocity());
            velocityMessageThrift.setSourceId(velocityMessage.getSourceId());
            velocityMessageThrift.setT(velocityMessage.getT());

            serilazedObject = thriftSerializer.serialize(velocityMessageThrift);

        }
        return serilazedObject;
    }

    private RaceTypeThrift getRaceType(RaceType raceType) {

        RaceTypeThrift raceTypeThrift = null;
        if (RaceType.COMPETITION == raceType) {
            raceTypeThrift = RaceTypeThrift.COMPETITION;
        }
        if (RaceType.TRAINING == raceType) {
            raceTypeThrift = RaceTypeThrift.TRAINING;
        }
        return raceTypeThrift;
    }

    private RaceType getRaceTypeThrift(RaceTypeThrift raceTypeThrift) {

        RaceType raceType = null;
        if (RaceTypeThrift.COMPETITION == raceTypeThrift) {
            raceType = RaceType.COMPETITION;
        }
        if (RaceTypeThrift.TRAINING == raceTypeThrift) {
            raceType = RaceType.TRAINING;
        }
        return raceType;
    }

    public List<Integer> convertIntArrayToList(int[] integerArray) {

        List<Integer> integerList = new ArrayList<>();
        for (int number : integerArray) {
            integerList.add(number);
        }
        return integerList;
    }

    public int[] convertIntListToArray(List<Integer> integerList) {

        int[] integerArray = new int[integerList.size()];
        for (int i = 0; i < integerArray.length; i++) {
            integerArray[i] = integerList.get(i);
        }
        return integerArray;
    }


}
