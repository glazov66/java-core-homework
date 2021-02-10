package weatherProject.controller;

import weatherProject.AppGlobalState;
import weatherProject.model.AccuWeatherCityCodeProvider;
import weatherProject.model.AccuWeatherProvider;
import weatherProject.model.ICityCodeProvider;
import weatherProject.model.IWeatherProvider;

import java.io.IOException;

public class Controller implements IController {

    ICityCodeProvider codeProvider = new AccuWeatherCityCodeProvider();
    IWeatherProvider weatherProvider = new AccuWeatherProvider();

    @Override
    public void onCityInput(String city) throws IOException {
        if (city.length() == 1) {
            throw new IOException("Недопустимо короткое название города");
        }

        codeProvider.getCodeByCityName(city);
    }

    @Override
    public void onCommandChosen(int selectedCommand) throws IOException {


        switch (selectedCommand) {
            case 1: {
                weatherProvider.getCurrentWeather(AppGlobalState.getInstance().getCityKey());
                break;
            }
            case 2:{
                weatherProvider.get5daysWeather(AppGlobalState.getInstance().getCityKey());
                break;
            }
            case 0:{
                System.out.println("Завершаю работу...");
                System.exit(0);
            }

            default: {
                throw new IOException("Неверный ввод\n");
            }
        }
    }
}
