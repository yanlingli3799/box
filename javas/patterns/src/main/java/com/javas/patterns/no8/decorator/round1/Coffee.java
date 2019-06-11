package com.javas.patterns.no8.decorator.round1;

import java.util.List;

/**
 * Created by liyanling on 2018/11/24.
 */
public abstract class Coffee {
  protected String          desc;
  protected long            price;
  protected List<Condiment> condimentList;

  public abstract long cost();

  public abstract void addCondiment(Condiment condiment);

}
