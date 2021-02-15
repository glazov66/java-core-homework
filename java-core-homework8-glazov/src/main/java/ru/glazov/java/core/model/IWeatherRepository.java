package ru.glazov.java.core.model;

import ru.glazov.java.core.model.entity.Weather;

import java.util.List;

public interface IWeatherRepository {
    List<Weather> getAllData();

    void saveWeatherObject(Weather weather);
}
