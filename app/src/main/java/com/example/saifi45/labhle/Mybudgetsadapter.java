package com.example.saifi45.labhle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gaurav on 10-Jun-15.
 */
public class Mybudgetsadapter extends BaseAdapter {
    Context context;


    LayoutInflater inflater;
    String[] data2;
    String[]headers2={"Registration","Free_trial_classes","Daily_pay_guest","Monthly","Quartely","Half_yearly","Annual","Cardio","Wt_training",
            "Yoga","Power_yoga","Aerobics","Personal_trainer","Trainer_at_home","Cross_fit_training","Kick_boxing","Pilates","Zumba"};


    public Mybudgetsadapter(Context context,  String[] data ){

        this.context= context;

        this.data2 = data ;


        inflater = LayoutInflater.from(this.context);

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
        return position;
    }
    public  class Holder{

        TextView tv1,tv2;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder;
        if(convertView== null) {
            convertView = inflater.inflate(R.layout.budgetitemlist, null);
            holder = new Holder();
            convertView.setTag(holder);
        }
        else {
            holder = (Holder)convertView.getTag();
        }


        holder.tv1 = (TextView)convertView.findViewById(R.id.budgetitems);
        holder.tv1.setText(headers2[position]);
        holder.tv2 = (TextView)convertView.findViewById(R.id.budgetitemstobeprinted);
        holder.tv2.setText(data2[position]);
        return convertView;
    }
}



