package ru.glazov.java.core;

public class BoxOperations {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        appleBox.addFruit(new Apple(), 12);
        appleBox2.addFruit(new Apple(), 23);
        orangeBox.addFruit(new Orange(), 8);
        orangeBox2.addFruit(new Orange(), 30);

        System.out.println(appleBox.fruits.size() ); // ПРОВЕРКА
        System.out.println(appleBox.boxWeight());
        System.out.println(orangeBox.boxWeight());
        System.out.println(orangeBox2.boxWeight());

        System.out.println(appleBox.compare(orangeBox));

        orangeBox.replace(orangeBox2);
        System.out.println(orangeBox2.fruits.size());
        System.out.println(orangeBox.fruits.size());




    }
}
