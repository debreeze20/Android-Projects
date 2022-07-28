package com.example.latihan6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ClassMakanan extends SQLiteOpenHelper {

    private static final String DB_Makanan = "db_makanan";
    private static final String KODE = "kode";
    private static final String NM_MAKANAN = "nm_makanan";
    private static final String tabel_makanan = "tabel_makanan";

    public ClassMakanan(@Nullable Context context) {
        super(context, DB_Makanan, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String nama_tabel = "create table "+ tabel_makanan + "(" + KODE + " integer primary key autoincrement, " + NM_MAKANAN + " text);";
        sqLiteDatabase.execSQL(nama_tabel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean tambahData(String nama) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues ContentValues = new ContentValues();
        ContentValues.put(NM_MAKANAN, nama);
        long hasil = db.insert(tabel_makanan, null, ContentValues);
        return hasil != -1;
    }


    public Cursor tampilMakanan() {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "select * from "+tabel_makanan;
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }
}
