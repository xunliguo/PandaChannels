package com.example.administrator.pandachannels.fragmentlive.model.entity;

/**
 * Created by ASUS-PC on 2017/9/15.
 */

public class PinBean {
     String name;
     String contont;

    public PinBean(String name, String contont) {
        this.name = name;
        this.contont = contont;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContont() {
        return contont;
    }

    public void setContont(String contont) {
        this.contont = contont;
    }
}
