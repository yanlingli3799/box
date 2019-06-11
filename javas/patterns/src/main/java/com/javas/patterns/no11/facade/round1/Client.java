package com.javas.patterns.no11.facade.round1;

public class Client {

  public static void main(String[] args){
    Computer computer  = new Computer(new CPU(),new Disk(),new Memory());

    computer.start();
    System.out.println("-----------------------");
    computer.readFile();
    System.out.println("-----------------------");
    computer.writeFile();
    System.out.println("-----------------------");
    computer.shutdown();
  }

}
