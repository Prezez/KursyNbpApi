package com.sda.javagda21.Generycznosc.PudelkoNaButy;

public class Main {

    public static void main(String[] args) {

        Buty but1 = new Buty("Szpile");
        Buty but2 = new Buty("Glany");
        Buty but3 = new Buty("Adki");
        Buty but4 = new Buty("Szmaciaki");
        Buty but5 = new Buty("Kalosze");
        Buty but6 = new Buty("Botki");
        Buty but7 = new Buty("Skarpety");
        Buty but8 = new Buty("Kowbojki");

        Pudelko pudelko = new Pudelko<Buty>(but1, but2);

        System.out.println(pudelko);

        PudelkoNaWieleButow pudelkoNaWieleButow = new PudelkoNaWieleButow();

        pudelkoNaWieleButow.dodajButy(but1, but2, but3, but4, but5, but6);
        System.out.println(pudelkoNaWieleButow);
        pudelkoNaWieleButow.dodajButy(but7, but2, but8, but3, but3, but3);
        System.out.println(pudelkoNaWieleButow);


    }
}
