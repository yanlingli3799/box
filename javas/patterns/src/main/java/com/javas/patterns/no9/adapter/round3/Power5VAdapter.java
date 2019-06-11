package com.javas.patterns.no9.adapter.round3;

public class Power5VAdapter extends PowerAdapter{

  public Power5VAdapter(AC220 ac220) {
    super(ac220);
  }

  @Override
  public int output5V() {
    if (ac220 != null) {
      return ac220.output220V() / 44;
    }else {
      return 0;
    }
  }


}
