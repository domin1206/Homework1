package com.example.a1zadanie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    ImageView iv;
    int drawable, rand = 0, sound = 0;
    String name = "", temp = "";
    MediaPlayer mp;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.iv);
        tv = findViewById(R.id.textView);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mp==null){
                    mp= MediaPlayer.create(getApplicationContext(),sound);
                    mp.start();
                }
                else
                {
                    mp.stop();
                    mp=null;
                }
            }
        });
    }

    public void randNum(){
        Random r = new Random();
        rand = r.nextInt(5);
        choosePicture(rand);
    }

    public void choosePicture(int i){//ustawienie avataru
        switch (i){
            case 0 :
                drawable = R.drawable.image1;
                break;
            case 1:
                drawable = R.drawable.image2;
                break;
            case 2:
                drawable = R.drawable.image3;
                break;
            case 3:
                drawable = R.drawable.image4;
                break;
            case 4:
                drawable = R.drawable.image5;
                break;
        }
        iv.setImageResource(drawable);
    }

    public void changeContact(View view) {
        Intent intent = new Intent(getApplicationContext(), ChangeContact.class);
        startActivityForResult(intent,1);
    }

    public void changeSound(View view) {
        if(!tv.getText().equals("")) {
            Intent intent = new Intent(getApplicationContext(), ChooseSound.class);
            startActivityForResult(intent, 2);
        }else
            Toast.makeText(this, "Select contact", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1) {//sprawdzamy czy wrocilismy od kontaktow
            if (resultCode == RESULT_OK) {//sprawdza czy zostalo wybrany jakis kontakt
                temp = name;
                name = data.getStringExtra("nameSet");

                if(!temp.equals(name)){//sprawdza czy wybralismy ten sam kontakt
                    tv.setText(name);
                    randNum();
                }

            }
        }

        if(requestCode == 2){//wrocilismy od sound
            if(resultCode == RESULT_OK){
                sound = data.getIntExtra("sound", 0);
            }
        }
    }

}