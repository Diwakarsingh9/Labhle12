package com.example.saifi45.labhle;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
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

/**
 * Created by saifi45 on 6/3/2015.
 */
public class Maplocation{

    public static void currenLocation(int zzzzzzzzzzzzzz, Context ctc, GoogleMap map) {
    LocationManager locationManager;
    Location loc;
    GPStracker gps;
     Marker now[];
     StringRequest sr;

     Fragment mMapFragment;

    ArrayList<String> id = new ArrayList<String>();
     final ArrayList<String> name = new ArrayList<String>();
    ArrayList<String> logo = new ArrayList<String>();
    ArrayList<String> address = new ArrayList<String>();
    ArrayList<String> mobile_no = new ArrayList<String>();
    ArrayList<String> phone_no = new ArrayList<String>();
    ArrayList<String> monthly_cost = new ArrayList<String>();
    ArrayList<String> daily_cost = new ArrayList<String>();
    ArrayList<String> year_of_esta = new ArrayList<String>();
    ArrayList<String> free_trial_classes = new ArrayList<String>();
     final ArrayList<String[]> latlng = new ArrayList<>();
     final ArrayList<String> latitude = new ArrayList<>();
     final ArrayList<String> longitude = new ArrayList<>();
    ArrayList<String> rating = new ArrayList<String>();
     int count=10;
     int p=0;
     Button b1, b2;
    TextView tv1;
     Double demolatitude[];
     Double demolongitude[];

     int distance11;
     int pageno = 1;
    MapView mapView;
     final GoogleMap mmap;
     RequestQueue queue;
     Double currentlat, currentlong;
     Circle mapCircle;

        mmap=map;
        queue= VolleySingleton.getInstance(ctc).getRequestQueue();
      gps = new GPStracker(ctc,mmap);
            distance11=zzzzzzzzzzzzzz;
        MAP_FRAGMENT.tv1.setText("" + distance11);
        if (gps !=null) {
            currentlat= gps.getLatitude();
            currentlong= gps.getLongitude();


            String finalurl;
            finalurl = SearchurlAPI.mapwithlatlongstart.concat(String.valueOf(currentlat)).
                    concat(SearchurlAPI.mapwithlatlongmid).concat(String.valueOf(currentlong)).
                    concat(SearchurlAPI.mapwithlatlongend).concat(String.valueOf(distance11)).
                    concat(SearchurlAPI.mapwithlatlongend2).concat(String.valueOf(pageno));
            Log.e("hfhhf", "" + finalurl);

            CameraUpdate center =
                    CameraUpdateFactory.newLatLng(new LatLng(currentlat,
                            currentlong));
            CameraUpdate zoom = CameraUpdateFactory.zoomTo(11);

            mmap.moveCamera(center);
            mmap.animateCamera(zoom);


            mapCircle=mmap.addCircle(new CircleOptions().center(new LatLng(currentlat,
                    currentlong)).radius(distance11 * 1000 * 1.2).strokeColor(Color.RED).strokeWidth(4));
            sr = new StringRequest(Request.Method.GET, finalurl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //  Toast.makeText(MainActivity.this, "Response" + response, Toast.LENGTH_SHORT).show();
                    List<INNERDATA1> data_list = null;
                    try {
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        final Gson gson = gsonBuilder.create();
                        Recivedfromapi received = new Recivedfromapi();

                        received = gson.fromJson(response, Recivedfromapi.class);
                        data_list = received.data;


                    //data_list = received.data;

                    for(int i=0;i<data_list.size();i++)
                    {
                        //p++;
                        name.add(data_list.get(i).name);
                        latlng.add(data_list.get(i).latlong1);
                        String [] a = latlng.get(i);
                        latitude.add(a[0]);
                        //Toast.makeText(getApplicationContext(),""+latitude,Toast.LENGTH_SHORT).show();
                        longitude.add(a[1]);
                    }
                    //Log.e("kfgjkg",""+latlng);
                    } catch (JsonSyntaxException e) {
                        e.printStackTrace();
                        Log.e("fffffff",""+e);
                    }
                    for(int k=0;k<name.size();k++){

                        Marker now= mmap.addMarker(new MarkerOptions()
                                .position(new LatLng(Double.parseDouble((latitude.get(k)).toString()), Double.parseDouble((longitude.get(k)).toString())))
                                .title("" + name.get(k)).icon(BitmapDescriptorFactory.fromResource(R.drawable.rszimage)));
                        mmap.setMyLocationEnabled(true);
                        now.showInfoWindow();
                    }

                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // Toast.makeText(MainActivity.this, "error" + error, Toast.LENGTH_SHORT).show();

                }
            });
            sr.setRetryPolicy(new DefaultRetryPolicy(50000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            queue.add(sr);
        }
        else {
           gps.showSettingsAlert();

        }
    }
}
