package com.example.saifi45.labhle;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.alexvasilkov.android.commons.adapters.ItemsAdapter;
import com.alexvasilkov.android.commons.utils.Views;
import com.alexvasilkov.foldablelayout.UnfoldableView;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.saifi45.labhle.imageloading.ImageLoader;
import com.example.saifi45.labhle.items.Painting;
//import com.example.saifi45.labhle.items.PaintingsAdapter;
import com.example.saifi45.labhle.items.PaintingAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import settergetter.ActivityListView;
import settergetter.INNERDATA3;
import settergetter.INNERDATA322;
import settergetter.INNERDATA4;
import settergetter.Receivedfromlocationapi;
import settergetter.Receivedfromlocationapi22;
import settergetter.Receivedfromspecificgyms;
import singleton.VolleySingleton;
import urlapi.SearchurlAPI;

public class SEARCH_FRAGMENT extends Fragment {

    public  ListView mListView,ListviewActivitydialog;

    private View mListTouchInterceptor;
    private View mDetailsLayout;
    private static UnfoldableView mUnfoldableView;
    static Painting painting;
    ImageView image,i1,i2,cancel, gymstrainersimage1,gymstrainersimage2;
    TextView title,idtext;
    String[] activitytext2;
    String[] activityimg2;
    ListView listView11;
    TextView gymsaddress,gymsphoneno,gymstrainersname1,gymstrainersname2,gymsyear,gymsgendersname,
            gymtrainerslastname1,gymtrainerslastname2,gym1mobileno,gym2mobile;
    static int iiiiii;
   ScrollView scroll;
    public static TextView et1,et2;
    ViewPager viewPager;
    public static SEARCH_FRAGMENT dddddd;
    public static Context ctc;
    public static Context ctc2;
    public static String strtext,strtext2;
     RequestQueue queue;
    public static String[] stockArr,stockArr22;
    public static String [] arrname,arrname22 ;
    public static String[] idarray,idarray22;
    public static ArrayList<String> ids = new ArrayList<String>();
    //public static String[] stockArr;
    public static ArrayList<String> name11=new ArrayList<String>();
    public static ArrayList<String> url=new ArrayList<String>();
    public static ArrayList<String> budgetarraylist=new ArrayList<String>();
    public static ArrayList<String> timmingarraylist=new ArrayList<String>();
    public static ArrayList<String> vitalsarraylist=new ArrayList<String>();
    public static ArrayList<String[]> mobileno = new ArrayList<>();
    static ArrayList<String> mobile1 = new ArrayList<>();
    static ArrayList<String> mobile2 = new ArrayList<>();

    String genders,addresss,phoneno,year,memberspersession,trainerspersession,trainersname1,
            trainersname1image,trainersname2image,trainersname2,trainerslastname1,trainerslastname2
             = null;
    ArrayList<String> activitytext=new ArrayList<String>();
    ArrayList<String> activityimg=new ArrayList<String>();
    String totaltrainers[];
    ImageLoader imloader;
    public static String bccd[] ;//= {"uploading...","uploading...","uploading...","uploading...","uploading...","uploading..."
    // ,"uploading...","uploading...","uploading...","uploading...","uploading...","uploading...","uploading...","uploading..."
    //,"uploading...","uploading...","uploading...","uploading..."};





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        et1=(TextView)view.findViewById(R.id.editText);
        et2=(TextView)view.findViewById(R.id.editText2);
        et1.setText(strtext);
        et2.setText(strtext2);
ctc2=getActivity();
        et1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Locationfinder.class);
                startActivity(in);
            }
        });

        et2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Gymnamefinder.class);
                startActivity(in);
            }
        });
        mListView = (ListView) view.findViewById(R.id.list_view11);
        if(SplashActivity.wwwwwwwwwwwwwwww==1) {
            parsing(et1.getText().toString(), et2.getText().toString(), ctc);


            //SplashActivity.wwwwwwwwwwwwwwww=0;
        }
        else if(SplashActivity.wwwwwwwwwwwwwwww==0){
            parsinggym(et1.getText().toString(), et2.getText().toString(), ctc);


            // Toast.makeText(ctc,"gym finder se aya mera dost dost ko slama kro",Toast.LENGTH_LONG).show();
            //SplashActivity.wwwwwwwwwwwwwwww=1;
        }

mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Specificgymparsing(idtext.getText().toString(), ctc);

        Intent intent = new Intent(getActivity(), Specificgym.class);
        getActivity().startActivity(intent);
    }
});

        return view;
    }
    public static SEARCH_FRAGMENT newInstance(String text, String messages, String messages1) {

        SEARCH_FRAGMENT f = new SEARCH_FRAGMENT();
        Bundle b = new Bundle();
        b.putString("msg", text);
        strtext=messages;
        strtext2=messages1;


        f.setArguments(b);

        return f;
    }

    public static void onBackpressed() {

        iiiiii=2;
    }

    public void parsing(String abc, String s, final Context ctc){

        String currentarea;
        String currentgym ;
        String currentcity;
        String finalurl23;
        final String currentlocationsearch;

        final Context ctctc;
        final StringRequest sr;



        ctctc=ctc;
        queue= VolleySingleton.getInstance(ctctc).getRequestQueue();
        currentlocationsearch=abc;

Log.e("currentlocationsearch",""+currentlocationsearch);
        StringTokenizer tokens = new StringTokenizer(currentlocationsearch, ",");
        currentarea = tokens.nextToken();
        currentcity = tokens.nextToken().trim();

        if(s.equals("Search Gym's Name")){
            currentgym="";
        }
        else{
            currentgym=s;
        }

        finalurl23= SearchurlAPI.locationfinderstart.concat(String.valueOf(currentcity)).
                concat(SearchurlAPI.locationfinderend).concat(String.valueOf(currentarea)).concat(SearchurlAPI.locationfinderend2).
                concat(String.valueOf(currentgym));
        finalurl23=finalurl23.replace(" ", "%20");
        Log.e("that i am executing ##", "" + finalurl23);
        sr = new StringRequest(Request.Method.GET, finalurl23, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                //Toast.makeText(ctctc, "Response" + response, Toast.LENGTH_SHORT).show();
                List<INNERDATA3> data_list=new ArrayList<INNERDATA3>();
                try {
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    final Gson gson = gsonBuilder.create();
                    Receivedfromlocationapi received111 = new Receivedfromlocationapi();
                    received111 = gson.fromJson(response, Receivedfromlocationapi.class);
                    data_list = received111.data;
                    SplashActivity.qqqqqqqq++;
                    name11.clear();
                    name11.clear();
                    url.clear();
                    ids.clear();


                    SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(getActivity());
                    SharedPreferences.Editor edit=pref.edit();
                    for(int i=0;i<data_list.size(); i++) {
                        name11.add(data_list.get(i).name);
                        url.add(data_list.get(i).logo);
                        ids.add(data_list.get(i).id);
                        edit.putString("Gym" + i, data_list.get(i).name);
                        edit.putInt("arraySize", i);
                        edit.commit();

                    }

                    stockArr = new String[name11.size()];
                    stockArr = name11.toArray(stockArr);
                    arrname = new String[url.size()];
                    arrname = url.toArray(arrname);
                    idarray = new String[ids.size()];
                    idarray = ids.toArray(idarray);
                    Log.e("dddddd", "" + stockArr + arrname);
                   // mListView.setAdapter(new PaintingAdapter(ctc, name11, url, ids));
                    Log.e("hdhdddhdh", "" + name11);
                    data_list.clear();

                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }
            // Toast.makeText(ctctc,""+name11,Toast.LENGTH_SHORT).show();



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
    public void parsinggym(String abc, String s, final Context ctc){

        String currentarea;
        String currentgym ;
        String currentcity;
        String finalurl23;
        final String currentlocationsearch;

        final Context ctctc;
        final StringRequest sr;




        ctctc=ctc;
        queue= VolleySingleton.getInstance(ctctc).getRequestQueue();
        currentlocationsearch=abc;


        StringTokenizer tokens = new StringTokenizer(currentlocationsearch, ",");
        currentarea = tokens.nextToken();
        currentcity = tokens.nextToken().trim();

        if(s.equals("Search Gym's Name")){
            currentgym="";
        }
        else{
            currentgym=s;
        }

        finalurl23= SearchurlAPI.locationfinderstart.concat(String.valueOf(currentcity)).
                concat(SearchurlAPI.locationfinderend).concat(String.valueOf(currentarea)).concat(SearchurlAPI.locationfinderend2).
                concat(String.valueOf(currentgym));
        finalurl23 = finalurl23.replace(" ", "%20");
        Log.e("that i am executing ##", "" + finalurl23);
        sr = new StringRequest(Request.Method.GET, finalurl23, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                //Toast.makeText(ctctc, "Response" + response, Toast.LENGTH_SHORT).show();
                List<INNERDATA322> data_list22=new ArrayList<INNERDATA322>();
                try {
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    final Gson gson = gsonBuilder.create();
                    Receivedfromlocationapi22 received111 = new Receivedfromlocationapi22();
                    received111 = gson.fromJson(response, Receivedfromlocationapi22.class);
                    data_list22 = received111.data22;
                    SplashActivity.qqqqqqqq++;
                    name11.clear();

                    name11.clear();
                    url.clear();
                    ids.clear();

                    for(int i=0;i<data_list22.size(); i++) {
                        name11.add(data_list22.get(i).name);
                        url.add(data_list22.get(i).logo);
                        ids.add(data_list22.get(i).id);


                    }

                    stockArr22 = new String[name11.size()];
                    stockArr22 = name11.toArray(stockArr);
                    arrname22 = new String[url.size()];
                    arrname22 = url.toArray(arrname);
                    idarray22 = new String[ids.size()];
                    idarray22 = ids.toArray(idarray);
                    Log.e("dddddd", "" + stockArr + arrname);
                    //mListView.setAdapter(new PaintingAdapter(ctc, name11, url, ids));
                    Log.e("hdhdddhdh", "" + name11);
                    data_list22.clear();
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }
            // Toast.makeText(ctctc,""+name11,Toast.LENGTH_SHORT).show();



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
    public void Specificgymparsing(String id, Context ctc){

        final Context context;
        final StringRequest sr1;
        context=ctc;
        String id2=id;

        queue= VolleySingleton.getInstance(context).getRequestQueue();
        String specificurl;

        specificurl = SearchurlAPI.specificgymulr.concat(String.valueOf(id2));
        Log.e("jjjjjggggff", "" + specificurl);
        sr1 = new StringRequest(Request.Method.GET, specificurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(getActivity(),""+response,Toast.LENGTH_SHORT).show();
                List<ActivityListView> activities=new ArrayList<ActivityListView>();
                try {
                    activities.clear();
                    activitytext.clear();
                    activityimg.clear();

                    GsonBuilder gsonBuilder = new GsonBuilder();
                    final Gson gson = gsonBuilder.create();
                    Receivedfromspecificgyms received222 = new Receivedfromspecificgyms();
                    received222 = gson.fromJson(response, Receivedfromspecificgyms.class);
                    Toast.makeText(getActivity(), "" + received222, Toast.LENGTH_SHORT).show();
                    addresss = received222.inner_4.address;
                    trainersname1= received222.inner_4.trainersdetails.fname1;
                    trainerslastname1 = received222.inner_4.trainersdetails.lname1;
                    trainerslastname2 = received222.inner_4.trainersdetails.lname2;
                    trainersname2=received222.inner_4.trainersdetails.fname2;
                    trainersname1image= received222.inner_4.trainersdetails.person_image1;
                    trainersname2image=received222.inner_4.trainersdetails.person_image2;



                    genders = received222.inner_4.workout_gender;
                    memberspersession = received222.inner_4.members_per_sessions;
                    phoneno = received222.inner_4.phone_no;
                    totaltrainers = received222.inner_4.total_trainers;
                    trainerspersession = received222.inner_4.trainers_per_session;
                    year = received222.inner_4.year_of_established;
                    activities =received222.inner_4.activities;
                    Log.e("dummast",""+activities.size()
                    );

                    gymstrainersname1.setText(trainersname1 + trainerslastname1);
                    gymstrainersname2.setText(trainersname2+" "+ trainerslastname2);
                    imloader.DisplayImage(trainersname1image, gymstrainersimage1);
                    imloader.DisplayImage(trainersname2image,gymstrainersimage2);
                    gymsaddress.setText(addresss);
                    gymsyear.setText(year);
                    gymsphoneno.setText(phoneno);
                    gymsgendersname.setText(genders);

                    // Log.e("ye hai",""+activities.get(1).activity_title);

                    for(int y=0;y<activities.size();y++){
                        activitytext.add(activities.get(y).activity_title);
                        activityimg.add(activities.get(y).activity_icon);
                    }
                    activitytext2 = new String[activitytext.size()];
                    activitytext2 = (activitytext).toArray(activitytext2);
                    activityimg2 = new String[activityimg.size()];
                    activityimg2 = (activityimg).toArray(activityimg2);


                    budgetarraylist.add(received222.inner_4.inner_5.registration);
                    budgetarraylist.add(received222.inner_4.inner_5.free_trial_classes);
                    budgetarraylist.add(received222.inner_4.inner_5.daily_pay_guest);
                    budgetarraylist.add(received222.inner_4.inner_5.monthly);
                    budgetarraylist.add(received222.inner_4.inner_5.quartely);
                    budgetarraylist.add(received222.inner_4.inner_5.half_yearly);
                    budgetarraylist.add(received222.inner_4.inner_5.annual);
                    budgetarraylist.add(received222.inner_4.inner_5.cardio);
                    budgetarraylist.add(received222.inner_4.inner_5.wt_training);
                    budgetarraylist.add(received222.inner_4.inner_5.yoga);
                    budgetarraylist.add(received222.inner_4.inner_5.power_yoga);
                    budgetarraylist.add(received222.inner_4.inner_5.aerobics);
                    budgetarraylist.add(received222.inner_4.inner_5.personal_trainer);
                    budgetarraylist.add(received222.inner_4.inner_5.trainer_at_home);
                    budgetarraylist.add(received222.inner_4.inner_5.cross_fit_training);
                    budgetarraylist.add(received222.inner_4.inner_5.pilates);
                    budgetarraylist.add(received222.inner_4.inner_5.zumba);
                    budgetarraylist.add(received222.inner_4.inner_5.kick_boxing);
                    bccd = new String[budgetarraylist.size()];
                    bccd = (budgetarraylist).toArray(bccd);


                    timmingarraylist.add(received222.inner_4.inner_6.mon_morn);
                    timmingarraylist.add(received222.inner_4.inner_6.tue_morn);
                    timmingarraylist.add(received222.inner_4.inner_6.wed_morn);
                    timmingarraylist.add(received222.inner_4.inner_6.thur_morn);
                    timmingarraylist.add(received222.inner_4.inner_6.fri_morn);
                    timmingarraylist.add(received222.inner_4.inner_6.sat_morn);
                    timmingarraylist.add(received222.inner_4.inner_6.sun_morn);
                    timmingarraylist.add(received222.inner_4.inner_6.mon_even);
                    timmingarraylist.add(received222.inner_4.inner_6.tue_even);
                    timmingarraylist.add(received222.inner_4.inner_6.wed_even);
                    timmingarraylist.add(received222.inner_4.inner_6.thur_even);
                    timmingarraylist.add(received222.inner_4.inner_6.fri_even);
                    timmingarraylist.add(received222.inner_4.inner_6.sat_even);
                    timmingarraylist.add(received222.inner_4.inner_6.sun_even);
                    timmingarraylist.add(received222.inner_4.inner_6.gen_morn);
                    timmingarraylist.add(received222.inner_4.inner_6.gen_even);


                    vitalsarraylist.add(received222.inner_4.inner_7.registration);
                    vitalsarraylist.add(received222.inner_4.inner_7.weekly);
                    vitalsarraylist.add(received222.inner_4.inner_7.bi_weekly);
                    vitalsarraylist.add(received222.inner_4.inner_7.monthly);
                    vitalsarraylist.add(received222.inner_4.inner_7.weighing_m_c);
                    vitalsarraylist.add(received222.inner_4.inner_7.measurementsr);
                    vitalsarraylist.add(received222.inner_4.inner_7.bmi_calculator);
                    vitalsarraylist.add(received222.inner_4.inner_7.n_a);


                    mobileno.add(received222.inner_4.mobile_no);
                    for(int p=0;p<mobileno.size();p++){
                        String [] a = mobileno.get(p);
                        mobile1.add(a[0]);
                        //Toast.makeText(getApplicationContext(),""+latitude,Toast.LENGTH_SHORT).show();
                        mobile2.add(a[1]);
                    }


//                Toast.makeText(getActivity(),"search toast"+timmingarray.length,Toast.LENGTH_SHORT).show();








                          /*mobile_no.add(data_list4.get(i).mobile_no);

                        phone_no.add(data_list4.get(i).phone_no);
                        monthly_cost.add(data_list4.get(i).monthly_cost);
                         daily_cost.add(data_list4.get(i).daily_cost);
                        free_trial_classes.add(data_list4.get(i).free_trial_classes);
                        monthly_cost.add(data_list4.get(i).monthly_cost);
                        year_of_esta.add(data_list4.get(i).year_of_esta);
                         rating.add(data_list4.get(i).rating);*/


                }
                catch (JsonSyntaxException e) {
                    e.printStackTrace();
                    Log.e("fffffff", "" + e);
                }


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Toast.makeText(MainActivity.this, "error" + error, Toast.LENGTH_SHORT).show();

            }
        });
        sr1.setRetryPolicy(new DefaultRetryPolicy(50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


        queue.add(sr1);
    }




}

