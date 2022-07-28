package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText angka1, angka2;
    TextView hasil;

    // edittext dan textview merupakan jenis palette yang diambil dari id di xml, sama seperti variabel di java
    // angka1, angka2, hasil merupakan nama id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        angka1 = (EditText) findViewById(R.id.angka1);
        angka2 = (EditText) findViewById(R.id.angka2);
        hasil = (TextView) findViewById(R.id.hasil);
    }
    // angka1, angka2 dan hasil merupakan variabel untuk mencari id yang berasal dari xml


    public void tambah(View view) {
        int a1 = Integer.parseInt(angka1.getText().toString());
        int a2 = Integer.parseInt(angka2.getText().toString());
        Integer hsl = a1+a2;
        hasil.setText(hsl.toString());
    }
    // int a1 dan a2 merupakan tipe data berbentuk angka, supaya data yang dimasukkan nanti berupa angka
    // fungsi parseInt digunakan untuk mengembalikkan tipe data angka berbentuk integer
    // getText untuk mendapatkan field teks
    // toString guna mengembalikkan object yang berupa tipe data tersebut
    // Integer hsl adalah variabel yang digunakan untuk pengoperasian
    // setText guna menampilkan text dari hasil variabel a1 dan a2
    // untuk methode kurang, kali, bagi memiliki fungsi yang sama dengan di atas

    public void kurang(View view) {
        int a1 = Integer.parseInt(angka1.getText().toString());
        int a2 = Integer.parseInt(angka2.getText().toString());
        Integer hsl = a1-a2;
        hasil.setText(hsl.toString());
    }

    public void kali(View view) {
        int a1 = Integer.parseInt(angka1.getText().toString());
        int a2 = Integer.parseInt(angka2.getText().toString());
        Integer hsl = a1*a2;
        hasil.setText(hsl.toString());
    }

    public void bagi(View view) {
        int a1 = Integer.parseInt(angka1.getText().toString());
        int a2 = Integer.parseInt(angka2.getText().toString());
        Integer hsl = a1/a2;
        hasil.setText(hsl.toString());
    }
}