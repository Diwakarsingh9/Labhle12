package com.example.saifi45.labhle;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;


import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;



import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class SplashActivity extends Activity implements android.location.LocationListener{


    // Splash screen timer
    private static int SPLASH_TIME_OUT = 6000;
    public  static int yyyyy=0;
    public static int distance=5;
    public  static int wwwwwwwwwwwwwwww=1;
    public  static int qqqqqqqq=0;

    LocationManager mLocationManager;
    Location mLocation;
    TextView tv;
    StringBuilder mSB;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);
        getActionBar().hide();

      /*  mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        String locationprovider = mLocationManager.getBestProvider(criteria,true);
        mLocation =mLocationManager.getLastKnownLocation(locationprovider);*/
        List<Address> addresses;
        try {
            Geocoder mGC = new Geocoder(this, Locale.ENGLISH);
            addresses = mGC.getFromLocation(new GPStracker(SplashActivity.this).getLatitude(),
                    new GPStracker(SplashActivity.this).getLongitude(), 1);
            if(addresses != null) {
                Address currentAddr = addresses.get(0);
                mSB = new StringBuilder("");
                //for(int i=0; i<currentAddr.getMaxAddressLineIndex(); i++) {
                mSB.append(currentAddr.getSubLocality()).append(",").append(" ").append(currentAddr.getLocality()); //}

                result = mSB.toString();
                Log.i("hghhhhhh",""+result);

            }
        } catch(IOException e) {
        }


        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                i.putExtra("message",result);
                i.putExtra("message1","Search Gym's Name");
                startActivity(i);
                SplashActivity.this.overridePendingTransition(R.anim.push_in_animation, R.anim.push_out_animation);
                //   SEARCH_FRAGMENT.parsing("SSector 31, Gurgaon",getApplicationContext());
                finish();



            }
            //  }
        }, SPLASH_TIME_OUT);
    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
