package com.company;


import Enumy.CzestotliwoscSkladek;
import Enumy.RodzajPojazdu;
import Enumy.StatusPolisy;

import java.io.Serializable;
import java.time.LocalDate;

public class Pojazd extends PolisaOgolne implements Serializable {

    private String marka;
    private String nrRejestracyjny;
    private String model;
    private boolean czyWypadkowy;
    private int przebieg;
    private int rocznik;
    private String rodzajPojazdu;

    public Pojazd(int nrPolisy, double sumaUbezpieczenia,
                  StatusPolisy statusPolisy, double skladka,
                  CzestotliwoscSkladek czestotliwosc, LocalDate dataZawarciaUmowy,
                  LocalDate dataZakonczeniaUmowy, Integer nrUmowyOgolnej,
                  double wartoscMajatku,
                  String nrRejestracyjny, String marka, String model, int rocznik,
                  boolean czyWypadkowy, int przebieg, RodzajPojazdu rodzajPojazdu) {

        super(nrPolisy, sumaUbezpieczenia, statusPolisy, skladka, czestotliwosc,
                dataZawarciaUmowy, dataZakonczeniaUmowy, nrUmowyOgolnej, wartoscMajatku);
        this.nrRejestracyjny = nrRejestracyjny;
        this.model = model;
        this.czyWypadkowy = czyWypadkowy;
        this.przebieg = przebieg;
        this.rodzajPojazdu = rodzajPojazdu.toString();
        this.marka = marka;
        this.rocznik = rocznik;
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
        return "Polisa Ogólna na Pojazd nr " + nrPolisy + "\n";
    }

    public String getNrRejestracyjny() {
        return nrRejestracyjny;
    }
    public void setNrRejestracyjny(String nrRejestracyjny) {
        this.nrRejestracyjny = nrRejestracyjny;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public boolean isCzyWypadkowy() {
        return czyWypadkowy;
    }
    public void setCzyWypadkowy(boolean czyWypadkowy) {
        this.czyWypadkowy = czyWypadkowy;
    }
    public int getPrzebieg() {
        return przebieg;
    }
    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }
    public String getMarka() {
        return marka;
    }
    public void setMarka(String marka) {
        this.marka = marka;
    }
    public int getRocznik() {
        return rocznik;
    }
    public void setRocznik(int rokProdukcji) {
        this.rocznik = rokProdukcji;
    }
}
