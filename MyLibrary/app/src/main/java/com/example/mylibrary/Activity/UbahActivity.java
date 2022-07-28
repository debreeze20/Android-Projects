package com.example.mylibrary.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mylibrary.R;

public class UbahActivity extends AppCompatActivity {

    private int xId;
    private String xJudul, xPengarang, xPenerbit;
    private int xTahun;
    private EditText etJudul, etPengarang, etPenerbit, etTahun;
    private Button btnUbah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah);

        Intent terima = getIntent();
        xId = terima.getIntExtra("xId",-1);
        xJudul = terima.getStringExtra("xJudul");
        xPengarang = terima.getStringExtra("xPengarang");
        xPenerbit = terima.getStringExtra("xPenerbit");
        xTahun = terima.getIntExtra("xTahun",-1);

        etJudul = findViewById(R.id.et_Judul);
        etPengarang = findViewById(R.id.et_Pengarang);
        etPenerbit = findViewById(R.id.et_Penerbit);
        etTahun = findViewById(R.id.et_Tahun);
        btnUbah = findViewById(R.id.btn_Ubah);

        etJudul.setText(xJudul);
        etPengarang.setText(xPengarang);
        etPenerbit.setText(xPenerbit);
        etTahun.setText(xTahun);
        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}