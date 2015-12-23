package com.example.saifi45.labhle;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saifi45.labhle.imageloading.ImageLoader;


public class Activitylistadapter extends BaseAdapter{
    Context context;


    LayoutInflater inflater;
    String[] tv;
    String[]img;
    ImageLoader il;



    public Activitylistadapter(Context context,  String[] data,String[] img ){

        this.context= context;

        this.tv = data ;
        this.img=img;

        il=new ImageLoader(context.getApplicationContext());
        inflater = LayoutInflater.from(this.context);

    }
    @Override
    public int getCount() {
        return tv.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public  class Holder{

        TextView tv1;
        ImageView tv2;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder;
        if(convertView== null) {
            convertView = inflater.inflate(R.layout.actlistviewitem, null);
            holder = new Holder();
            convertView.setTag(holder);
        }
        else {
            holder = (Holder)convertView.getTag();
        }


        holder.tv1 = (TextView)convertView.findViewById(R.id.tvact);
        holder.tv1.setText(tv[position]);
        holder.tv2 = (ImageView)convertView.findViewById(R.id.imgact);
       // holder.tv2.setImageResource(Integer.parseInt(img[position]));
        il.DisplayImage(img[position],holder.tv2);
        return convertView;
    }
}
