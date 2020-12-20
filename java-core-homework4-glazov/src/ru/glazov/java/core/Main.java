package ru.glazov.java.core;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] words = new String[16];
        words[0] = "один";
        words[1] = "два";
        words[2] = "три";
        words[3] = "четыре";
        words[4] = "пять";
        words[5] = "один";
        words[6] = "три";
        words[7] = "пять";
        words[8] = "шесть";
        words[9] = "пять";
        words[10] = "четыре";
        words[11] = "два";
        words[12] = "один";
        words[13] = "три";
        words[14] = "восемь";
        words[15] = "девять";

        uniqueWords(words);

        uniqueCount(words);
        System.out.println();

        Phonebook phonebook = new Phonebook();
        phonebook.addContact("Ivanov", "123-45-67");
        phonebook.addContact("Petrov", "123-41-23");
        phonebook.addContact("Ivanov", "456-78-90");
        phonebook.addContact("Sidorov", "987-65-43");

        for (Map.Entry o : phonebook.ph_book.entrySet())
        System.out.println(o.getKey() + ": " + o.getValue());
        System.out.println();

        System.out.println("Поиск номера по фамилии");
        phonebook.findContact("Ivanov");
        phonebook.findContact("Petrov");


    }

    private static void uniqueCount(String[] words) {
        Map<String, Integer> uniqueCount = new LinkedHashMap<>();

        for (String x : words) {
            uniqueCount.put(x, uniqueCount.getOrDefault(x, 0) + 1);
        }
        System.out.println(uniqueCount);
    }


    private static void uniqueWords(String[] words) {
        Set<String> uniqueSet = new LinkedHashSet<>();
        for (String s : words) {
            uniqueSet.add(s);
        }

        System.out.println("Кол-во уникальных элементов: " + uniqueSet.size());
        System.out.println(uniqueSet.toString());

    }
}
