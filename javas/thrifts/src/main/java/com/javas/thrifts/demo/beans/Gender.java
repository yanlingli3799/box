/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.javas.thrifts.demo.beans;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum Gender implements org.apache.thrift.TEnum {
  BOY(1),
  GIRL(2);

  private final int value;

  private Gender(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static Gender findByValue(int value) { 
    switch (value) {
      case 1:
        return BOY;
      case 2:
        return GIRL;
      default:
        return null;
    }
  }
}
