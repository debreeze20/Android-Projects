package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void HomeAksi(View view) {
        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    // method "Home Aksi" dibuat secara otomatis dari file xml, methode ini berfungsi untuk memberikan sebuah code supaya elemen yang berada di file xml bisa berjalan
    // Intent berfungsi menghubungkan sebuah halaman, sehingga halaman pertama dapat berpindah ke halaman kedua
    // MainActivity merupakan kelas sebuah kelas java yang sekarang berada
    // this menunjukkan kelas tersebut
    // kelas HomeActivity adalah kelas dimana berpindah dari kelas sebelumnya
    // startActivity berguna untuk memulai sebuah activity lain

    public void BeautyCareAksi(View view) {
        Intent intent = new Intent(MainActivity.this,BeautyCareActivity.class);
        startActivity(intent);
    }
}