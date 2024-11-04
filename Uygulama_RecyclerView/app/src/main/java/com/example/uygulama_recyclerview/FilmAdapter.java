package com.example.uygulama_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.CardViewTasarimNesneleriniTutucu> {
    private Context mContext;
    private List<Filmler> filmlerList;

    public FilmAdapter(Context mContext, List<Filmler> filmlerList) {
        this.mContext = mContext;
        this.filmlerList = filmlerList;
    }

    @NonNull
    @Override
    public CardViewTasarimNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // olusturdugumuz card_tasarim.xml tasarimini burada baglamaliyiz.
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_film_tasarim,parent,false);

        return new CardViewTasarimNesneleriniTutucu(itemView); // burasi tasarimimiz temsil eder
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimNesneleriniTutucu holder, int position) {
         final Filmler film = filmlerList.get(position);
         holder.textViewFilmBaslik.setText(film.getFilm_adi());
         holder.textViewFilmFiyat.setText(film.getFilm_fiyat() + " TL");

         holder.imageViewFilmResim.setImageResource(mContext.getResources().getIdentifier(film.getFilm_resim_ad(),"drawable",mContext.getPackageName()));

         holder.buttonSepeteEkle.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(mContext,film.getFilm_adi()  + " Sepete Eklendi", Toast.LENGTH_SHORT).show();
             }
         });



    }

    @Override
    public int getItemCount() {
        return filmlerList.size();
    }

    // Apater nesnesi budur
    public class CardViewTasarimNesneleriniTutucu extends RecyclerView.ViewHolder{
        public ImageView imageViewFilmResim;
        public TextView textViewFilmBaslik;
        public TextView textViewFilmFiyat;
        public Button buttonSepeteEkle;

        public CardViewTasarimNesneleriniTutucu(@NonNull View itemView) { // itemView: tasarimimizi temsil eder
            // burasi gorsel nesnelerimizi temsil eder
            super(itemView);
            imageViewFilmResim = itemView.findViewById(R.id.imageViewFilmResim);
            textViewFilmBaslik = itemView.findViewById(R.id.textViewFilmBaslik);
            textViewFilmFiyat = itemView.findViewById(R.id.textViewFilmFiyat);
            buttonSepeteEkle = itemView.findViewById(R.id.buttonSepeteEkle);

        }
    }
}
