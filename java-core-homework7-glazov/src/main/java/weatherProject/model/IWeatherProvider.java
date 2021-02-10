package weatherProject.model;

import java.io.IOException;

public interface IWeatherProvider {

    void getCurrentWeather(String cityKey) throws IOException;
    void get5daysWeather(String cityKey) throws IOException;

}