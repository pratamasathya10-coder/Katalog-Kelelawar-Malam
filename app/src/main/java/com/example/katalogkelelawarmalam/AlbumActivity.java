package com.example.katalogkelelawarmalam;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    EditText inputSearch;
    Button btnCari, btnSort;

    ListView listAlbum;
    ArrayAdapter<String> adapter;

    String[] lagu = {
            "Misteri (02:16)",
            "Kesurupan (02:30)",
            "Cahaya (03:27)",
            "Budak Kelelawar (03:55)",
            "Harut Marut (02:01)",
            "Khundang (04:41)",
            "Kosong (03:18)",
            "Tulang Belulang (05:56)"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        inputSearch = findViewById(R.id.inputSearch);
        btnCari = findViewById(R.id.btnCari);
        btnSort = findViewById(R.id.btnSort);
        listAlbum = findViewById(R.id.listAlbum);

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                lagu
        );

        listAlbum.setAdapter(adapter);

        // VALIDASI + LINEAR SEARCH
        btnCari.setOnClickListener(v -> {

            String keyword = inputSearch.getText().toString();

            if (keyword.isEmpty()) {

                Toast.makeText(this,
                        "Masukkan nama lagu terlebih dahulu!",
                        Toast.LENGTH_SHORT).show();

            } else {

                ArrayList<String> hasil = new ArrayList<>();

                for (String l : lagu) {

                    if (l.toLowerCase().contains(keyword.toLowerCase())) {

                        hasil.add(l);

                    }
                }

                if (hasil.isEmpty()) {

                    Toast.makeText(this,
                            "Lagu tidak ditemukan...",
                            Toast.LENGTH_SHORT).show();

                } else {

                    ArrayAdapter<String> hasilAdapter =
                            new ArrayAdapter<>(
                                    this,
                                    android.R.layout.simple_list_item_1,
                                    hasil
                            );

                    listAlbum.setAdapter(hasilAdapter);

                }
            }
        });

        // BUBBLE SORT A-Z
        btnSort.setOnClickListener(v -> {

            for (int i = 0; i < lagu.length - 1; i++) {

                for (int j = 0; j < lagu.length - i - 1; j++) {

                    if (lagu[j].compareTo(lagu[j + 1]) > 0) {

                        String temp = lagu[j];
                        lagu[j] = lagu[j + 1];
                        lagu[j + 1] = temp;

                    }
                }
            }

            adapter.notifyDataSetChanged();

            Toast.makeText(this,
                    "Lagu berhasil diurutkan A-Z",
                    Toast.LENGTH_SHORT).show();

        });
    }
}