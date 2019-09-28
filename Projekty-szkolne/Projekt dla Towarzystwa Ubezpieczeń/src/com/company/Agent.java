package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Agent extends Osoba implements Serializable {

    private int nrAgenta;
    protected static LinkedHashMap<Integer, Agent> agents = new LinkedHashMap<>();

    public Agent (ArrayList listaImion, String nazwisko, String PESEL, boolean plec,
                  String nrTelefonu, String adres, LocalDate dataUrodzenia, int nrAgenta) throws Exception {
        super(listaImion, nazwisko, PESEL, plec, nrTelefonu, adres, dataUrodzenia);
        setNrAgenta(nrAgenta);
        agents.put(nrAgenta, this);
    }

    public Agent(Osoba o, int nrAgenta) throws Exception {
        super(o.listaImion, o.nazwisko, o.PESEL, o.plec, o.nrTelefonu,
                o.adres, o.dataUrodzenia);
        setNrAgenta(nrAgenta);
        agents.put(nrAgenta, this);
    }

    public Kontraktor zostanKontraktorem(Osoba o, int nrKontraktora) {
        if (this.getClass().equals(Kierownik.class)){
            System.out.println("Kierownik nie może zmienić stanowiska!");
            return null;
        } else {
            Kontraktor kontraktor = null;
            try {
                kontraktor = new Kontraktor(o, nrKontraktora);
                return kontraktor;
            } catch (Exception e) {
                e.printStackTrace();
            }
            agents.remove(nrAgenta, this);
            return kontraktor;
        }
    }

    @Override
    public String toString(){

        return "Agent nr: " + getNrAgenta() + " " + getFirstName() + " "
                + (!getSecondName().equals("") ? getSecondName() + " " : "")
                + getNazwisko();
    }

    public int getNrAgenta() {
        return nrAgenta;
    }
    public void setNrAgenta(int nrAgenta) {
        if (!nrAgentów.containsKey(nrAgenta)){
            this.nrAgenta = nrAgenta;
            nrAgentów.put(nrAgenta, this);
        } else throw new IllegalArgumentException("Nr Agenta już występuje");
    }


    public static LinkedHashMap podajListęAgentów() throws Exception {
        loadAgenci(agents);
        return agents;
    }
}
