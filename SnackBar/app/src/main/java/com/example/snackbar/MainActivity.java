package com.example.snackbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    // SnackBar yeni bir etkilesim oldugu icin material design ile kullanilmaktadir.
    // Toast mesajin guncel hali olarak dusunulebilir
    private Button buttonNormal, buttonGeriDonus, buttonOzel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonNormal = findViewById(R.id.buttonNormal);
        buttonGeriDonus = findViewById(R.id.buttonGeriDonus);
        buttonOzel = findViewById(R.id.buttonOzel);

        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Merhaba", Snackbar.LENGTH_SHORT).show(); // v: gorsel nesnesinin kendisini istemektedir.
            }
        });

        buttonGeriDonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SnackBar'in ustune action konulabilir.
                Snackbar.make(v,"Mesaj Silinsin mi?", Snackbar.LENGTH_LONG)
                        .setAction("Evet", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar.make(v,"Mesaj Silindi",Snackbar.LENGTH_SHORT).show();

                            }
                        }).show();
            }
        });

        buttonOzel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v,"İnternet Baglantisi Yoktur", Snackbar.LENGTH_LONG)
                        .setAction("Tekrar Dene", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                snackbar.setActionTextColor(Color.BLUE);
                snackbar.setBackgroundTint(Color.YELLOW); // arka plan rengi
                snackbar.setTextColor(Color.BLUE); // yeni guncelleme ile tek satir kod yeterli
                snackbar.show();
            }
        });
    }
}