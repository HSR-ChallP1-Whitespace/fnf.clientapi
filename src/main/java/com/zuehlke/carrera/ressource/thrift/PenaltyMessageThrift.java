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

public class PenaltyMessageThrift implements org.apache.thrift.TBase<PenaltyMessageThrift, PenaltyMessageThrift._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PenaltyMessageThrift");

  private static final org.apache.thrift.protocol.TField ACTUAL_SPEED_FIELD_DESC = new org.apache.thrift.protocol.TField("actualSpeed", org.apache.thrift.protocol.TType.DOUBLE, (short)1);
  private static final org.apache.thrift.protocol.TField SPEED_LIMIT_FIELD_DESC = new org.apache.thrift.protocol.TField("speedLimit", org.apache.thrift.protocol.TType.DOUBLE, (short)2);
  private static final org.apache.thrift.protocol.TField PENALTY_MS_FIELD_DESC = new org.apache.thrift.protocol.TField("penalty_ms", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField BARRIER_FIELD_DESC = new org.apache.thrift.protocol.TField("barrier", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField RACE_TRACK_FIELD_DESC = new org.apache.thrift.protocol.TField("raceTrack", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new PenaltyMessageThriftStandardSchemeFactory());
    schemes.put(TupleScheme.class, new PenaltyMessageThriftTupleSchemeFactory());
  }

  public double actualSpeed; // required
  public double speedLimit; // required
  public int penalty_ms; // required
  public String barrier; // required
  public String raceTrack; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ACTUAL_SPEED((short)1, "actualSpeed"),
    SPEED_LIMIT((short)2, "speedLimit"),
    PENALTY_MS((short)3, "penalty_ms"),
    BARRIER((short)4, "barrier"),
    RACE_TRACK((short)5, "raceTrack");

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
        case 1: // ACTUAL_SPEED
          return ACTUAL_SPEED;
        case 2: // SPEED_LIMIT
          return SPEED_LIMIT;
        case 3: // PENALTY_MS
          return PENALTY_MS;
        case 4: // BARRIER
          return BARRIER;
        case 5: // RACE_TRACK
          return RACE_TRACK;
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
  private static final int __ACTUALSPEED_ISSET_ID = 0;
  private static final int __SPEEDLIMIT_ISSET_ID = 1;
  private static final int __PENALTY_MS_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ACTUAL_SPEED, new org.apache.thrift.meta_data.FieldMetaData("actualSpeed", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.SPEED_LIMIT, new org.apache.thrift.meta_data.FieldMetaData("speedLimit", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.PENALTY_MS, new org.apache.thrift.meta_data.FieldMetaData("penalty_ms", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "int")));
    tmpMap.put(_Fields.BARRIER, new org.apache.thrift.meta_data.FieldMetaData("barrier", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    tmpMap.put(_Fields.RACE_TRACK, new org.apache.thrift.meta_data.FieldMetaData("raceTrack", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PenaltyMessageThrift.class, metaDataMap);
  }

  public PenaltyMessageThrift() {
  }

  public PenaltyMessageThrift(
    double actualSpeed,
    double speedLimit,
    int penalty_ms,
    String barrier,
    String raceTrack)
  {
    this();
    this.actualSpeed = actualSpeed;
    setActualSpeedIsSet(true);
    this.speedLimit = speedLimit;
    setSpeedLimitIsSet(true);
    this.penalty_ms = penalty_ms;
    setPenalty_msIsSet(true);
    this.barrier = barrier;
    this.raceTrack = raceTrack;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public PenaltyMessageThrift(PenaltyMessageThrift other) {
    __isset_bitfield = other.__isset_bitfield;
    this.actualSpeed = other.actualSpeed;
    this.speedLimit = other.speedLimit;
    this.penalty_ms = other.penalty_ms;
    if (other.isSetBarrier()) {
      this.barrier = other.barrier;
    }
    if (other.isSetRaceTrack()) {
      this.raceTrack = other.raceTrack;
    }
  }

  public PenaltyMessageThrift deepCopy() {
    return new PenaltyMessageThrift(this);
  }

  @Override
  public void clear() {
    setActualSpeedIsSet(false);
    this.actualSpeed = 0.0;
    setSpeedLimitIsSet(false);
    this.speedLimit = 0.0;
    setPenalty_msIsSet(false);
    this.penalty_ms = 0;
    this.barrier = null;
    this.raceTrack = null;
  }

  public double getActualSpeed() {
    return this.actualSpeed;
  }

  public PenaltyMessageThrift setActualSpeed(double actualSpeed) {
    this.actualSpeed = actualSpeed;
    setActualSpeedIsSet(true);
    return this;
  }

  public void unsetActualSpeed() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ACTUALSPEED_ISSET_ID);
  }

  /** Returns true if field actualSpeed is set (has been assigned a value) and false otherwise */
  public boolean isSetActualSpeed() {
    return EncodingUtils.testBit(__isset_bitfield, __ACTUALSPEED_ISSET_ID);
  }

  public void setActualSpeedIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ACTUALSPEED_ISSET_ID, value);
  }

  public double getSpeedLimit() {
    return this.speedLimit;
  }

  public PenaltyMessageThrift setSpeedLimit(double speedLimit) {
    this.speedLimit = speedLimit;
    setSpeedLimitIsSet(true);
    return this;
  }

  public void unsetSpeedLimit() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SPEEDLIMIT_ISSET_ID);
  }

  /** Returns true if field speedLimit is set (has been assigned a value) and false otherwise */
  public boolean isSetSpeedLimit() {
    return EncodingUtils.testBit(__isset_bitfield, __SPEEDLIMIT_ISSET_ID);
  }

  public void setSpeedLimitIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SPEEDLIMIT_ISSET_ID, value);
  }

  public int getPenalty_ms() {
    return this.penalty_ms;
  }

  public PenaltyMessageThrift setPenalty_ms(int penalty_ms) {
    this.penalty_ms = penalty_ms;
    setPenalty_msIsSet(true);
    return this;
  }

  public void unsetPenalty_ms() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PENALTY_MS_ISSET_ID);
  }

  /** Returns true if field penalty_ms is set (has been assigned a value) and false otherwise */
  public boolean isSetPenalty_ms() {
    return EncodingUtils.testBit(__isset_bitfield, __PENALTY_MS_ISSET_ID);
  }

  public void setPenalty_msIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PENALTY_MS_ISSET_ID, value);
  }

  public String getBarrier() {
    return this.barrier;
  }

  public PenaltyMessageThrift setBarrier(String barrier) {
    this.barrier = barrier;
    return this;
  }

  public void unsetBarrier() {
    this.barrier = null;
  }

  /** Returns true if field barrier is set (has been assigned a value) and false otherwise */
  public boolean isSetBarrier() {
    return this.barrier != null;
  }

  public void setBarrierIsSet(boolean value) {
    if (!value) {
      this.barrier = null;
    }
  }

  public String getRaceTrack() {
    return this.raceTrack;
  }

  public PenaltyMessageThrift setRaceTrack(String raceTrack) {
    this.raceTrack = raceTrack;
    return this;
  }

  public void unsetRaceTrack() {
    this.raceTrack = null;
  }

  /** Returns true if field raceTrack is set (has been assigned a value) and false otherwise */
  public boolean isSetRaceTrack() {
    return this.raceTrack != null;
  }

  public void setRaceTrackIsSet(boolean value) {
    if (!value) {
      this.raceTrack = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ACTUAL_SPEED:
      if (value == null) {
        unsetActualSpeed();
      } else {
        setActualSpeed((Double)value);
      }
      break;

    case SPEED_LIMIT:
      if (value == null) {
        unsetSpeedLimit();
      } else {
        setSpeedLimit((Double)value);
      }
      break;

    case PENALTY_MS:
      if (value == null) {
        unsetPenalty_ms();
      } else {
        setPenalty_ms((Integer)value);
      }
      break;

    case BARRIER:
      if (value == null) {
        unsetBarrier();
      } else {
        setBarrier((String)value);
      }
      break;

    case RACE_TRACK:
      if (value == null) {
        unsetRaceTrack();
      } else {
        setRaceTrack((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ACTUAL_SPEED:
      return Double.valueOf(getActualSpeed());

    case SPEED_LIMIT:
      return Double.valueOf(getSpeedLimit());

    case PENALTY_MS:
      return Integer.valueOf(getPenalty_ms());

    case BARRIER:
      return getBarrier();

    case RACE_TRACK:
      return getRaceTrack();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ACTUAL_SPEED:
      return isSetActualSpeed();
    case SPEED_LIMIT:
      return isSetSpeedLimit();
    case PENALTY_MS:
      return isSetPenalty_ms();
    case BARRIER:
      return isSetBarrier();
    case RACE_TRACK:
      return isSetRaceTrack();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof PenaltyMessageThrift)
      return this.equals((PenaltyMessageThrift)that);
    return false;
  }

  public boolean equals(PenaltyMessageThrift that) {
    if (that == null)
      return false;

    boolean this_present_actualSpeed = true;
    boolean that_present_actualSpeed = true;
    if (this_present_actualSpeed || that_present_actualSpeed) {
      if (!(this_present_actualSpeed && that_present_actualSpeed))
        return false;
      if (this.actualSpeed != that.actualSpeed)
        return false;
    }

    boolean this_present_speedLimit = true;
    boolean that_present_speedLimit = true;
    if (this_present_speedLimit || that_present_speedLimit) {
      if (!(this_present_speedLimit && that_present_speedLimit))
        return false;
      if (this.speedLimit != that.speedLimit)
        return false;
    }

    boolean this_present_penalty_ms = true;
    boolean that_present_penalty_ms = true;
    if (this_present_penalty_ms || that_present_penalty_ms) {
      if (!(this_present_penalty_ms && that_present_penalty_ms))
        return false;
      if (this.penalty_ms != that.penalty_ms)
        return false;
    }

    boolean this_present_barrier = true && this.isSetBarrier();
    boolean that_present_barrier = true && that.isSetBarrier();
    if (this_present_barrier || that_present_barrier) {
      if (!(this_present_barrier && that_present_barrier))
        return false;
      if (!this.barrier.equals(that.barrier))
        return false;
    }

    boolean this_present_raceTrack = true && this.isSetRaceTrack();
    boolean that_present_raceTrack = true && that.isSetRaceTrack();
    if (this_present_raceTrack || that_present_raceTrack) {
      if (!(this_present_raceTrack && that_present_raceTrack))
        return false;
      if (!this.raceTrack.equals(that.raceTrack))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(PenaltyMessageThrift other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    PenaltyMessageThrift typedOther = (PenaltyMessageThrift)other;

    lastComparison = Boolean.valueOf(isSetActualSpeed()).compareTo(typedOther.isSetActualSpeed());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetActualSpeed()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.actualSpeed, typedOther.actualSpeed);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSpeedLimit()).compareTo(typedOther.isSetSpeedLimit());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSpeedLimit()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.speedLimit, typedOther.speedLimit);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPenalty_ms()).compareTo(typedOther.isSetPenalty_ms());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPenalty_ms()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.penalty_ms, typedOther.penalty_ms);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBarrier()).compareTo(typedOther.isSetBarrier());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBarrier()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.barrier, typedOther.barrier);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRaceTrack()).compareTo(typedOther.isSetRaceTrack());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRaceTrack()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.raceTrack, typedOther.raceTrack);
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
    StringBuilder sb = new StringBuilder("PenaltyMessageThrift(");
    boolean first = true;

    sb.append("actualSpeed:");
    sb.append(this.actualSpeed);
    first = false;
    if (!first) sb.append(", ");
    sb.append("speedLimit:");
    sb.append(this.speedLimit);
    first = false;
    if (!first) sb.append(", ");
    sb.append("penalty_ms:");
    sb.append(this.penalty_ms);
    first = false;
    if (!first) sb.append(", ");
    sb.append("barrier:");
    if (this.barrier == null) {
      sb.append("null");
    } else {
      sb.append(this.barrier);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("raceTrack:");
    if (this.raceTrack == null) {
      sb.append("null");
    } else {
      sb.append(this.raceTrack);
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

  private static class PenaltyMessageThriftStandardSchemeFactory implements SchemeFactory {
    public PenaltyMessageThriftStandardScheme getScheme() {
      return new PenaltyMessageThriftStandardScheme();
    }
  }

  private static class PenaltyMessageThriftStandardScheme extends StandardScheme<PenaltyMessageThrift> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, PenaltyMessageThrift struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ACTUAL_SPEED
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.actualSpeed = iprot.readDouble();
              struct.setActualSpeedIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SPEED_LIMIT
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.speedLimit = iprot.readDouble();
              struct.setSpeedLimitIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PENALTY_MS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.penalty_ms = iprot.readI32();
              struct.setPenalty_msIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // BARRIER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.barrier = iprot.readString();
              struct.setBarrierIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // RACE_TRACK
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.raceTrack = iprot.readString();
              struct.setRaceTrackIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, PenaltyMessageThrift struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ACTUAL_SPEED_FIELD_DESC);
      oprot.writeDouble(struct.actualSpeed);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(SPEED_LIMIT_FIELD_DESC);
      oprot.writeDouble(struct.speedLimit);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(PENALTY_MS_FIELD_DESC);
      oprot.writeI32(struct.penalty_ms);
      oprot.writeFieldEnd();
      if (struct.barrier != null) {
        oprot.writeFieldBegin(BARRIER_FIELD_DESC);
        oprot.writeString(struct.barrier);
        oprot.writeFieldEnd();
      }
      if (struct.raceTrack != null) {
        oprot.writeFieldBegin(RACE_TRACK_FIELD_DESC);
        oprot.writeString(struct.raceTrack);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class PenaltyMessageThriftTupleSchemeFactory implements SchemeFactory {
    public PenaltyMessageThriftTupleScheme getScheme() {
      return new PenaltyMessageThriftTupleScheme();
    }
  }

  private static class PenaltyMessageThriftTupleScheme extends TupleScheme<PenaltyMessageThrift> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, PenaltyMessageThrift struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetActualSpeed()) {
        optionals.set(0);
      }
      if (struct.isSetSpeedLimit()) {
        optionals.set(1);
      }
      if (struct.isSetPenalty_ms()) {
        optionals.set(2);
      }
      if (struct.isSetBarrier()) {
        optionals.set(3);
      }
      if (struct.isSetRaceTrack()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetActualSpeed()) {
        oprot.writeDouble(struct.actualSpeed);
      }
      if (struct.isSetSpeedLimit()) {
        oprot.writeDouble(struct.speedLimit);
      }
      if (struct.isSetPenalty_ms()) {
        oprot.writeI32(struct.penalty_ms);
      }
      if (struct.isSetBarrier()) {
        oprot.writeString(struct.barrier);
      }
      if (struct.isSetRaceTrack()) {
        oprot.writeString(struct.raceTrack);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, PenaltyMessageThrift struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.actualSpeed = iprot.readDouble();
        struct.setActualSpeedIsSet(true);
      }
      if (incoming.get(1)) {
        struct.speedLimit = iprot.readDouble();
        struct.setSpeedLimitIsSet(true);
      }
      if (incoming.get(2)) {
        struct.penalty_ms = iprot.readI32();
        struct.setPenalty_msIsSet(true);
      }
      if (incoming.get(3)) {
        struct.barrier = iprot.readString();
        struct.setBarrierIsSet(true);
      }
      if (incoming.get(4)) {
        struct.raceTrack = iprot.readString();
        struct.setRaceTrackIsSet(true);
      }
    }
  }

}
