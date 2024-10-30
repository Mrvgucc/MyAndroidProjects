package com.example.sayfalararasiveritransferi;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_b);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Bu sekilde veri gonderme pek tercih edilmez onun yerine Serilizable sinifi kullanilarak nesne tabanli bir sekilde yapilir.
        /*String gelenMesaj = getIntent().getStringExtra("mesaj");
        int gelenYas = getIntent().getIntExtra("yas",0);
        double gelenBoy = getIntent().getDoubleExtra("boy",0.0);
        Log.e("Gelen Mesaj", gelenMesaj);
        Log.e("Gelen Yas", String.valueOf(gelenYas));
        Log.e("Gelen Bas", String.valueOf(gelenBoy));*/

        // Serilizable
        // burada getSerilizableExtra() metodu Serilizable sinifindan geldigi icin burada downCasting yapilarak Kisilier sinifina cevrildi
        Kisiler gelenKisi1 = (Kisiler) getIntent().getSerializableExtra("nesne1");
        Kisiler gelenKisi2 = (Kisiler) getIntent().getSerializableExtra("nesne2");

        Log.e("Gelen Kisi1 tcNo:", String.valueOf(gelenKisi1.getTcNo()));
        Log.e("Gelen Kisi1 isim", gelenKisi1.getIsim()); // isim zaten stirn oldugu icin stringe cevirmeye gerek yoktur
        Log.e("Gelen Kisi1 boy", String.valueOf(gelenKisi1.getBoy()));

        Log.e("Gelen Kisi2 tcNo:", String.valueOf(gelenKisi2.getTcNo()));
        Log.e("Gelen Kisi2 isim", gelenKisi2.getIsim()); // isim zaten stirn oldugu icin stringe cevirmeye gerek yoktur
        Log.e("Gelen Kisi2 boy", String.valueOf(gelenKisi2.getBoy()));






    }
}