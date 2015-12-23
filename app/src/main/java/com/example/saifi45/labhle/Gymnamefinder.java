package com.example.saifi45.labhle;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Gymnamefinder extends Activity {

    EditText   searchedt ;
    ListView lv4;
    ArrayAdapter adp;
    String txt33;

   ArrayList<String> xvids=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gymnamefinder);
        xvids.clear();
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int size=pref.getInt("arraySize", 0);

        for(int i=0;i<size;i++){
            String Grey=pref.getString("Gym"+i,"example");
            xvids.add(Grey);
        }

        String data[]=new String[xvids.size()];
        data=xvids.toArray(data);
        try {
            searchedt = (EditText) findViewById(R.id.searchbar);
            lv4 = (ListView) findViewById(R.id.listViewgym);
            lv4.setTextFilterEnabled(true);
            adp = new ArrayAdapter(Gymnamefinder.this, R.layout.gymfinder, R.id.textView10, data);
            lv4.setAdapter(adp);
            Toast.makeText(Gymnamefinder.this,""+SEARCH_FRAGMENT.name11,Toast.LENGTH_SHORT).show();


            searchedt.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    Gymnamefinder.this.adp.getFilter().filter(s);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        lv4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //MainActivity.uuuuuu=0;
                SplashActivity.wwwwwwwwwwwwwwww=0;
                txt33 = (String) lv4.getItemAtPosition(position);
                Intent in = new Intent(Gymnamefinder.this, MainActivity.class);
                in.putExtra("message1", txt33);
                in.putExtra("message", SEARCH_FRAGMENT.et1.getText().toString());
                startActivity(in);
                MainActivity.activity.finish();
                finish();
            }
        });
    }




    }



