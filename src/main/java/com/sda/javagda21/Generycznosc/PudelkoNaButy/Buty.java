package com.sda.javagda21.Generycznosc.PudelkoNaButy;


import lombok.Data;

@Data
public class Buty {

    private String nazwa;

    public Buty(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
