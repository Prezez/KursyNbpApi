package com.sda.javagda21.Quiz;

import lombok.Data;

import java.util.List;

@Data
public class ZadanieQuizowe {
    private String pytanie;
    private List <String> odpowiedzi;

    public ZadanieQuizowe(String pytanie, List<String> odpowiedzi) {
        this.pytanie = pytanie;
        this.odpowiedzi = odpowiedzi;
    }

    public String prawidlowaOdpowiedz (){
        return odpowiedzi.get(0);
    }


}
