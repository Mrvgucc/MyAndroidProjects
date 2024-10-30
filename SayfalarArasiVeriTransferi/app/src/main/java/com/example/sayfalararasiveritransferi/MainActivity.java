package com.example.sayfalararasiveritransferi;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sayfalararasiveritransferi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Kisiler kisi1 = new Kisiler(23232323,"Ahmet",1.80);
        Kisiler kisi2 = new Kisiler(54545454,"Ayse",1.60);

        binding.buttonGoToB.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,ActivityB.class);
            /*intent.putExtra("mesaj","merhaba");
            intent.putExtra("yas",22);
            intent.putExtra("boy",1.58);*/

            intent.putExtra("nesne1", kisi1);
            intent.putExtra("nesne2", kisi2);
            startActivity(intent);
        });

    }
}