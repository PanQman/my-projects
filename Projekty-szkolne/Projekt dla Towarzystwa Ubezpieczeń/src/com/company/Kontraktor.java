package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Kontraktor extends Osoba implements Serializable {

    private int nrKontraktora;

    public Kontraktor (ArrayList<String> listaImion, String nazwisko,
                       String PESEL, boolean plec, String nrTelefonu,
                       String adres, LocalDate dataUrodzenia, int nrKontraktora) throws Exception {
        super(listaImion, nazwisko, PESEL, plec, nrTelefonu, adres, dataUrodzenia);
        setNrKontraktora(nrKontraktora);
    }

    public Kontraktor (Osoba o, int nrKontraktora) throws Exception {
        super(o.listaImion, o.nazwisko, o.PESEL, o.plec, o.nrTelefonu,
                o.adres, o.dataUrodzenia);
        setNrKontraktora(nrKontraktora);
    }


    public Agent zostanAgentem(Osoba osoba, int nrAgenta) {
        Agent agent = null;
        try {
            agent = new Agent(osoba, nrAgenta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agent;
    }


    public int getNrKontraktora() {
        return nrKontraktora;
    }
    public void setNrKontraktora(int nrKontraktora) {
        if (!nrKontraktorów.containsKey(nrKontraktora)){
            this.nrKontraktora = nrKontraktora;
            nrKontraktorów.put(nrKontraktora, this);
        } else throw new IllegalArgumentException("Nr Kontraktora już występuje");
    }


    @Override
    public String toString(){
        return "Kontraktor nr: " + getNrKontraktora() + " " + getFirstName() + " "
                + (!getSecondName().equals("") ? getSecondName() + " " : "") +
                getNazwisko()/* + "\n" + "PESEL: " + getPESEL() + " " + getPlec() + "\n" +
                "Telefon: " + getNrTelefonu() + "\n" +  "Adres: " + getAdres() + "\n"
                + "Data urodzenia: " + getDataUrodzenia() + " wiek: " + getWiek() +
                "\n"
                + "jednostka ubezpieczająca: " + getJednsotka() + "\n" +
                "----------------------------------------" + "\n"*/;
    }

    /*Osoba o1 = new Agent(listaImion, nazwisko, PESEL, plec, nrTelefonu,
            adres, dataUrodzenia, nrAgenta);*/
}
