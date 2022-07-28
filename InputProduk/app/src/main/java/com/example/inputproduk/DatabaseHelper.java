package com.example.inputproduk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "data_produk.db";
    public static final String TABLE_NAME = "table_produk";
    public static final String COL_1 = "id_produk";
    public static final String COL_2 = "judul";
    public static final String COL_3 = "deskripsi";
    public static final String COL_4 = "kategori";
    public static final int COL_5 = 0;
    public static final int COL_6 = 0;
    public static final String COL_7 = "kondisi";
    public static final int DATABASE_VERTION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERTION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE table_produk (id_produk text null, judul text null, deskripsi text null, kategori text null, harga int null, stok int null, kondisi text null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    // Method untuk menambahkan data

    public boolean insertData(String id_produk, String judul, String deskripsi, String kategori, int harga, int stok, String kondisi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id_produk);
        contentValues.put(COL_2,judul);
        contentValues.put(COL_3,deskripsi);
        contentValues.put(COL_4,kategori);
        contentValues.put(String.valueOf(COL_5),harga);
        contentValues.put(String.valueOf(COL_6),stok);
        contentValues.put(COL_7,kondisi);
        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result==-1){
            return false;
        } else {
            return true;
        }
    }

    // Method untuk Edit Data

    public boolean updateData(String id_produk, String judul, String deskripsi, String kategori, int harga, int stok, String kondisi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id_produk);
        contentValues.put(COL_2,judul);
        contentValues.put(COL_3,deskripsi);
        contentValues.put(COL_4,kategori);
        contentValues.put(String.valueOf(COL_5),harga);
        contentValues.put(String.valueOf(COL_6),stok);
        contentValues.put(COL_7,kondisi);

        db.update(TABLE_NAME,contentValues,"id_produk = ?", new String[] {id_produk});
        return true;
    }

    // Method untuk menghapus data

    public int deleteData(String id_produk) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"id_produk = ?",new String[] {id_produk});
    }

    // Method untuk menampilkan data

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from table_produk",null);
        return res;
    }
}
