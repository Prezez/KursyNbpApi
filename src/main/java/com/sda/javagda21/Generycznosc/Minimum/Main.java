package com.sda.javagda21.Generycznosc.Minimum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List listaLiczb = new ArrayList(Arrays.asList(9, 2, 7, 18, 4));
        System.out.println(findMinimum(listaLiczb));
    }

    private static <T extends Number & Comparable> T findMinimum(List<T> lista) {
        T minimum = lista.get(0);

        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i).compareTo(minimum) < 0) {
                minimum = lista.get(i);
            }
        }

        return minimum;
    }
}
