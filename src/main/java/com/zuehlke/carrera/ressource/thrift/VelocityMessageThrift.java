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

public class VelocityMessageThrift implements org.apache.thrift.TBase<VelocityMessageThrift, VelocityMessageThrift._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("VelocityMessageThrift");

  private static final org.apache.thrift.protocol.TField RACETRACK_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("racetrackId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TIME_STAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("timeStamp", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField VELOCITY_FIELD_DESC = new org.apache.thrift.protocol.TField("velocity", org.apache.thrift.protocol.TType.DOUBLE, (short)3);
  private static final org.apache.thrift.protocol.TField SOURCE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sourceId", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField T_FIELD_DESC = new org.apache.thrift.protocol.TField("t", org.apache.thrift.protocol.TType.I32, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new VelocityMessageThriftStandardSchemeFactory());
    schemes.put(TupleScheme.class, new VelocityMessageThriftTupleSchemeFactory());
  }

  public String racetrackId; // required
  public long timeStamp; // required
  public double velocity; // required
  public String sourceId; // required
  public int t; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RACETRACK_ID((short)1, "racetrackId"),
    TIME_STAMP((short)2, "timeStamp"),
    VELOCITY((short)3, "velocity"),
    SOURCE_ID((short)4, "sourceId"),
    T((short)5, "t");

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
        case 1: // RACETRACK_ID
          return RACETRACK_ID;
        case 2: // TIME_STAMP
          return TIME_STAMP;
        case 3: // VELOCITY
          return VELOCITY;
        case 4: // SOURCE_ID
          return SOURCE_ID;
        case 5: // T
          return T;
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
  private static final int __VELOCITY_ISSET_ID = 1;
  private static final int __T_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RACETRACK_ID, new org.apache.thrift.meta_data.FieldMetaData("racetrackId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    tmpMap.put(_Fields.TIME_STAMP, new org.apache.thrift.meta_data.FieldMetaData("timeStamp", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "long")));
    tmpMap.put(_Fields.VELOCITY, new org.apache.thrift.meta_data.FieldMetaData("velocity", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.SOURCE_ID, new org.apache.thrift.meta_data.FieldMetaData("sourceId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    tmpMap.put(_Fields.T, new org.apache.thrift.meta_data.FieldMetaData("t", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "int")));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(VelocityMessageThrift.class, metaDataMap);
  }

  public VelocityMessageThrift() {
  }

  public VelocityMessageThrift(
    String racetrackId,
    long timeStamp,
    double velocity,
    String sourceId,
    int t)
  {
    this();
    this.racetrackId = racetrackId;
    this.timeStamp = timeStamp;
    setTimeStampIsSet(true);
    this.velocity = velocity;
    setVelocityIsSet(true);
    this.sourceId = sourceId;
    this.t = t;
    setTIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public VelocityMessageThrift(VelocityMessageThrift other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetRacetrackId()) {
      this.racetrackId = other.racetrackId;
    }
    this.timeStamp = other.timeStamp;
    this.velocity = other.velocity;
    if (other.isSetSourceId()) {
      this.sourceId = other.sourceId;
    }
    this.t = other.t;
  }

  public VelocityMessageThrift deepCopy() {
    return new VelocityMessageThrift(this);
  }

  @Override
  public void clear() {
    this.racetrackId = null;
    setTimeStampIsSet(false);
    this.timeStamp = 0;
    setVelocityIsSet(false);
    this.velocity = 0.0;
    this.sourceId = null;
    setTIsSet(false);
    this.t = 0;
  }

  public String getRacetrackId() {
    return this.racetrackId;
  }

  public VelocityMessageThrift setRacetrackId(String racetrackId) {
    this.racetrackId = racetrackId;
    return this;
  }

  public void unsetRacetrackId() {
    this.racetrackId = null;
  }

  /** Returns true if field racetrackId is set (has been assigned a value) and false otherwise */
  public boolean isSetRacetrackId() {
    return this.racetrackId != null;
  }

  public void setRacetrackIdIsSet(boolean value) {
    if (!value) {
      this.racetrackId = null;
    }
  }

  public long getTimeStamp() {
    return this.timeStamp;
  }

  public VelocityMessageThrift setTimeStamp(long timeStamp) {
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

  public double getVelocity() {
    return this.velocity;
  }

  public VelocityMessageThrift setVelocity(double velocity) {
    this.velocity = velocity;
    setVelocityIsSet(true);
    return this;
  }

  public void unsetVelocity() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __VELOCITY_ISSET_ID);
  }

  /** Returns true if field velocity is set (has been assigned a value) and false otherwise */
  public boolean isSetVelocity() {
    return EncodingUtils.testBit(__isset_bitfield, __VELOCITY_ISSET_ID);
  }

  public void setVelocityIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __VELOCITY_ISSET_ID, value);
  }

  public String getSourceId() {
    return this.sourceId;
  }

  public VelocityMessageThrift setSourceId(String sourceId) {
    this.sourceId = sourceId;
    return this;
  }

  public void unsetSourceId() {
    this.sourceId = null;
  }

  /** Returns true if field sourceId is set (has been assigned a value) and false otherwise */
  public boolean isSetSourceId() {
    return this.sourceId != null;
  }

  public void setSourceIdIsSet(boolean value) {
    if (!value) {
      this.sourceId = null;
    }
  }

  public int getT() {
    return this.t;
  }

  public VelocityMessageThrift setT(int t) {
    this.t = t;
    setTIsSet(true);
    return this;
  }

  public void unsetT() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __T_ISSET_ID);
  }

  /** Returns true if field t is set (has been assigned a value) and false otherwise */
  public boolean isSetT() {
    return EncodingUtils.testBit(__isset_bitfield, __T_ISSET_ID);
  }

  public void setTIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __T_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RACETRACK_ID:
      if (value == null) {
        unsetRacetrackId();
      } else {
        setRacetrackId((String)value);
      }
      break;

    case TIME_STAMP:
      if (value == null) {
        unsetTimeStamp();
      } else {
        setTimeStamp((Long)value);
      }
      break;

    case VELOCITY:
      if (value == null) {
        unsetVelocity();
      } else {
        setVelocity((Double)value);
      }
      break;

    case SOURCE_ID:
      if (value == null) {
        unsetSourceId();
      } else {
        setSourceId((String)value);
      }
      break;

    case T:
      if (value == null) {
        unsetT();
      } else {
        setT((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RACETRACK_ID:
      return getRacetrackId();

    case TIME_STAMP:
      return Long.valueOf(getTimeStamp());

    case VELOCITY:
      return Double.valueOf(getVelocity());

    case SOURCE_ID:
      return getSourceId();

    case T:
      return Integer.valueOf(getT());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RACETRACK_ID:
      return isSetRacetrackId();
    case TIME_STAMP:
      return isSetTimeStamp();
    case VELOCITY:
      return isSetVelocity();
    case SOURCE_ID:
      return isSetSourceId();
    case T:
      return isSetT();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof VelocityMessageThrift)
      return this.equals((VelocityMessageThrift)that);
    return false;
  }

  public boolean equals(VelocityMessageThrift that) {
    if (that == null)
      return false;

    boolean this_present_racetrackId = true && this.isSetRacetrackId();
    boolean that_present_racetrackId = true && that.isSetRacetrackId();
    if (this_present_racetrackId || that_present_racetrackId) {
      if (!(this_present_racetrackId && that_present_racetrackId))
        return false;
      if (!this.racetrackId.equals(that.racetrackId))
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

    boolean this_present_velocity = true;
    boolean that_present_velocity = true;
    if (this_present_velocity || that_present_velocity) {
      if (!(this_present_velocity && that_present_velocity))
        return false;
      if (this.velocity != that.velocity)
        return false;
    }

    boolean this_present_sourceId = true && this.isSetSourceId();
    boolean that_present_sourceId = true && that.isSetSourceId();
    if (this_present_sourceId || that_present_sourceId) {
      if (!(this_present_sourceId && that_present_sourceId))
        return false;
      if (!this.sourceId.equals(that.sourceId))
        return false;
    }

    boolean this_present_t = true;
    boolean that_present_t = true;
    if (this_present_t || that_present_t) {
      if (!(this_present_t && that_present_t))
        return false;
      if (this.t != that.t)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(VelocityMessageThrift other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    VelocityMessageThrift typedOther = (VelocityMessageThrift)other;

    lastComparison = Boolean.valueOf(isSetRacetrackId()).compareTo(typedOther.isSetRacetrackId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRacetrackId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.racetrackId, typedOther.racetrackId);
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
    lastComparison = Boolean.valueOf(isSetVelocity()).compareTo(typedOther.isSetVelocity());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVelocity()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.velocity, typedOther.velocity);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSourceId()).compareTo(typedOther.isSetSourceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSourceId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sourceId, typedOther.sourceId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetT()).compareTo(typedOther.isSetT());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetT()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.t, typedOther.t);
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
    StringBuilder sb = new StringBuilder("VelocityMessageThrift(");
    boolean first = true;

    sb.append("racetrackId:");
    if (this.racetrackId == null) {
      sb.append("null");
    } else {
      sb.append(this.racetrackId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("timeStamp:");
    sb.append(this.timeStamp);
    first = false;
    if (!first) sb.append(", ");
    sb.append("velocity:");
    sb.append(this.velocity);
    first = false;
    if (!first) sb.append(", ");
    sb.append("sourceId:");
    if (this.sourceId == null) {
      sb.append("null");
    } else {
      sb.append(this.sourceId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("t:");
    sb.append(this.t);
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

  private static class VelocityMessageThriftStandardSchemeFactory implements SchemeFactory {
    public VelocityMessageThriftStandardScheme getScheme() {
      return new VelocityMessageThriftStandardScheme();
    }
  }

  private static class VelocityMessageThriftStandardScheme extends StandardScheme<VelocityMessageThrift> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, VelocityMessageThrift struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RACETRACK_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.racetrackId = iprot.readString();
              struct.setRacetrackIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TIME_STAMP
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.timeStamp = iprot.readI64();
              struct.setTimeStampIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // VELOCITY
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.velocity = iprot.readDouble();
              struct.setVelocityIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SOURCE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.sourceId = iprot.readString();
              struct.setSourceIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // T
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.t = iprot.readI32();
              struct.setTIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, VelocityMessageThrift struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.racetrackId != null) {
        oprot.writeFieldBegin(RACETRACK_ID_FIELD_DESC);
        oprot.writeString(struct.racetrackId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(TIME_STAMP_FIELD_DESC);
      oprot.writeI64(struct.timeStamp);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(VELOCITY_FIELD_DESC);
      oprot.writeDouble(struct.velocity);
      oprot.writeFieldEnd();
      if (struct.sourceId != null) {
        oprot.writeFieldBegin(SOURCE_ID_FIELD_DESC);
        oprot.writeString(struct.sourceId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(T_FIELD_DESC);
      oprot.writeI32(struct.t);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class VelocityMessageThriftTupleSchemeFactory implements SchemeFactory {
    public VelocityMessageThriftTupleScheme getScheme() {
      return new VelocityMessageThriftTupleScheme();
    }
  }

  private static class VelocityMessageThriftTupleScheme extends TupleScheme<VelocityMessageThrift> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, VelocityMessageThrift struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetRacetrackId()) {
        optionals.set(0);
      }
      if (struct.isSetTimeStamp()) {
        optionals.set(1);
      }
      if (struct.isSetVelocity()) {
        optionals.set(2);
      }
      if (struct.isSetSourceId()) {
        optionals.set(3);
      }
      if (struct.isSetT()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetRacetrackId()) {
        oprot.writeString(struct.racetrackId);
      }
      if (struct.isSetTimeStamp()) {
        oprot.writeI64(struct.timeStamp);
      }
      if (struct.isSetVelocity()) {
        oprot.writeDouble(struct.velocity);
      }
      if (struct.isSetSourceId()) {
        oprot.writeString(struct.sourceId);
      }
      if (struct.isSetT()) {
        oprot.writeI32(struct.t);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, VelocityMessageThrift struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.racetrackId = iprot.readString();
        struct.setRacetrackIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.timeStamp = iprot.readI64();
        struct.setTimeStampIsSet(true);
      }
      if (incoming.get(2)) {
        struct.velocity = iprot.readDouble();
        struct.setVelocityIsSet(true);
      }
      if (incoming.get(3)) {
        struct.sourceId = iprot.readString();
        struct.setSourceIdIsSet(true);
      }
      if (incoming.get(4)) {
        struct.t = iprot.readI32();
        struct.setTIsSet(true);
      }
    }
  }

}

