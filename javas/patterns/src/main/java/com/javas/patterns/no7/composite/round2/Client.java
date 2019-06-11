package com.javas.patterns.no7.composite.round2;


public class Client {

  public static void main(String[] args){
    Node root = new Node("root");
    Node child1 = new Node("1");
    Node child2 = new Node("2");
    Node child3 = new Node("3");

    root.addChild(child1);
    root.addChild(child2);
    root.addChild(child3);

    root.display(1);

  }

}
