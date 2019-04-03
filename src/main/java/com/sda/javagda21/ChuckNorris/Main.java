package com.sda.javagda21.ChuckNorris;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final String URL_SITE = "https://api.chucknorris.io/jokes/random";
    private static final Gson GSON = new Gson();

    public static void main(String[] args) throws IOException {

        String[] listaJokeow = new String[10];


        Random random = new Random();
        boolean repeated = false;

        for (int i = 0; i < 10; i++) {

            String query = getQueryFromSite();

            Joke joke = GSON.fromJson(query, Joke.class);

            listaJokeow[i] = joke.value;

            for (int j = 0; j < i; j++) {
                if (listaJokeow[j].equalsIgnoreCase(listaJokeow[i])) {
                    repeated = true;
                }
            }

            if (repeated) {
                i--;
                repeated = false;
            } else {
                System.out.println(i + 1 + ". " + listaJokeow[i]);
            }
        }
    }

    public static String getQueryFromSite() throws IOException {

        URLConnection connection = new URL(URL_SITE).openConnection();
        connection.addRequestProperty("User-Agent", "Chrome");
        Scanner scanner = new Scanner(connection.getInputStream());
        return scanner.nextLine();
    }
}
