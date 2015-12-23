package com.example.saifi45.labhle;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class BUDGET_FRAGMENT extends Fragment {

    ListView lv;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_budget__fragment, container, false);
        lv = (ListView)v.findViewById(R.id.budgetlist);


        Mybudgetsadapter myadapter = new Mybudgetsadapter(getActivity(),SEARCH_FRAGMENT.bccd);
        lv.setAdapter(myadapter);

        return v;


    }

    public static BUDGET_FRAGMENT newInstance(String text) {

        BUDGET_FRAGMENT f = new BUDGET_FRAGMENT();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

}