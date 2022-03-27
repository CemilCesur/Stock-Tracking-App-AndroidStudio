package com.example.mcstok;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DialogFragment extends androidx.fragment.app.DialogFragment {

    TextView IsimText;
    TextView NumaraText;
    FrameLayout tedcallbtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
            View v =inflater.inflate(R.layout.tedarikci_card,container,false);
            Bundle bundle = getArguments(); // TedarikciActivity'de gönderdiğimiz bundle'ı alan kısım
            final String isim = bundle.getString("İsim"); // TedarikciActivity'den gelen stringleri key'ine göre alıyoruz
            final String num = bundle.getString("Numara");
            IsimText = (TextView) v.findViewById(R.id.txtIsimi);
            NumaraText = (TextView) v.findViewById(R.id.textView2);
            tedcallbtn = (FrameLayout) v.findViewById(R.id.tedcallbtn);
            IsimText.setText(isim); // Yukarıda tanımladığımız isim ve numaraları textview'lara yazdırıyoruz
            NumaraText.setText(num);
            aramaMetodu(num);
            return v;
    }
    private void aramaMetodu(String a){

        tedcallbtn.setOnClickListener(new View.OnClickListener() { // Destek Hattı'nı arama işlemi
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + a));
                startActivity(intent);;
            }

        });
    }

}
