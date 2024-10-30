package com.example.buttontextviewedittext;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.buttontextviewedittext.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.button.setOnClickListener(view -> {
            String alinanVeri = binding.editTextText.getText().toString();
            Log.e("İsim Alindi" , alinanVeri);
            binding.baslik.setText("Hosgeldin "+ alinanVeri);

        });




    }
}