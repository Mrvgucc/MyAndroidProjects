package com.example.floatinglabels;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    // edittext'te veri girildiginde placeholder kismindaki yazi kayboluyordu ancak bu yapi ile verilen yazi yukari kayarak veri giris alaninin ustunde yer alir.
    private TextInputEditText editTextAd, editTextSoyad;
    private Button button;
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

        editTextAd = findViewById(R.id.editTextAd);
        editTextSoyad = findViewById(R.id.editTextSoyad);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gelenAd = editTextAd.getText().toString();
                String gelenSoyad = editTextSoyad.getText().toString();

                Toast.makeText(getApplicationContext(),"İsim: " + gelenAd + " Soyisim: " + gelenSoyad,Toast.LENGTH_SHORT).show();
            }
        });


    }
}