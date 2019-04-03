package com.sda.javagda21.Generycznosc.PudelkoNaButy;


import lombok.Data;

@Data
public class Pudelko <T extends Buty>{
    public T but1;
    public T but2;

    public Pudelko(T but1, T but2) {
        this.but1 = but1;
        this.but2 = but2;
    }

}
