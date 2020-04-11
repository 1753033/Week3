package com.example.week3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText tbUsername,tbPassword,tbPassword2,tbBirthday;
    Button btnSelect,btnReset,btnSignup;
    RadioButton selectGender,selectHobbies;
    RadioGroup gender,hobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbUsername = findViewById(R.id.tbUsername);
        tbPassword = findViewById(R.id.tbPassword);
        tbPassword2 = findViewById(R.id.tbPassword2);
        tbBirthday = findViewById(R.id.tbBirthday);
        btnSelect = findViewById(R.id.btnSelect);
        btnReset = findViewById(R.id.btnReset);
        btnSignup = findViewById(R.id.btnsignup);


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tbUsername.setText("");
                tbBirthday.setText("");
                tbPassword.setText("");
                tbPassword2.setText("");

            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle myBundle = new Bundle();


                myBundle.putString("Username", tbUsername.getText().toString());

                myBundle.putString("Password", tbPassword.getText().toString());

                myBundle.putString("Birthday", tbBirthday.getText().toString());




                myIntent.putExtras(myBundle);
                startActivityForResult(myIntent, 102);
            }
        });
    }
}
