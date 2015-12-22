package com.kalis.model;

import java.io.Serializable;

/**
 * Created by Kalis on 12/4/2015.
 */
public class Category implements Serializable {
    private int index;
    private String title;
    private int cateid;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public Category(int index, String title, int cateid) {

        this.index = index;
        this.title = title;
        this.cateid = cateid;
    }
}
