package com.twoactivities.buttonnewactivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Activity2 extends Activity{

    String command;
    TextView tvView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        init();
        getPing(command);
    }

    public void init() {
        tvView=(TextView)findViewById(R.id.tvView);
        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            command = extra.getString("Command");
        }

    }


        public void getPing(String command) {
                //
            try {
                Process p1 = java.lang.Runtime.getRuntime().exec("/system/bin/sh"+command);
                BufferedReader in = new BufferedReader(new InputStreamReader(p1.getInputStream()));
                OutputStreamWriter newOutputStreamWriter =  new OutputStreamWriter(getApplicationContext().openFileOutput("config.txt", Context.MODE_PRIVATE));
                    if (in.readLine() != null){
                        //newOutputStreamWriter.write(line);
                        tvView.setText(in.readLine());
                    }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}

