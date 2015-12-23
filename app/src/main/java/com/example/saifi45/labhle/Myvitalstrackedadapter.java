package com.example.saifi45.labhle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by saifi45 on 6/11/2015.
 */
public class Myvitalstrackedadapter extends BaseAdapter {
    Context context;


    LayoutInflater inflater;
    String[] datavitals;
    String[]headersvitals={
            "registration",
            "weekly",
            "bi-weekly",
            "monthly",
            "weighing-m-c",
            "measurementsr",
            "bmi-calculator",
            "n/a"};



    public Myvitalstrackedadapter(Context context,  String[] datavitals ){

        this.context= context;

        this.datavitals = datavitals ;


        inflater = LayoutInflater.from(this.context);

    }
    @Override
    public int getCount() {
        return datavitals.length;
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

        TextView tv1,tv2;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder;
        if(convertView== null) {
            convertView = inflater.inflate(R.layout.vitalsitemslist, null);
            holder = new Holder();
            convertView.setTag(holder);
        }
        else {
            holder = (Holder)convertView.getTag();
        }


        holder.tv1 = (TextView)convertView.findViewById(R.id.vitalsitems);
        holder.tv1.setText(headersvitals[position]);
        holder.tv2 = (TextView)convertView.findViewById(R.id.vitalsitemstobeprinted);
        holder.tv2.setText(datavitals[position]);
        return convertView;
    }
}
