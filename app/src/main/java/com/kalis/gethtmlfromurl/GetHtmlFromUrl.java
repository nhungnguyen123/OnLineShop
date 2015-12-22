package com.kalis.gethtmlfromurl;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetHtmlFromUrl {

    public static void getData(String s){

        Document doc;
        try {
            Log.e("TAG","hi2");
            doc = Jsoup.connect(s).get(); // or Jsoup.parse(htmlString);
//            Elements header = doc.select("#header"); //access to <div id="header">...</div>
//            Elements inputs = header.select("input");
//            for(Element input : inputs){
//
//                Log.e("TAG", input.attr("id")); //printing attribute id
//            }
            Log.e("TAG","hi3");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}