package com.example.recyclerviewcardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// adapter class'imiz
public class BasitRVAdapter extends RecyclerView.Adapter<BasitRVAdapter.CardViewTasarimNesneleriniTutucu>{
    private Context mContext; //  android'in kendi ozelliklerini kullanmamiz icin gereken bir yapidir.
    private List<String> ulkelerDisaridanGelenList;// disaridan verilecek olan kumeyi tanimladik (liste olarak)

    public BasitRVAdapter(Context mContext, List<String> ulkelerDisaridanGelenList) {
        this.mContext = mContext;
        this.ulkelerDisaridanGelenList = ulkelerDisaridanGelenList;
    }

    @NonNull
    @Override
    public CardViewTasarimNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // nesneleri tanimladik ancak inflate etmedik burada inflate edecegiz.
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim,parent,false);
        return new CardViewTasarimNesneleriniTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimNesneleriniTutucu holder, int position) { // position o anda bulundugu/calistigi index'i verir holder ise CardViewTasarimNesneleriniTutucu sinifindan bir nesnedir
        // yani holder ile satirCardView, satirYazi gibi tum nesnelere ulabiliriz
        // getItemCount'tan donen sayi kadar (yani listenin boyutu kadar) onBindViewHolder calisacaktir.
        // ornegin liste icinde 10 tane eleman varsa bu metod da 10 kere calisacaktir.

        final String ulke = ulkelerDisaridanGelenList.get(position); // bulundugum satirdaki ulkeyi verir bu ulkeyi card_tasarim.xml'de satirYazi'ya yazdirmak istiyoruz.
        holder.satirYazi.setText(ulke); // bu sekilde ulke adini yazdirmis olduk

        holder.satirCardView.setOnClickListener(new View.OnClickListener() { // cardView'in tiklanilma ozelligini de bu sekilde aktiflestirebiliriz
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Sectiginiz ulke: " + ulke, Toast.LENGTH_SHORT).show();
            }
        });

        // olusturdugumuz 3 nokta resmine tikladaigimiz zaman burada calisacak
        holder.noktaResim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(mContext,"Resim : " + ulke,Toast.LENGTH_SHORT).show();
                PopupMenu popup = new PopupMenu(mContext,holder.noktaResim);
                MenuInflater menuInflater = popup.getMenuInflater();
                menuInflater.inflate(R.menu.card_menu, popup.getMenu()); // popUpMenu ile tasarim nesnesi olusturuldu
                popup.show();

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) { // item nesnesi popUpMenu uzerinde tiklanilan item'i verir
                        switch (item.getItemId()){
                            case R.id.action_sil:
                                Toast.makeText(mContext,"Sil Tiklandi: " + ulke ,Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.action_duzenle:
                                Toast.makeText(mContext,"Duzenle Tiklandi: " + ulke, Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() { // burasi veri kumesinin boyutunu ister (kac tane veri oldugunu bilmek ister)
        return ulkelerDisaridanGelenList.size(); // bu sekilde liste boyutunu cekebiliriz.
    }

    public class CardViewTasarimNesneleriniTutucu extends RecyclerView.ViewHolder {
        // kullanmak istedigimiz nesneleri tek tek tanimlamaiz gerekiyor
        public TextView satirYazi;
        public CardView satirCardView;
        public ImageView noktaResim;

        public CardViewTasarimNesneleriniTutucu(@NonNull View itemView) {
            super(itemView);
            satirYazi = itemView.findViewById(R.id.satirYazi);
            satirCardView = itemView.findViewById(R.id.satirCardView);
            noktaResim = itemView.findViewById(R.id.noktaResim);

        }
    }
}
