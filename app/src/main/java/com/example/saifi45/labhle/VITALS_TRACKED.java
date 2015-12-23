package com.example.saifi45.labhle;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class VITALS_TRACKED extends Fragment {

    ListView lvvitals;
    String [] vitalsarray ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_vitals__tracked, container, false);
        lvvitals = (ListView)v.findViewById(R.id.vitalslistview);


        vitalsarray =new String[SEARCH_FRAGMENT.vitalsarraylist.size()];
        vitalsarray=(SEARCH_FRAGMENT.vitalsarraylist).toArray(vitalsarray);

        Myvitalstrackedadapter myvitalsadapter = new Myvitalstrackedadapter(getActivity(),vitalsarray);

        lvvitals.setAdapter(myvitalsadapter);


        return v;
    }
    public static VITALS_TRACKED newInstance(String text) {

        VITALS_TRACKED f = new VITALS_TRACKED();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

}
