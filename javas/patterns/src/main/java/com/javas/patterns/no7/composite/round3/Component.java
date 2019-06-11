package com.javas.patterns.no7.composite.round3;

/**
 * Created by liyanling on 2018/11/23.
 */
public abstract class Component {
  public String data;

  public abstract void add(Component component);

  public abstract void remove(Component component);

  public abstract void display(int depth);
}
