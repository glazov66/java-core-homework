package ru.glazov.java.core;

public class Main {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        try {
            System.out.println("\nСумма элементов массива = " + transformArray());

        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("\nНа вход метода подали массив некорректного размера");
            System.exit(0);

        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("\nВ массиве есть символы или текст вместо числа");
            System.exit(0);
        }
    }

    public static int transformArray() throws MyArraySizeException, MyArrayDataException {
        String[][] myStringArray = new String[4][4]; // Здесь меняем размерность для срабатывания исключения MyArraySizeException

        try {
            // здесь меняем какой-то элемент массива на буквы для срабатывания исключения MyArrayDataException
            myStringArray[0][0] = "1";
            myStringArray[0][1] = "2";
            myStringArray[0][2] = "3";
            myStringArray[0][3] = "4";
            myStringArray[1][0] = "5";
            myStringArray[1][1] = "6";
            myStringArray[1][2] = "7";
            myStringArray[1][3] = "8";
            myStringArray[2][0] = "9";
            myStringArray[2][1] = "10";
            myStringArray[2][2] = "jhg"; //БУКВЫ!
            myStringArray[2][3] = "12";
            myStringArray[3][0] = "13";
            myStringArray[3][1] = "14";
            myStringArray[3][2] = "15";
            myStringArray[3][3] = "16";

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new MyArraySizeException(e.getMessage());
        }

        int[][] myInt = new int[4][4];
        int summ = 0;

        for (int i = 0; i < myStringArray.length; i++) {
            for (int j = 0; j < myStringArray.length; j++) {
                try {
                    myInt[i][j] = Integer.parseInt(myStringArray[i][j].trim());
                    summ = summ + myInt[i][j];
                    System.out.printf("%3d", myInt[i][j]);

                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Невалидный элемент массива № [" + i + "][" + j + "]");
                }
            }
            System.out.println();
        }
        return summ;
    }
}

