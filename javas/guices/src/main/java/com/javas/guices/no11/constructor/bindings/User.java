package com.javas.guices.no11.constructor.bindings;

import com.google.inject.Inject;

import javax.inject.Named;

public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Inject
    public User(@Named("user") String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
