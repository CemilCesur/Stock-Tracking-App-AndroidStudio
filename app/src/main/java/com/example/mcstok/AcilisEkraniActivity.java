package com.example.mcstok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class AcilisEkraniActivity extends AppCompatActivity {

    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acilis_ekrani);

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(AcilisEkraniActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        }, 2000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(AcilisEkraniActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        }, 2000);

    }
}