/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.zuehlke.carrera.ressource;

import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;

import java.util.*;

public class RaceStopMessageThrift implements org.apache.thrift.TBase<RaceStopMessageThrift, RaceStopMessageThrift._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RaceStopMessageThrift");

  private static final org.apache.thrift.protocol.TField TRACK_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("trackId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TEAM_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("teamId", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField TIME_STAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("timeStamp", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField RACE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("raceType", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new RaceStopMessageThriftStandardSchemeFactory());
    schemes.put(TupleScheme.class, new RaceStopMessageThriftTupleSchemeFactory());
  }

  public String trackId; // required
  public String teamId; // required
  public long timeStamp; // required
  /**
   * 
   * @see RaceTypeThrift
   */
  public RaceTypeThrift raceType; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TRACK_ID((short)1, "trackId"),
    TEAM_ID((short)2, "teamId"),
    TIME_STAMP((short)3, "timeStamp"),
    /**
     * 
     * @see RaceTypeThrift
     */
    RACE_TYPE((short)4, "raceType");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TRACK_ID
          return TRACK_ID;
        case 2: // TEAM_ID
          return TEAM_ID;
        case 3: // TIME_STAMP
          return TIME_STAMP;
        case 4: // RACE_TYPE
          return RACE_TYPE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __TIMESTAMP_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TRACK_ID, new org.apache.thrift.meta_data.FieldMetaData("trackId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    tmpMap.put(_Fields.TEAM_ID, new org.apache.thrift.meta_data.FieldMetaData("teamId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    tmpMap.put(_Fields.TIME_STAMP, new org.apache.thrift.meta_data.FieldMetaData("timeStamp", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "long")));
    tmpMap.put(_Fields.RACE_TYPE, new org.apache.thrift.meta_data.FieldMetaData("raceType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, RaceTypeThrift.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RaceStopMessageThrift.class, metaDataMap);
  }

  public RaceStopMessageThrift() {
  }

  public RaceStopMessageThrift(
    String trackId,
    String teamId,
    long timeStamp,
    RaceTypeThrift raceType)
  {
    this();
    this.trackId = trackId;
    this.teamId = teamId;
    this.timeStamp = timeStamp;
    setTimeStampIsSet(true);
    this.raceType = raceType;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RaceStopMessageThrift(RaceStopMessageThrift other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetTrackId()) {
      this.trackId = other.trackId;
    }
    if (other.isSetTeamId()) {
      this.teamId = other.teamId;
    }
    this.timeStamp = other.timeStamp;
    if (other.isSetRaceType()) {
      this.raceType = other.raceType;
    }
  }

  public RaceStopMessageThrift deepCopy() {
    return new RaceStopMessageThrift(this);
  }

  @Override
  public void clear() {
    this.trackId = null;
    this.teamId = null;
    setTimeStampIsSet(false);
    this.timeStamp = 0;
    this.raceType = null;
  }

  public String getTrackId() {
    return this.trackId;
  }

  public RaceStopMessageThrift setTrackId(String trackId) {
    this.trackId = trackId;
    return this;
  }

  public void unsetTrackId() {
    this.trackId = null;
  }

  /** Returns true if field trackId is set (has been assigned a value) and false otherwise */
  public boolean isSetTrackId() {
    return this.trackId != null;
  }

  public void setTrackIdIsSet(boolean value) {
    if (!value) {
      this.trackId = null;
    }
  }

  public String getTeamId() {
    return this.teamId;
  }

  public RaceStopMessageThrift setTeamId(String teamId) {
    this.teamId = teamId;
    return this;
  }

  public void unsetTeamId() {
    this.teamId = null;
  }

  /** Returns true if field teamId is set (has been assigned a value) and false otherwise */
  public boolean isSetTeamId() {
    return this.teamId != null;
  }

  public void setTeamIdIsSet(boolean value) {
    if (!value) {
      this.teamId = null;
    }
  }

  public long getTimeStamp() {
    return this.timeStamp;
  }

  public RaceStopMessageThrift setTimeStamp(long timeStamp) {
    this.timeStamp = timeStamp;
    setTimeStampIsSet(true);
    return this;
  }

  public void unsetTimeStamp() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TIMESTAMP_ISSET_ID);
  }

  /** Returns true if field timeStamp is set (has been assigned a value) and false otherwise */
  public boolean isSetTimeStamp() {
    return EncodingUtils.testBit(__isset_bitfield, __TIMESTAMP_ISSET_ID);
  }

  public void setTimeStampIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TIMESTAMP_ISSET_ID, value);
  }

  /**
   * 
   * @see RaceTypeThrift
   */
  public RaceTypeThrift getRaceType() {
    return this.raceType;
  }

  /**
   * 
   * @see RaceTypeThrift
   */
  public RaceStopMessageThrift setRaceType(RaceTypeThrift raceType) {
    this.raceType = raceType;
    return this;
  }

  public void unsetRaceType() {
    this.raceType = null;
  }

  /** Returns true if field raceType is set (has been assigned a value) and false otherwise */
  public boolean isSetRaceType() {
    return this.raceType != null;
  }

  public void setRaceTypeIsSet(boolean value) {
    if (!value) {
      this.raceType = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TRACK_ID:
      if (value == null) {
        unsetTrackId();
      } else {
        setTrackId((String)value);
      }
      break;

    case TEAM_ID:
      if (value == null) {
        unsetTeamId();
      } else {
        setTeamId((String)value);
      }
      break;

    case TIME_STAMP:
      if (value == null) {
        unsetTimeStamp();
      } else {
        setTimeStamp((Long)value);
      }
      break;

    case RACE_TYPE:
      if (value == null) {
        unsetRaceType();
      } else {
        setRaceType((RaceTypeThrift)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TRACK_ID:
      return getTrackId();

    case TEAM_ID:
      return getTeamId();

    case TIME_STAMP:
      return Long.valueOf(getTimeStamp());

    case RACE_TYPE:
      return getRaceType();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TRACK_ID:
      return isSetTrackId();
    case TEAM_ID:
      return isSetTeamId();
    case TIME_STAMP:
      return isSetTimeStamp();
    case RACE_TYPE:
      return isSetRaceType();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RaceStopMessageThrift)
      return this.equals((RaceStopMessageThrift)that);
    return false;
  }

  public boolean equals(RaceStopMessageThrift that) {
    if (that == null)
      return false;

    boolean this_present_trackId = true && this.isSetTrackId();
    boolean that_present_trackId = true && that.isSetTrackId();
    if (this_present_trackId || that_present_trackId) {
      if (!(this_present_trackId && that_present_trackId))
        return false;
      if (!this.trackId.equals(that.trackId))
        return false;
    }

    boolean this_present_teamId = true && this.isSetTeamId();
    boolean that_present_teamId = true && that.isSetTeamId();
    if (this_present_teamId || that_present_teamId) {
      if (!(this_present_teamId && that_present_teamId))
        return false;
      if (!this.teamId.equals(that.teamId))
        return false;
    }

    boolean this_present_timeStamp = true;
    boolean that_present_timeStamp = true;
    if (this_present_timeStamp || that_present_timeStamp) {
      if (!(this_present_timeStamp && that_present_timeStamp))
        return false;
      if (this.timeStamp != that.timeStamp)
        return false;
    }

    boolean this_present_raceType = true && this.isSetRaceType();
    boolean that_present_raceType = true && that.isSetRaceType();
    if (this_present_raceType || that_present_raceType) {
      if (!(this_present_raceType && that_present_raceType))
        return false;
      if (!this.raceType.equals(that.raceType))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(RaceStopMessageThrift other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    RaceStopMessageThrift typedOther = (RaceStopMessageThrift)other;

    lastComparison = Boolean.valueOf(isSetTrackId()).compareTo(typedOther.isSetTrackId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTrackId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.trackId, typedOther.trackId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTeamId()).compareTo(typedOther.isSetTeamId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTeamId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.teamId, typedOther.teamId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTimeStamp()).compareTo(typedOther.isSetTimeStamp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimeStamp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.timeStamp, typedOther.timeStamp);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRaceType()).compareTo(typedOther.isSetRaceType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRaceType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.raceType, typedOther.raceType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("RaceStopMessageThrift(");
    boolean first = true;

    sb.append("trackId:");
    if (this.trackId == null) {
      sb.append("null");
    } else {
      sb.append(this.trackId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("teamId:");
    if (this.teamId == null) {
      sb.append("null");
    } else {
      sb.append(this.teamId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("timeStamp:");
    sb.append(this.timeStamp);
    first = false;
    if (!first) sb.append(", ");
    sb.append("raceType:");
    if (this.raceType == null) {
      sb.append("null");
    } else {
      sb.append(this.raceType);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class RaceStopMessageThriftStandardSchemeFactory implements SchemeFactory {
    public RaceStopMessageThriftStandardScheme getScheme() {
      return new RaceStopMessageThriftStandardScheme();
    }
  }

  private static class RaceStopMessageThriftStandardScheme extends StandardScheme<RaceStopMessageThrift> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RaceStopMessageThrift struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TRACK_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.trackId = iprot.readString();
              struct.setTrackIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TEAM_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.teamId = iprot.readString();
              struct.setTeamIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TIME_STAMP
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.timeStamp = iprot.readI64();
              struct.setTimeStampIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // RACE_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.raceType = RaceTypeThrift.findByValue(iprot.readI32());
              struct.setRaceTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, RaceStopMessageThrift struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.trackId != null) {
        oprot.writeFieldBegin(TRACK_ID_FIELD_DESC);
        oprot.writeString(struct.trackId);
        oprot.writeFieldEnd();
      }
      if (struct.teamId != null) {
        oprot.writeFieldBegin(TEAM_ID_FIELD_DESC);
        oprot.writeString(struct.teamId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(TIME_STAMP_FIELD_DESC);
      oprot.writeI64(struct.timeStamp);
      oprot.writeFieldEnd();
      if (struct.raceType != null) {
        oprot.writeFieldBegin(RACE_TYPE_FIELD_DESC);
        oprot.writeI32(struct.raceType.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RaceStopMessageThriftTupleSchemeFactory implements SchemeFactory {
    public RaceStopMessageThriftTupleScheme getScheme() {
      return new RaceStopMessageThriftTupleScheme();
    }
  }

  private static class RaceStopMessageThriftTupleScheme extends TupleScheme<RaceStopMessageThrift> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RaceStopMessageThrift struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetTrackId()) {
        optionals.set(0);
      }
      if (struct.isSetTeamId()) {
        optionals.set(1);
      }
      if (struct.isSetTimeStamp()) {
        optionals.set(2);
      }
      if (struct.isSetRaceType()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetTrackId()) {
        oprot.writeString(struct.trackId);
      }
      if (struct.isSetTeamId()) {
        oprot.writeString(struct.teamId);
      }
      if (struct.isSetTimeStamp()) {
        oprot.writeI64(struct.timeStamp);
      }
      if (struct.isSetRaceType()) {
        oprot.writeI32(struct.raceType.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RaceStopMessageThrift struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.trackId = iprot.readString();
        struct.setTrackIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.teamId = iprot.readString();
        struct.setTeamIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.timeStamp = iprot.readI64();
        struct.setTimeStampIsSet(true);
      }
      if (incoming.get(3)) {
        struct.raceType = RaceTypeThrift.findByValue(iprot.readI32());
        struct.setRaceTypeIsSet(true);
      }
    }
  }

}

