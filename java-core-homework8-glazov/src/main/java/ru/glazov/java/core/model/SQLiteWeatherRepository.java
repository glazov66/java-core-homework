package ru.glazov.java.core.model;

import ru.glazov.java.core.AppGlobalState;
import ru.glazov.java.core.model.entity.Weather;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLiteWeatherRepository implements IWeatherRepository {
    @Override
    public List<Weather> getAllData() {
        Statement statement = AppGlobalState.getStatement();
        List<Weather> result = new ArrayList<>();

        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM weather");
            while (rs.next()) {
                result.add(new Weather(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public void saveWeatherObject(Weather weather) {
        PreparedStatement insertOne = AppGlobalState.getInsertWeatherPreparedStatement();
        try {
            insertOne.setString(1, weather.getCity());
            insertOne.setString(2, weather.getLocalDate());
            insertOne.setString(3, weather.getWeatherText());
            insertOne.setString(4, weather.getTemperature());
            insertOne.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
