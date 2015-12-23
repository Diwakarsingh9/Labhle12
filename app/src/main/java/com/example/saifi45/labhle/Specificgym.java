package com.example.saifi45.labhle;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.alexvasilkov.android.commons.utils.Views;
import com.alexvasilkov.foldablelayout.UnfoldableView;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.astuetz.PagerSlidingTabStrip;
import com.example.saifi45.labhle.imageloading.ImageLoader;
import com.example.saifi45.labhle.items.Painting;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import settergetter.ActivityListView;
import settergetter.Receivedfromspecificgyms;
import singleton.VolleySingleton;
import urlapi.SearchurlAPI;


public class Specificgym extends Activity {

    public ListView mListView,ListviewActivitydialog;
    private View mListTouchInterceptor;
    private View mDetailsLayout;
    private static UnfoldableView mUnfoldableView;
    static Painting painting;
    ImageView image,i1,i2,cancel, gymstrainersimage1,gymstrainersimage2;
    TextView title,idtext;
    String[] activitytext2;
    String[] activityimg2;

    TextView gymsaddress,gymsphoneno,gymstrainersname1,gymstrainersname2,gymsyear,gymsgendersname,
            gymtrainerslastname1,gymtrainerslastname2,gym1mobileno,gym2mobile;

    ScrollView scroll;

    ViewPager viewPager;
    public static SEARCH_FRAGMENT dddddd;
    public static Context ctc;
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
    public  static FragmentManager fragmentManager;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specificgym);


        i1 = (ImageView)findViewById(R.id.activity);
        i2 = (ImageView)findViewById(R.id.sessions);
        gymsaddress=(TextView)findViewById(R.id.addresstobeprint);
        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(new MySearchAdapter(fragmentManager));



        gymstrainersname1 = (TextView)findViewById(R.id.trainersnametobeprint11);
        gym1mobileno = (TextView)findViewById(R.id.trainerslastnametobeprint11);

        gym2mobile = (TextView)findViewById(R.id.trainerslastnametobeprint222);
        gymstrainersname2 = (TextView)findViewById(R.id.trainersnametobeprint22);
        gymstrainersimage1 = (ImageView)findViewById(R.id.trainersimagetobeprint1);
        gymstrainersimage2 = (ImageView)findViewById(R.id.trainerimagestobeprint2);

        imloader=new ImageLoader(ctc.getApplicationContext());
        gymsphoneno=(TextView)findViewById(R.id.phonetobeprint);
        gymsyear=(TextView)findViewById(R.id.yeartobeprint);
        gymsgendersname = (TextView)findViewById(R.id.gendernametobeprint);
        // gymstrainersname=(TextView)view.findViewById(R.id.trainersnametobeprint);

        scroll= (ScrollView)findViewById(R.id.scrollView);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();

            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSessionCustomDialog();

            }
        });
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip)findViewById(R.id.tabs);
        tabs.setIndicatorHeight(5);
        tabs.setTextColor(Color.WHITE);
        tabs.setUnderlineColor(0x7f1101);
        tabs.setIndicatorColor(Color.WHITE);
        // tabs.setTabPaddingLeftRight(20);
        tabs.setDividerColor(Color.WHITE);

        tabs.setViewPager(viewPager);

        Picasso.with(Specificgym.this).load(painting.getImageId()).into(image);
        title.setText(painting.getTitle());
        idtext.setText(painting.getIdss());


    }
    public  void showCustomDialog() {

        final Dialog dialog = new Dialog(Specificgym.this,android.R.style.Theme_Translucent_NoTitleBar);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.setContentView(R.layout.customdailog);

        //ArrayList<String>aaaa={"Kick Boxing","Weight Lifting","Dancing"};
        //Activityadapter adapter = new Activityadapter(ctc,aaaa);
        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount=0.6f;
        dialog.getWindow().setAttributes(lp);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.setCancelable(false);
        ListviewActivitydialog=(ListView)dialog.findViewById(R.id.activitylistview);
        Activitylistadapter act = new Activitylistadapter(Specificgym.this,activitytext2 ,activityimg2);
        ListviewActivitydialog.setAdapter(act);

        cancel = (ImageView)dialog.findViewById(R.id.button1);


        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                dialog.dismiss();
            }
        });

        dialog.show();

    }
    public  void showSessionCustomDialog() {



        final Dialog dialog = new Dialog(Specificgym.this,android.R.style.Theme_Translucent_NoTitleBar);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount=0.6f;
        dialog.getWindow().setAttributes(lp);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.sessiondetails);
        TextView gymmemberspersession , gymtrainerspersession , gymtotaltrainers;


        gymmemberspersession =(TextView)dialog.findViewById(R.id.memberspersessiontobeprint);
        gymtrainerspersession =(TextView)dialog.findViewById(R.id.trainerspersessiontobeprint);
        gymtotaltrainers =(TextView)dialog.findViewById(R.id.totaltrainerstobeprint);

        gymmemberspersession.setText(memberspersession);
        gymtrainerspersession.setText(trainerspersession);
        gymtotaltrainers.setText(totaltrainers[0]);

        cancel = (ImageView)dialog.findViewById(R.id.button1);
        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                dialog.dismiss();
            }
        });

        dialog.show();

    }
    public class MySearchAdapter extends FragmentStatePagerAdapter {
        private final String[] TITLES = {"FACILITY", "TIMING","BUDGET","VITALS TRACKED"};

        public MySearchAdapter(FragmentManager fm) {
            super(fm);
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

                case 1:
                    return TIMING_FRAGMENT.newInstance("FirstFragment, Instance 1");
                case 0:
                    return FACILITY_FRAGMENT.newInstance("SecondFragment, Instance 1");
                case 2:
                    return BUDGET_FRAGMENT.newInstance("ThirdFragment, Instance 1");
                case 3:
                    return VITALS_TRACKED.newInstance("FourthFragment, Instance 1");



                default: return MAP_FRAGMENT.newInstance("SecondFragment, Default");

            }

        }

    }

public void set(){
    gym1mobileno.setText(mobile1.toString());
    gym2mobile.setText(mobile2.toString());
}

}
