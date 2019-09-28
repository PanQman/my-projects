package com.company;

import java.io.Serializable;
import java.util.Vector;

public class Gospodarstwo extends PolisaOgolne.Nieruchomosci implements Serializable {

    protected Vector<PoleUprawne> polaUprawne = new Vector<>();
    protected double powierzchnia;
    protected String adresGospodarstwa;


    public Gospodarstwo(String adres, double powierzchnia) {
        super();
        adresGospodarstwa = adres;
        this.powierzchnia = powierzchnia;
    }

    public PoleUprawne dodajPole(String powierzchnia, String obreb, String nrdzialki){

        PoleUprawne pole = new PoleUprawne(powierzchnia, obreb, nrdzialki);
        polaUprawne.add(pole);
        return pole;
    }

    public void usunPole(Gospodarstwo.PoleUprawne p1) throws Exception {
        polaUprawne.remove(p1);
        usunCzesc(p1);
    }


    @Override
    public String toString(){
        return "Gospodarstwo - Adres: " + adresGospodarstwa + "\n"
                + "Powierzchnia: " + powierzchnia + "\n"
                + (!polaUprawne.isEmpty() ? polaUprawne : "");
    }


    public class PoleUprawne extends ObjectPlusPlus {

        protected String nazwaPola;
        protected String powierzchnia;
        protected String obreb;
        protected String nrdzialki;

        public PoleUprawne(String powierzchnia, String obreb, String nrdzialki) {
            super();
            this.nazwaPola = "Pole uprawne:";
            this.powierzchnia = powierzchnia;
            this.obreb = obreb;
            this.nrdzialki = nrdzialki;
        }

        @Override
        public String toString() {
            return nazwaPola + " " + "powierzchnia pola w metrach: " + powierzchnia +
                    " obreb: " + obreb + "\n" + "dzialka nr: " + nrdzialki + "\n";
        }
    }
}
