package com.company;

import Enumy.CzestotliwoscSkladek;
import Enumy.StatusPolisy;

import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public abstract class Polisa extends ObjectPlusPlus implements Serializable {

    protected int nrPolisy;
    protected double sumaUbezpieczenia;
    protected String statusPolisy;
    protected double skladka;
    protected String czestotliwosc;
    protected ArrayList<LocalDate> wymagalnosci = new ArrayList<>();
    protected LocalDate dataZawarciaUmowy;
    protected LocalDate dataZakonczeniaUmowy;

    protected String znizka;
    public ArrayList<HistoriaWplat> historiawplat;


    public Polisa(int nrPolisy, double sumaUbezpieczenia,
                  StatusPolisy statusPolisy, double skladka,
                  CzestotliwoscSkladek czestotliwosc, LocalDate dataZawarciaUmowy,
                  LocalDate dataZakonczeniaUmowy) {
        super();
        this.sumaUbezpieczenia = sumaUbezpieczenia;
        this.statusPolisy = statusPolisy.toString();
        this.skladka = skladka;
        this.czestotliwosc = czestotliwosc.toString();
        this.dataZawarciaUmowy = dataZawarciaUmowy;
        this.dataZakonczeniaUmowy = dataZakonczeniaUmowy;
        setNrPolisy(nrPolisy);
        setWymagalnosc(dataZawarciaUmowy, czestotliwosc);
        this.historiawplat = new ArrayList<>();
    }

    private void setWymagalnosc(LocalDate dataZawarciaUmowy, CzestotliwoscSkladek czestotliwosc) {
        switch (czestotliwosc){
            case MIESIECZNA:
                setWymagalnosc(12, dataZawarciaUmowy);
                break;
            case KWARTALNA:
                setWymagalnosc(4, dataZawarciaUmowy);
                break;
            case ROCZNA:
                setWymagalnosc(1, dataZawarciaUmowy);
                default:
                    break;
        }
    }

    private void setWymagalnosc(int i, LocalDate data) {
        if (!(i==4)){
            for (int k = 0; k < i; k++) {
                this.wymagalnosci.add(data);
                data = data.plusMonths(1);
            }
        } else {
            for (int k = 0; k < i; k++) {
                this.wymagalnosci.add(data);
               data = data.plusMonths(3);
            }
        }
    }


    public void wyswietlAgentow(JTextArea jTextArea1, Agent a) throws Exception {

        Integer inNumber;
        LinkedHashMap mapa = Agent.podajListęAgentów();
        mapa.remove(a.getNrAgenta());

        if (mapa.size() > 1){

            jTextArea1.append("Dostępni agenci:" + "\n");
            for (Object s : mapa.values()){
                jTextArea1.append(s.toString() + "\n");
            }

            jTextArea1.append("Wpisz nr agenta który ma przejąć polisę \n");

        } else {
            jTextArea1.append("Dostępny jest tylko jeden agent \nSystem inicjuje zmianę\n");
            inNumber = (int) mapa.keySet().iterator().next();
            NewJFrame.jTextField2.setText(inNumber.toString());
            Thread.sleep(2000);
            NewJFrame.wybierz_Button.doClick();

        }
    }

    protected void usunAgenta(Agent staryAgent) {
        usunPowiazanie(staryAgent, staryAgent, "zawarta pomiędzy");
    }

    protected void dodajAgenta(Osoba nowyAgent) {
        dodajPowiazanie("zawarta pomiędzy", "zawarta", nowyAgent);
    }

    public abstract void wyliczZnizke();
    public abstract void wyswietl() throws Exception;

    public void dodajWplate(LocalDate datawplaty, double kwota) throws Exception {
        historiawplat.add(new HistoriaWplat(datawplaty, kwota));
    }

    public String toString() {
        return "Błąd - Polisa nie jest ani Ogólna, ani Życiowa";
    }

    public int getNrPolisy() {
        return nrPolisy;
    }
    public void setNrPolisy(int nrPolisy) {
        if (!polisy.containsKey(nrPolisy)){
            this.nrPolisy = nrPolisy;
            polisy.put(nrPolisy, this);
        } else throw new IllegalArgumentException("Nr Polisy już występuje");
    }
    public double getSumaUbezpieczenia() {
        return sumaUbezpieczenia;
    }
    public void setSumaUbezpieczenia(double sumaUbezpieczenia) {
        this.sumaUbezpieczenia = sumaUbezpieczenia;
    }
    public String getStatusPolisy() {
        return statusPolisy;
    }
    public void setStatusPolisy(String statusPolisy) {
        this.statusPolisy = statusPolisy;
    }
    public double getSkladka() {
        return skladka;
    }
    public void setSkladka(double skladka) {
        this.skladka = skladka;
    }
    public String getCzestotliwosc() {
        return czestotliwosc;
    }
    public void setCzestotliwosc(String czestotliwosc) {
        this.czestotliwosc = czestotliwosc;
    }
    public LocalDate getDataZawarciaUmowy() {
        return dataZawarciaUmowy;
    }
    public void setDataZawarciaUmowy(LocalDate dataZawarciaUmowy) {
        this.dataZawarciaUmowy = dataZawarciaUmowy;
    }
    public LocalDate getDataZakonczeniaUmowy() {
        return dataZakonczeniaUmowy;
    }
    public void setDataZakonczeniaUmowy(LocalDate dataZakonczeniaUmowy) {
        this.dataZakonczeniaUmowy = dataZakonczeniaUmowy;
    }
}

