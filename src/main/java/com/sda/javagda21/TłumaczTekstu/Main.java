package com.sda.javagda21.TłumaczTekstu;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.errors.APIError;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException, APIError {
        DetectLanguage.apiKey = "672ae5693d42a2625f2b2ffd6cfeb42f";
        String language = "";

        for (String lista : znajdzNazwyPlikow()) {
            String fileName = lista;
            System.out.println(fileName);

            FileReader fileReader = new FileReader("src/main/resources/" + lista);
            Scanner scanner = new Scanner(fileReader);
            String tekst = "";
//            TODO:
//            StringBuilder stringBuilder = new StringBuilder();
//            pokombinować z tym można oraz wyodrębnić metodę na to

            while (scanner.hasNextLine()) {
                tekst += scanner.nextLine();
            }

            language = DetectLanguage.simpleDetect(tekst);

            System.out.println(language);
            Locale locale = new Locale(language);
            System.out.println("locale: "+locale.getDisplayLanguage());
            System.out.println("locale in locale: "+locale.getDisplayLanguage(locale));
            System.out.println();
        }
    }

    public static String[] znajdzNazwyPlikow() {
        File folder = new File("src/main/resources/");
        File[] listOfFiles = folder.listFiles();

        String[] listaNazwPlikow = new String[listOfFiles.length];

        for (int i = 0; i < listOfFiles.length; i++) {
            listaNazwPlikow[i] = listOfFiles[i].getName();
        }
        return listaNazwPlikow;
    }
}
