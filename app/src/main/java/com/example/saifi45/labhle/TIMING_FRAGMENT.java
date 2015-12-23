package com.example.saifi45.labhle;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;


public class TIMING_FRAGMENT extends Fragment {

    ListView timminglv;
    String [] timimngarray ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_timing__fragment, container, false);
        timminglv = (ListView)v.findViewById(R.id.timminglistview);



        timimngarray =new String[SEARCH_FRAGMENT.timmingarraylist.size()];
        timimngarray=(SEARCH_FRAGMENT.timmingarraylist).toArray(timimngarray);
        Toast.makeText(getActivity() , "timimng toast "+timimngarray.length, Toast.LENGTH_SHORT).show();

        MyTimmingadapter mytimmingadapter = new MyTimmingadapter(getActivity(),timimngarray);

       timminglv.setAdapter(mytimmingadapter);



        return v;
    }
    public static TIMING_FRAGMENT newInstance(String text) {

        TIMING_FRAGMENT f = new TIMING_FRAGMENT();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

}
