package com.sda.javagda21.Quiz;

import lombok.Data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

@Data
public class ListaZadanQuizowych {
    private List<ZadanieQuizowe> listaZadanQuizowych;

    public List<ZadanieQuizowe> wczytajDoListy(String nazwaPliku) {

        listaZadanQuizowych = new ArrayList<>();
        int licznik = 0;

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src/main/resources/pytania/" + nazwaPliku);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(fileReader);

        while (scanner.hasNextLine()) {
            String pytanie = scanner.nextLine();
            int iloscOdpowiedzi = Integer.valueOf(scanner.nextLine());
            List<String> listaOdpowiedzi = new ArrayList<>();
            for (int i = 0; i < iloscOdpowiedzi; i++) {
                listaOdpowiedzi.add(i, scanner.nextLine());
            }
            ZadanieQuizowe zadanieQuizowe = new ZadanieQuizowe(pytanie, listaOdpowiedzi);
            listaZadanQuizowych.add(zadanieQuizowe);
        }
        return listaZadanQuizowych;
    }

    public ZadanieQuizowe wylosujPytanie() {
        Random random = new Random();

        int liczbaPytan = listaZadanQuizowych.size();
        int pozycjaLosowegoPytania = random.nextInt(liczbaPytan);
        ZadanieQuizowe pytanie = listaZadanQuizowych.get(pozycjaLosowegoPytania);

        return pytanie;
    }

    public List<String> wypiszPytanie(ZadanieQuizowe pytanie) {

        System.out.println(pytanie.getPytanie());
        System.out.println("Odpowiedzi:");

        List<String> odpowiedzi = pytanie.getOdpowiedzi();
        List<String> odpowiedziPomieszane = new ArrayList<>(pytanie.getOdpowiedzi());
        Collections.shuffle(odpowiedziPomieszane);

        for (int i = 0; i < odpowiedzi.size(); i++) {
            System.out.println(i + 1 + ". " + odpowiedziPomieszane.get(i));
        }

        return odpowiedziPomieszane;
    }

    public int czyToDobraOdpowiedz (ZadanieQuizowe pytanie, String odpowiedz){
        if (pytanie.prawidlowaOdpowiedz().equals(odpowiedz))
        {
            System.out.println("Poprawna odpowiedź");
            return 1;
        }
        else {
            System.out.println("Błędna odpowiedź");
            return 0;
        }
    }

    public Set <ZadanieQuizowe> wylosujSetPytan (int iloscPytan){
        Set <ZadanieQuizowe> setPytan = new HashSet<>();

        while (setPytan.size()<iloscPytan) {
            ZadanieQuizowe pytanie = wylosujPytanie();
            setPytan.add(pytanie);
        }
        return setPytan;
    }

    public int zadajPytanieISprawdzOdpowiedzi (int iloscPytan){
        Scanner scanner = new Scanner(System.in);
        int wynik = 0;
        Set <ZadanieQuizowe> setPytan = wylosujSetPytan(iloscPytan);

        for (ZadanieQuizowe pytanie : setPytan) {

        List<String> losoweOdpowiedzi = wypiszPytanie(pytanie);
        int wybor = scanner.nextInt();
        String odpowiedz = losoweOdpowiedzi.get(wybor-1);
        wynik += czyToDobraOdpowiedz(pytanie, odpowiedz);
        }

        return wynik;
    }

    public void graj (int liczbaPytan) {
        ListaPlikow listaPlikow = new ListaPlikow();
        String kategoria = listaPlikow.wydrukujIWybierz();
        this.wczytajDoListy(kategoria);
        int liczbaPunktow = 0;

            liczbaPunktow += zadajPytanieISprawdzOdpowiedzi(liczbaPytan);



        System.out.println("Twoja liczba punktów to: " + liczbaPunktow);
    }

}
