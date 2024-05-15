package com.example.mgp1_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
//Reference for the splash screen
//https://www.youtube.com/watch?v=WyAzD7RMwHM&t=65s&ab_channel=EasyTuto

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splash.this, Login.class));
                finish();
            }
        }, 2000);
    }
}

