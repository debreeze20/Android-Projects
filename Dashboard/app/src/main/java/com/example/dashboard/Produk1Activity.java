package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Produk1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk1);
    }

    public void Back(View view) {
        Intent intent = new Intent(Produk1Activity.this,BeautyCareActivity.class);
        startActivity(intent);
    }

    // method "Home Aksi" dibuat secara otomatis dari file xml, methode ini berfungsi untuk memberikan sebuah code supaya elemen yang berada di file xml bisa berjalan
    // Intent berfungsi menghubungkan sebuah halaman, sehingga halaman pertama dapat berpindah ke halaman kedua
    // Produk1 merupakan kelas sebuah kelas java yang sekarang berada
    // this menunjukkan kelas tersebut
    // kelas BeautyCareActivity adalah kelas dimana berpindah dari kelas sebelumnya
    // startActivity berguna untuk memulai sebuah activity lain

    public void AddtoCart(View view) {
    }

    public void BuyNow(View view) {
        Intent intent = new Intent(Produk1Activity.this,OrderActivity.class);
        startActivity(intent);
    }
}