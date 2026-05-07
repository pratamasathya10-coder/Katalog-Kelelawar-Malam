package com.example.katalogkelelawarmalam;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AlbumActivity extends AppCompatActivity {

    EditText inputSearch;
    Button btnCari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        inputSearch = findViewById(R.id.inputSearch);
        btnCari = findViewById(R.id.btnCari);

        btnCari.setOnClickListener(v -> {

            String keyword = inputSearch.getText().toString();

            if (keyword.isEmpty()) {

                Toast.makeText(this,
                        "Masukkan nama lagu terlebih dahulu!",
                        Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this,
                        "Mencari lagu: " + keyword,
                        Toast.LENGTH_SHORT).show();

            }

        });
    }
}