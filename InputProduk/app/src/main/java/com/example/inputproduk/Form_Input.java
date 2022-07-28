package com.example.inputproduk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Form_Input extends AppCompatActivity {

    Spinner Kategori, Kondisi;

    public String menu_Kategori [] = {"Blazer", "Dress", "Skirt", "Trouser"};
    public String menu_Kondisi [] = {"Baru", "Pernah Dipakai"};

    EditText xidproduk;
    EditText xjudul;
    EditText xdeskripsi;
    Spinner xkategori;
    EditText xharga;
    EditText xstok;
    Spinner xkondisi;
    Button tblTambah;
    Button tblTampil;
    Button tblHapus;
    Button tblEdit;
    DatabaseHelper BantuDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_input);

        Kategori = (Spinner) findViewById(R.id.kategori);
        Kondisi = (Spinner) findViewById(R.id.kondisi);

        ArrayAdapter adapter_kategori = new ArrayAdapter(Form_Input.this,R.layout.support_simple_spinner_dropdown_item,menu_Kategori);
        ArrayAdapter adapter_kondisi = new ArrayAdapter(Form_Input.this,R.layout.support_simple_spinner_dropdown_item,menu_Kondisi);

        Kategori.setAdapter(adapter_kategori);
        Kondisi.setAdapter(adapter_kondisi);

        BantuDb = new DatabaseHelper(this);
        xidproduk = (EditText) findViewById(R.id.idproduk);
        xjudul = (EditText) findViewById(R.id.judul);
        xdeskripsi = (EditText) findViewById(R.id.deskripsi);
        xharga = (EditText) findViewById(R.id.harga);
        xstok = (EditText) findViewById(R.id.stok);

        tblTambah = (Button) findViewById(R.id.tblTambah);
        tblTampil = (Button) findViewById(R.id.tblTampil);
        tblHapus = (Button) findViewById(R.id.tblHapus);
        tblEdit = (Button) findViewById(R.id.tblEdit);
        viewAll();

        tblTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean IsInserted = BantuDb.insertData(xidproduk.getText().toString(),xjudul.getText().toString(),xdeskripsi.getText().toString(),
                        Kategori.getSelectedItem().toString(),Integer.parseInt(xharga.getText().toString()),Integer.parseInt(xstok.getText().toString()),
                        Kondisi.getSelectedItem().toString());

                if (IsInserted == true) {
                    Toast.makeText(Form_Input.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Form_Input.this, "Gagal Tersimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tblEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BantuDb.updateData(xidproduk.getText().toString(),xjudul.getText().toString(),xdeskripsi.getText().toString(),
                        Kategori.getSelectedItem().toString(),Integer.parseInt(xharga.getText().toString()),Integer.parseInt(xstok.getText().toString()),
                        Kondisi.getSelectedItem().toString());

                Toast.makeText(Form_Input.this, "Data Terupdate", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Form_Input.this,MainActivity.class);
                startActivity(i);
            }
        });

        tblHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BantuDb.deleteData(xidproduk.getText().toString());
                Toast.makeText(Form_Input.this, "Data Terhapus", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Form_Input.this,MainActivity.class);
                startActivity(i);
            }
        });

    }

    private void viewAll() {
        tblTampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = BantuDb.getAllData();

                if (res.getCount()==0) {
                    showMessage("Error","Tidak Ditemukan");
                    return;
                } else {
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("ID Produk : "+res.getString(0)+"\n");
                        buffer.append("Nama Produk : "+res.getString(1)+"\n");
                        buffer.append("Deskripsi : "+res.getString(2)+"\n");
                        buffer.append("Kategori : "+res.getString(3)+"\n");
                    }
                    showMessage("Nama Produk : ",buffer.toString());
                    showMessage("Deskripsi : ",buffer.toString());
                    showMessage("Kategori : ",buffer.toString());
                }
            }
        });
    }

    public void showMessage (String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}