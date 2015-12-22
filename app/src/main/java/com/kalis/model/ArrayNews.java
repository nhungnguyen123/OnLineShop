package com.kalis.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Kalis on 12/3/2015.
 */
public class ArrayNews extends News implements Serializable {

    private ArrayList<News> dsNews = new ArrayList<>();

    public ArrayList<News> getDsNews() {
        return dsNews;
    }

    public void setDsNews(ArrayList<News> dsNews) {
        this.dsNews = dsNews;
    }

    public ArrayNews(int index, String desciption, String src) {
        super(index, desciption, src);
    }
}
