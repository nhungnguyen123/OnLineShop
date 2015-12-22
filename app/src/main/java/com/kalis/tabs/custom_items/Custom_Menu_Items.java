package com.kalis.tabs.custom_items;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.kalis.onlineshop.R;

public class Custom_Menu_Items extends BaseAdapter {

    private Context mContext;
    private Integer []mThumbIds;

    public Custom_Menu_Items(Context c){
        mContext=c;
    }

    public Custom_Menu_Items(Context c,Integer []arrIds){
        mContext=c;
        mThumbIds=arrIds;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgView;
        if(convertView==null){
            imgView=new ImageView(mContext);
            //can chỉnh lại hình cho đẹp
            imgView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgView.setPadding(8, 8, 8, 8);
        }else{
            imgView=(ImageView) convertView;
        }
        //lấy đúng vị trí hình ảnh được chọn
        //gán lại ImageResource
        imgView.setImageResource(mThumbIds[position]);
        return imgView;
    }
}
