package com.company;

import java.io.Serializable;

public class Dom_i_Gospodarstwo extends Gospodarstwo implements Serializable {

    private int iloscPieter;
    private boolean czyMieszkanie;
    private double metraz;
    private String adresDomu;

    public Dom_i_Gospodarstwo(String adresDomu, double metraz,
                              int iloscPieter, boolean czyMieszkanie, String adresGospodarstwa,
                              double powierzchnia) {
        super(adresGospodarstwa, powierzchnia);
        this.adresDomu = adresDomu;
        this.metraz = metraz;
        this.iloscPieter = iloscPieter;
        this.czyMieszkanie = czyMieszkanie;
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
    public String getAdresDomu() {
        return adresDomu;
    }
    public void setAdresDomu(String adresDomu) {
        this.adresDomu = adresDomu;
    }

    @Override
    public String toString(){
        return "Dom i Gospodarstwo - Adres domu: " + adresDomu + "\n" +
                "Metraż: " + metraz + " Ilość pięter: " + iloscPieter +
                "\n" + (czyMieszkanie ? "Mieszkanie" : "Dom") + "\n" +
                "Gospodarstwo - Adres: " + adresGospodarstwa + "\n"
                + "Powierzchnia: " + powierzchnia + "\n"
                + (!polaUprawne.isEmpty() ? polaUprawne : "");
    }

}
