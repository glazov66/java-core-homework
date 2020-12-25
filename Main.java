package ru.glazov.java.core;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String TEST_CSV = "test.csv";
    public static final String DELIMITER = ";";

    public static void main(String[] args) throws IOException {
        AppData appData =
                new AppData(
                        new String[] {"Value 1", "Value 2", "Value 3"},
                        new int[][] {{100, 200, 300}, {300, 400, 500}});

        System.out.println("Before write: " + appData.toString());
        writeToFile(appData, TEST_CSV);

        AppData dataFromFile = readFromFile(TEST_CSV);
        System.out.println("After read: " + dataFromFile.toString());
    }

    private static AppData readFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String headerLine = reader.readLine();
            String[] header = headerLine.split(DELIMITER);

            List<int[]> lines = new ArrayList<>();
            for (String dataLine = reader.readLine(); dataLine != null; dataLine = reader.readLine()) {
                int[] intValues = toIntArray(dataLine);
                lines.add(intValues);
            }

            int[][] arrayLines = lines.toArray(new int[0][0]);
            return new AppData(header, arrayLines);
        }
    }

    private static int[] toIntArray(String dataLine) {
        String[] strValues = dataLine.split(DELIMITER);
        int[] intValues = new int[strValues.length];
        for (int i = 0; i < strValues.length; i++) {
            intValues[i] = Integer.parseInt(strValues[i]);
        }
        return intValues;
    }

    private static void writeToFile(AppData appData, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            String header = String.join(DELIMITER, appData.header);
            writer.write(header);
            writer.newLine();

            for (int[] dataLineArray : appData.data) {
                writer.write(arrayToString(dataLineArray));
                writer.newLine();
            }
        }
    }

    private static String arrayToString(int[] dataLineArray) {
        String dataLine = "";
        for (int j = 0; j < dataLineArray.length; j++) {
            dataLine += dataLineArray[j];
            if (j != dataLineArray.length - 1) {
                dataLine += DELIMITER;
            }
        }
        return dataLine;
    }
}


