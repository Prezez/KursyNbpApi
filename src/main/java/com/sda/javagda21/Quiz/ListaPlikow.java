package com.sda.javagda21.Quiz;

import lombok.Data;

import java.io.File;
import java.util.*;

@Data
public class ListaPlikow {

    private Map<String, ListaZadanQuizowych> mapaKategorii = new HashMap<>();

    public Map<String, ListaZadanQuizowych> zgromadzWszystkieKategorie () {
        File folder = new File("src/main/resources/pytania/");
        File [] listaPlikow = folder.listFiles();
        String[] listaNazwPlikow = new String[listaPlikow.length];


        for (int i = 0; i < listaPlikow.length; i++) {
            listaNazwPlikow[i] = listaPlikow[i].getName();
            ListaZadanQuizowych listaPytan = new ListaZadanQuizowych();
            listaPytan.wczytajDoListy(listaNazwPlikow[i]);
            mapaKategorii.put(listaNazwPlikow[i], listaPytan);
        }
        return mapaKategorii;
    }

    public List <String> listaKategorii (Map<String, ListaZadanQuizowych> mapka){
        List<String> lista = new ArrayList<>();
        for (Map.Entry<String, ListaZadanQuizowych> wpis : mapka.entrySet()) {
        lista.add(wpis.getKey());
        }
        return lista;
    }
    
    public void wydrukujListeKategorii (List<String> lista)
    {

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ". " + lista.get(i).substring(0, lista.get(i).length()-4));
        }
    }

    public String wydrukujIWybierz (){
        Map<String, ListaZadanQuizowych> mapka = this.zgromadzWszystkieKategorie();
        List <String> lista = listaKategorii(mapka);
        wydrukujListeKategorii(lista);
        return  wybierzKategorie(lista);

    }

    public String wybierzKategorie (List<String> lista) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz kategorię:");
        int wybor = scanner.nextInt();
        return lista.get(wybor);

    }






}
