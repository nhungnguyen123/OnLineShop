package com.kalis.model;

/**
 * Created by Kalis on 12/3/2015.
 */
public class Product {
    private int id;
    private String name;
    private String src;

    public Product(int id, String name, String src) {
        this.id = id;
        this.name = name;
        this.src = src;
    }

    public String getSrc() {

        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(int id, String name) {

        this.id = id;
        this.name = name;
    }
}
