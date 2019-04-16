package com.example.a1zadanie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ChangeContact extends AppCompatActivity {
    String[] tabString;
    RadioButton rb1, rb2, rb3, rb4, rb5;
    Button cancel;
    boolean checked = false;
    String nameSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_contact);

        tabString = getResources().getStringArray(R.array.contacts);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);

        rb1.setText(tabString[0]);
        rb2.setText(tabString[1]);
        rb3.setText(tabString[2]);
        rb4.setText(tabString[3]);
        rb5.setText(tabString[4]);

        cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void confirm(View view) {
        if(checked) {
            Intent intent = new Intent();
            intent.putExtra("nameSet", nameSet);
            setResult(RESULT_OK, intent);
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(), "No contact selected", Toast.LENGTH_LONG).show();
        }
    }

    public void chooseName(View view) {
        checked = ((RadioButton) view).isChecked();

        if(checked) {
            switch (view.getId()) {
                case R.id.rb1:
                    nameSet = tabString[0];
                    break;
                case R.id.rb2:
                    nameSet = tabString[1];
                    break;
                case R.id.rb3:
                    nameSet = tabString[2];
                    break;
                case R.id.rb4:
                    nameSet = tabString[3];
                    break;
                case R.id.rb5:
                    nameSet = tabString[4];
                    break;
            }
        }
    }
}