package com.example.inputmahasiswa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "data_mhs.db";
    public static final String TABLE_NAME = "tabel_mhs";
    public static final String COL_1 = "nim";
    public static final String COL_2 = "nama";
    public static final int DATABASE_VERTION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERTION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE table_mhs (nim text null, nama text null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    // method untuk menambahkan data

    public boolean insertData(String nim, String nama) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, nim);
        contentValues.put(COL_2, nama);
        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Method untuk edit data
    public boolean updateData(String nim, String nama, String bu) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, nim);
        contentValues.put(COL_2, nama);

        db.update(TABLE_NAME,contentValues,"nim = ?", new String[] {nim});
        return true;
    }

    public int deleteData(String nim) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "nim = ? ", new String[] {nim});
    }

    // method untuk menampilkan data
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from tabel_mhs", null);
        return res;
    }

}