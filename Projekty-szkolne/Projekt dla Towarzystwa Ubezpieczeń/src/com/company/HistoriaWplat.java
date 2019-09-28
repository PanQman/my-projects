package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.TreeMap;

public class HistoriaWplat extends ObjectPlusPlus implements Serializable {

    protected TreeMap<LocalDate, Double> wplaty = new TreeMap<>();
    private Polisa polisa;
    private Osoba osoba;

    public HistoriaWplat(LocalDate dataWplaty, Double kwotaWplaty, Polisa polisa, Osoba osoba)
            throws Exception {
        super();
        this.polisa = polisa;
        this.osoba = osoba;
        dodajWplate(dataWplaty, kwotaWplaty);
    }

    public HistoriaWplat(LocalDate dataWplaty, Double kwotaWplaty)
            throws Exception {
        super();
        dodajWplate(dataWplaty, kwotaWplaty);
    }

    public void dodajWplate(LocalDate data, Double kwota) throws Exception {
        if (wplaty.containsKey(data)){
            throw new Exception("Zarejestrowano już wpłatę o tej dacie!");
        } else {
            wplaty.put(data, kwota);
        }
    }
    public TreeMap<LocalDate, Double> getWplaty() {
        return wplaty;
    }

    public String toString(){
        return wplaty.toString();
    }


}
