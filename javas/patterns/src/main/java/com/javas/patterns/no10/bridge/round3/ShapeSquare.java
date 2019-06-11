package com.javas.patterns.no10.bridge.round3;

public class ShapeSquare extends Shape{

  public ShapeSquare(Color color) {
    super(color);
  }

  @Override
  public void drawCircle() {
    throw new IllegalArgumentException("unsupport drawSquare");
  }

  @Override
  public void drawSquare() {
    this.color.draw("正方形");
  }
}
