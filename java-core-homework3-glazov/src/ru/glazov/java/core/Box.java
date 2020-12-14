package ru.glazov.java.core;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    ArrayList<Fruit> fruits = new ArrayList<Fruit>();

    public void addFruit(T fruit, int quantity) {
        for (int i = 0; i < quantity; i++) {
            fruits.add(fruit);
        }
    }

    public float boxWeight() {
        float boxWeight = 0.0f;
        for (Fruit o : fruits) {
            boxWeight += o.getWeight();
        }
        return boxWeight;
    }

    public boolean compare(Box anotherBox) {
        if (boxWeight() == anotherBox.boxWeight()) return true;
        return false;
    }

    public void replace(Box<T> anotherBox) {
        anotherBox.fruits.addAll(fruits);
        fruits.clear();
    }


}






