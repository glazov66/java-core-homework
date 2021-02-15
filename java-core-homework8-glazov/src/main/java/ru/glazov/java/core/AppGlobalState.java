package ru.glazov.java.core;

import java.sql.*;

public class AppGlobalState {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    private static Statement statement;

    public static Statement getStatement() {
        return statement;
    }

    private static PreparedStatement insertWeatherPreparedStatement;

    public static PreparedStatement getInsertWeatherPreparedStatement() {
        return insertWeatherPreparedStatement;
    }

    private static AppGlobalState instance;

    private String cityKey;

    public String getCityKey() {
        return cityKey;
    }

    public void setCityKey(String cityKey) {
        this.cityKey = cityKey;
    }

    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getApiKey() {

       // return "iBdSz7vFYu9q9RUZHkKpqQ4jLsWy0oF1";  API от первого аккаунта
        return "foUcQALICuRLzXXM2TAG7GV7pO6WXKrV";
    }

    public String getDbName() {return "weather-app.db";
    }

    private AppGlobalState() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + getDbName());
            statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS weather (" +
                    "city TEXT NOT NULL, date TEXT NOT NULL, text TEXT NOT NULL, temp TEXT NOT NULL );");

            insertWeatherPreparedStatement = connection.prepareStatement(
                    "INSERT INTO weather  (city, date, text, temp) VALUES (?,?,?,?);"
            );

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.exit(1);
        }
    }

    public static AppGlobalState getInstance() {
        if (instance == null) {
            instance = new AppGlobalState();
        }
        return instance;
    }
}
