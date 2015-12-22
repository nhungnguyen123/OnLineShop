package com.kalis.tabs;


import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kalis.function.Read_Online;
import com.kalis.model.News;
import com.kalis.model.Product;
import com.kalis.onlineshop.MainActivity;
import com.kalis.onlineshop.R;

import java.io.InputStreamReader;
import java.net.URL;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1_HomePage extends Fragment {
    GridView gv;
    TableLayout tabLayout_1;
    LinearLayout ll = null;

    public Tab1_HomePage() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ll = null;
         new LoadInfoFromUrl().execute(MainActivity.Url_News);



        return inflater.inflate(R.layout.fragment_tab1_homepage, container, false);
    }

    public class LoadInfoFromUrl extends AsyncTask<String, News, Void> {
        @Override
        protected Void doInBackground(String... params) {

            String link = params[0];

            try {
                URL url = new URL(link);

                InputStreamReader reader = new InputStreamReader(url.openStream(), "UTF-8");


               News [] dsNews = new Gson().fromJson(reader,News[].class);

                publishProgress(dsNews);


            }
            catch (Exception e) {

                Log.e("ERROR", e.toString());
            }

            return null;

        }

        @Override
        protected void onProgressUpdate(News... values) {
            super.onProgressUpdate(values);

            addNewsToLayout(values);

        }

    }

    private class ImageEvents implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Toast.makeText(getContext(), " You Clicked", Toast.LENGTH_SHORT).show();

        }
    }

    private void addNewsToLayout(News[] values) {
        try {
            View parent = getView();

            if ( ll == null)
            {
                ll = (LinearLayout) parent.findViewById(R.id.layout_tab_1);

                    for (News news : values) {
                        ImageView img = new ImageView(parent.getContext());
                        Bitmap bm = new Read_Online.ImageLoadTask(news.getSrc(), img).execute().get();
                        img.setImageBitmap(bm.createScaledBitmap(bm, 1200, 600, false));

                        img.setOnClickListener(new ImageEvents());


                        ll.addView(img);
                    }

            }
        } catch (Exception e) {
            Log.e("Error tab 1", e.toString());

        }
    }

}
