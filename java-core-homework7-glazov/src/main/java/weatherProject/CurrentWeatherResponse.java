package weatherProject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentWeatherResponse {

    private String localObservationDateTime;
    private int epochTime;
    private String weatherText;
    private int weatherIcon;
    private boolean hasPrecipitation;
    private String precipitationType;
    private boolean dayTime;
    private Temperature temperature;
    private String mobileLink;
    private String link;

    @JsonProperty("LocalObservationDateTime")
    public String getLocalObservationDateTime() {
        return localObservationDateTime;
    }

    @JsonProperty("LocalObservationDateTime")
    public void setLocalObservationDateTime(String value) {
        this.localObservationDateTime = value;
    }

    @JsonProperty("EpochTime")
    public int getEpochTime() {
        return epochTime;
    }

    @JsonProperty("EpochTime")
    public void setEpochTime(int value) {
        this.epochTime = value;
    }

    @JsonProperty("WeatherText")
    public String getWeatherText() {
        return weatherText;
    }

    @JsonProperty("WeatherText")
    public void setWeatherText(String value) {
        this.weatherText = value;
    }

    @JsonProperty("WeatherIcon")
    public int getWeatherIcon() {
        return weatherIcon;
    }

    @JsonProperty("WeatherIcon")
    public void setWeatherIcon(int value) {
        this.weatherIcon = value;
    }

    @JsonProperty("HasPrecipitation")
    public boolean isHasPrecipitation() {
        return hasPrecipitation;
    }

    @JsonProperty("HasPrecipitation")
    public void setHasPrecipitation(boolean value) {
        this.hasPrecipitation = value;
    }

    @JsonProperty("PrecipitationType")
    public String getPrecipitationType() {
        return precipitationType;
    }

    @JsonProperty("PrecipitationType")
    public void setPrecipitationType(String value) {
        this.precipitationType = value;
    }

    @JsonProperty("IsDayTime")
    public boolean isDayTime() {
        return dayTime;
    }

    @JsonProperty("IsDayTime")
    public void setDayTime(boolean value) {
        this.dayTime = value;
    }

    @JsonProperty("Temperature")
    public Temperature getTemperature() {
        return temperature;
    }

    @JsonProperty("Temperature")
    public void setTemperature(Temperature value) {
        this.temperature = value;
    }

    @JsonProperty("MobileLink")
    public String getMobileLink() {
        return mobileLink;
    }

    @JsonProperty("MobileLink")
    public void setMobileLink(String value) {
        this.mobileLink = value;
    }

    @JsonProperty("Link")
    public String getLink() {
        return link;
    }

    @JsonProperty("Link")
    public void setLink(String value) {
        this.link = value;
    }

    @Override
    public String toString() {
        return "Прогноз на текущий день:\n" +
                "Погода (weatherText): " + weatherText +
                ", температура (temperature) = " + temperature;
    }
}
