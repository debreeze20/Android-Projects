package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BeautyCareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty_care);
    }

    public void Search(View view) {
    }

    public void Category(View view) {
    }

    public void Sort(View view) {
    }

    public void Filter(View view) {
    }

    public void Basket(View view) {
    }

    public void Produk1(View view) {
        Intent intent = new Intent(BeautyCareActivity.this,Produk1Activity.class);
        startActivity(intent);
    }

    // method "Home Aksi" dibuat secara otomatis dari file xml, methode ini berfungsi untuk memberikan sebuah code supaya elemen yang berada di file xml bisa berjalan
    // Intent berfungsi menghubungkan sebuah halaman, sehingga halaman pertama dapat berpindah ke halaman kedua
    // MainActivity merupakan kelas sebuah kelas java yang sekarang berada
    // this menunjukkan kelas tersebut
    // kelas HomeActivity adalah kelas dimana berpindah dari kelas sebelumnya
    // startActivity berguna untuk memulai sebuah activity lain

    public void Produk2(View view) {
    }

    public void Produk3(View view) {
    }

    public void Produk4(View view) {
    }
}