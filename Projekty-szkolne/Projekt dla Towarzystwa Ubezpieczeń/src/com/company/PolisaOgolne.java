package com.company;

import Enumy.*;

import java.io.Serializable;
import java.time.LocalDate;

public class PolisaOgolne extends Polisa implements Serializable {

    protected String nrUmowyOgolnej;
    protected double wartoscMajatku;

    protected Gospodarstwo gosp = null;
    protected Dom dom = null;
    protected Dom_i_Gospodarstwo dom_i_gospodarstwo = null;



    public PolisaOgolne(int nrPolisy, double sumaUbezpieczenia,
                  StatusPolisy statusPolisy, double skladka,
                  CzestotliwoscSkladek czestotliwosc, LocalDate dataZawarciaUmowy,
                  LocalDate dataZakonczeniaUmowy, Integer nrUmowyOgolnej,
                  double wartoscMajatku) {
        super(nrPolisy, sumaUbezpieczenia, statusPolisy, skladka, czestotliwosc, dataZawarciaUmowy,
                dataZakonczeniaUmowy);

        this.nrUmowyOgolnej = nrUmowyOgolnej.toString();
        this.wartoscMajatku = wartoscMajatku;
        wyliczZnizke();
    }


    public void dodajDom(String adres, double metraz,
                         int iloscPieter, boolean czyMieszkanie){
        dom = new Dom(adres, metraz, iloscPieter, czyMieszkanie);
    }

    public void dodajGospodarstwo(String adres, double powierzchnia){
        gosp = new Gospodarstwo(adres, powierzchnia);
    }

    public void dodajDomIGospodarstwo(String adresDomu, double metraz,
                                      int iloscPieter, boolean czyMieszkanie, String adresGospodarstwa,
                                      double powierzchnia){
        dom_i_gospodarstwo = new Dom_i_Gospodarstwo(adresDomu, metraz, iloscPieter, czyMieszkanie,
                adresGospodarstwa, powierzchnia);
    }


    //polimorfizm
    public void wyswietl() throws Exception{
        wyswietlPowiazania("zawarta pomiędzy", System.out);

        if (!historiawplat.isEmpty()){
            System.out.println(historiawplat.toString());
        }
        if (gosp != null){
            System.out.println(gosp);
        } else if (dom != null){
            System.out.println(dom);
        } else if (dom_i_gospodarstwo != null){
            System.out.println(dom_i_gospodarstwo);
        } else System.out.println("Błąd - polisa Ogólna " + getNrPolisy() + " nie ma produktu");
    }



    //polimorfizm
    public void wyliczZnizke() {
        znizka = "35 %";
    }


    public static class Nieruchomosci extends ObjectPlusPlus {

        public Nieruchomosci(){
            super();

        }
    }

    public String toString() {
        try {
            //wyswietl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Polisa Ogólna nr: " + getNrPolisy() + "\n";
    }

    public String getNrUmowyOgolnej() {
        return nrUmowyOgolnej;
    }
    public void setNrUmowyOgolnej(String nrUmowyOgolnej) {
        this.nrUmowyOgolnej = nrUmowyOgolnej;
    }
    public double getWartoscMajatku() {
        return wartoscMajatku;
    }
    public void setWartoscMajatku(double wartoscMajatku) {
        this.wartoscMajatku = wartoscMajatku;
    }
    public Gospodarstwo getGosp() { return gosp; }
}

