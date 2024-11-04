package com.example.tabslayout;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // tablayout ana yapi; altinda fragment'larin gorunmesini saglagimiz yapi ise viewPager yapisidir.

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private ArrayList<String> fragmentBaslikListesi = new ArrayList<>();



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

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);

        // olusturdugumuz fragmentleri tabLayout ile kullanabilmek icin ArrayList olusturulup fragmentlar icine aktarilmalidir.
        fragmentArrayList.add(new FragmentBirinci());
        fragmentArrayList.add(new FragementIkinci());
        fragmentArrayList.add(new FragmentUcuncu());

        // bu fragmnetlari tabLayout da goruntulemek icin Adapter'a ihtiyacimiz var.
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(this);

        viewPager2.setAdapter(adapter);

        // tabLayout ve viewPager2 yapisini birlestirebilmek icin TabLayoutMediator yapisi kullanilir
        fragmentBaslikListesi.add("Bir");
        fragmentBaslikListesi.add("İki");
        fragmentBaslikListesi.add("Üç");

        new TabLayoutMediator(tabLayout,viewPager2,(tab,position) -> tab.setText(fragmentBaslikListesi.get(position))).attach(); // bu sekilde birlestirildi

    }
    // adapter olusturalim:
    private class MyViewPagerAdapter extends FragmentStateAdapter{

        public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) { // Adapter'in goruntuleyecegi fragmentlari belirttigimiz yerdir
            // getItemCount'tan cektigi boyut bilgisi ile index dondurebiliyor.
            return fragmentArrayList.get(position); // bu sekilde fragmnetlari ceker
        }

        @Override
        public int getItemCount() { // kac tane fragment!in organize edilecegini belirler.
            return fragmentArrayList.size(); // olusturdugumuz ArrayList icinde kac tane framgent oldugunu cekebildik
        }
    }
}