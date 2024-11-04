package com.example.uygulama_recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<Filmler> filmlerArrayList;
    private FilmAdapter adapter;
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
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)) ;

        Filmler f6 = new Filmler(1,"Django" , "django",12.99);
        Filmler f2 = new Filmler(2,"Inception","inception",10.99);
        Filmler f3 = new Filmler(3, "Interstaller","interstellar",29.99);
        Filmler f4 = new Filmler(4, "The Hateful Eight","thehatefuleight",5.99);
        Filmler f5 = new Filmler(5, "The Pianist", "thepianist",11.99);
        Filmler f1 = new Filmler(6, "Bir Zamanlar Anadolu'da","birzamanlaranadoluda",12.99);

        // olusturulan bu film nesneleri bir arrayliste eklenecek
        filmlerArrayList = new ArrayList<>();
        filmlerArrayList.add(f1);
        filmlerArrayList.add(f2);
        filmlerArrayList.add(f3);
        filmlerArrayList.add(f4);
        filmlerArrayList.add(f5);
        filmlerArrayList.add(f6);

        adapter = new FilmAdapter(this,filmlerArrayList);
        rv.setAdapter(adapter); // recyclerView nesnesi adapter icine aktarildi.




    }
}