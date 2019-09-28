package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.*;

public class ObjectPlusPlus extends ObjectPlus implements Serializable {

    protected Hashtable<String, HashMap<Object, ObjectPlusPlus>> powiazania =
            new Hashtable<String, HashMap<Object, ObjectPlusPlus>>();


    private static HashSet<ObjectPlusPlus> wszystkieCzesci = new HashSet<>();

    public ObjectPlusPlus(){
        super();
    }

    public Agent getStaryAgent(String nazwaRoli){
        HashMap<Object, ObjectPlusPlus> powiazaniaObiektu;

        powiazaniaObiektu = powiazania.get(nazwaRoli);
        Collection col = powiazaniaObiektu.values();
        for (Object object : col) {
            if (object.getClass().getSimpleName().equals("Agent")) {
                return ((Agent) object);
            } else if (object.getClass().getSimpleName().equals("Kierownik")) {
                return ((Kierownik) object);
            }
        }
        return null;
    }

    public void usunPowiazanie(ObjectPlusPlus obiektDocelowy,
                               Object kwalifikator, String nazwaRoli) {

        HashMap<Object, ObjectPlusPlus> powiazanieDoUsuniecia;
        powiazanieDoUsuniecia = powiazania.get(nazwaRoli);

        powiazanieDoUsuniecia.remove(kwalifikator, obiektDocelowy);
    }


    public void dodajPowiazanie(String nazwaRoli, String odwrotnaNazwaRoli, ObjectPlusPlus obiektDocelowy,
                                Object kwalifikator, int licznik){
        HashMap<Object, ObjectPlusPlus> powiazaniaObiektu;

        if (licznik < 1){
            return;
        }
        if (powiazania.containsKey(nazwaRoli)){
            powiazaniaObiektu = powiazania.get(nazwaRoli);
        } else {
            powiazaniaObiektu = new HashMap<>();
            powiazania.put(nazwaRoli, powiazaniaObiektu);
        }

        if (!powiazaniaObiektu.containsKey(kwalifikator)){
            powiazaniaObiektu.put(kwalifikator, obiektDocelowy);
            obiektDocelowy.dodajPowiazanie(odwrotnaNazwaRoli, nazwaRoli, this, this, --licznik);
        }
    }

    public void dodajPowiazanie(String nazwaRoli, String odwrotnaNazwaRoli, ObjectPlusPlus obiektDocelowy,
                                Object kwalifikator){
        dodajPowiazanie(nazwaRoli, odwrotnaNazwaRoli, obiektDocelowy, kwalifikator, 2);
    }

    public void dodajPowiazanie(String nazwaRoli, String odwrotnaNazwaRoli, ObjectPlusPlus obiektDocelowy){
        dodajPowiazanie(nazwaRoli, odwrotnaNazwaRoli, obiektDocelowy, obiektDocelowy);
    }

    public void dodajCzesc(String nazwaRoli, String odwrotnaNazwaRoli, ObjectPlusPlus obiektCzesc)
            throws Exception{
        if (wszystkieCzesci.contains(obiektCzesc)){
            throw new Exception("Ta część jest juz powiazana z całością");
        }
        dodajPowiazanie(nazwaRoli, odwrotnaNazwaRoli, obiektCzesc);
        wszystkieCzesci.add(obiektCzesc);
    }

    public void usunCzesc(ObjectPlusPlus obiektCzesc) throws Exception{
        if(wszystkieCzesci.contains(obiektCzesc)){
            wszystkieCzesci.remove(obiektCzesc);

        } else throw new Exception("Nie ma części");
    }

    public ObjectPlusPlus[] dajPowiazania(String nazwaRoli) throws Exception{
        HashMap<Object, ObjectPlusPlus> powiazaniaObiektu;

        if (!powiazania.containsKey(nazwaRoli)){
            throw new Exception("Brak powiązań dla roli " + nazwaRoli);
        }
        powiazaniaObiektu = powiazania.get(nazwaRoli);
        return (ObjectPlusPlus[]) powiazaniaObiektu.values().toArray(new ObjectPlusPlus[0]);
    }

    public void wyswietlPowiazania(String nazwaRoli, PrintStream stream) throws Exception{
        HashMap<Object, ObjectPlusPlus> powiazaniaObiektu;

        if (!powiazania.containsKey(nazwaRoli)){

            throw new Exception("Brak powiązań dla roli " + nazwaRoli);
        }

        powiazaniaObiektu = powiazania.get(nazwaRoli);
        Collection col = powiazaniaObiektu.values();
        stream.println(this.getClass().getSimpleName() + " powiazania w roli " + nazwaRoli + ":");
        for (Object object : col){
            stream.println("  " + object);
        }
    }

    public ObjectPlusPlus dajPowiazanyObiekt(String nazwaRoli, Object kwalifikator) throws Exception{
        HashMap<Object, ObjectPlusPlus> powiazaniaObiektu;

        if (!powiazania.containsKey(nazwaRoli)){
            throw new Exception("Brak powiązań dla roli " + nazwaRoli);
        }

        powiazaniaObiektu = powiazania.get(nazwaRoli);
        if (!powiazaniaObiektu.containsKey(kwalifikator)){
            throw new Exception("Brak powiązań dla kwalifikatora " + kwalifikator);
        }
        return powiazaniaObiektu.get(kwalifikator);
    }
}
