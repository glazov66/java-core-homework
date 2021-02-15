package ru.glazov.java.core.model.entity;

public class Weather {
    private String city;
    private String localDate;
    private String weatherText;
    private String temperature;

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public Weather(String city, String localDate, String weatherText, String temperature) {
        this.city = city;
        this.localDate = localDate;
        this.weatherText = weatherText;
        this.temperature = temperature;
    }

    public Weather() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "\nПрогноз для " +
                "города " + city +
                " на дату " + localDate +
                ": погода: " + weatherText +
                ", температура: " + temperature +
                "\u00b0C.";
    }

}
