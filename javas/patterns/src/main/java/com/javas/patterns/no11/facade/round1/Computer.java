package com.javas.patterns.no11.facade.round1;

public class Computer {
  private CPU cpu;
  private Disk disk;
  private Memory memory;

  public Computer(CPU cpu, Disk disk, Memory memory) {
    this.cpu = cpu;
    this.disk = disk;
    this.memory = memory;
  }

  public void start(){
    cpu.start();
    memory.start();
    disk.start();
  }

  public void shutdown(){
    disk.shutdown();
    memory.shutdown();
    cpu.shutdown();
  }

  public void readFile(){
    disk.read();
  }

  public void writeFile(){
    disk.write();
  }

}
