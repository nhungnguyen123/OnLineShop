package com.kalis.model;

import java.io.Serializable;

/**
 * Created by Kalis on 12/3/2015.
 */
public class News implements Serializable {
    private int index;
    private String desciption;
    private String src;

    public News(int index, String desciption, String src) {
        this.index = index;
        this.desciption = desciption;
        this.src = src;
    }

    public int getIndex() {

        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
