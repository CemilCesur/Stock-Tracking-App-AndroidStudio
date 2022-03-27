package com.example.mcstok;

import android.annotation.SuppressLint;
import android.content.Context;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    private List<Product> productItemList;
    Context context;

    public ProductAdapter(List<Product> productItemList, Context context) {
        this.productItemList = productItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout file
        View ProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_product_card, parent, false);
        ProductViewHolder gvh = new ProductViewHolder(ProductView);
        return gvh;
    }
    private int countup = 0;
    private int countdown = 0;

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder,final int position) {
        holder.imageProductImage.setImageResource(productItemList.get(position).getProductImage());
        holder.txtProductName.setText(productItemList.get(position).getProductName());
        holder.txtProductPrice.setText(productItemList.get(position).getProductPrice());
        holder.txtProductWeight.setText(productItemList.get(position).getProductWeight());
        holder.txtProductQty.setText(productItemList.get(position).getProductQty());

        holder.imageProductImage.setOnClickListener(v -> {// Üürn resmine tıkladığımızda ürün adedi ve tutarını yazdırır
            String productName = productItemList.get(position).getProductName();
            String tut = String.valueOf(productItemList.get(position).getProductPrice());
            String[] tutSplit = tut.split(" ");
            double miktar = Double.parseDouble(tutSplit[0]);
            double sayi = Double.parseDouble(String.valueOf(holder.txtProductQty.getText()));
            Toast.makeText(context, "Ürün: " + productName +  String.format("\nTutar:  %.2f TL", miktar*sayi) ,Toast.LENGTH_SHORT).show();

        });

        holder.imageButtonUp.setOnClickListener(view -> {// Up butonuna tıklandığında
            countup = Integer.parseInt(productItemList.get(position).getProductQty());// Ürünün sayısı alınır
            countup++; // sayı artırılır

            productItemList.get(position).setProductQty(String.valueOf(countup)) ; // Ürünün sayısı güncellenir
            holder.txtProductQty.setText(String.valueOf(countup)); // TextView'da gösterilir
        });

        holder.imageButtonDown.setOnClickListener(view -> {
            countdown = Integer.parseInt(productItemList.get(position).getProductQty());
            countdown--; // sayı azaltılır

            if(countdown < 0) {
                countdown = 0;
                Toast.makeText(context, "Miktar değeri sıfırdan küçük olamaz! ",Toast.LENGTH_SHORT).show();
            }
            productItemList.get(position).setProductQty(String.valueOf(countdown)) ;
            holder.txtProductQty.setText(String.valueOf(countdown));
        });

        holder.txtProductQty.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            //Product sayısının üstüne tıklandığında düzenlenmesini sağlayan metod
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                // set result in second edit text

                if (holder.txtProductQty.getText().toString().matches("")) {//Eğer null değer verilirse view'a 0 yazdırır
                    productItemList.get(position).setProductQty("0");
                    Toast.makeText(context, "Miktar değeri null olamaz! ",Toast.LENGTH_SHORT).show();
                    holder.txtProductQty.setText("0");
                }
                else if (0 <= Integer.parseInt(String.valueOf(holder.txtProductQty.getText()))) {
                    productItemList.get(position).setProductQty(String.valueOf(holder.txtProductQty.getText()));//view değeri güncellenir
                }
                else {//Eğer eksi değer verilirse view'a 0 yazdırır
                    productItemList.get(position).setProductQty("0");
                    holder.txtProductQty.setText("0");
                    Toast.makeText(context, "Miktar değeri sıfırdan küçük olamaz! ",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return productItemList.size();
    }
    public class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imageProductImage;
        TextView txtProductName;
        TextView txtProductPrice;
        TextView txtProductWeight;
        EditText txtProductQty;
        ImageButton imageButtonUp;
        ImageButton imageButtonDown;
        Button sepetButton;

        public ProductViewHolder(View view) {
            super(view);
            imageProductImage=view.findViewById(R.id.idProductImage);
            txtProductName=view.findViewById(R.id.idProductName);
            txtProductPrice = view.findViewById(R.id.idProductPrice);
            txtProductWeight = view.findViewById(R.id.idProductWeight);
            txtProductQty = view.findViewById(R.id.idProductQty);
            imageButtonUp = view.findViewById(R.id.imageButtonUp);
            imageButtonDown = view.findViewById(R.id.imageButtonDown);
            sepetButton=view.findViewById(R.id.buttonEkle);

        }
    }

    public double sepet(){
        double sepetToplam = 0;
        for (int say=0;say<productItemList.size();say++){
            String tutmac=productItemList.get(say).getProductPrice();
            String[] tutmacSplit=tutmac.split(" ");
            double miktar2=Double.parseDouble(tutmacSplit[0]);
            sepetToplam+=miktar2*Double.parseDouble(String.valueOf(productItemList.get(say).getProductQty()));

        }
        return sepetToplam;
    }


}
