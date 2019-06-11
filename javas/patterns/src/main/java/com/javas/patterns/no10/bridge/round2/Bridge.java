package com.javas.patterns.no10.bridge.round2;

public abstract class Bridge {

  private Driver driver;

  public void connect(){
    driver.connect();
  }

  public void setDriver(Driver driverTemp){
    this.driver = driverTemp;
  }

  public Driver getDriver() {
    return this.driver;
  }

}
