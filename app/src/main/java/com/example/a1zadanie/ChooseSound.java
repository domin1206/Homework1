package com.example.a1zadanie;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class ChooseSound extends AppCompatActivity {

    Spinner spinner;
    int soundID = 0;
    ArrayAdapter<String> arrayAdapter;
    List<String> list;
    String[] items = {""};
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_sound);

        cancel = findViewById(R.id.button3);
        spinner = findViewById(R.id.spinner);
        list = new ArrayList<>();
        items = getResources().getStringArray(R.array.sounds);
        arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, items);

        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        soundID = R.raw.sound1;
                        break;
                    case 1:
                        soundID = R.raw.sound1;
                        break;
                    case 2:
                        soundID = R.raw.sound1;
                        break;
                    case 3:
                        soundID = R.raw.sound1;
                        break;
                    case 4:
                        soundID = R.raw.sound1;
                        break;
                    case 5:
                        soundID = R.raw.sound1;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void ok(View view) {
        Intent intent = new Intent();
        intent.putExtra("sound", soundID);
        setResult(RESULT_OK,intent);
        finish();
    }
}