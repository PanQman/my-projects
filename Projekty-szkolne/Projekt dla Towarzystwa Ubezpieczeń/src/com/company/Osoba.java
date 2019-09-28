package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public abstract class Osoba extends ObjectPlusPlus implements Serializable {

    protected String nazwisko;
    protected String PESEL;
    protected String plec;
    protected String nrTelefonu = "";
    protected String adres;
    protected LocalDate dataUrodzenia;
    protected ArrayList<String> listaImion;
    protected final static int MINWIEK = 18;
    protected static String jednsotka = "Viva Ubezpieczenia Sp. z o. o.";



    public Osoba(ArrayList<String> listaImion, String nazwisko,
                 String PESEL, boolean jakaPlec, String nrTelefonu,
                 String adres, LocalDate dataUrodzenia) throws Exception {
        super();
        this.listaImion = new ArrayList<>(listaImion);
        this.nazwisko = nazwisko;
        this.nrTelefonu = nrTelefonu;
        this.adres = adres;
        this.dataUrodzenia = dataUrodzenia;
        setPlec(jakaPlec);
        setPESEL(PESEL);
        sprawdzWiek();
    }

    public Osoba(ArrayList<String> listaImion, String nazwisko,
                 String PESEL, String plec, String nrTelefonu,
                 String adres, LocalDate dataUrodzenia) throws Exception {
        super();
        this.listaImion = new ArrayList<>(listaImion);
        this.nazwisko = nazwisko;
        this.nrTelefonu = nrTelefonu;
        this.adres = adres;
        this.dataUrodzenia = dataUrodzenia;
        this.plec = plec;
        setPESEL(PESEL);
        sprawdzWiek();
    }


    public void sprawdzWiek() throws Exception {
        if (getWiek() < MINWIEK){
            throw new Exception("Osoba nie może być niepełnoletnia!");
        }
    }

    @Override
    public String toString(){
        return "Osoba nie jest Ubezpieczonym ani Ubezpieczającym! Błąd po stronie systemu!";
    }

    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public int getWiek() {
        LocalDate today = LocalDate.now();
        Period p = Period.between(dataUrodzenia, today);
        return p.getYears();
    }
    public String PESEL() {
        return PESEL;
    }
    public void setPESEL(String PESEL) {
        if (!nrPesel.containsKey(PESEL)){
            this.PESEL = PESEL;
            nrPesel.put(PESEL, this);
        } else throw new IllegalArgumentException("Pesel już występuje");
    }
    public String getJednsotka() { return jednsotka; }
    public String getPlec() {
        return plec;
    }
    public void setPlec(boolean jakaPlec) {
        if(jakaPlec == true){
            this.plec = "Mezczyzna";
        } else {
            this.plec = "Kobieta";
        }
    }
    public String getNrTelefonu() {
        return nrTelefonu;
    }
    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }
    public String getAdres() {
        return adres;
    }
    public void setAdres(String adres) {
        this.adres = adres;
    }
    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }
    public LocalDate getDataUrodzenia() { return dataUrodzenia; }
    public String getFirstName(){
        return listaImion.get(0);
    }
    public String getSecondName(){
        if (listaImion.size() == 1){
            return "";
        } else {
            return listaImion.get(1);
        }
    }
}
