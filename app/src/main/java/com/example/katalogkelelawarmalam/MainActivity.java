package com.example.katalogkelelawarmalam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnProfil, btnAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProfil = findViewById(R.id.btnProfil);
        btnAlbum = findViewById(R.id.btnAlbum);

        btnProfil.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfilActivity.class);
            startActivity(intent);
        });

        btnAlbum.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AlbumActivity.class);
            startActivity(intent);
        });
    }
}