package com.javas.patterns.no7.composite.round4;

/**
 * Created by liyanling on 2018/11/23.
 */
public class Client {


  public static void main(String[] args){
    Node root = new Node("root");
    Leaf leaf1 = new Leaf("1");
    Leaf leaf2 = new Leaf("2");
    Leaf leaf3 = new Leaf("3");

    root.add(leaf1);
    root.add(leaf2);
    root.add(leaf3);

    root.display(1);
  }

}
