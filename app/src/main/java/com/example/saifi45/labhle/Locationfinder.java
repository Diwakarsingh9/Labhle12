package com.example.saifi45.labhle;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.List;

import settergetter.INNERDATA2;
import settergetter.locationresult;
import singleton.VolleySingleton;
import urlapi.SearchurlAPI;


public class Locationfinder extends FragmentActivity {
  ListView lv2;
    HorizontalListView lv1;
    String locationurl;
    String data;
    public static StringRequest sr1,sr2;
    public static locationresult received1 = new locationresult();
    public static locationresult received2 = new locationresult();
    public static List<INNERDATA2> data_list1;
    public static List<INNERDATA2> data_list2;
    public static ArrayList<String> idd = new ArrayList<String>();
    public static ArrayList<String> name = new ArrayList<String>();
    public static ArrayList<String> idd1 = new ArrayList<String>();
    public static ArrayList<String> name1 = new ArrayList<String>();
    RequestQueue queue;
    ProgressBar pb;
    String iddd;
    String txt,txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locationfinder);

       String locationurl=SearchurlAPI.locationurl;
        //queue= VolleySingleton.getInstance(getActivity()).getRequestQueue();
        lv1 = (HorizontalListView) findViewById(R.id.listView);
        lv2 = (ListView) findViewById(R.id.listView2);
        pb=(ProgressBar)findViewById(R.id.pb1);
        //pbb=(ProgressBar)findViewById(R.id.pb2);
        //http://wscubetech.org/labhle/app/webroot/api/api.php?api_name=view_city
        queue = VolleySingleton.getInstance(Locationfinder.this).getRequestQueue();



        sr1 = new StringRequest(Request.Method.GET, locationurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            pb.setVisibility(View.GONE);
                try {
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    final Gson gson = gsonBuilder.create();
                    received1 = gson.fromJson(response, locationresult.class);



                data_list1 = received1.data;
                name.clear();
                idd.clear();
                for (int i = 0; i < data_list1.size(); i++) {
                    name.add(data_list1.get(i).city_name);
                    idd.add(data_list1.get(i).city_id);

                    //  String [] a = name.get(i);
                }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
                ArrayAdapter ad = new ArrayAdapter(Locationfinder.this, R.layout.rows, R.id.txtview, name);
                lv1.setAdapter(ad);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Toast.makeText(getActivity(), "error" + error, Toast.LENGTH_SHORT).show();

            }
        });
        sr1.setRetryPolicy(new DefaultRetryPolicy(50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


        queue.add(sr1);
    pb.setVisibility(View.VISIBLE);

            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    txt2 = name.get(position);
                    iddd = idd.get(position);
                    String locationurl2 = SearchurlAPI.locationurl2+ iddd;
                    //Toast.makeText(getApplicationContext(),""+iddd,Toast.LENGTH_SHORT).show();
                    queue = VolleySingleton.getInstance(Locationfinder.this).getRequestQueue();
                    sr2 = new StringRequest(Request.Method.GET, locationurl2, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            //pbb.setVisibility(View.GONE);
                            try {
                                GsonBuilder gsonBuilder = new GsonBuilder();
                                final Gson gson = gsonBuilder.create();
                                received2 = gson.fromJson(response, locationresult.class);


                                data_list2 = received2.data;
                                name1.clear();
                                idd1.clear();
                                for (int i = 0; i < data_list2.size(); i++) {
                                    name1.add(data_list2.get(i).location_name);
                                    idd1.add(data_list2.get(i).location_id);

                                }
                            } catch (JsonSyntaxException e) {
                                e.printStackTrace();
                            }
                            ArrayAdapter ad2 = new ArrayAdapter(Locationfinder.this, R.layout.rows2, R.id.txtview1, name1);
                            lv2.setAdapter(ad2);

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // Toast.makeText(getActivity(), "error" + error, Toast.LENGTH_SHORT).show();

                        }
                    });
                    sr2.setRetryPolicy(new DefaultRetryPolicy(50000,
                            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


                    queue.add(sr2);
                }
            });

           lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    SplashActivity.wwwwwwwwwwwwwwww=1;
                  txt=name1.get(position);
                   Intent in = new Intent(Locationfinder.this,MainActivity.class);
                   in.putExtra("message", txt+", "+txt2);
                   in.putExtra("message1","Search Gym's Name");
                   startActivity(in);
                   MainActivity.activity.finish();
                   finish();
               }
           });

        }
    }




