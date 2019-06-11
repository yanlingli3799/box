package com.javas.patterns.no10.bridge.round3;

public abstract class Shape {
  protected Color color;


  public Shape(Color color) {
    this.color = color;
  }

  public abstract void drawCircle();
  public abstract void drawSquare();

}
