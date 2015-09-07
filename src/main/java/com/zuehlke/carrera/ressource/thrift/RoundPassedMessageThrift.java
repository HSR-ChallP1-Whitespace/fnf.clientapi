/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.zuehlke.carrera.ressource.thrift;

import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;

import java.util.*;

public class RoundPassedMessageThrift implements org.apache.thrift.TBase<RoundPassedMessageThrift, RoundPassedMessageThrift._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RoundPassedMessageThrift");

  private static final org.apache.thrift.protocol.TField TIME_STAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("timeStamp", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField RACE_TRACK_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("raceTrackId", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new RoundPassedMessageThriftStandardSchemeFactory());
    schemes.put(TupleScheme.class, new RoundPassedMessageThriftTupleSchemeFactory());
  }

  public long timeStamp; // required
  public String raceTrackId; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TIME_STAMP((short)1, "timeStamp"),
    RACE_TRACK_ID((short)2, "raceTrackId");

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
        case 1: // TIME_STAMP
          return TIME_STAMP;
        case 2: // RACE_TRACK_ID
          return RACE_TRACK_ID;
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
    tmpMap.put(_Fields.TIME_STAMP, new org.apache.thrift.meta_data.FieldMetaData("timeStamp", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "long")));
    tmpMap.put(_Fields.RACE_TRACK_ID, new org.apache.thrift.meta_data.FieldMetaData("raceTrackId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RoundPassedMessageThrift.class, metaDataMap);
  }

  public RoundPassedMessageThrift() {
  }

  public RoundPassedMessageThrift(
    long timeStamp,
    String raceTrackId)
  {
    this();
    this.timeStamp = timeStamp;
    setTimeStampIsSet(true);
    this.raceTrackId = raceTrackId;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RoundPassedMessageThrift(RoundPassedMessageThrift other) {
    __isset_bitfield = other.__isset_bitfield;
    this.timeStamp = other.timeStamp;
    if (other.isSetRaceTrackId()) {
      this.raceTrackId = other.raceTrackId;
    }
  }

  public RoundPassedMessageThrift deepCopy() {
    return new RoundPassedMessageThrift(this);
  }

  @Override
  public void clear() {
    setTimeStampIsSet(false);
    this.timeStamp = 0;
    this.raceTrackId = null;
  }

  public long getTimeStamp() {
    return this.timeStamp;
  }

  public RoundPassedMessageThrift setTimeStamp(long timeStamp) {
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

  public String getRaceTrackId() {
    return this.raceTrackId;
  }

  public RoundPassedMessageThrift setRaceTrackId(String raceTrackId) {
    this.raceTrackId = raceTrackId;
    return this;
  }

  public void unsetRaceTrackId() {
    this.raceTrackId = null;
  }

  /** Returns true if field raceTrackId is set (has been assigned a value) and false otherwise */
  public boolean isSetRaceTrackId() {
    return this.raceTrackId != null;
  }

  public void setRaceTrackIdIsSet(boolean value) {
    if (!value) {
      this.raceTrackId = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TIME_STAMP:
      if (value == null) {
        unsetTimeStamp();
      } else {
        setTimeStamp((Long)value);
      }
      break;

    case RACE_TRACK_ID:
      if (value == null) {
        unsetRaceTrackId();
      } else {
        setRaceTrackId((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TIME_STAMP:
      return Long.valueOf(getTimeStamp());

    case RACE_TRACK_ID:
      return getRaceTrackId();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TIME_STAMP:
      return isSetTimeStamp();
    case RACE_TRACK_ID:
      return isSetRaceTrackId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RoundPassedMessageThrift)
      return this.equals((RoundPassedMessageThrift)that);
    return false;
  }

  public boolean equals(RoundPassedMessageThrift that) {
    if (that == null)
      return false;

    boolean this_present_timeStamp = true;
    boolean that_present_timeStamp = true;
    if (this_present_timeStamp || that_present_timeStamp) {
      if (!(this_present_timeStamp && that_present_timeStamp))
        return false;
      if (this.timeStamp != that.timeStamp)
        return false;
    }

    boolean this_present_raceTrackId = true && this.isSetRaceTrackId();
    boolean that_present_raceTrackId = true && that.isSetRaceTrackId();
    if (this_present_raceTrackId || that_present_raceTrackId) {
      if (!(this_present_raceTrackId && that_present_raceTrackId))
        return false;
      if (!this.raceTrackId.equals(that.raceTrackId))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(RoundPassedMessageThrift other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    RoundPassedMessageThrift typedOther = (RoundPassedMessageThrift)other;

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
    lastComparison = Boolean.valueOf(isSetRaceTrackId()).compareTo(typedOther.isSetRaceTrackId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRaceTrackId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.raceTrackId, typedOther.raceTrackId);
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
    StringBuilder sb = new StringBuilder("RoundPassedMessageThrift(");
    boolean first = true;

    sb.append("timeStamp:");
    sb.append(this.timeStamp);
    first = false;
    if (!first) sb.append(", ");
    sb.append("raceTrackId:");
    if (this.raceTrackId == null) {
      sb.append("null");
    } else {
      sb.append(this.raceTrackId);
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

  private static class RoundPassedMessageThriftStandardSchemeFactory implements SchemeFactory {
    public RoundPassedMessageThriftStandardScheme getScheme() {
      return new RoundPassedMessageThriftStandardScheme();
    }
  }

  private static class RoundPassedMessageThriftStandardScheme extends StandardScheme<RoundPassedMessageThrift> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RoundPassedMessageThrift struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TIME_STAMP
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.timeStamp = iprot.readI64();
              struct.setTimeStampIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // RACE_TRACK_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.raceTrackId = iprot.readString();
              struct.setRaceTrackIdIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, RoundPassedMessageThrift struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(TIME_STAMP_FIELD_DESC);
      oprot.writeI64(struct.timeStamp);
      oprot.writeFieldEnd();
      if (struct.raceTrackId != null) {
        oprot.writeFieldBegin(RACE_TRACK_ID_FIELD_DESC);
        oprot.writeString(struct.raceTrackId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RoundPassedMessageThriftTupleSchemeFactory implements SchemeFactory {
    public RoundPassedMessageThriftTupleScheme getScheme() {
      return new RoundPassedMessageThriftTupleScheme();
    }
  }

  private static class RoundPassedMessageThriftTupleScheme extends TupleScheme<RoundPassedMessageThrift> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RoundPassedMessageThrift struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetTimeStamp()) {
        optionals.set(0);
      }
      if (struct.isSetRaceTrackId()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetTimeStamp()) {
        oprot.writeI64(struct.timeStamp);
      }
      if (struct.isSetRaceTrackId()) {
        oprot.writeString(struct.raceTrackId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RoundPassedMessageThrift struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.timeStamp = iprot.readI64();
        struct.setTimeStampIsSet(true);
      }
      if (incoming.get(1)) {
        struct.raceTrackId = iprot.readString();
        struct.setRaceTrackIdIsSet(true);
      }
    }
  }

}
