package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {
    Button btn_Register, btn_Cancel;
    EditText editText_Name, editText_Phone;
    Switch switch_Gender;
    Spinner spinner_Level;
    SeekBar seekbar_Age;
    TextView tv_Age;
    CheckBox checkbox_Sport;
    RadioGroup radioBtnGr;
    RadioButton radioBtn_Rock, radioBtn_Rap, radioBtn_Pop;
    int progressChangedValue = 0;
    int selectedRadioBtnId = 0;
    String[] literacy_arr = {"THPT", "CD", "DH"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Register = findViewById(R.id.btn_Register);
        btn_Cancel = findViewById(R.id.btn_Cancel);
        editText_Name = findViewById(R.id.editText_Name);
        editText_Phone = findViewById(R.id.editText_Phone);
        switch_Gender = findViewById(R.id.switch_Gender);
        spinner_Level = findViewById(R.id.spinner_Level);
        seekbar_Age = findViewById(R.id.seekbar_Age);
        tv_Age = findViewById(R.id.tv_Age);
        checkbox_Sport = findViewById(R.id.checkbox_Sport);
        radioBtnGr = findViewById(R.id.radioBtnGr);
        radioBtn_Rock = findViewById(R.id.radioBtn_Rock);
        radioBtn_Rap = findViewById(R.id.radioBtn_Rap);
        radioBtn_Pop = findViewById(R.id.radioBtn_Pop);

        seekbar_Age.setOnSeekBarChangeListener(this);
        btn_Register.setOnClickListener(this);
        btn_Cancel.setOnClickListener(this);

        //Setting spinner
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, literacy_arr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_Level.setAdapter(adapter);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        progressChangedValue = i;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        tv_Age.setText(progressChangedValue + "");
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;

        switch (btn.getId()) {
            case R.id.btn_Register:
                selectedRadioBtnId = radioBtnGr.getCheckedRadioButtonId();
                RadioButton rbtn = findViewById(selectedRadioBtnId);
                User us = new User(editText_Name.getText().toString(), editText_Phone.getText().toString(), switch_Gender.isChecked(), (byte) spinner_Level.getSelectedItemPosition(), progressChangedValue, checkbox_Sport.isChecked(), rbtn.getText().toString());

                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                i.putExtra("us", (Serializable) us);
                startActivity(i);
                break;
            case R.id.btn_Cancel:
                editText_Name.setText("");
                editText_Phone.setText("");
                switch_Gender.setChecked(false);
                seekbar_Age.setProgress(0);
                tv_Age.setText("0");
                checkbox_Sport.setChecked(false);

                break;
            default:
                break;
        }
    }
}