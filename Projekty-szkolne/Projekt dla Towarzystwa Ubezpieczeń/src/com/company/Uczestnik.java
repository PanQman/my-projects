package com.company;

import Enumy.RodzajKlienta;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;

public class Uczestnik extends Osoba implements Serializable {

    private EnumSet<RodzajKlienta> rodzajKlienta;
    private static int counterUczestnik = 1033;
    private int idUczestnik;

    //Ubezpieczony
    private String zawod;
    private static ArrayList<Uczestnik> listOfUbezpieczeni = new ArrayList<>();

    //Ubezpieczajacy
    private String email = "";


    public Uczestnik(ArrayList<String> listaImion, String nazwisko,
                     String PESEL, boolean plec, String nrTelefonu,
                     String adres, String email, LocalDate dataUrodzenia) throws Exception {
        super(listaImion, nazwisko, PESEL, plec, nrTelefonu, adres, dataUrodzenia);

        this.email = email;
        setIdUczestnik(++counterUczestnik);
        rodzajKlienta = EnumSet.<RodzajKlienta>of(RodzajKlienta.UBEZPIECZAJACY);
    }

    public Uczestnik(ArrayList<String> listaImion, String nazwisko,
                     String PESEL, boolean plec, String nrTelefonu,
                     String adres, LocalDate dataUrodzenia, String zawod) throws Exception {
        super(listaImion, nazwisko, PESEL, plec, nrTelefonu, adres, dataUrodzenia);

        this.zawod = zawod;
        setIdUczestnik(++counterUczestnik);
        rodzajKlienta = EnumSet.<RodzajKlienta>of(RodzajKlienta.UBEZPIECZONY);
        listOfUbezpieczeni.add(this);
    }

    public Uczestnik(ArrayList<String> listaImion, String nazwisko,
                     String PESEL, boolean plec, String nrTelefonu,
                     String adres, LocalDate dataUrodzenia, String email, String zawod) throws Exception {
        super(listaImion, nazwisko, PESEL, plec, nrTelefonu, adres, dataUrodzenia);

        this.email = email;
        this.zawod = zawod;
        idUczestnik = ++counterUczestnik;
        listOfUbezpieczeni.add(this);

        rodzajKlienta = EnumSet.<RodzajKlienta>of(RodzajKlienta.UBEZPIECZAJACY, RodzajKlienta.UBEZPIECZONY);
    }



    @Override
    public String toString() {
        /*try {
            wyswietlPowiazania("zawarta", System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        if (rodzajKlienta.contains(RodzajKlienta.UBEZPIECZAJACY) &&
                rodzajKlienta.contains(RodzajKlienta.UBEZPIECZONY)) {

            return "Ubezpieczający i Ubezpieczony: " + "\n" + "Ubezpieczający: " +
                    getIdUczestnik() + " Ubezpieczony: " + getIdUczestnik() + "\n" +
                    getFirstName() + " " + (!getSecondName().equals("") ? getSecondName() + " " : "") +
                    getNazwisko();

        } else if (rodzajKlienta.contains(RodzajKlienta.UBEZPIECZAJACY)){
            return "Ubezpieczający: " + getIdUczestnik() + " " + getFirstName() + " "
                    + (!getSecondName().equals("") ? getSecondName() + " " : "") +
                    getNazwisko();

        } else if (rodzajKlienta.contains(RodzajKlienta.UBEZPIECZONY)){
            return "Ubezpieczony: " + getIdUczestnik() + " " + getFirstName() + " "
                    + (!getSecondName().equals("") ? getSecondName() + " " : "") +
                    getNazwisko();
        }
        return null;
    }

    public static void printNajstarszy() {
        Uczestnik ubezpieczony = null;

        for (Uczestnik u : listOfUbezpieczeni){
            if (ubezpieczony == null){
                ubezpieczony = u; }

            if (u.getWiek() > ubezpieczony.getWiek()){
                ubezpieczony = u;
            }
        }
        System.out.println("Najstarszy ubezpieczony to: " + ubezpieczony);
    }



        public String getZawod(){
            return zawod;
        }
        public void setZawod (String zawod){
            this.zawod = zawod;
        }
        public int getIdUczestnik() {
            return idUczestnik;
        }
        public void setIdUczestnik(int idUczestnik){
        if (!idUczestników.containsKey(idUczestnik)){
            this.idUczestnik = idUczestnik;
            idUczestników.put(idUczestnik, this);
        } else throw new IllegalArgumentException("Id Uczestnika już występuje");
    }
        public String getEmail(){
            return email;
        }
        public void setEmail (String email){
            this.email = email;
        }

}

