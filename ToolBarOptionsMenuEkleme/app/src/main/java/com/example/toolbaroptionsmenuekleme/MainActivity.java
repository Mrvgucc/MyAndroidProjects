package com.example.toolbaroptionsmenuekleme;


import com.example.toolbaroptionsmenuekleme.R.id.*; // Proje adınızın doğru olduğuna dikkat edin.


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
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

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("ToolBar Menu");
        setSupportActionBar(toolbar);

    }
    // olsuturdugumuz toolbar_menu.xml dosyasini buraya bagladik
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_bilgi:
                Toast.makeText(getApplicationContext(),"Bilgi Tiklandi",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_ayarlar:
                Toast.makeText(getApplicationContext(),"Ayarlar Tiklandi",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_ekle:
                Toast.makeText(getApplicationContext(),"Ekle Tiklandi",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_cikis:
                Toast.makeText(getApplicationContext(),"Cikis Tiklandi",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }

    }
}