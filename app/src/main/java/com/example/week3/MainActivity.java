package com.example.week3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;

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
        gender = findViewById(R.id.rbgender);
        hobbies = findViewById(R.id.rbhobbies);


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tbUsername.setText("");
                tbBirthday.setText("");
                tbPassword.setText("");
                tbPassword2.setText("");
                gender.clearCheck();
                hobbies.clearCheck();

            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!tbUsername.getText().toString().isEmpty() && !tbPassword.getText().toString().isEmpty() && !tbPassword2.getText().toString().isEmpty()) {

                    if (tbPassword.getText().toString().equals(tbPassword2.getText().toString())) {

                        Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
                        Bundle myBundle = new Bundle();

                        myBundle.putString("Username", tbUsername.getText().toString());

                        myBundle.putString("Password", tbPassword.getText().toString());

                        myBundle.putString("Birthday", tbBirthday.getText().toString());


                        if (gender.getCheckedRadioButtonId() != -1) {
                            selectGender = findViewById(gender.getCheckedRadioButtonId());
                            myBundle.putString("Gender", selectGender.getText().toString());
                        }

                        if (hobbies.getCheckedRadioButtonId() != -1) {
                            selectHobbies = findViewById(hobbies.getCheckedRadioButtonId());
                            myBundle.putString("Hobbies", selectHobbies.getText().toString());
                        }

                        myIntent.putExtras(myBundle);
                        startActivityForResult(myIntent, 102);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Please check your password.",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please fill out the information.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
