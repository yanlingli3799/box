package com.javas.patterns.no7.composite.round1;

public class Client {

  public static void main(String[] args){
    Node left = new Node("left");
    Node right = new Node("right");
    Node root = new Node("root",left,right);

    System.out.println("left="+left);
    System.out.println("right="+right);
    System.out.println("root="+root);

  }

}
