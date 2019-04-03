package com.sda.javagda21.KursyWalut;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static Gson GSON = new Gson();
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public static void main(String[] args) throws IOException {

        double amount = 100.0;
        List<String> listaWalut = new ArrayList(Arrays.asList("CHF", "USD", "GBP", "EUR"));

        for (String lista : listaWalut) {

            String midRate = getMidRate(lista);
            double value = amount / Double.valueOf(midRate);
            System.out.println("Za 100 PLN możesz kupić " + df2.format(value) + " " + lista + " po kursie średnim.");

            LocalDate today = LocalDate.now();
            String todaysDate = formatDate(today);
            String sellRate = getSellRate(lista, todaysDate);
            double sellValue = amount / Double.valueOf(sellRate);
            System.out.println("Za 100 PLN możesz kupić " + df2.format(sellValue) + " " + lista + " po kursie sprzedaży.");

            LocalDate monthAgo = LocalDate.now().minusMonths(1);
            monthAgo = checkIfValidDate(monthAgo);
            String monthBeforeDate = formatDate(monthAgo);
            String sellRateMonthAgo = getSellRate(lista, monthBeforeDate);
            double sellValueMonthAgo = amount / Double.valueOf(sellRateMonthAgo);
            System.out.println("Za 100 PLN możesz kupić " + df2.format(sellValueMonthAgo) + " " + lista + " po kursie sprzedaży miesiąc temu.");
            checkDifference(sellValue, sellValueMonthAgo, lista);

            System.out.println();

        }
    }

    public static String getMidRate(String lista) throws IOException {
        Scanner scanner = getExchangeRates(lista);
        String query = scanner.nextLine();

        MidExchangeRate midExchangeRate = GSON.fromJson(query, MidExchangeRate.class);

        return midExchangeRate.getRates()[0].getMid();
    }

    public static String getSellRate(String lista, String date) throws IOException {
        Scanner scanner = getSellExchangeRates(lista, date);
        String query = scanner.nextLine();

        BuySellExchangeRate sellExchangeRate = GSON.fromJson(query, BuySellExchangeRate.class);

        return sellExchangeRate.getRates()[0].getAsk();
    }


    public static Scanner getExchangeRates(String rateName) throws IOException {

        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/a/" + rateName + "/");
        return new Scanner(url.openStream());
    }

    public static Scanner getSellExchangeRates(String rateName, String date) throws IOException {
        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/c/" + rateName + "/" + date + "/?format=json");
        return new Scanner(url.openStream());

    }

    public static String formatDate(LocalDate date) {
        String correctDate;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        correctDate = date.format(dateTimeFormatter);
        return correctDate;
    }


    public static LocalDate checkIfValidDate(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            date = date.minusDays(1);
            return checkIfValidDate(date);
        }
        return date;
    }

    public static void checkDifference(double currentValue, double previousValue, String currency) {
        String zyskStrata = "wyższy";
        double roznica = currentValue - previousValue;
        if (previousValue > currentValue) {
            zyskStrata = "niższy";
        }

        System.out.println("Dzisiaj kurs jest " + zyskStrata + " niż miesiąc temu o " + df2.format(roznica) + " " + currency);

    }
}
