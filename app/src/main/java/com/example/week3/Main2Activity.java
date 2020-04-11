package com.example.week3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent myCallerIntent = getIntent();
        Bundle myBundle = myCallerIntent.getExtras();
        int val1 = myBundle.getInt("val1");
    }
}
