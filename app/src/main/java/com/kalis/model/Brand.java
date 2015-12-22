package com.kalis.model;

import java.io.Serializable;

/**
 * Created by Kalis on 12/4/2015.
 */
public class Brand implements Serializable {
    private int brandId;
    private String brandName;
    private String src;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Brand(int brandId, String brandName, String src) {

        this.brandId = brandId;
        this.brandName = brandName;
        this.src = src;
    }
}
