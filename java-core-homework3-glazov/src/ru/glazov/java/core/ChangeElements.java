package ru.glazov.java.core;

import java.util.Arrays;

public class ChangeElements {

    public static void main(String[] args) {

        Integer[] arrayOne = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] arrayTwo = {"раз", "два", "три", "четыре", "пять"};

        changeElements(arrayOne);
        changeElements(arrayTwo);
    }

    private static void changeElements(Object[] array) {
        int numOne = (int) (Math.random() * array.length);

        int numTwo = (int) (Math.random() * array.length);
        if (numTwo == numOne) {
            numTwo += numOne;
            if (numTwo > array.length) {
                numTwo = numOne - 2;
            }
        }

        System.out.println("Массив " + array.getClass().getSimpleName());

        System.out.println("Меняем " + (numOne + 1) + "-й элемент на " + (numTwo + 1) + "-й"); // Для проверки выводим сформированные номера.
        System.out.println();
        Object x = array[numOne];
        array[numOne] = array[numTwo];
        array[numTwo] = x;

        System.out.println((numOne + 1) + "-й элемент теперь " + array[numOne]);
        System.out.println((numTwo + 1) + "-й элемент теперь " + array[numTwo]);
        System.out.println(Arrays.toString(array));
        System.out.println();
    }
}
