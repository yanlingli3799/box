package com.javas.guices.no13.built.in.bindings.typeliteral;

import com.google.inject.Inject;

public class Client {

    @Inject
    private Storage<String,String> storage;

    public Storage<String, String> getStorage() {
        return storage;
    }

    public void setStorage(Storage<String, String> storage) {
        this.storage = storage;
    }

    public void putToStore(){
        storage.put("1","2");
    }

    public void getFromStore(){
        System.out.println("s:"+storage.get("1"));
    }


    @Override
    public String toString() {
        return "Client{" +
                "storage=" + storage.toString() +
                '}';
    }
}
