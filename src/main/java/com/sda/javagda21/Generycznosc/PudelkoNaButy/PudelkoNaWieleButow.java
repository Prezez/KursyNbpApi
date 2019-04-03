package com.sda.javagda21.Generycznosc.PudelkoNaButy;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PudelkoNaWieleButow<T extends Buty> {
    private List<T> listaButow = new ArrayList<T>();


    public void dodajButy(T... paraButow) {
        int iloscElementow = paraButow.length;


        for (int i = 0; i < iloscElementow; i++) {
            listaButow.add(paraButow[i]);
        }
    }
}
