package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }

    public void Back(View view) {
        Intent intent = new Intent(OrderActivity.this,Produk1Activity.class);
        startActivity(intent);
    }

    // method "Back" dibuat secara otomatis dari file xml, methode ini berfungsi untuk memberikan sebuah code supaya elemen yang berada di file xml bisa berjalan
    // Intent berfungsi menghubungkan sebuah halaman, sehingga halaman pertama dapat berpindah ke halaman kedua
    // OrderActivity merupakan kelas sebuah kelas java yang sekarang berada
    // this menunjukkan kelas tersebut
    // kelas Produk1Activity adalah kelas dimana berpindah dari kelas sebelumnya
    // startActivity berguna untuk memulai sebuah activity lain
}