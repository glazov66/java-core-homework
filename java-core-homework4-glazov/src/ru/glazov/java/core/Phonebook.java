package ru.glazov.java.core;

import java.util.HashMap;
import java.util.HashSet;

public class Phonebook {
    HashMap<String, HashSet<String>> ph_book;

    public Phonebook() {
        this.ph_book = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        HashSet<String> number = ph_book.getOrDefault(name, new HashSet<>());
        number.add(phone);
        ph_book.put(name, number);
    }
    public void findContact(String name){
        ph_book.getOrDefault(name, new HashSet<>());
        System.out.println(name + ph_book.getOrDefault(name, new HashSet<>()));
    }


}
