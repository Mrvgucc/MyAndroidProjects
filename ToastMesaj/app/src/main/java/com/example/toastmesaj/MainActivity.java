package com.example.toastmesaj;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Bazi android surumlerinde toast mesaj ozellestirmeleri desteklenmiyor olabilir
    private Button buttonNormal, buttonOzel;
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
        buttonOzel = findViewById(R.id.buttonOzel);

        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MainActivity.this ile getApplicationContext() metodu ayni ise yarar
                Toast.makeText(MainActivity.this,"Merhaba", Toast.LENGTH_SHORT).show();
            }
        });

        buttonOzel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View tasarim = getLayoutInflater().inflate(R.layout.toast_tasarim, null); // inflater varsa bir tasarim projeye aktariliyordur.
                // olusturdugumuz bu toast tasarimina eristik artik icindeki nesnelere de erisebiliriz.
                TextView textViewMesaj = tasarim.findViewById(R.id.textViewMesaj);
                textViewMesaj.setText("Merhaba Ozel Toast Mesaj");

                Toast toastOzel = new Toast(getApplicationContext());
                toastOzel.setView(tasarim);

                toastOzel.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);

                toastOzel.setDuration(Toast.LENGTH_LONG);

                toastOzel.show();

                // Android ozel Toast mesajlarini artik desteklemiyor.
            }
        });
    }
}