package com.example.mcstok;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class TedarikciActivity extends AppCompatActivity {
    DialogFragment mDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tedarikci);

        Button ted1but = findViewById(R.id.ted1);
        Button ted2but = findViewById(R.id.ted2);
        Button ted3but = findViewById(R.id.ted3);
        Button ted4but = findViewById(R.id.ted4);
        Button ted5but = findViewById(R.id.ted5);
        Button ted6but = findViewById(R.id.ted6);
        Button ted7but = findViewById(R.id.ted7);
        Button ted8but = findViewById(R.id.ted8);
        Button ted9but = findViewById(R.id.ted9);
        Button ted10but = findViewById(R.id.ted10);
        Button ted11but = findViewById(R.id.ted11);
        Button ted12but = findViewById(R.id.ted12);
        Button ted13but = findViewById(R.id.ted13);
        Button ted14but = findViewById(R.id.ted14);
        Button ted15but = findViewById(R.id.ted15);

        ted1but.setOnClickListener(view -> {
            mDialogFragment = new DialogFragment();
            Bundle bundle = new Bundle(); // Dialog Fragment'e isim ve numara bilgisini atmak için bundle yaratıyoruz
            bundle.putString("İsim","Pınar Et");
            bundle.putString("Numara","0232 447 5619");
            mDialogFragment.setArguments(bundle); // Dialog Fragment'in argument'i olarak bundle'ı veriyoruz

            mDialogFragment.show(getSupportFragmentManager(),getString(R.string.fragment_mesaji));// fragmet gösterme metodu
        });

        ted2but.setOnClickListener(view -> {
            mDialogFragment = new DialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("İsim","Unkar Gıda");
            bundle.putString("Numara","0232 123 4567");
            mDialogFragment.setArguments(bundle);
            mDialogFragment.show(getSupportFragmentManager(),getString(R.string.fragment_mesaji));
        });

        ted3but.setOnClickListener(view -> {
            mDialogFragment = new DialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("İsim","OKYANUS GLOBAL GIDA");
            bundle.putString("Numara","0224 441 8965");
            mDialogFragment.setArguments(bundle);
            mDialogFragment.show(getSupportFragmentManager(),getString(R.string.fragment_mesaji));
        });
        ted4but.setOnClickListener(view -> {
            mDialogFragment = new DialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("İsim","OKYANUS GLOBAL GIDA");
            bundle.putString("Numara","0224 441 8965");
            mDialogFragment.setArguments(bundle);
            mDialogFragment.show(getSupportFragmentManager(),getString(R.string.fragment_mesaji));
        });

        ted5but.setOnClickListener(view -> {
            mDialogFragment = new DialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("İsim","Calve");
            bundle.putString("Numara","0232 4123 4567");
            mDialogFragment.setArguments(bundle);
            mDialogFragment.show(getSupportFragmentManager(),getString(R.string.fragment_mesaji));
        });

        ted6but.setOnClickListener(view -> {
            mDialogFragment = new DialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("İsim","Coca Cola");
            bundle.putString("Numara","0232 123 4567");
            mDialogFragment.setArguments(bundle);
            mDialogFragment.show(getSupportFragmentManager(),getString(R.string.fragment_mesaji));
        });
        ted7but.setOnClickListener(view -> {
            mDialogFragment = new DialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("İsim","Sütaş");
            bundle.putString("Numara","0232 123 4567");
            mDialogFragment.setArguments(bundle);
            mDialogFragment.show(getSupportFragmentManager(),getString(R.string.fragment_mesaji));;
        });

        ted8but.setOnClickListener(view -> {
            mDialogFragment = new DialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("İsim","Sem Plastik");
            bundle.putString("Numara","0232 652 9878");
            mDialogFragment.setArguments(bundle);
            mDialogFragment.show(getSupportFragmentManager(),getString(R.string.fragment_mesaji));
        });

        ted9but.setOnClickListener(view -> {
            mDialogFragment = new DialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("İsim","Sem Plastik");
            bundle.putString("Numara","0232 652 9878");
            mDialogFragment.setArguments(bundle);
            mDialogFragment.show(getSupportFragmentManager(),getString(R.string.fragment_mesaji));
        });
        ted10but.setOnClickListener(view -> {
            mDialogFragment = new DialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("İsim","DOGA TOHUMCULUK");
            bundle.putString("Numara","0232 123 4567");
            mDialogFragment.setArguments(bundle);
            mDialogFragment.show(getSupportFragmentManager(),getString(R.string.fragment_mesaji));
        });

        ted11but.setOnClickListener(view -> {
            mDialogFragment = new DialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("İsim","McCafe");
            bundle.putString("Numara","0232 666 8700");
            mDialogFragment.setArguments(bundle);
            mDialogFragment.show(getSupportFragmentManager(),getString(R.string.fragment_mesaji));
        });

        ted12but.setOnClickListener(view -> {
            mDialogFragment = new DialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("İsim","Lipton");
            bundle.putString("Numara","0232 123 4567");
            mDialogFragment.setArguments(bundle);
            mDialogFragment.show(getSupportFragmentManager(),getString(R.string.fragment_mesaji));
        });
        ted13but.setOnClickListener(view -> {
            mDialogFragment = new DialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("İsim","Monero");
            bundle.putString("Numara","0232 447 5619");
            mDialogFragment.setArguments(bundle);
            mDialogFragment.show(getSupportFragmentManager(),getString(R.string.fragment_mesaji));
        });

        ted14but.setOnClickListener(view -> {
            mDialogFragment = new DialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("İsim","Algida");
            bundle.putString("Numara","0232 447 5619");
            mDialogFragment.setArguments(bundle);
            mDialogFragment.show(getSupportFragmentManager(),getString(R.string.fragment_mesaji));
        });

        ted15but.setOnClickListener(view -> {
            mDialogFragment = new DialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("İsim","Kudret Zeytin Yagları");
            bundle.putString("Numara","0266 432 1080");
            mDialogFragment.setArguments(bundle);
            mDialogFragment.show(getSupportFragmentManager(),getString(R.string.fragment_mesaji));
        });
    }
}