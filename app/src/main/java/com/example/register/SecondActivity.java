package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tv_Name, tv_Phone, tv_Gender, tv_Literacy, tv_Age, tv_Music;
    CheckBox cbSport;
    String[] literacy_arr = {"THPT", "CD", "DH"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv_Name = findViewById(R.id.tv_Name);
        tv_Phone = findViewById(R.id.tv_Phone);
        tv_Gender = findViewById(R.id.tv_Gender);
        tv_Literacy = findViewById(R.id.tv_Literacy);
        tv_Age = findViewById(R.id.tv_Age);
        cbSport = findViewById(R.id.cbSport);
        tv_Music = findViewById(R.id.tv_Music);

        Intent intent = getIntent();
        User us = (User) intent.getSerializableExtra("us");

        String strGender = "Nam";
        if (us.getGender()){
            strGender = "Nữ";
        }

        tv_Name.setText(us.getName());
        tv_Phone.setText(us.getNumber());
        tv_Gender.setText(strGender);
        tv_Literacy.setText(literacy_arr[us.getLiteracy()]);
        tv_Age.setText(us.getAge() + "");
        cbSport.setChecked(us.getSport());
        tv_Music.setText(us.getMusic());
    }
}