package com.example.mcstok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnmenu1 = findViewById(R.id.urun_listesi_but);
        Button btnmenu2 = findViewById(R.id.activity2_but);
        ImageButton callbtn = findViewById(R.id.callbtn);

        btnmenu1.setOnClickListener(new View.OnClickListener() { // ürün listesinin verildiği StokActivity'e gidilir
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, StokActivity.class);
                startActivity(intent);
            }
        });

        btnmenu2.setOnClickListener(new View.OnClickListener() { // Stoktaki her ürünün tedarikçilerinin listelendiği TedarikciActivity'e gidilir
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MenuActivity.this, TedarikciActivity.class); // act 2 yaz
                startActivity(intent);
            }
        });

        callbtn.setOnClickListener(new View.OnClickListener() { // Destek Hattı'nı arama işlemi
            @Override
            public void onClick(View view) {
                String phone = getString(R.string.tel_string);
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(phone));
                startActivity(intent);
            }
        });
    }
}