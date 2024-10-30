package com.example.alertviewolusturma;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
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
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                Log.e("Normal"  ,"Normal");
                ad.setTitle("Başlik");
                ad.setMessage("Merhaba Alert Normal");
                ad.setIcon(R.drawable.resim); // olusturdugumuz resmi kullanabiliriz.
                ad.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Tamam Tiklandi",Toast.LENGTH_SHORT).show();
                    }
                });

                ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"İptal Tiklandi",Toast.LENGTH_SHORT).show();
                    }
                });

                ad.create().show();
            }
        });

        buttonOzel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e( "Ozel" , "tiklandi");
                View tasarim = getLayoutInflater().inflate(R.layout.alert_tasarim,null);
                final EditText editTextAlert = tasarim.findViewById(R.id.editTextText);

                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);

                ad.setTitle("Baslik");
                ad.setMessage("Mesaj");
                ad.setView(tasarim);

                ad.setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String gelenVeri = editTextAlert.getText().toString();
                        Toast.makeText(getApplicationContext(),"Yazilan İsim: " + gelenVeri, Toast.LENGTH_SHORT).show();
                    }
                });

                ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Ozel İptal Secildi " , Toast.LENGTH_SHORT).show();
                    }
                });
                ad.create().show();

            }
        });
    }
}