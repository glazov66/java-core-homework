package weatherProject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FiveDaysWeatherResponse {


    private Headline headline;
    private DailyForecasts[] dailyForecasts;

    @JsonProperty("Headline")
    public Headline getHeadline() {
        return headline;
    }
@JsonProperty("Headline")
    public void setHeadline(Headline value) {
        this.headline = value;
    }
@JsonProperty("DailyForecasts")
    public DailyForecasts[] getDailyForecasts() {
        return dailyForecasts;
    }
@JsonProperty("DailyForecasts")
    public void setDailyForecasts(DailyForecasts[] value) {
        this.dailyForecasts = value;
    }
}
