package com.kalis.function;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

/**
 * Created by Kalis on 12/1/2015.
 */
public class Read_Online {

     public static String readAll(Reader rd) {
        StringBuilder sb = new StringBuilder();
        int cp;
        try {
            while ((cp = rd.read()) != -1  )
            {
//                if (rd.read() == (char)'}' ) break;
                sb.append((char) cp);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return sb.toString();
    }

    public static JSONObject[] readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
//đọc nội dung với Unicode:
            BufferedReader rd = new BufferedReader
                    (new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
//            JSONArray jsonArray = new JSONArray(jsonText);
//
//            JSONObject json = 
//            StringBuilder sb = new StringBuilder(jsonText);
            StringTokenizer stringTokenizer = new StringTokenizer(jsonText,"}");
            JSONObject [] jsonObject = new JSONObject[stringTokenizer.countTokens()];
            int i =0;
            while (stringTokenizer.hasMoreTokens())
            {
                jsonObject[i] = new JSONObject(stringTokenizer.nextToken() + "}");

                Log.e("ERROR 1", jsonObject[i].getString("src").toString() );
                i++;




            }

//            return jsonObject;
            return null;


        } finally {
            is.close();
        }

    }

    public static class ImageLoadTask extends AsyncTask<Void, Void, Bitmap> {

        //Link url hình ảnh bất kỳ
        private String url;
        private Bitmap bm;
        //Control ImageView bất kỳ
        private ImageView imageView;

        public ImageLoadTask(String url, ImageView imageView) {
            this.url = url;
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            try {
                //Tiến hành tạo đối tượng URL
                URL urlConnection = new URL(url);
                //Mở kết nối
                HttpURLConnection connection = (HttpURLConnection) urlConnection
                        .openConnection();
                connection.setDoInput(true);
                connection.connect();
                //Đọc dữ liệu
                InputStream input = connection.getInputStream();
                //Tiến hành convert qua hình ảnh
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                bm = myBitmap;
                return myBitmap;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
