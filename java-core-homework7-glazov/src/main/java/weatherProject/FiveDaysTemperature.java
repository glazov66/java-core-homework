package weatherProject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FiveDaysTemperature {
    private Minimum minimum;
    private Maximum maximum;

    @JsonProperty("Minimum")
    public Minimum getMinimum() {
        return minimum;
    }
@JsonProperty("Minimum")
    public void setMinimum(Minimum value) {
        this.minimum = value;
    }
@JsonProperty("Maximum")
    public Maximum getMaximum() {
        return maximum;
    }
@JsonProperty("Maximum")
    public void setMaximum(Maximum value) {
        this.maximum = value;
    }
}
