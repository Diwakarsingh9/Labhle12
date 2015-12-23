package com.example.saifi45.labhle;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;
import java.util.List;

import settergetter.INNERDATA1;
import settergetter.Recivedfromapi;
import singleton.VolleySingleton;

import static com.example.saifi45.labhle.R.id.mapgh;


public class MAP_FRAGMENT extends Fragment {

    //public static GoogleMap mMap;
    public static LocationManager locationManager;
    public static Location loc;
    public static GPStracker gps;
    public static Marker now[];
    public static StringRequest sr;
    public static Recivedfromapi received = new Recivedfromapi();
    public static Fragment mMapFragment;
    public static List<INNERDATA1> data_list;
    ArrayList<String> id = new ArrayList<String>();
    public static ArrayList<String> name = new ArrayList<String>();
    ArrayList<String> logo = new ArrayList<String>();
    ArrayList<String> address = new ArrayList<String>();
    ArrayList<String> mobile_no = new ArrayList<String>();
    ArrayList<String> phone_no = new ArrayList<String>();
    ArrayList<String> monthly_cost = new ArrayList<String>();
    ArrayList<String> daily_cost = new ArrayList<String>();
    ArrayList<String> year_of_esta = new ArrayList<String>();
    ArrayList<String> free_trial_classes = new ArrayList<String>();
    public static ArrayList<String[]> latlng = new ArrayList<>();
    static ArrayList<String> latitude = new ArrayList<>();
    static ArrayList<String> longitude = new ArrayList<>();
    ArrayList<String> rating = new ArrayList<String>();
    public static int count=10;
    public static int p=0;
    public static Button b1, b2;
    public static TextView tv1;
    public static Double demolatitude[];
    public static Double demolongitude[];
        Context ctc;
    public static int distance;
    public static int pageno = 1;
    MapView mapView;
    public static GoogleMap map;
    public static RequestQueue queue;
    public static Double currentlat, currentlong;
    public static Circle mapCircle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ctc=getActivity();
        View v = inflater.inflate(R.layout.fragment_map__fragment, container, false);
        queue= VolleySingleton.getInstance(getActivity()).getRequestQueue();
        b1=(Button)v.findViewById(R.id.button1);
        b2=(Button)v.findViewById(R.id.button2);
        tv1=(TextView)v.findViewById(R.id.textView);


        MapsInitializer.initialize(getActivity());
        switch (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity())) {
            case ConnectionResult.SUCCESS:
                // Toast.makeText(getActivity(), "SUCCESS", Toast.LENGTH_SHORT).show();
                mapView = (MapView) v.findViewById(mapgh);
                mapView.onCreate(savedInstanceState);
                // Gets to GoogleMap from the MapView and does initialization stuff
                if (mapView != null) {
                    map = mapView.getMap();
                    map.getUiSettings().setMyLocationButtonEnabled(true);
                    map.setMyLocationEnabled(true);
                    gps = new GPStracker(getActivity(), map);
                   Maplocation.currenLocation(5,ctc,map);

                }
                break;
            case ConnectionResult.SERVICE_MISSING:
                Toast.makeText(getActivity(), "SERVICE MISSING", Toast.LENGTH_SHORT).show();
                break;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED:
                Toast.makeText(getActivity(), "UPDATE REQUIRED", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getActivity(), GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()), Toast.LENGTH_SHORT).show();
        }



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int df = Integer.parseInt(tv1.getText().toString());
                tv1.setText("" + (df - 1));
                int dfd = Integer.parseInt(tv1.getText().toString());
                {
                    if (dfd < 0) {
                        tv1.setText("" + 0);
                    }
                }
                distance = 0;
                distance = Integer.parseInt(tv1.getText().toString());
                if (mapCircle != null) {
                    mapCircle.remove();
                }
                map.clear();
                Maplocation.currenLocation(distance, ctc, map);


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int fg = Integer.parseInt(tv1.getText().toString());

                tv1.setText("" + (fg + 1));
                int fgss = Integer.parseInt(tv1.getText().toString());
                Log.e("hfh", "" + fgss);
                distance = 0;
                distance = Integer.parseInt(tv1.getText().toString());
                if (mapCircle != null) {
                    mapCircle.remove();
                }
                map.clear();
                Maplocation.currenLocation(distance, ctc, map);
               }
        });

        return v;
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    public static MAP_FRAGMENT newInstance(String text) {

        MAP_FRAGMENT f = new MAP_FRAGMENT();
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);

        return f;
    }


    }



