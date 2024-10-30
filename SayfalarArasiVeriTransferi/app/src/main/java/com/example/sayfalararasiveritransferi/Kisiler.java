package com.example.sayfalararasiveritransferi;

import java.io.Serializable;
// Serilizable impelements edilmezse veriler karsi tarafa gonderilemez !!
public class Kisiler implements Serializable {
    private int tcNo;
    private String isim;
    private double boy;

    public Kisiler(int tcNo, String isim, double boy) {
        this.tcNo = tcNo;
        this.isim = isim;
        this.boy = boy;
    }

    public Kisiler() {
    }

    public int getTcNo() {
        return tcNo;
    }

    public void setTcNo(int tcNo) {
        this.tcNo = tcNo;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public double getBoy() {
        return boy;
    }

    public void setBoy(double boy) {
        this.boy = boy;
    }
}
