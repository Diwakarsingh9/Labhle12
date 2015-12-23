package com.example.saifi45.labhle;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.astuetz.PagerSlidingTabStrip;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.List;

import settergetter.INNERDATA1;
import settergetter.Recivedfromapi;
import singleton.VolleySingleton;
import urlapi.SearchurlAPI;

public class MainActivity extends FragmentActivity {

    ViewPager pager;
    public  static FragmentManager fragmentManager;
    ActionBar actionBar;
    public static MainActivity activity;
    String message,message1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity=this;

        getActionBar().hide();
        Bundle bundle = getIntent().getExtras();
         message = bundle.getString("message");
        message1 = bundle.getString("message1");
        fragmentManager=getSupportFragmentManager();
        pager = (ViewPager) findViewById(R.id.pager);


        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), message,message1));

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setIndicatorHeight(5);
        tabs.setTextColor(Color.WHITE);
        tabs.setUnderlineColor(0x7f1101);
        tabs.setIndicatorColor(Color.WHITE);
        tabs.setDividerColor(Color.WHITE);

        tabs.setViewPager(pager);
if(SplashActivity.yyyyy==0){
    pager.setCurrentItem(1);
    SplashActivity.yyyyy++;
}
    }
    @Override
    public void onBackPressed() {

        if (SEARCH_FRAGMENT.iiiiii==1){
        SEARCH_FRAGMENT.onBackpressed();
        }
        else{
            super.onBackPressed();
        }
    }


    ////////////  Adapter class for view pager
    public class MyPagerAdapter extends FragmentStatePagerAdapter {
        String messages,messages1;
        private final String[] TITLES = {"Search","NearBy"};

        public MyPagerAdapter(FragmentManager fm, String message, String message1) {
            super(fm);
            messages=message;
            messages1=message1;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {

                case 0:
                    return SEARCH_FRAGMENT.newInstance("FirstFragment, Instance 1",messages,messages1);
                case 1:
                    return MAP_FRAGMENT.newInstance("SecondFragment, Instance 1");

                default: return MAP_FRAGMENT.newInstance("Firstfragment, Default");

            }

        }

    }

}

           /* b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int df= Integer.parseInt(tv1.getText().toString());
                    tv1.setText(df - 1);
                    distance=Integer.parseInt(tv1.getText().toString());
                    currenLocation();
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int fg= Integer.parseInt(tv1.getText().toString());

                    tv1.setText(fg + 1);
                    int fgss= Integer.parseInt(tv1.getText().toString());
                    Log.e("hfh", ""+fgss);
                    distance=Integer.parseInt(tv1.getText().toString());
                    currenLocation();
                }
            });*/

