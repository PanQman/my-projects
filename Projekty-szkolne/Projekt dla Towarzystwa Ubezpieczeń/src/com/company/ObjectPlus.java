package com.company;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Vector;

public class ObjectPlus implements Serializable  {

    protected static Hashtable ekstensje = new Hashtable();
    protected static HashMap<String, Osoba> nrPesel = new HashMap<>();
    protected static HashMap<Integer, Osoba> nrAgentów = new HashMap<>();
    protected static HashMap<Integer, Osoba> nrKierownikow= new HashMap<>();
    protected static HashMap<Integer, Osoba> nrKontraktorów= new HashMap<>();
    protected static HashMap<Integer, Osoba> idUczestników = new HashMap<>();
    protected static HashMap<Integer, Polisa> polisy = new HashMap<>();

    public ObjectPlus(){
        Vector ekstensja = null;
        Class klasa = this.getClass();

        if (ekstensje.containsKey(klasa)){
            ekstensja = (Vector) ekstensje.get(klasa);

        }else {
            ekstensja = new Vector();
            ekstensje.put(klasa, ekstensja);
        }
        ekstensja.add(this);
    }

    public static void saveEkstensje(ObjectOutputStream stream) throws IOException {
        stream.writeObject(ekstensje);
    }

    public static void loadEkstensje(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        ekstensje = (Hashtable) stream.readObject();
    }

    public static void loadEkstensje(Class klasa, HashMap<Integer, Polisa> polisy) throws Exception{
        Vector ekstensja = null;

        if (ekstensje.containsKey(klasa)){
            ekstensja = (Vector) ekstensje.get(klasa);
        } else {
            throw new Exception("Nieznana klasa " + klasa);
        }
        for (Object object : ekstensja) {
            polisy.put(  ((Polisa)object).getNrPolisy(), ((Polisa) object) );
        }
    }

    public static LinkedHashMap<Integer, Agent> loadAgenci(LinkedHashMap<Integer, Agent> agents){
        Vector ekstensja = null;

        if (ekstensje.containsKey(Agent.class)){
            ekstensja = (Vector) ekstensje.get(Agent.class);

            for (Object object : ekstensja) {
                agents.put(((Agent) object).getNrAgenta(), ((Agent) object));
            }
        }

        if (ekstensje.containsKey(Kierownik.class)) {
            ekstensja = (Vector) ekstensje.get(Kierownik.class);

            for (Object object : ekstensja) {
                agents.put(  ((Kierownik)object).getNrAgenta(), ((Kierownik) object) );
            }
        }

        return agents;
    }
}


