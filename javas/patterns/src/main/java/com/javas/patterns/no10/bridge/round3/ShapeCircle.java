package com.javas.patterns.no10.bridge.round3;

public class ShapeCircle extends Shape{

  public ShapeCircle(Color color) {
    super(color);
  }

  @Override
  public void drawCircle() {
    this.color.draw("圆形");
  }

  @Override
  public void drawSquare() {
    throw new IllegalArgumentException("unsupport drawSquare");
  }
}
