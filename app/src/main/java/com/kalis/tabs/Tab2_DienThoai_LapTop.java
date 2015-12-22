package com.kalis.tabs;


import android.app.ActionBar;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kalis.function.Read_Online;
import com.kalis.model.Brand;
import com.kalis.model.Product;
import com.kalis.onlineshop.MainActivity;
import com.kalis.onlineshop.R;

import java.io.InputStreamReader;
import java.net.URL;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab2_DienThoai_LapTop extends Fragment {

    private LinearLayout linearLayout = null;

    public Tab2_DienThoai_LapTop() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        new LoadBrandFromUrl().execute(MainActivity.Url_Brands);
        new LoadProductFromUrl().execute(MainActivity.Url_Products);
        linearLayout = null;

        return inflater.inflate(R.layout.fragment_tab2_dienthoai_laptop, container, false);
    }

    public class LoadBrandFromUrl extends AsyncTask<String, Brand, Void> {
        @Override
        protected Void doInBackground(String... params) {

            try {

                String link = params[0];
                URL url = new URL(link);

                InputStreamReader reader = new InputStreamReader(url.openStream(), "UTF-8");


                Brand [] brands = new Gson().fromJson(reader,Brand[].class);

                publishProgress(brands);


            }
            catch (Exception e) {
                Log.e("ERROR", e.toString());
            }

            return null;

        }

        @Override
        protected void onProgressUpdate(Brand... values) {
            super.onProgressUpdate(values);

            addBrandToLayout(values);

        }

    }
    private void addBrandToLayout(Brand[] brands)
    {
        try {
                View parent = getView();
                linearLayout = (LinearLayout) getView().findViewById(R.id.layout_tab_2);
                linearLayout.setBackgroundResource(R.color.primary);

                LinearLayout layout = new LinearLayout(parent.getContext());

                HorizontalScrollView scrollView = new HorizontalScrollView (parent.getContext());
                scrollView.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                scrollView.setHorizontalScrollBarEnabled(false);

                layout.setGravity(Gravity.CENTER);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                layout.setBackgroundResource(R.color.accent);
                layout.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                int w = 0,h=0;
                for (int i = 0; i < 5; i++) {
                    for (Brand brand : brands) {

                        if (!brand.getSrc().trim().isEmpty())
                        {
                            ImageView img = new ImageView(parent.getContext());
                            Bitmap bm = new Read_Online.ImageLoadTask(brand.getSrc(), img).execute().get();
                            if (bm != null)  {
                                w = bm.getWidth();
                                h = bm.getHeight();
                            }
                            img.setImageBitmap(bm);
                            layout.addView(img);


                            ImageView img2 = new ImageView(parent.getContext());
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(w, h);
                            img2.setLayoutParams(layoutParams);
                            img2.setBackgroundResource(R.color.accent);
                            layout.addView(img2);
                        }


                    }
//                }

                scrollView.addView(layout);

                linearLayout.addView(scrollView);

            }
        }
        catch (Exception e){
            Log.e("ERROR tab 2",e.toString());
        }
    }

    public class LoadProductFromUrl extends AsyncTask<String, Product, Void> {
        @Override
        protected Void doInBackground(String... params) {

            try {

                String link = params[0];
                URL url = new URL(link);

                InputStreamReader reader = new InputStreamReader(url.openStream(), "UTF-8");


                Product [] dsProducts = new Gson().fromJson(reader,Product[].class);

                publishProgress(dsProducts);


            }
            catch (Exception e) {
                Log.e("ERROR", e.toString());
            }

            return null;

        }

        @Override
        protected void onProgressUpdate(Product... values) {
            super.onProgressUpdate(values);

            addProductToLayout(values);

        }

    }
    private void addProductToLayout(Product [] products)
    {
        try {
                View parent = getView();
                linearLayout = (LinearLayout) getView().findViewById(R.id.layout_tab_2);


                LinearLayout layout = new LinearLayout(parent.getContext());

                ScrollView scrollView = new ScrollView(parent.getContext());
                scrollView.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));


                int w = 0,h=0;
                for (int i = 0; i < 10; i++) {
                    for (Product product : products) {

                        if (!product.getSrc().trim().isEmpty())
                        {
                            layout.setOrientation(LinearLayout.VERTICAL);
                            layout.setBackgroundResource(R.color.white);
                            layout.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                            ImageView img = new ImageView(parent.getContext());
                            Bitmap bm = new Read_Online.ImageLoadTask(product.getSrc(), img).execute().get();
                            if (bm != null)  {
                                w = bm.getWidth();
                                h = bm.getHeight();
                            }
                            img.setImageBitmap(bm);
                            layout.addView(img);


                            ImageView img2 = new ImageView(parent.getContext());
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(w, h);
                            img2.setLayoutParams(layoutParams);
                            img2.setBackgroundResource(R.color.white);
                            layout.addView(img2);
                        }


                    }
                }

                scrollView.addView(layout);

                linearLayout.addView(scrollView);

            Log.e("error", products[0].getSrc());
            Log.e("error", products[1].getSrc());
        }
        catch (Exception e){
            Log.e("ERROR tab 2",e.toString());
        }
    }

}
