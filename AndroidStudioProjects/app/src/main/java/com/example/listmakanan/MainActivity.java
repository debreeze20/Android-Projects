package com.example.listmakanan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Spinner combo;

    public String Menu_Makanan [] = {"Tteokbokki", "Ramyeon", "Kimchi", "Odeng", "Bokkeumbab", "Kimbab"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listMakanan);
        combo = (Spinner) findViewById(R.id.comboMakanan);

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,Menu_Makanan);

        listView.setAdapter(adapter);
        combo.setAdapter(adapter);
    }
}