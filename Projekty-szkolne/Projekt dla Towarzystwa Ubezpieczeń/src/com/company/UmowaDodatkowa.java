package com.company;

import Enumy.ProduktDodaktowy;

import java.io.Serializable;

public class UmowaDodatkowa extends ObjectPlusPlus implements Serializable {

    protected String produkt;
    protected double skladkaUD;


    public UmowaDodatkowa(ProduktDodaktowy produkt, double skladkaUD) {
        super();
        this.produkt = produkt.toString();
        this.skladkaUD = skladkaUD;
    }

    public String getProdukt() {
        return produkt;
    }
    public void setProdukt(String produkt) {
        this.produkt = produkt;
    }
    public double getSkladkaUD() {
        return skladkaUD;
    }
    public void setSkladkaUD(double skladkaUD) {
        this.skladkaUD = skladkaUD;
    }


    public String toString(){
        return "Umowa dodatkowa, produkt " + produkt;
    }

}
