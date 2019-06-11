package com.javas.patterns.no8.decorator.round1;

/**
 * Created by liyanling on 2018/11/24.
 */
public abstract class Condiment {
  protected String desc;
  protected long price;

  public abstract long cost();
}
