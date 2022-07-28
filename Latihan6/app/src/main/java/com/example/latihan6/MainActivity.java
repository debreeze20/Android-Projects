package com.example.latihan6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ClassMakanan cm;
    ListView listView;
    EditText editText;
    Button tblTambah;

    ArrayAdapter adapter;
    ArrayList <String> listviewku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listMakanan);
        editText = findViewById(R.id.dataMakanan);
        tblTambah = findViewById((R.id.tombolTambah));
        tampilkan_makanan();
        listviewku = new ArrayList<>();

        tblTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cm.tambahData(editText.getText().toString());
                Toast.makeText(MainActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                tampilkan_makanan();
            }
        });
    }

    private void tampilkan_makanan() {
        Cursor cursor = cm.tampilMakanan();
        if (cursor.getCount() == 0 ) {
            Toast.makeText(MainActivity.this, "Record Kosong", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                listviewku.add(String.valueOf(cursor.getInt(0))+" "+cursor.getString(1));
            }
            adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,listviewku);
            listView.setAdapter(adapter);
        }
    }

}