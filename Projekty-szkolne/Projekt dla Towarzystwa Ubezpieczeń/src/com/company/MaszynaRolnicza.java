package com.company;

import Enumy.CzestotliwoscSkladek;
import Enumy.StatusPolisy;

import java.io.Serializable;
import java.time.LocalDate;

public class MaszynaRolnicza extends PolisaOgolne implements Serializable {

    private String nazwaMaszyny;
    private String marka;
    private int rokProdukcji;

    public MaszynaRolnicza(int nrPolisy, double sumaUbezpieczenia,
                           StatusPolisy statusPolisy, double skladka,
                           CzestotliwoscSkladek czestotliwosc, LocalDate dataZawarciaUmowy,
                           LocalDate dataZakonczeniaUmowy, Integer nrUmowyOgolnej,
                           double wartoscMajatku,
                           String nazwaMaszyny, int rokProdukcji,
                           String marka) {

        super(nrPolisy, sumaUbezpieczenia, statusPolisy, skladka, czestotliwosc,
                dataZawarciaUmowy, dataZakonczeniaUmowy, nrUmowyOgolnej, wartoscMajatku);
        this.nazwaMaszyny = nazwaMaszyny;
        this.marka = marka;
        this.rokProdukcji = rokProdukcji;
    }

    public void wyswietl() throws Exception{
        wyswietlPowiazania("zawarta pomiędzy", System.out);

        if (!historiawplat.isEmpty()){
            System.out.println(historiawplat.toString());
        }
    }

    public String toString(){

        try {
            wyswietl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Polisa Ogólna nr " + nrPolisy + "\n";
    }


    public String getNazwaMaszyny() {
        return nazwaMaszyny;
    }
    public void setNazwaMaszyny(String nazwaMaszyny) {
        this.nazwaMaszyny = nazwaMaszyny;
    }
    public String getMarka() {
        return marka;
    }
    public void setMarka(String marka) {
        this.marka = marka;
    }
    public int getRokProdukcji() {
        return rokProdukcji;
    }
    public void setRokProdukcji(int rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }
}
