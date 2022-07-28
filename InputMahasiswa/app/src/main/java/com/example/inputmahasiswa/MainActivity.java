package com.example.inputmahasiswa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText xnim;
    EditText xnama;
    Button tblTambah;
    Button tblTampil;
    DatabaseHelper BantuDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BantuDb = new DatabaseHelper(this);
        xnim = (EditText) findViewById(R.id.xnim);
        xnama = (EditText) findViewById(R.id.xnama);
        tblTambah = (Button) findViewById(R.id.tblTambah);
        tblTampil = (Button) findViewById(R.id.tblTampil);
        viewAll();

        tblTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean IsInserted = BantuDb.insertData(xnim.getText().toString(), xnama.getText().toString());

                if (IsInserted == true) {
                    Toast.makeText(MainActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Gagal Tersimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void viewAll() {
        tblTampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = BantuDb.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error", "TIdak Ditemukan");
                    return;
                } else {
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("Nim : "+res.getString(0)+"\n");
                        buffer.append("Nama : "+res.getString(1)+"\n");
                    }
                    showMessage("Mahasiswa : ",buffer.toString());
                }
            }
        });
    }

    public  void showMessage (String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}