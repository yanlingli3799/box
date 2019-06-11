package com.javas.patterns.no10.bridge.round3;

public class Client {

  public static void main(String[] args){

    new ShapeSquare(new ColorRed()).drawSquare();
    new ShapeCircle(new ColorYellow()).drawCircle();
  }

}
