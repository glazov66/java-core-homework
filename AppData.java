package ru.glazov.java.core;

import java.util.Arrays;

public class AppData {
    public String[] header;
    public int[][] data;


    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    @Override
    public String toString() {
        String dataLines = "";
        for (int i = 0; i < data.length; i++) {
            dataLines += Arrays.toString(data[i]);
            if (i != data.length - 1)
                dataLines += ", ";
        }

        return "AppData{" + "header=" + Arrays.toString(header) + ", data=" + dataLines + '}';
    }
}
