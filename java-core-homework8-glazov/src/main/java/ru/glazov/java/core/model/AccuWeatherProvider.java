package ru.glazov.java.core.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import ru.glazov.java.core.AppGlobalState;
import ru.glazov.java.core.CurrentWeatherResponse;
import ru.glazov.java.core.FiveDaysWeatherResponse;
import ru.glazov.java.core.model.entity.Weather;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

public class AccuWeatherProvider implements IWeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String CURRENTCONDITIONS_PATH = "currentconditions";
    private static final String FORECAST_PATH = "forecasts";
    private static final String DAILY_PATH = "daily";
    private static final String FIVEDAYS_PATH = "5day";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = AppGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public Weather getCurrentWeather(String cityKey) throws IOException {
        //http://dataservice.accuweather.com/currentconditions/v1/27497?apikey={{accuweatherApiKey}}

        HttpUrl getCurrentWeatherUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(CURRENTCONDITIONS_PATH)
                .addPathSegment(API_VERSION)
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru")
                .addQueryParameter("metric", "true")
                .build();

        Request getCurrentWeatherRequest = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(getCurrentWeatherUrl)
                .build();

        Response currentDayResponse = client.newCall(getCurrentWeatherRequest).execute();
        if (!currentDayResponse.isSuccessful()) {
            throw new IOException("Ошибка сети\n");
        }


//        System.out.println("currentDayResponse-JSON: " + currentDayResponse.body().string());

        try
                (FileOutputStream outCurrentDay = new FileOutputStream("currentDayJson.json")) {
            outCurrentDay.write(currentDayResponse.body().string().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<CurrentWeatherResponse> currentDayResponseJava = objectMapper.readValue(new File("currentDayJson.json"), new TypeReference<List<CurrentWeatherResponse>>() {
        });
//        System.out.println("Полный currentDayResponseJava из JSON (для контроля)");
//        System.out.println(objectMapper.writeValueAsString(currentDayResponseJava.get(0)));
//        System.out.println();
//        System.out.println("--Вывод прогноза для пользователя--\n");
//        System.out.println("Сегодня " + currentDayResponseJava.get(0).getWeatherText().toLowerCase(Locale.ROOT) + ".\n");
//        System.out.println("Температура : " + currentDayResponseJava.get(0).getTemperature().getMetricTemp().getValue() + "\u00b0C.");
//        System.out.println();

//        String temperature = objectMapper.readTree(currentDayResponse.body().string()).get(0).at("/Temperature/Metric/Value").asText();
//        String localDate = objectMapper.readTree(currentDayResponse.body().string()).get(0).at("/LocalObservationDateTime".substring(0, 10)).asText();
//        String weatherText = objectMapper.readTree(currentDayResponse.body().string()).get(0).at("WeatherText").asText();
        String localDate = currentDayResponseJava.get(0).getLocalObservationDateTime().substring(0, 10);
        String weatherText = currentDayResponseJava.get(0).getWeatherText();
        String temperature = currentDayResponseJava.get(0).getTemperature().getMetricTemp().getValue();

        Weather result = new Weather(AppGlobalState.getInstance().getCityName(), localDate, weatherText, temperature);

        return result;


    }

    public void get5daysWeather(String cityKey) throws IOException {
        // CURRENT: http://dataservice.accuweather.com/currentconditions/v1/27497?apikey={{accuweatherApiKey}}
        //5-DAYS: http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey={{accuweatherApiKey}}

        HttpUrl get5daysWeatherUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECAST_PATH)
                .addPathSegment(API_VERSION)
                .addPathSegment(DAILY_PATH)
                .addPathSegment(FIVEDAYS_PATH)
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru")
                .addQueryParameter("metric", "true")
                .build();

        Request get5daysWeatherRequest = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(get5daysWeatherUrl)
                .build();
//        System.out.println("URL запроса:");  // Проверочный вывод
//        System.out.println("get5daysWeatherRequest:  " + get5daysWeatherRequest);
//        System.out.println();

        Response fiveDaysResponse = client.newCall(get5daysWeatherRequest).execute();
        if (!fiveDaysResponse.isSuccessful()) {
            throw new IOException("Ошибка сети\n");
        }

//        System.out.println("5 days forecast fiveDaysResponse-JSON:\n" + fiveDaysResponse.body().string());

        try
                (FileOutputStream outFiveDays = new FileOutputStream("fiveDaysJson.json")) {
            outFiveDays.write(fiveDaysResponse.body().string().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

        FiveDaysWeatherResponse fiveDaysResponseJava = objectMapper.readValue(new File("fiveDaysJson.json"), FiveDaysWeatherResponse.class);

//        System.out.println("Полный fiveDaysResponseJava из JSON (для контроля)") ;
//        System.out.println(objectMapper.writeValueAsString(fiveDaysResponseJava));
        System.out.println("-----------");

        for (int i = 0; i < fiveDaysResponseJava.getDailyForecasts().length; i++) {

//            String cityName = objectMapper.writeValueAsString(fiveDaysResponseJava.getDailyForecasts()[i].getLink().substring(33,40).toUpperCase(Locale.ROOT));
            System.out.println();
            System.out.println("В городе " + AppGlobalState.getInstance().getCityName() + " на дату " + fiveDaysResponseJava.getDailyForecasts()[i].getDate().substring(0, 10) + " ожидается");
            System.out.println("температура от " + fiveDaysResponseJava.getDailyForecasts()[i].getTemperature().getMinimum().getValue() + "\u00b0C.");
            System.out.println("до " + fiveDaysResponseJava.getDailyForecasts()[i].getTemperature().getMaximum().getValue() + "\u00b0C.");
            System.out.println("Днём " + fiveDaysResponseJava.getDailyForecasts()[i].getDay().getIconPhrase().toLowerCase(Locale.ROOT) + ", ");
            System.out.println("ночью " + fiveDaysResponseJava.getDailyForecasts()[i].getNight().getIconPhrase().toLowerCase(Locale.ROOT) + ".\n");

        }


    }

}
