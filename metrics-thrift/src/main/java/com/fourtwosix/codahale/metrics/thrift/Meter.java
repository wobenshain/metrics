/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.fourtwosix.codahale.metrics.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Meter implements org.apache.thrift.TBase<Meter, Meter._Fields>, java.io.Serializable, Cloneable, Comparable<Meter> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Meter");

  private static final org.apache.thrift.protocol.TField COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("count", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField M15_RATE_FIELD_DESC = new org.apache.thrift.protocol.TField("m15Rate", org.apache.thrift.protocol.TType.DOUBLE, (short)2);
  private static final org.apache.thrift.protocol.TField M1_RATE_FIELD_DESC = new org.apache.thrift.protocol.TField("m1Rate", org.apache.thrift.protocol.TType.DOUBLE, (short)3);
  private static final org.apache.thrift.protocol.TField M5_RATE_FIELD_DESC = new org.apache.thrift.protocol.TField("m5Rate", org.apache.thrift.protocol.TType.DOUBLE, (short)4);
  private static final org.apache.thrift.protocol.TField MEAN_RATE_FIELD_DESC = new org.apache.thrift.protocol.TField("meanRate", org.apache.thrift.protocol.TType.DOUBLE, (short)5);
  private static final org.apache.thrift.protocol.TField UNITS_FIELD_DESC = new org.apache.thrift.protocol.TField("units", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new MeterStandardSchemeFactory());
    schemes.put(TupleScheme.class, new MeterTupleSchemeFactory());
  }

  public long count; // required
  public double m15Rate; // required
  public double m1Rate; // required
  public double m5Rate; // required
  public double meanRate; // required
  public String units; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    COUNT((short)1, "count"),
    M15_RATE((short)2, "m15Rate"),
    M1_RATE((short)3, "m1Rate"),
    M5_RATE((short)4, "m5Rate"),
    MEAN_RATE((short)5, "meanRate"),
    UNITS((short)6, "units");

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
        case 1: // COUNT
          return COUNT;
        case 2: // M15_RATE
          return M15_RATE;
        case 3: // M1_RATE
          return M1_RATE;
        case 4: // M5_RATE
          return M5_RATE;
        case 5: // MEAN_RATE
          return MEAN_RATE;
        case 6: // UNITS
          return UNITS;
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
  private static final int __COUNT_ISSET_ID = 0;
  private static final int __M15RATE_ISSET_ID = 1;
  private static final int __M1RATE_ISSET_ID = 2;
  private static final int __M5RATE_ISSET_ID = 3;
  private static final int __MEANRATE_ISSET_ID = 4;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.COUNT, new org.apache.thrift.meta_data.FieldMetaData("count", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.M15_RATE, new org.apache.thrift.meta_data.FieldMetaData("m15Rate", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.M1_RATE, new org.apache.thrift.meta_data.FieldMetaData("m1Rate", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.M5_RATE, new org.apache.thrift.meta_data.FieldMetaData("m5Rate", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.MEAN_RATE, new org.apache.thrift.meta_data.FieldMetaData("meanRate", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.UNITS, new org.apache.thrift.meta_data.FieldMetaData("units", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Meter.class, metaDataMap);
  }

  public Meter() {
  }

  public Meter(
    long count,
    double m15Rate,
    double m1Rate,
    double m5Rate,
    double meanRate,
    String units)
  {
    this();
    this.count = count;
    setCountIsSet(true);
    this.m15Rate = m15Rate;
    setM15RateIsSet(true);
    this.m1Rate = m1Rate;
    setM1RateIsSet(true);
    this.m5Rate = m5Rate;
    setM5RateIsSet(true);
    this.meanRate = meanRate;
    setMeanRateIsSet(true);
    this.units = units;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Meter(Meter other) {
    __isset_bitfield = other.__isset_bitfield;
    this.count = other.count;
    this.m15Rate = other.m15Rate;
    this.m1Rate = other.m1Rate;
    this.m5Rate = other.m5Rate;
    this.meanRate = other.meanRate;
    if (other.isSetUnits()) {
      this.units = other.units;
    }
  }

  public Meter deepCopy() {
    return new Meter(this);
  }

  @Override
  public void clear() {
    setCountIsSet(false);
    this.count = 0;
    setM15RateIsSet(false);
    this.m15Rate = 0.0;
    setM1RateIsSet(false);
    this.m1Rate = 0.0;
    setM5RateIsSet(false);
    this.m5Rate = 0.0;
    setMeanRateIsSet(false);
    this.meanRate = 0.0;
    this.units = null;
  }

  public long getCount() {
    return this.count;
  }

  public Meter setCount(long count) {
    this.count = count;
    setCountIsSet(true);
    return this;
  }

  public void unsetCount() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __COUNT_ISSET_ID);
  }

  /** Returns true if field count is set (has been assigned a value) and false otherwise */
  public boolean isSetCount() {
    return EncodingUtils.testBit(__isset_bitfield, __COUNT_ISSET_ID);
  }

  public void setCountIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __COUNT_ISSET_ID, value);
  }

  public double getM15Rate() {
    return this.m15Rate;
  }

  public Meter setM15Rate(double m15Rate) {
    this.m15Rate = m15Rate;
    setM15RateIsSet(true);
    return this;
  }

  public void unsetM15Rate() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __M15RATE_ISSET_ID);
  }

  /** Returns true if field m15Rate is set (has been assigned a value) and false otherwise */
  public boolean isSetM15Rate() {
    return EncodingUtils.testBit(__isset_bitfield, __M15RATE_ISSET_ID);
  }

  public void setM15RateIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __M15RATE_ISSET_ID, value);
  }

  public double getM1Rate() {
    return this.m1Rate;
  }

  public Meter setM1Rate(double m1Rate) {
    this.m1Rate = m1Rate;
    setM1RateIsSet(true);
    return this;
  }

  public void unsetM1Rate() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __M1RATE_ISSET_ID);
  }

  /** Returns true if field m1Rate is set (has been assigned a value) and false otherwise */
  public boolean isSetM1Rate() {
    return EncodingUtils.testBit(__isset_bitfield, __M1RATE_ISSET_ID);
  }

  public void setM1RateIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __M1RATE_ISSET_ID, value);
  }

  public double getM5Rate() {
    return this.m5Rate;
  }

  public Meter setM5Rate(double m5Rate) {
    this.m5Rate = m5Rate;
    setM5RateIsSet(true);
    return this;
  }

  public void unsetM5Rate() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __M5RATE_ISSET_ID);
  }

  /** Returns true if field m5Rate is set (has been assigned a value) and false otherwise */
  public boolean isSetM5Rate() {
    return EncodingUtils.testBit(__isset_bitfield, __M5RATE_ISSET_ID);
  }

  public void setM5RateIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __M5RATE_ISSET_ID, value);
  }

  public double getMeanRate() {
    return this.meanRate;
  }

  public Meter setMeanRate(double meanRate) {
    this.meanRate = meanRate;
    setMeanRateIsSet(true);
    return this;
  }

  public void unsetMeanRate() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MEANRATE_ISSET_ID);
  }

  /** Returns true if field meanRate is set (has been assigned a value) and false otherwise */
  public boolean isSetMeanRate() {
    return EncodingUtils.testBit(__isset_bitfield, __MEANRATE_ISSET_ID);
  }

  public void setMeanRateIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MEANRATE_ISSET_ID, value);
  }

  public String getUnits() {
    return this.units;
  }

  public Meter setUnits(String units) {
    this.units = units;
    return this;
  }

  public void unsetUnits() {
    this.units = null;
  }

  /** Returns true if field units is set (has been assigned a value) and false otherwise */
  public boolean isSetUnits() {
    return this.units != null;
  }

  public void setUnitsIsSet(boolean value) {
    if (!value) {
      this.units = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case COUNT:
      if (value == null) {
        unsetCount();
      } else {
        setCount((Long)value);
      }
      break;

    case M15_RATE:
      if (value == null) {
        unsetM15Rate();
      } else {
        setM15Rate((Double)value);
      }
      break;

    case M1_RATE:
      if (value == null) {
        unsetM1Rate();
      } else {
        setM1Rate((Double)value);
      }
      break;

    case M5_RATE:
      if (value == null) {
        unsetM5Rate();
      } else {
        setM5Rate((Double)value);
      }
      break;

    case MEAN_RATE:
      if (value == null) {
        unsetMeanRate();
      } else {
        setMeanRate((Double)value);
      }
      break;

    case UNITS:
      if (value == null) {
        unsetUnits();
      } else {
        setUnits((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case COUNT:
      return Long.valueOf(getCount());

    case M15_RATE:
      return Double.valueOf(getM15Rate());

    case M1_RATE:
      return Double.valueOf(getM1Rate());

    case M5_RATE:
      return Double.valueOf(getM5Rate());

    case MEAN_RATE:
      return Double.valueOf(getMeanRate());

    case UNITS:
      return getUnits();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case COUNT:
      return isSetCount();
    case M15_RATE:
      return isSetM15Rate();
    case M1_RATE:
      return isSetM1Rate();
    case M5_RATE:
      return isSetM5Rate();
    case MEAN_RATE:
      return isSetMeanRate();
    case UNITS:
      return isSetUnits();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Meter)
      return this.equals((Meter)that);
    return false;
  }

  public boolean equals(Meter that) {
    if (that == null)
      return false;

    boolean this_present_count = true;
    boolean that_present_count = true;
    if (this_present_count || that_present_count) {
      if (!(this_present_count && that_present_count))
        return false;
      if (this.count != that.count)
        return false;
    }

    boolean this_present_m15Rate = true;
    boolean that_present_m15Rate = true;
    if (this_present_m15Rate || that_present_m15Rate) {
      if (!(this_present_m15Rate && that_present_m15Rate))
        return false;
      if (this.m15Rate != that.m15Rate)
        return false;
    }

    boolean this_present_m1Rate = true;
    boolean that_present_m1Rate = true;
    if (this_present_m1Rate || that_present_m1Rate) {
      if (!(this_present_m1Rate && that_present_m1Rate))
        return false;
      if (this.m1Rate != that.m1Rate)
        return false;
    }

    boolean this_present_m5Rate = true;
    boolean that_present_m5Rate = true;
    if (this_present_m5Rate || that_present_m5Rate) {
      if (!(this_present_m5Rate && that_present_m5Rate))
        return false;
      if (this.m5Rate != that.m5Rate)
        return false;
    }

    boolean this_present_meanRate = true;
    boolean that_present_meanRate = true;
    if (this_present_meanRate || that_present_meanRate) {
      if (!(this_present_meanRate && that_present_meanRate))
        return false;
      if (this.meanRate != that.meanRate)
        return false;
    }

    boolean this_present_units = true && this.isSetUnits();
    boolean that_present_units = true && that.isSetUnits();
    if (this_present_units || that_present_units) {
      if (!(this_present_units && that_present_units))
        return false;
      if (!this.units.equals(that.units))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Meter other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCount()).compareTo(other.isSetCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.count, other.count);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetM15Rate()).compareTo(other.isSetM15Rate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetM15Rate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.m15Rate, other.m15Rate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetM1Rate()).compareTo(other.isSetM1Rate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetM1Rate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.m1Rate, other.m1Rate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetM5Rate()).compareTo(other.isSetM5Rate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetM5Rate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.m5Rate, other.m5Rate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMeanRate()).compareTo(other.isSetMeanRate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMeanRate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.meanRate, other.meanRate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUnits()).compareTo(other.isSetUnits());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUnits()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.units, other.units);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Meter(");
    boolean first = true;

    sb.append("count:");
    sb.append(this.count);
    first = false;
    if (!first) sb.append(", ");
    sb.append("m15Rate:");
    sb.append(this.m15Rate);
    first = false;
    if (!first) sb.append(", ");
    sb.append("m1Rate:");
    sb.append(this.m1Rate);
    first = false;
    if (!first) sb.append(", ");
    sb.append("m5Rate:");
    sb.append(this.m5Rate);
    first = false;
    if (!first) sb.append(", ");
    sb.append("meanRate:");
    sb.append(this.meanRate);
    first = false;
    if (!first) sb.append(", ");
    sb.append("units:");
    if (this.units == null) {
      sb.append("null");
    } else {
      sb.append(this.units);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'count' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'm15Rate' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'm1Rate' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'm5Rate' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'meanRate' because it's a primitive and you chose the non-beans generator.
    if (units == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'units' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class MeterStandardSchemeFactory implements SchemeFactory {
    public MeterStandardScheme getScheme() {
      return new MeterStandardScheme();
    }
  }

  private static class MeterStandardScheme extends StandardScheme<Meter> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Meter struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.count = iprot.readI64();
              struct.setCountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // M15_RATE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.m15Rate = iprot.readDouble();
              struct.setM15RateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // M1_RATE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.m1Rate = iprot.readDouble();
              struct.setM1RateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // M5_RATE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.m5Rate = iprot.readDouble();
              struct.setM5RateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // MEAN_RATE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.meanRate = iprot.readDouble();
              struct.setMeanRateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // UNITS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.units = iprot.readString();
              struct.setUnitsIsSet(true);
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
      if (!struct.isSetCount()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'count' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetM15Rate()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'm15Rate' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetM1Rate()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'm1Rate' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetM5Rate()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'm5Rate' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetMeanRate()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'meanRate' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Meter struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(COUNT_FIELD_DESC);
      oprot.writeI64(struct.count);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(M15_RATE_FIELD_DESC);
      oprot.writeDouble(struct.m15Rate);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(M1_RATE_FIELD_DESC);
      oprot.writeDouble(struct.m1Rate);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(M5_RATE_FIELD_DESC);
      oprot.writeDouble(struct.m5Rate);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(MEAN_RATE_FIELD_DESC);
      oprot.writeDouble(struct.meanRate);
      oprot.writeFieldEnd();
      if (struct.units != null) {
        oprot.writeFieldBegin(UNITS_FIELD_DESC);
        oprot.writeString(struct.units);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MeterTupleSchemeFactory implements SchemeFactory {
    public MeterTupleScheme getScheme() {
      return new MeterTupleScheme();
    }
  }

  private static class MeterTupleScheme extends TupleScheme<Meter> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Meter struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI64(struct.count);
      oprot.writeDouble(struct.m15Rate);
      oprot.writeDouble(struct.m1Rate);
      oprot.writeDouble(struct.m5Rate);
      oprot.writeDouble(struct.meanRate);
      oprot.writeString(struct.units);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Meter struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.count = iprot.readI64();
      struct.setCountIsSet(true);
      struct.m15Rate = iprot.readDouble();
      struct.setM15RateIsSet(true);
      struct.m1Rate = iprot.readDouble();
      struct.setM1RateIsSet(true);
      struct.m5Rate = iprot.readDouble();
      struct.setM5RateIsSet(true);
      struct.meanRate = iprot.readDouble();
      struct.setMeanRateIsSet(true);
      struct.units = iprot.readString();
      struct.setUnitsIsSet(true);
    }
  }

}

