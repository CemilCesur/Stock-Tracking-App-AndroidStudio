package com.example.mcstok;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StokActivity extends AppCompatActivity { // Stokların tutulduğu activity

    private RecyclerView mRecyclerView;
    private ProductAdapter mAdapter;
    private List<Product> mProductList;
    private ArrayList<String> txtList;
    Context context;
    ProductAdapter pa;
    double stokToplam = 0;
    String tut;
    TextView textViewTutar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the recyclerview from xml
        mRecyclerView = (RecyclerView) findViewById(R.id.idRecyclerView);
        //mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Ürün tanımlamaları yapılır ve ArrayList'e atılır
        mProductList = new ArrayList<>();
        mProductList.add(new Product("Köfte",R.drawable.ic_kofte,"56.72 TL", "kilo", getString(R.string.baslangic_qty)));
        mProductList.add(new Product("Ekmek",R.drawable.ic_ekmek,"60.02 TL", "kasa", getString(R.string.baslangic_qty)));
        mProductList.add(new Product("Marul",R.drawable.ic_marul,"15.27 TL", "kilo", getString(R.string.baslangic_qty)));
        mProductList.add(new Product("Domates",R.drawable.ic_domates,"6.15 TL", "kilo", getString(R.string.baslangic_qty)));
        mProductList.add(new Product("Sos", R.drawable.ic_sos,"20.12 TL", "paket", getString(R.string.baslangic_qty)));
        mProductList.add(new Product("Kola",R.drawable.ic_kola,"2.35 TL", "litre", getString(R.string.baslangic_qty)));
        mProductList.add(new Product("Ayran",R.drawable.ic_ayran,"3.69 TL", "litre", getString(R.string.baslangic_qty)));
        mProductList.add(new Product("Pipet", R.drawable.ic_pipet,"2.00 TL", "paket", getString(R.string.baslangic_qty)));
        mProductList.add(new Product("Bardak", R.drawable.ic_bardak,"10.70 TL", "paket", getString(R.string.baslangic_qty)));
        mProductList.add(new Product("Patates",R.drawable.ic_patates,"4.95 TL", "kilo", getString(R.string.baslangic_qty)));
        mProductList.add(new Product("Kahve", R.drawable.ic_kahve,"55.84 TL", "kilo", getString(R.string.baslangic_qty)));
        mProductList.add(new Product("Çay",R.drawable.ic_cay,"36.95 TL", "kilo", getString(R.string.baslangic_qty)));
        mProductList.add(new Product("Milkshake",R.drawable.ic_milkshake,"102.43 TL", "kilo", getString(R.string.baslangic_qty)));
        mProductList.add(new Product("Dondurma", R.drawable.ic_dondurma,"97.28 TL", "kilo", getString(R.string.baslangic_qty)));
        mProductList.add(new Product("Yağ", R.drawable.ic_yag,"59.99 TL", "litre", getString(R.string.baslangic_qty)));

        loadContent(); // Önceki değerler ile güncelleme işlemini yapan metod çağrılır

        //set adapter to recyclerview
        mAdapter = new ProductAdapter(mProductList,this);
        mRecyclerView.setAdapter(mAdapter);

        Button sepetButton = findViewById(R.id.buttonEkle);
        Button sifirlaButton =findViewById(R.id.sifirlaButton);

        textViewTutar=findViewById(R.id.sepetCikti);

        //Sepete ekleme butonu gerçekleştirimi
        sepetButton.setOnClickListener(v -> {
            stokToplam = 0;
            for (int say=0;say<mProductList.size();say++){
                String tutmac=mProductList.get(say).getProductPrice();
                String[] tutmacSplit=tutmac.split(" ");
                double miktar2 = Double.parseDouble(tutmacSplit[0]);
                stokToplam+=miktar2*Double.parseDouble(String.valueOf(mProductList.get(say).getProductQty()));
            }
            tut = String.format("Stok Tutarı: %.2f TL", stokToplam);
            textViewTutar.setText(tut);
        });
        //Sıfırlama butonu gerçekleştirimi
        sifirlaButton.setOnClickListener(v -> {
            for (int say=0;say<mProductList.size();say++) {
                mProductList.get(say).setProductQty("0");
            }
            ProductAdapter mAdapter1 = new ProductAdapter(mProductList,this);
            mRecyclerView.setAdapter(mAdapter1);
            textViewTutar.setText("Stok Tutarı: 0.00 TL");
            stokToplam=0;
        });
    }

    public void loadContent() { // Aşağıda txt dosyasına yazılan değerler dosyadan okunarak
        // onCreate() metodunun içinde bu metot çağrılır ve destroy öncesi değerler kurtarılmış olur
        View view;
        File path = getApplicationContext().getFilesDir();
        File readFrom = new File(path,getString(R.string.dosya_adi));
        byte[] content = new byte[(int) readFrom.length()];
        try {
            FileInputStream stream = new FileInputStream(readFrom);
            stream.read(content);
            String s = new String(content);
            s = s.substring(1,s.length()-1);
            String split[] = s.split(", ");
            mProductList.get(0).setProductQty(split[0]);
            mProductList.get(1).setProductQty(split[1]);
            mProductList.get(2).setProductQty(split[2]);
            mProductList.get(3).setProductQty(split[3]);
            mProductList.get(4).setProductQty(split[4]);
            mProductList.get(5).setProductQty(split[5]);
            mProductList.get(6).setProductQty(split[6]);
            mProductList.get(7).setProductQty(split[7]);
            mProductList.get(8).setProductQty(split[8]);
            mProductList.get(9).setProductQty(split[9]);
            mProductList.get(10).setProductQty(split[10]);
            mProductList.get(11).setProductQty(split[11]);
            mProductList.get(12).setProductQty(split[12]);
            mProductList.get(13).setProductQty(split[13]);
            mProductList.get(14).setProductQty(split[14]);
            stokToplam = Double.parseDouble(split[15]);

            view=findViewById(R.id.sepetCikti); // view nesnesi tanımlanır
            TextView textView = view.findViewById(R.id.sepetCikti); // Sepet tutarını yazdıran view alınır
            textView.setText(String.format("Stok Toplam: %.2f TL", stokToplam)); // Sepet tutarı text'i güncellenir

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() { //Product sayılarını kaydetmek için metot

        File file = getApplicationContext().getFilesDir(); // değerler bir txt dosyasına yazılır

        txtList = new ArrayList<>();
        txtList.add(mProductList.get(0).getProductQty());
        txtList.add(mProductList.get(1).getProductQty());
        txtList.add(mProductList.get(2).getProductQty());
        txtList.add(mProductList.get(3).getProductQty());
        txtList.add(mProductList.get(4).getProductQty());
        txtList.add(mProductList.get(5).getProductQty());
        txtList.add(mProductList.get(6).getProductQty());
        txtList.add(mProductList.get(7).getProductQty());
        txtList.add(mProductList.get(8).getProductQty());
        txtList.add(mProductList.get(9).getProductQty());
        txtList.add(mProductList.get(10).getProductQty());
        txtList.add(mProductList.get(11).getProductQty());
        txtList.add(mProductList.get(12).getProductQty());
        txtList.add(mProductList.get(13).getProductQty());
        txtList.add(mProductList.get(14).getProductQty());
        txtList.add(String.valueOf(stokToplam));
        try {
            FileOutputStream writer = new FileOutputStream(new File(file,getString(R.string.dosya_adi)));
            writer.write(txtList.toString().getBytes());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

}