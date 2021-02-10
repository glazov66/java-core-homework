package weatherProject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {

    private Metric metricTemp;
    private Imperial imperialTemp;

    @JsonProperty("Metric")
    public Metric getMetricTemp() {
        return metricTemp;
    }
    @JsonProperty("Metric")
    public void setMetricTemp(Metric value) {
        this.metricTemp = value;
    }
    @JsonProperty("Imperial")
    public Imperial getImperialTemp() {
        return imperialTemp;
    }
    @JsonProperty("Imperial")
    public void setImperialTemp(Imperial value) {
        this.imperialTemp = value;
    }
}
