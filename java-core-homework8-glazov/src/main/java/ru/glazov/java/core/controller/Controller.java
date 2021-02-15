package ru.glazov.java.core.controller;

import ru.glazov.java.core.AppGlobalState;
import ru.glazov.java.core.model.*;
import ru.glazov.java.core.model.entity.Weather;
import ru.glazov.java.core.view.IUserInterface;
import ru.glazov.java.core.view.UserInterface;

import java.io.IOException;
import java.util.List;

public class Controller implements IController {


    ICityCodeProvider codeProvider = new AccuWeatherCityCodeProvider();
    IWeatherProvider weatherProvider = new AccuWeatherProvider();
    IWeatherRepository weatherRepository = new SQLiteWeatherRepository();

    @Override
    public void onCityInput(String city) throws IOException {
        if ((city.length() == 1) && (!city.equals("*"))) {
            throw new IOException("Недопустимо короткое название города");
        }


        codeProvider.getCodeByCityName(city);
    }

    @Override
    public void onCommandChosen(int selectedCommand) throws IOException {


        switch (selectedCommand) {
            case 1: {
//                weatherProvider.getCurrentWeather(AppGlobalState.getInstance().getCityKey());
                Weather currentWeather = weatherProvider.getCurrentWeather(AppGlobalState.getInstance().getCityKey());
                System.out.println(currentWeather);
                weatherRepository.saveWeatherObject(currentWeather);
                break;
            }

            case 2: {
                weatherProvider.get5daysWeather(AppGlobalState.getInstance().getCityKey());
                break;
            }

            case 3: {
                List<Weather> allData = weatherRepository.getAllData();
                allData.forEach(System.out::println);
                break;
            }
            case 0: {
                System.out.println("Завершаю работу...");
                System.exit(0);
            }

            default: {
                throw new IOException("Неверный ввод\n");
            }
        }

    }

    public void printAllData() {
        List<Weather> allData = weatherRepository.getAllData();
        allData.forEach(System.out::println);

    }
}
