package com.example.saifi45.labhle;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class FACILITY_FRAGMENT extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_facility__fragment, container, false);
        return v;
    }
    public static FACILITY_FRAGMENT newInstance(String text) {

        FACILITY_FRAGMENT f = new FACILITY_FRAGMENT();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

}
