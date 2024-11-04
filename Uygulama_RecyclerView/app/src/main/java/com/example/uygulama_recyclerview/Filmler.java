package com.example.uygulama_recyclerview;

public class Filmler {
    private int film_id;
    private String film_adi;
    private String film_resim_ad;
    private double film_fiyat;

    public Filmler( int film_id,String film_adi, String film_resim_ad, double film_fiyat) {
        this.film_id = film_id;
        this.film_adi = film_adi;
        this.film_resim_ad = film_resim_ad;
        this.film_fiyat = film_fiyat;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getFilm_adi() {
        return film_adi;
    }

    public void setFilm_adi(String film_adi) {
        this.film_adi = film_adi;
    }

    public String getFilm_resim_ad() {
        return film_resim_ad;
    }

    public void setFilm_resim_ad(String film_resim_ad) {
        this.film_resim_ad = film_resim_ad;
    }

    public double getFilm_fiyat() {
        return film_fiyat;
    }

    public void setFilm_fiyat(double film_fiyat) {
        this.film_fiyat = film_fiyat;
    }
}
