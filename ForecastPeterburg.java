package ru.geekbrains.javacore;

import okhttp3.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;


public class ForecastPeterburg {

    public static void main(String[] args) throws IOException, ParseException {

        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment("295212")
                .addQueryParameter("apikey", "iBdSz7vFYu9q9RUZHkKpqQ4jLsWy0oF1")
                .addQueryParameter("language", "ru")
                .addQueryParameter("details", "false")
                .addQueryParameter("metric", "true")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = client.newCall(request).execute();
        System.out.println("Запрос погоды в Санкт-Петербурге на 5 дней\n");
        System.out.println(response.request());
        System.out.println("Код ответа: " + response.code());
        System.out.println("Текст ответа: " + response.message());

        String weatherResponseBody = response.body().string();
        System.out.println("json-строка с прогнозом погоды: " + weatherResponseBody);
        System.out.println(" ");

        File jsonFile = new File("forecast.json");
        try (OutputStream out = new FileOutputStream(jsonFile)) {
            out.write(weatherResponseBody.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            FileReader jsonReader = new FileReader("forecast.json");

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonReader);

            JSONArray jsonArray = (JSONArray) jsonObject.get("DailyForecasts");

            Iterator i = jsonArray.iterator();

            while (i.hasNext()) {

                JSONObject param = (JSONObject) i.next();
                JSONObject temp = (JSONObject) param.get("Temperature");
                JSONObject minTemp = (JSONObject) temp.get("Minimum");
                JSONObject maxTemp = (JSONObject) temp.get("Maximum");
                JSONObject day = (JSONObject) param.get("Day");
                JSONObject night = (JSONObject) param.get("Night");

                String x = (String) param.get("Date");
                System.out.println("Дата: " + x.substring(0, 10) + " ");
                System.out.println("Температура: от " + minTemp.get("Value") + "\u00b0" + " до " + maxTemp.get("Value") + "\u00b0 ");
                System.out.println("Днем: " + day.get("IconPhrase") + "; " + " Ночью: " + night.get("IconPhrase"));
                System.out.println(" ");

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }
}
