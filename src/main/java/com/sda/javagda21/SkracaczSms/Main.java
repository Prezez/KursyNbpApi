package com.sda.javagda21.SkracaczSms;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String zdanie = scanner.nextLine();
        String tresc = "";

        String[] tabelaSlow = zdanie.split("[a-z]");

        for (int i = 0; i < tabelaSlow.length; i++) {

            if (tabelaSlow[i].isEmpty()) {
                continue;
            }
            String firstLetter = tabelaSlow[i].substring(0, 1).toUpperCase();
            String rest = tabelaSlow[i].substring(1).toLowerCase();
            tresc = tresc.concat(firstLetter).concat(rest);
        }

        System.out.println(tresc);

        System.out.println(tresc.length());
        System.out.println();
        int iloscSms = 0;

        if (tresc.length() > 0 & tresc.length() <= 160) {
            iloscSms = 1;
        } else {
            iloscSms = ((tresc.length() - 1) / 153) + 1;
//            int temp = tresc.length()-153;
//            int reszta = temp%153;
//            iloscSms = ((temp - reszta)/153)+2;
        }


        System.out.println();
        System.out.println(iloscSms);


    }
}


/* 1-160 znaków = 1 zbilingowany SMS
161-306 znaków = 2 zbilingowane SMSy
307-459 znaków = 3 zbilingowane SMSy
460-612 znaków  = 4 zbilingowane SMSy
613-765 znaków = 5 zbilingowanych SMSów
766-918 znaków = 6 zbilingowanych SMSów
919-1071 znaków = 7 zbilingowanych SMSów
1072-1224 znaków = 8 zbilingowanych SMSów
1225-1377 znaków = 9 zbilingowanych SMSów
*/