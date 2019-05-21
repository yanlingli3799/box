package com.javas.guices.no7.instance.binding;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class DbUtil {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Inject
    public DbUtil(@Named("JDBC Url") String url) {
        this.url = url;
    }

    public void print(){
        System.out.println("url = "+this.getUrl());
    }
}
