package com.javas.patterns.observer.round2;

/**
 * Created by liyanling on 2018/11/8.
 */
public interface ISubject {

  public void addPerson(User user);

  public void removePerson(User user);

  public void publishMessage(String message);

  public void readOutboxMessage();

}
