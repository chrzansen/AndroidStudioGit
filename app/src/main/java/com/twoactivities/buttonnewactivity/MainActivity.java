package com.twoactivities.buttonnewactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void onButtonClick(View v){
        if(v.getId() == R.id.btnDisplay){
            edText = (EditText) findViewById(R.id.etCommand);
            String command = edText.getText().toString();
            Intent newIntent = new Intent(MainActivity.this, Activity2.class);
            newIntent.putExtra("Command", command);
            startActivity(newIntent);
        }
    }
}
