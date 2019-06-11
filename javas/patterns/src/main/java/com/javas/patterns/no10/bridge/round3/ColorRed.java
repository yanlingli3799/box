package com.javas.patterns.no10.bridge.round3;

public class ColorRed implements Color{

  @Override
  public void draw(String desc) {
    System.out.println("red "+desc);
  }
}
