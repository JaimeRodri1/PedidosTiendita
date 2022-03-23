package com.example.pedidostiendita;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class splash extends AppCompatActivity {

    private ImageView spla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        spla = (ImageView) findViewById(R.id.IVs);

    }
}