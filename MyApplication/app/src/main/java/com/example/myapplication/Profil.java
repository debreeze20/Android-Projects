package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
    }

    public void linkwa(View view) {
        String nomer = "6285866606927";
        String url = "https://api.whatsapp.com/send?phone="+nomer;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setPackage("com.whatsapp");
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    //public void metode dari fungsi onClick yang berada di button untuk redirect ke link kontak whatsapp
    //View view nanti merupakan metode memanggil kembali
    //String fungsi untuk teks
    //Intent berfungsi untuk perpindahan antar activity

    public void linkemail(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"111201912276@mhs.dinus.ac.id"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
        emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
    }

    //Intent di atas perpindahan activity dimana nantinya untuk kirim ke email
    //putExtra metode dari Intent yang berfungsi mengirim data
}