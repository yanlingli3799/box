package com.javas.utils.id;

import java.util.UUID;

public class IdGen3 {

  public static void main(String[] args) {
    for (int i = 0; i < 30; i++) {
      System.out.println(UUID.randomUUID());
    }
  }
}
