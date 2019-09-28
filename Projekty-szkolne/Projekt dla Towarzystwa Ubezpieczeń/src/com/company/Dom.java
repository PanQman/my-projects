package com.company;


import java.io.Serializable;

public class Dom extends PolisaOgolne.Nieruchomosci implements Serializable {

    private int iloscPieter;
    private boolean czyMieszkanie;
    private double metraz;
    private String adresDomu;

    public Dom(String adres, double metraz, int iloscPieter, boolean czyMieszkanie) {
        super();
        adresDomu = adres;
        this.metraz = metraz;
        this.iloscPieter = iloscPieter;
        this.czyMieszkanie = czyMieszkanie;
    }

    @Override
    public String toString(){
        return "Dom - Adres: " + adresDomu + "\n" +
                "Metraż: " + metraz + " Ilość pięter: " + iloscPieter +
                "\n"  +
                (czyMieszkanie ? "Mieszkanie" : "Dom");
    }

    public String getAdresDomu() {
        return adresDomu;
    }
    public void setAdresDomu(String adresDomu) {
        this.adresDomu = adresDomu;
    }
    public double getMetraz() {
        return metraz;
    }
    public void setMetraz(double metraz) {
        this.metraz = metraz;
    }
    public int getIloscPieter() {
        return iloscPieter;
    }
    public void setIloscPieter(int iloscPieter) {
        this.iloscPieter = iloscPieter;
    }
    public boolean isCzyMieszkanie() {
        return czyMieszkanie;
    }
    public void setCzyMieszkanie(boolean czyMieszkanie) {
        this.czyMieszkanie = czyMieszkanie;
    }
}
