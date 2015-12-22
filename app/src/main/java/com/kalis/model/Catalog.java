package com.kalis.model;

import java.io.Serializable;

/**
 * Created by Kalis on 12/3/2015.
 */
public class Catalog implements Serializable {
    private int cateId;
    private String cateName;
    private String src;

    public Catalog(int cateId, String cateName, String src) {
        this.cateId = cateId;
        this.cateName = cateName;
        this.src = src;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
