package weatherProject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Day {
    private int icon;
    private String iconPhrase;
    private boolean hasPrecipitation;
    private String precipitationType;
    private String precipitationIntensity;

    @JsonProperty("Icon")
    public int getIcon() {
        return icon;
    }

    @JsonProperty("Icon")
    public void setIcon(int value) {
        this.icon = value;
    }

    @JsonProperty("IconPhrase")
    public String getIconPhrase() {
        return iconPhrase;
    }

    @JsonProperty("IconPhrase")
    public void setIconPhrase(String value) {
        this.iconPhrase = value;
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

    @JsonProperty("PrecipitationIntensity")
    public String getPrecipitationIntensity() {
        return precipitationIntensity;
    }

    @JsonProperty("PrecipitationIntensity")
    public void setPrecipitationIntensity(String value) {
        this.precipitationIntensity = value;
    }
}
