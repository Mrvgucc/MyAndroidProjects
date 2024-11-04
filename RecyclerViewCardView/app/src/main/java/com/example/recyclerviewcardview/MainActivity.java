package com.example.recyclerviewcardview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // CardView: satir tasarimi nesnesidir.
    // RecyclerView: listeleme nesnesidir.
    // su anda listeleme icin kullanilan en guncel yapi budur
    // CardView nesneleri RecyclerView nesneleri icinde gosterilir.
    // RecyclerView icindeki nesnelerin tasarimi CardView yapisi ile gerceklesir.
    // CardView tasarimi icerisinde hangi verinin nerede duracagina CardView de karar vermez bunun icin bir ara sinif olusturmamiz lazim. Bu ara sinif yapisina da Adapter denir
    // Elimizde bir veri kumesi olacak ve bu veri kumesini Adapter icine yerlestirecegiz.
    // CardView Adapter icerinde baglanir.
    // CardView yapisi ayri da kullanilabilir sadece RecyclerView icerisinde kullanilmak zorunda degildir.

    // bir veri kumemiz varsa bu veri kumesi icin bir cardView tasarimi yapmamiz gerekiyor
    // hangi sayfada goruntuleme listeleme islemini yapmak istiyorsak bir recyclerView olusturmamiz gerekir
    // bunlari organize edecek bir adapter gerekiyor
    // son olarak bu adapteri recyclerView icerisine aktardigimiz zaman goruntuleyebiliyoruz

    // hazirladigimiz card_tasarim.xml yapisini gostermek icin RecyclerView kullanmaliyiz.

    private RecyclerView rv;
    private ArrayList<String> ulkelerList;
    private BasitRVAdapter adapter;

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

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true); //  icerisine ekleyecegmiz listelerin boyutunu sabitlemek icin daha guzel durmasi icin ekledigimiz bir koddur.

        rv.setLayoutManager(new LinearLayoutManager(this));
        // rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)); her satirda 2 nesne gorunur
        // rv.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)); // 1 satirda hepsi gozukur ve yatay kaydirma yapilir.

        ulkelerList = new ArrayList<>();
        ulkelerList.add("Türkiye");
        ulkelerList.add("İtalya");
        ulkelerList.add("Japonya");
        ulkelerList.add("Rusya");
        ulkelerList.add("Amerika");

        // adapteri tanimlayalim:
        adapter = new BasitRVAdapter(this,ulkelerList); // veri kumemizi ve context'i adapter icine yerlestirdik
        // context: uygulamamizin calisma ortamini temsil eder
        // recyclerView'in calismasi icin;
        rv.setAdapter(adapter); // adapter bu sekilde calisir.


    }
}