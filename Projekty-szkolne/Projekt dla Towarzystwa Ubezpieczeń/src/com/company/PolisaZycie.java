package com.company;

import Enumy.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;

public class PolisaZycie extends Polisa implements Serializable {

    private String nrUmowyZyciowej;
    private WariantUbez wariant;
    private TreeMap<Integer, UmowaDodatkowa> dodUmowa;
    private ArrayList<Integer> licznikUmowDodatkowych;


    public PolisaZycie(int nrPolisy, double sumaUbezpieczenia,
                  StatusPolisy statusPolisy, double skladka,
                  CzestotliwoscSkladek czestotliwosc, LocalDate dataZawarciaUmowy,
                  LocalDate dataZakonczeniaUmowy, WariantUbez wariant,
                  Integer nrUmowyZyciowej) {

        super(nrPolisy, sumaUbezpieczenia, statusPolisy, skladka, czestotliwosc, dataZawarciaUmowy,
                dataZakonczeniaUmowy);
        this.wariant = wariant;
        this.nrUmowyZyciowej = nrUmowyZyciowej.toString();
        licznikUmowDodatkowych = new ArrayList<>();
        dodUmowa = new TreeMap<>();
        wyliczZnizke();
    }

    public void dodajUmoweDodatkowa(Integer a, UmowaDodatkowa umowaDodatkowa){
        dodUmowa.put(a, umowaDodatkowa);
        licznikUmowDodatkowych.add(a);
    }

    //polimorfizm
    public void wyswietl() throws Exception{
        wyswietlPowiazania("zawarta pomiędzy", System.out);

        if (!historiawplat.isEmpty()){

            System.out.println(historiawplat.toString());
        }
        if (!dodUmowa.isEmpty()){
            for (Integer a: licznikUmowDodatkowych){
                System.out.println(dajPowiazanyObiekt("z umową dodatkową", a));
            }

        }
    }


    //polimorfizm
    public void wyliczZnizke() {
            znizka = "20 %";
    }


    public String toString() {
        try {
            wyswietl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Polisa Życie nr: " + getNrPolisy() + "\n";
    }


    public String getNrUmowyZyciowej() {
        return nrUmowyZyciowej;
    }
    public void setNrUmowyZyciowej(String nrUmowyZyciowej) {
        this.nrUmowyZyciowej = nrUmowyZyciowej;
    }

}


