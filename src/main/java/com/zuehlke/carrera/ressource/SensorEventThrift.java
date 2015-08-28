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

public class SensorEventThrift implements org.apache.thrift.TBase<SensorEventThrift, SensorEventThrift._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SensorEventThrift");

  private static final org.apache.thrift.protocol.TField RACE_TRACK_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("raceTrackId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TIME_STAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("timeStamp", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField A_FIELD_DESC = new org.apache.thrift.protocol.TField("a", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField G_FIELD_DESC = new org.apache.thrift.protocol.TField("g", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField M_FIELD_DESC = new org.apache.thrift.protocol.TField("m", org.apache.thrift.protocol.TType.LIST, (short)5);
  private static final org.apache.thrift.protocol.TField T_FIELD_DESC = new org.apache.thrift.protocol.TField("t", org.apache.thrift.protocol.TType.I32, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SensorEventThriftStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SensorEventThriftTupleSchemeFactory());
  }

  public String raceTrackId; // required
  public long timeStamp; // required
  public List<Integer> a; // required
  public List<Integer> g; // required
  public List<Integer> m; // required
  public int t; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RACE_TRACK_ID((short)1, "raceTrackId"),
    TIME_STAMP((short)2, "timeStamp"),
    A((short)3, "a"),
    G((short)4, "g"),
    M((short)5, "m"),
    T((short)6, "t");

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
        case 1: // RACE_TRACK_ID
          return RACE_TRACK_ID;
        case 2: // TIME_STAMP
          return TIME_STAMP;
        case 3: // A
          return A;
        case 4: // G
          return G;
        case 5: // M
          return M;
        case 6: // T
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
  private static final int __T_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RACE_TRACK_ID, new org.apache.thrift.meta_data.FieldMetaData("raceTrackId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    tmpMap.put(_Fields.TIME_STAMP, new org.apache.thrift.meta_data.FieldMetaData("timeStamp", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "long")));
    tmpMap.put(_Fields.A, new org.apache.thrift.meta_data.FieldMetaData("a", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32            , "int"))));
    tmpMap.put(_Fields.G, new org.apache.thrift.meta_data.FieldMetaData("g", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32            , "int"))));
    tmpMap.put(_Fields.M, new org.apache.thrift.meta_data.FieldMetaData("m", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32            , "int"))));
    tmpMap.put(_Fields.T, new org.apache.thrift.meta_data.FieldMetaData("t", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "int")));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SensorEventThrift.class, metaDataMap);
  }

  public SensorEventThrift() {
  }

  public SensorEventThrift(
    String raceTrackId,
    long timeStamp,
    List<Integer> a,
    List<Integer> g,
    List<Integer> m,
    int t)
  {
    this();
    this.raceTrackId = raceTrackId;
    this.timeStamp = timeStamp;
    setTimeStampIsSet(true);
    this.a = a;
    this.g = g;
    this.m = m;
    this.t = t;
    setTIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SensorEventThrift(SensorEventThrift other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetRaceTrackId()) {
      this.raceTrackId = other.raceTrackId;
    }
    this.timeStamp = other.timeStamp;
    if (other.isSetA()) {
      List<Integer> __this__a = new ArrayList<Integer>();
      for (Integer other_element : other.a) {
        __this__a.add(other_element);
      }
      this.a = __this__a;
    }
    if (other.isSetG()) {
      List<Integer> __this__g = new ArrayList<Integer>();
      for (Integer other_element : other.g) {
        __this__g.add(other_element);
      }
      this.g = __this__g;
    }
    if (other.isSetM()) {
      List<Integer> __this__m = new ArrayList<Integer>();
      for (Integer other_element : other.m) {
        __this__m.add(other_element);
      }
      this.m = __this__m;
    }
    this.t = other.t;
  }

  public SensorEventThrift deepCopy() {
    return new SensorEventThrift(this);
  }

  @Override
  public void clear() {
    this.raceTrackId = null;
    setTimeStampIsSet(false);
    this.timeStamp = 0;
    this.a = null;
    this.g = null;
    this.m = null;
    setTIsSet(false);
    this.t = 0;
  }

  public String getRaceTrackId() {
    return this.raceTrackId;
  }

  public SensorEventThrift setRaceTrackId(String raceTrackId) {
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

  public long getTimeStamp() {
    return this.timeStamp;
  }

  public SensorEventThrift setTimeStamp(long timeStamp) {
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

  public int getASize() {
    return (this.a == null) ? 0 : this.a.size();
  }

  public java.util.Iterator<Integer> getAIterator() {
    return (this.a == null) ? null : this.a.iterator();
  }

  public void addToA(int elem) {
    if (this.a == null) {
      this.a = new ArrayList<Integer>();
    }
    this.a.add(elem);
  }

  public List<Integer> getA() {
    return this.a;
  }

  public SensorEventThrift setA(List<Integer> a) {
    this.a = a;
    return this;
  }

  public void unsetA() {
    this.a = null;
  }

  /** Returns true if field a is set (has been assigned a value) and false otherwise */
  public boolean isSetA() {
    return this.a != null;
  }

  public void setAIsSet(boolean value) {
    if (!value) {
      this.a = null;
    }
  }

  public int getGSize() {
    return (this.g == null) ? 0 : this.g.size();
  }

  public java.util.Iterator<Integer> getGIterator() {
    return (this.g == null) ? null : this.g.iterator();
  }

  public void addToG(int elem) {
    if (this.g == null) {
      this.g = new ArrayList<Integer>();
    }
    this.g.add(elem);
  }

  public List<Integer> getG() {
    return this.g;
  }

  public SensorEventThrift setG(List<Integer> g) {
    this.g = g;
    return this;
  }

  public void unsetG() {
    this.g = null;
  }

  /** Returns true if field g is set (has been assigned a value) and false otherwise */
  public boolean isSetG() {
    return this.g != null;
  }

  public void setGIsSet(boolean value) {
    if (!value) {
      this.g = null;
    }
  }

  public int getMSize() {
    return (this.m == null) ? 0 : this.m.size();
  }

  public java.util.Iterator<Integer> getMIterator() {
    return (this.m == null) ? null : this.m.iterator();
  }

  public void addToM(int elem) {
    if (this.m == null) {
      this.m = new ArrayList<Integer>();
    }
    this.m.add(elem);
  }

  public List<Integer> getM() {
    return this.m;
  }

  public SensorEventThrift setM(List<Integer> m) {
    this.m = m;
    return this;
  }

  public void unsetM() {
    this.m = null;
  }

  /** Returns true if field m is set (has been assigned a value) and false otherwise */
  public boolean isSetM() {
    return this.m != null;
  }

  public void setMIsSet(boolean value) {
    if (!value) {
      this.m = null;
    }
  }

  public int getT() {
    return this.t;
  }

  public SensorEventThrift setT(int t) {
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
    case RACE_TRACK_ID:
      if (value == null) {
        unsetRaceTrackId();
      } else {
        setRaceTrackId((String)value);
      }
      break;

    case TIME_STAMP:
      if (value == null) {
        unsetTimeStamp();
      } else {
        setTimeStamp((Long)value);
      }
      break;

    case A:
      if (value == null) {
        unsetA();
      } else {
        setA((List<Integer>)value);
      }
      break;

    case G:
      if (value == null) {
        unsetG();
      } else {
        setG((List<Integer>)value);
      }
      break;

    case M:
      if (value == null) {
        unsetM();
      } else {
        setM((List<Integer>)value);
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
    case RACE_TRACK_ID:
      return getRaceTrackId();

    case TIME_STAMP:
      return Long.valueOf(getTimeStamp());

    case A:
      return getA();

    case G:
      return getG();

    case M:
      return getM();

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
    case RACE_TRACK_ID:
      return isSetRaceTrackId();
    case TIME_STAMP:
      return isSetTimeStamp();
    case A:
      return isSetA();
    case G:
      return isSetG();
    case M:
      return isSetM();
    case T:
      return isSetT();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SensorEventThrift)
      return this.equals((SensorEventThrift)that);
    return false;
  }

  public boolean equals(SensorEventThrift that) {
    if (that == null)
      return false;

    boolean this_present_raceTrackId = true && this.isSetRaceTrackId();
    boolean that_present_raceTrackId = true && that.isSetRaceTrackId();
    if (this_present_raceTrackId || that_present_raceTrackId) {
      if (!(this_present_raceTrackId && that_present_raceTrackId))
        return false;
      if (!this.raceTrackId.equals(that.raceTrackId))
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

    boolean this_present_a = true && this.isSetA();
    boolean that_present_a = true && that.isSetA();
    if (this_present_a || that_present_a) {
      if (!(this_present_a && that_present_a))
        return false;
      if (!this.a.equals(that.a))
        return false;
    }

    boolean this_present_g = true && this.isSetG();
    boolean that_present_g = true && that.isSetG();
    if (this_present_g || that_present_g) {
      if (!(this_present_g && that_present_g))
        return false;
      if (!this.g.equals(that.g))
        return false;
    }

    boolean this_present_m = true && this.isSetM();
    boolean that_present_m = true && that.isSetM();
    if (this_present_m || that_present_m) {
      if (!(this_present_m && that_present_m))
        return false;
      if (!this.m.equals(that.m))
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

  public int compareTo(SensorEventThrift other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    SensorEventThrift typedOther = (SensorEventThrift)other;

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
    lastComparison = Boolean.valueOf(isSetA()).compareTo(typedOther.isSetA());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetA()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.a, typedOther.a);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetG()).compareTo(typedOther.isSetG());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetG()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.g, typedOther.g);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetM()).compareTo(typedOther.isSetM());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetM()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.m, typedOther.m);
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
    StringBuilder sb = new StringBuilder("SensorEventThrift(");
    boolean first = true;

    sb.append("raceTrackId:");
    if (this.raceTrackId == null) {
      sb.append("null");
    } else {
      sb.append(this.raceTrackId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("timeStamp:");
    sb.append(this.timeStamp);
    first = false;
    if (!first) sb.append(", ");
    sb.append("a:");
    if (this.a == null) {
      sb.append("null");
    } else {
      sb.append(this.a);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("g:");
    if (this.g == null) {
      sb.append("null");
    } else {
      sb.append(this.g);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("m:");
    if (this.m == null) {
      sb.append("null");
    } else {
      sb.append(this.m);
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

  private static class SensorEventThriftStandardSchemeFactory implements SchemeFactory {
    public SensorEventThriftStandardScheme getScheme() {
      return new SensorEventThriftStandardScheme();
    }
  }

  private static class SensorEventThriftStandardScheme extends StandardScheme<SensorEventThrift> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SensorEventThrift struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RACE_TRACK_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.raceTrackId = iprot.readString();
              struct.setRaceTrackIdIsSet(true);
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
          case 3: // A
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.a = new ArrayList<Integer>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  int _elem2; // required
                  _elem2 = iprot.readI32();
                  struct.a.add(_elem2);
                }
                iprot.readListEnd();
              }
              struct.setAIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // G
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list3 = iprot.readListBegin();
                struct.g = new ArrayList<Integer>(_list3.size);
                for (int _i4 = 0; _i4 < _list3.size; ++_i4)
                {
                  int _elem5; // required
                  _elem5 = iprot.readI32();
                  struct.g.add(_elem5);
                }
                iprot.readListEnd();
              }
              struct.setGIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // M
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list6 = iprot.readListBegin();
                struct.m = new ArrayList<Integer>(_list6.size);
                for (int _i7 = 0; _i7 < _list6.size; ++_i7)
                {
                  int _elem8; // required
                  _elem8 = iprot.readI32();
                  struct.m.add(_elem8);
                }
                iprot.readListEnd();
              }
              struct.setMIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // T
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, SensorEventThrift struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.raceTrackId != null) {
        oprot.writeFieldBegin(RACE_TRACK_ID_FIELD_DESC);
        oprot.writeString(struct.raceTrackId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(TIME_STAMP_FIELD_DESC);
      oprot.writeI64(struct.timeStamp);
      oprot.writeFieldEnd();
      if (struct.a != null) {
        oprot.writeFieldBegin(A_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.a.size()));
          for (int _iter9 : struct.a)
          {
            oprot.writeI32(_iter9);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.g != null) {
        oprot.writeFieldBegin(G_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.g.size()));
          for (int _iter10 : struct.g)
          {
            oprot.writeI32(_iter10);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.m != null) {
        oprot.writeFieldBegin(M_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.m.size()));
          for (int _iter11 : struct.m)
          {
            oprot.writeI32(_iter11);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(T_FIELD_DESC);
      oprot.writeI32(struct.t);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SensorEventThriftTupleSchemeFactory implements SchemeFactory {
    public SensorEventThriftTupleScheme getScheme() {
      return new SensorEventThriftTupleScheme();
    }
  }

  private static class SensorEventThriftTupleScheme extends TupleScheme<SensorEventThrift> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SensorEventThrift struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetRaceTrackId()) {
        optionals.set(0);
      }
      if (struct.isSetTimeStamp()) {
        optionals.set(1);
      }
      if (struct.isSetA()) {
        optionals.set(2);
      }
      if (struct.isSetG()) {
        optionals.set(3);
      }
      if (struct.isSetM()) {
        optionals.set(4);
      }
      if (struct.isSetT()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetRaceTrackId()) {
        oprot.writeString(struct.raceTrackId);
      }
      if (struct.isSetTimeStamp()) {
        oprot.writeI64(struct.timeStamp);
      }
      if (struct.isSetA()) {
        {
          oprot.writeI32(struct.a.size());
          for (int _iter12 : struct.a)
          {
            oprot.writeI32(_iter12);
          }
        }
      }
      if (struct.isSetG()) {
        {
          oprot.writeI32(struct.g.size());
          for (int _iter13 : struct.g)
          {
            oprot.writeI32(_iter13);
          }
        }
      }
      if (struct.isSetM()) {
        {
          oprot.writeI32(struct.m.size());
          for (int _iter14 : struct.m)
          {
            oprot.writeI32(_iter14);
          }
        }
      }
      if (struct.isSetT()) {
        oprot.writeI32(struct.t);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SensorEventThrift struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.raceTrackId = iprot.readString();
        struct.setRaceTrackIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.timeStamp = iprot.readI64();
        struct.setTimeStampIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list15 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.a = new ArrayList<Integer>(_list15.size);
          for (int _i16 = 0; _i16 < _list15.size; ++_i16)
          {
            int _elem17; // required
            _elem17 = iprot.readI32();
            struct.a.add(_elem17);
          }
        }
        struct.setAIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list18 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.g = new ArrayList<Integer>(_list18.size);
          for (int _i19 = 0; _i19 < _list18.size; ++_i19)
          {
            int _elem20; // required
            _elem20 = iprot.readI32();
            struct.g.add(_elem20);
          }
        }
        struct.setGIsSet(true);
      }
      if (incoming.get(4)) {
        {
          org.apache.thrift.protocol.TList _list21 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.m = new ArrayList<Integer>(_list21.size);
          for (int _i22 = 0; _i22 < _list21.size; ++_i22)
          {
            int _elem23; // required
            _elem23 = iprot.readI32();
            struct.m.add(_elem23);
          }
        }
        struct.setMIsSet(true);
      }
      if (incoming.get(5)) {
        struct.t = iprot.readI32();
        struct.setTIsSet(true);
      }
    }
  }

}

