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
public class MyTimmingadapter extends BaseAdapter {
    Context context;


    LayoutInflater inflater;
    String[] timmingdata2 ;
    String[]timmingheaders={
            "mon_morn",
            "tue_morn",
            "wed_morn",
            "thur_morn",
            "fri_morn",
            "sat_morn",
            "sun_morn",
            "mon_even",
            "tue_even",
            "wed_even",
            "thur_even",
            "fri_even",
            "sat_even",
            "sun_even",
            "gen_morn",
            "gen_even"};



    public MyTimmingadapter(Context context,  String[] timmingdata ){

        this.context= context;

        this.timmingdata2 = timmingdata ;


        inflater = LayoutInflater.from(this.context);

    }
    @Override
    public int getCount() {
        return timmingdata2.length;
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
            convertView = inflater.inflate(R.layout.timmingitemlist, null);
            holder = new Holder();
            convertView.setTag(holder);
        }
        else {
            holder = (Holder)convertView.getTag();
        }


        holder.tv1 = (TextView)convertView.findViewById(R.id.timmingitems);
        holder.tv1.setText(timmingheaders[position]);
        holder.tv2 = (TextView)convertView.findViewById(R.id.timmingitemstobeprinted);
        holder.tv2.setText(timmingdata2[position]);
        return convertView;
    }
}




