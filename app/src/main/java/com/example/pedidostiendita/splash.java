package com.example.pedidostiendita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Timer;
import java.util.TimerTask;

public class splash extends AppCompatActivity {

    private ImageView spla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        spla = (ImageView) findViewById(R.id.IVs);

        Glide.with(getApplicationContext()).load(R.drawable.splash).into(spla);

        TimerTask splash = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        };
        Timer segundos = new Timer();
        segundos.schedule(splash,4000);



    }
}