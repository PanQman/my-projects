package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;

public class Kierownik extends Agent implements Serializable {

    private int nrKierownika;
    private TreeSet<Agent> podwladni = new TreeSet<>();

    public void dodajpodwladnego(Agent nowyAgent){
        podwladni.add(nowyAgent);
    }

    public Kierownik (ArrayList listaImion, String nazwisko, String PESEL, boolean plec,
                  String nrTelefonu, String adres, LocalDate dataUrodzenia, int nrAgenta, int nrKierownika) throws Exception {
        super(listaImion, nazwisko, PESEL, plec, nrTelefonu, adres, dataUrodzenia, nrAgenta);
        setNrKierownika(nrKierownika);
    }


    public int getNrKierownika() {
        return nrKierownika;
    }
    public void setNrKierownika(int nrKierownika) {
        if (!nrKierownikow.containsKey(nrKierownika)){
            this.nrKierownika = nrKierownika;
            nrKierownikow.put(nrKierownika, this);
        } else throw new IllegalArgumentException("Nr Kierownika już występuje");
    }

    @Override
    public String toString(){
        return "Kierownik nr: " + getNrKierownika() + " " + getFirstName() + " "
                + (!getSecondName().equals("") ? getSecondName() + " " : "") +
                getNazwisko() + " Numer jako agent: " + getNrAgenta();
    }

    public void wyswietlAgentow(){
        Agent agent = null;

        for (Agent a : podwladni){
            agent = a;
            System.out.println("Agent podwładny: " + "\n" + agent);
        }

    }
}
