package com.example.week3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tvUsername,tvPassword,tvBirthday,tvGender,tvHobbies;
    Button btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        tvUsername = findViewById(R.id.tvUsername);
        tvPassword = findViewById(R.id.tvPassword);
        tvBirthday = findViewById(R.id.tvBirthday);
        tvGender = findViewById(R.id.tvGender);
        tvHobbies = findViewById(R.id.tvHobbies);
        btnExit = findViewById(R.id.btnExit);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent myCallerIntent = getIntent();
        Bundle myBundle = myCallerIntent.getExtras();
        tvUsername.setText(myBundle.getString("Username"));
        tvPassword.setText(myBundle.getString("Password"));
        tvBirthday.setText(myBundle.getString("Birthday"));
        tvHobbies.setText(myBundle.getString("Hobbies"));
        tvGender.setText(myBundle.getString("Gender"));
    }
}
