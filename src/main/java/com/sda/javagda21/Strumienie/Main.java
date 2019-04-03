package com.sda.javagda21.Strumienie;

import javax.xml.crypto.Data;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(DataCollections.getSurnames());
        System.out.println(DataCollections.getLoremIpsum());
        System.out.println(DataCollections.getNumbers(10));
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println();

        System.out.println(DataCollections.getSurnames().stream()
                .filter(nazwisko -> nazwisko.length() <= 4)
                .map(String::toUpperCase)
                .collect(Collectors.toList()));
        System.out.println();

        System.out.println(DataCollections.getSurnames().stream()
                .filter(nazwisko -> nazwisko.startsWith("B"))
                .collect(Collectors.toList()));
        System.out.println();

        System.out.println(DataCollections.getSurnames().stream()
                .map(nazwisko -> nazwisko.substring(0, 3).toLowerCase())
                .distinct()
                .collect(Collectors.toList()));
        System.out.println();

        System.out.println(DataCollections.getSurnames().stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(10)
                .collect(Collectors.toList()));
        System.out.println();

        System.out.println(DataCollections.getSurnames().stream()
                .sorted(Comparator.comparing(String::length).reversed().thenComparing(nazwisko -> nazwisko))
                .limit(10)
                .collect(Collectors.toList()));
        System.out.println();


        System.out.println(DataCollections.getSurnames().stream()
                .sorted(Comparator.comparing(String::length))
                .limit(20)
                .sorted(Comparator.comparing(nazwisko -> nazwisko.charAt(nazwisko.length() - 1)))
                .collect(Collectors.toList()));
        System.out.println();

        System.out.println(DataCollections.getSurnames().stream()
                .map(nazwisko -> new StringBuilder(nazwisko).reverse().toString())
                .filter(nazwisko -> nazwisko.substring(0, 3).toLowerCase().contains("a"))
                .collect(Collectors.toList()));
        System.out.println();

        System.out.println(DataCollections.getNumbers(10000).stream()
                .filter(liczba -> liczba % 2 == 0)
                .count());

        System.out.println(DataCollections.getNumbers(10000).stream()
                .filter(liczba -> liczba >= 10000 && liczba <= 99999)
                .count());

        DataCollections.getNumbers(10000).stream()
                .min(Integer::compareTo);

        System.out.println(DataCollections.getNumbers(10000).stream()
                .mapToInt(i -> i)
                .summaryStatistics());

        DataCollections.getNumbers(10000).stream()
                .sorted(Integer::compareTo)
                .limit(5001)
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());

    }


}
