package com.example.mylibrary.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mylibrary.API.APIRequestData;
import com.example.mylibrary.API.RetroServer;
import com.example.mylibrary.Model.ResponseModel;
import com.example.mylibrary.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahData extends AppCompatActivity {

    private EditText etJudul, etPengarang, etPenerbit, etTahun;
    private Button btnSimpan;
    private String judul,pengarang,penerbit;
    private int tahun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        etJudul = findViewById(R.id.et_Judul);
        etPengarang = findViewById(R.id.et_Pengarang);
        etPenerbit = findViewById(R.id.et_Penerbit);
        etTahun = findViewById(R.id.et_Tahun);
        btnSimpan = findViewById(R.id.btn_Simpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                judul = etJudul.getText().toString();
                pengarang = etPengarang.getText().toString();
                penerbit = etPenerbit.getText().toString();
                tahun = Integer.parseInt(etTahun.getText().toString());

                if (judul.trim().equals("")) {
                    etJudul.setError("Judul Harus Diisi");
                } else if (pengarang.trim().equals("")) {
                    etPengarang.setError("Pengarang Harus Diisi");
                } else if (penerbit.trim().equals("")) {
                    etPenerbit.setError("Penerbit Harus Diisi");
//                } else if (tahun.trim().equals("")) {
//                    etTahun.setError("Tahun Harus Diisi");
                } else {
                    createData();
                }
            }

            public void createData() {
                APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
                Call<ResponseModel> simpanData = ardData.ardCreateData(judul,pengarang,penerbit,tahun);
                simpanData.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        int kode = response.body().getKode();
                        String pesan = response.body().getPesan();

                        Toast.makeText(TambahData.this, "Kode : "+kode+"| Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        Toast.makeText(TambahData.this, "Gagal Menghubunkan Server | "+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });

    }
}