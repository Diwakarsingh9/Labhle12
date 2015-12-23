package com.example.saifi45.labhle.items;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saifi45.labhle.R;
import com.example.saifi45.labhle.imageloading.ImageLoader;

import java.util.ArrayList;

/**
 * Created by saifi45 on 6/16/2015.
 */
public class PaintingAdapter extends BaseAdapter {

    ImageView image;
    TextView title;
    TextView id;
    String[]headers2;
    String[] data2;
    String[] img;
    ImageLoader il;
    Context ctcc;
    public PaintingAdapter(Context ctc, ArrayList<String> name11, ArrayList<String> url, ArrayList<String> ids) {

        headers2 = new String[name11.size()];
        headers2 = (name11).toArray(headers2);
        data2 = new String[ids.size()];
        data2 = (ids).toArray(data2);
        img = new String[url.size()];
        img = (url).toArray(img);
        ctcc=ctc;




    }

    @Override
    public int getCount() {
        return headers2.length;
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {
         Log.e("adapter", "" +  " " + headers2[position]);
        il=new ImageLoader(ctcc.getApplicationContext());
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater lf=(LayoutInflater) ctcc.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v= lf.inflate(R.layout.listforsearching,null);




        title = (TextView)v.findViewById(R.id.textView);
        title.setText(headers2[position]);
        image = (ImageView)v.findViewById(R.id.imageView);
        il.DisplayImage(img[position], image);
        id=(TextView)v.findViewById(R.id.textView1);
        id.setText(data2[position]);

        return v;
    }



}