package com.company;

import Enumy.*;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class Main extends ObjectPlusPlus implements Serializable {

    private static ArrayList<String> listaImion = new ArrayList<>();
    private static Integer licznikZycia = 290;
    private static Integer licznikOgolu = 431;
    private static Integer licznikDodatkowy = 68;

    private static HashMap<Integer, Polisa> polisy = new HashMap<>();
    private static LinkedHashMap<Integer, Agent> agenci = new LinkedHashMap<>();
    private static Polisa znalezionaPolisa;
    private static NewJFrame njf;
    private static Agent agent;
    private static int nrAgenta = 12332;
    private File file;

    public static void main(String[] args) throws Exception {
        new Main();
    }
        private Main() throws Exception {
            file = new File("C:\\Users\\Adam\\Desktop\\SZP.bin");

            if (file.isFile()) {
                loadEkstensje(new ObjectInputStream(new FileInputStream(file)));
                loadEkstensje(PolisaOgolne.class, polisy);
                loadEkstensje(PolisaZycie.class, polisy);
                loadEkstensje(Pojazd.class, polisy);
                loadEkstensje(MaszynaRolnicza.class, polisy);

                //loadAgenci(agenci);

        } else utworzPolisy();

            njf = new NewJFrame(this);
            njf.setVisible(true);
    }

    //20091, 20095, 232, 234
    public Polisa szukajPolisy(Integer i){

        znalezionaPolisa = polisy.get(i);
        agent = znalezionaPolisa.getStaryAgent("zawarta pomiędzy");

        if (nrAgenta == agent.getNrAgenta()){
            return znalezionaPolisa;
        } else
            throw new IllegalArgumentException("Agent nie jest przypisany do tej polisy");
    }

    public static Agent twojAgent(){
        return agent;
    }

    public static void dostepniAgenci(JTextArea jTextArea1) throws Exception {
        try {
            znalezionaPolisa.wyswietlAgentow(jTextArea1, agent);
        } catch (NullPointerException e){
            jTextArea1.append("Wyszukiwanie dostępnych agentów dostępne dopiero po wybraniu nr polisy\n");
        }
    }

    public static void zmienAgenta(int newAgent) throws Exception {

        znalezionaPolisa.usunAgenta(agent);
        agent = (Agent)Agent.podajListęAgentów().get(newAgent);

        znalezionaPolisa.dodajAgenta(agent);
        saveEkstensje(new ObjectOutputStream(new FileOutputStream
                ("C:\\Users\\Adam\\Desktop\\SZP.bin")));
    }

    public static void utworzPolisy() throws Exception {


        //Ubezpieczający *************************************************
        listaImion.addAll(Arrays.asList("Adam"));
        Uczestnik u1 = new Uczestnik(listaImion, "Kowalski", "939414941", true,
                "5129329391", "Marki, ul. Jakaś 24E", "", LocalDate.of(1990, 10, 21));
        listaImion.clear();

        listaImion.addAll(Arrays.asList("Ewa", "Marta"));
        Uczestnik u2 = new Uczestnik(listaImion, "Ciechan", "834248851", false,
                "", "Wyszków, ul. Gromowładna 293", "skokcosa@test.org", LocalDate.of(1960, 2, 19));
        listaImion.clear();

        listaImion.addAll(Arrays.asList("Kamil"));
        Uczestnik u3 = new Uczestnik(listaImion, "Zdybula", "995281844", true,
                "123893124", "Warszawa, ul. Ziemowita 29E", "bily@microsoft.com", LocalDate.of(1994, 10, 7));
        listaImion.clear();

        listaImion.addAll(Arrays.asList("Maciek", "Michał"));
        Uczestnik u4 = new Uczestnik(listaImion, "Ptyś", "9238823828", true,
                "0239182424", "Radzymin, ul. Wołomińska 93", "amazon@az.pl", LocalDate.of(1997, 3, 1));
        listaImion.clear();

        listaImion.addAll(Arrays.asList("Krzysztof"));
        Uczestnik u5 = new Uczestnik(listaImion, "Kowal", "823148141", true,
                "9239883131", "Wrocłąw, ul. Nudna 90", "fsdomivmds@wp.pl", LocalDate.of(1969, 11, 21));
        listaImion.clear();

        listaImion.addAll(Arrays.asList("Marlena"));
        Uczestnik u6 = new Uczestnik(listaImion, "Cieślak", "758249414", false,
                "", "Ossów, ul. Ustna 10", "dfkamo@wp.pl", LocalDate.of(2000, 2, 1));
        listaImion.clear();

        //Ubezpieczeni *************************************************

        listaImion.addAll(Arrays.asList("Karol", "Adam"));
        Uczestnik ub1 = new Uczestnik(listaImion, "Osąćxzc", "3812837414", true,
                "5129329391", "Warszawa, ul. Jugosłowacka 98", LocalDate.of(1971, 4, 11),
                "Tester");
        listaImion.clear();

        listaImion.addAll(Arrays.asList("Merlin", "Janusz"));
        Uczestnik ub2 = new Uczestnik(listaImion, "Posłąś", "8919865322", true,
                "9029130138", "Marki, ul. Szkolna 2A", LocalDate.of(1997, 7, 10),
                "Kierowca");
        listaImion.clear();

        listaImion.addAll(Arrays.asList("Łucja"));
        Uczestnik ub3 = new Uczestnik(listaImion, "Milanowska", "8975121311", false,
                "0938123123", "Chełm, al. Chełmżyńska 7", LocalDate.of(1960, 11, 30),
                "Student");
        listaImion.clear();

        listaImion.addAll(Arrays.asList("Grażyna", "Bożena"));
        Uczestnik ub4 = new Uczestnik(listaImion, "Paź", "8852155632", false,
                "1238742713", "InoWrocław, ul. Kopernika 12D", LocalDate.of(1991, 5, 13),
                "Bezrobotny");
        listaImion.clear();

        listaImion.addAll(Arrays.asList("Grzegorz"));
        Uczestnik ub5 = new Uczestnik(listaImion, "Bąkałą", "8798415212", true,
                "4829371244", "Warszawa, ul. KEN 290", LocalDate.of(2000, 8, 18),
                "Developer");
        listaImion.clear();

        listaImion.addAll(Arrays.asList("Vigor"));
        Uczestnik ub6 = new Uczestnik(listaImion, "Jasiński", "9632587415", true,
                "23828742198", "Warszawa, ul. Czarna 41K", LocalDate.of(1976, 6, 30),
                "Tester");
        listaImion.clear();

        listaImion.addAll(Arrays.asList("Bogusław"));
        Uczestnik uu1 = new Uczestnik(listaImion,
                "Skorupka", "8284192383", true, "391941941294",
                "Warszawa, ul. Stawki 29E", LocalDate.of(1956, 8, 13),
                "DevOps", "boguslaw@microsoft.com");
        listaImion.clear();

        listaImion.addAll(Arrays.asList("Jerzy"));
        Uczestnik uu2 = new Uczestnik(listaImion,
                "Zięba", "9818248141", true, "3941929133",
                "Lublin, al. Poniatowska 41C", LocalDate.of(1979, 10, 20),
                "Budowlaniec", "jerzy@microsoft.com");
        listaImion.clear();

        // Agenci i Kontraktorzy *************************************************
        listaImion.addAll(Arrays.asList("Maciej"));
        Osoba a1 = new Agent(listaImion, "Nawałka", "6793911921", true, "592203918",
                "Warszawa, ul. Inflacka 4B", LocalDate.of(1971, 1, 22), 12332);
        listaImion.clear();

        listaImion.addAll(Arrays.asList("Ewa"));
        Osoba a2 = new Agent(listaImion, "Laskowska", "7293211431", false, "751293301",
                "Warszawa, ul. Inflacka 4B", LocalDate.of(1991, 4, 14), 12333);
        listaImion.clear();

        listaImion.addAll(Arrays.asList("Sebastian"));
        Osoba kierownik = new Kierownik(listaImion, "Parówa", "928831233", true, "751293301",
                "Warszawa, ul. Inflacka 4B", LocalDate.of(1991, 4, 14), 12318, 63);
        listaImion.clear();

        listaImion.addAll(Arrays.asList("Majka"));
        Osoba kontraktor = new Kontraktor(listaImion, "Czarnecka", "928318232", false, "92831831",
                "Kraków, ul. Smogowa 2", LocalDate.of(1985, 9, 15), 9921);

        //Dziedziczenie wieloaspektowe *************************************************

        Pojazd polisaO1 = new Pojazd(231, 10000, StatusPolisy.CZYNNA, 130.01,
                CzestotliwoscSkladek.MIESIECZNA, LocalDate.of(2000, 2, 20),
                LocalDate.of(2100, 2, 20), licznikOgolu++, 3218.99,
                "WWL 88231", "OPEL", "Astra", 1999, false, 300000, RodzajPojazdu.SAMOCHOD);

        MaszynaRolnicza polisaO2 = new MaszynaRolnicza(232, 20000, StatusPolisy.CZYNNA, 600,
                CzestotliwoscSkladek.KWARTALNA, LocalDate.of(2007, 5, 30),
                LocalDate.of(2107, 5, 29), licznikOgolu++, 173900.15,
                "Kombajn zbożowy", 1998, "CLAAS");

        PolisaOgolne polisaO4 = new PolisaOgolne(234, 100000, StatusPolisy.CZYNNA, 69.85,
                CzestotliwoscSkladek.MIESIECZNA, LocalDate.of(2012, 8, 5),
                LocalDate.of(2030, 1, 28), licznikOgolu++, 40020.06);

        PolisaOgolne polisaO5 = new PolisaOgolne(235, 180000, StatusPolisy.CZYNNA, 2087.03,
                CzestotliwoscSkladek.ROCZNA, LocalDate.of(2019, 3, 1),
                LocalDate.of(2119, 2, 28), licznikOgolu++, 240_000);//Wielodziedziczenie

        PolisaZycie polisaZ1 = new PolisaZycie(20091, 12000, StatusPolisy.CZYNNA, 99.99,
                CzestotliwoscSkladek.MIESIECZNA, LocalDate.of(1989, 4, 21),
                LocalDate.of(2089, 12, 12), WariantUbez.PODSTAWOWY, licznikZycia++);
        PolisaZycie polisaZ2 = new PolisaZycie(20092, 20000, StatusPolisy.CZYNNA, 108.73,
                CzestotliwoscSkladek.MIESIECZNA, LocalDate.of(2000, 10, 19),
                LocalDate.of(2028, 10, 18), WariantUbez.PLATYNOWY, licznikZycia++);
        PolisaZycie polisaZ3 = new PolisaZycie(20093, 40000, StatusPolisy.CZYNNA, 45,
                CzestotliwoscSkladek.MIESIECZNA, LocalDate.of(2015, 5, 31),
                LocalDate.of(2020, 5, 30), WariantUbez.ROZSZERZONY, licznikZycia++);

        PolisaZycie polisaZ5 = new PolisaZycie(20095, 9000, StatusPolisy.ZAWIESZONA, 760.64,
                CzestotliwoscSkladek.KWARTALNA, LocalDate.of(2017, 6, 9),
                LocalDate.of(2021, 6, 8), WariantUbez.ROZSZERZONY, licznikZycia++);

        UmowaDodatkowa ud1 = new UmowaDodatkowa(ProduktDodaktowy.NNW, 9.10);
        UmowaDodatkowa ud2 = new UmowaDodatkowa(ProduktDodaktowy.WPODROZY, 47.98);

        //Asocjacje *************************************************
        polisaZ1.dodajPowiazanie("zawarta pomiędzy", "zawarta", u1);
        polisaZ1.dodajPowiazanie("zawarta pomiędzy", "zawarta", ub1);
        polisaZ1.dodajPowiazanie("zawarta pomiędzy", "zawarta", a1);

        polisaZ2.dodajPowiazanie("zawarta pomiędzy", "zawarta", u2);
        polisaZ2.dodajPowiazanie("zawarta pomiędzy", "zawarta", ub2);
        polisaZ2.dodajPowiazanie("zawarta pomiędzy", "zawarta", kierownik);

        //Asocjacja kwalifikowana *************************************************
        polisaZ2.dodajPowiazanie("z umową dodatkową", " umowa dodatkowa do ",
                ud1, licznikDodatkowy);
        polisaZ2.dodajUmoweDodatkowa(licznikDodatkowy, ud1);
        licznikDodatkowy++;
        polisaZ2.dodajPowiazanie("z umową dodatkową", " umowa dodatkowa do ",
                ud2, licznikDodatkowy);
        polisaZ2.dodajUmoweDodatkowa(licznikDodatkowy, ud2);
        licznikDodatkowy++;

        polisaZ3.dodajPowiazanie("zawarta pomiędzy", "zawarta", uu1);
        polisaZ3.dodajPowiazanie("zawarta pomiędzy", "zawarta", a2);
        polisaZ3.dodajPowiazanie("z umową dodatkową", " umowa dodatkowa do ",
                ud2, licznikDodatkowy);
        polisaZ3.dodajUmoweDodatkowa(licznikDodatkowy, ud2);
        licznikDodatkowy++;

        polisaO1.dodajPowiazanie("zawarta pomiędzy", "zawarta", u3);
        polisaO1.dodajPowiazanie("zawarta pomiędzy", "zawarta", ub3);
        polisaO1.dodajPowiazanie("zawarta pomiędzy", "zawarta", kontraktor);

        polisaO2.dodajPowiazanie("zawarta pomiędzy", "zawarta", u4);
        polisaO2.dodajPowiazanie("zawarta pomiędzy", "zawarta", ub4);
        polisaO2.dodajPowiazanie("zawarta pomiędzy", "zawarta", a1);

        polisaO4.dodajPowiazanie("zawarta pomiędzy", "zawarta", u6);
        polisaO4.dodajPowiazanie("zawarta pomiędzy", "zawarta", ub6);
        polisaO4.dodajPowiazanie("zawarta pomiędzy", "zawarta", a1);

        //Wielodziedziczenie *************************************************
        polisaO5.dodajPowiazanie("zawarta pomiędzy", "zawarta", u5);
        polisaO5.dodajPowiazanie("zawarta pomiędzy", "zawarta", ub5);
        polisaO5.dodajPowiazanie("zawarta pomiędzy", "zawarta", a2);

        polisaO4.dodajGospodarstwo("Niegów, ul. Handlowa 20", 987.91);

        //Wielodziedziczenie *************************************************
        polisaO5.dodajDomIGospodarstwo("Łomża ul. Stracona 22", 141.11, 2, false,
                "Wieś Wsiowa 23", 2500.00);


        //Kompozycja *************************************************

        Gospodarstwo.PoleUprawne pole1 = polisaO4.gosp.dodajPole("3500", "4-11-63", "3");
        Gospodarstwo.PoleUprawne pole4 = polisaO5.dom_i_gospodarstwo.dodajPole("2000", "2-12-91", "2");

        polisaO4.gosp.dodajCzesc("Obiekt Całość-część", "Obiekt Część-całość", pole1);
        polisaO5.dom_i_gospodarstwo.dodajCzesc("Obiekt Całość-część", "Obiekt Część-całość", pole4);
        //Wielodziedziczenie ***********************************

        polisaO4.gosp.usunPole(pole1);//kompozycja - usunięcie części *************************************

        Gospodarstwo.PoleUprawne pole2 =polisaO4.gosp.dodajPole("1400", "3-13-15", "188");
        polisaO4.gosp.dodajCzesc("Obiekt Całość-część", "Obiekt Część-całość", pole2);

        Gospodarstwo.PoleUprawne pole3 =polisaO4.gosp.dodajPole("2400", "2-14-11", "191");
        polisaO4.gosp.dodajCzesc("Obiekt Całość-część", "Obiekt Część-całość", pole3);

        //Asocjacja z atrybutem
        polisaO1.dodajWplate(LocalDate.of(2018, 4, 15), 80);
        polisaO1.dodajWplate(LocalDate.of(2018, 5, 15), 80);

        //Dziedziczenie dynamiczne - zmiana stanowiska
        //a1 = ((Agent) a1).zostanKontraktorem(a1, 2213);
        //Utworzone na potrzeby miniprojektu

        polisaZ5.dodajPowiazanie("zawarta pomiędzy", "zawarta", uu2);
        polisaZ5.dodajPowiazanie("zawarta pomiędzy", "zawarta", a1);

        polisy.put(polisaO1.getNrPolisy(), polisaO1);
        polisy.put(polisaO2.getNrPolisy(), polisaO2);
        polisy.put(polisaO4.getNrPolisy(), polisaO4);
        polisy.put(polisaO5.getNrPolisy(), polisaO5);
        polisy.put(polisaZ1.getNrPolisy(), polisaZ1);
        polisy.put(polisaZ2.getNrPolisy(), polisaZ2);
        polisy.put(polisaZ3.getNrPolisy(), polisaZ3);
        polisy.put(polisaZ5.getNrPolisy(), polisaZ5);

        //znalezionaPolisa = polisy.get(2);

        saveEkstensje(new ObjectOutputStream(new FileOutputStream
                ("C:\\Users\\Adam\\Desktop\\SZP.bin")));
    }

}

