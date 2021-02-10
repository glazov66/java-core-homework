package weatherProject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Imperial {
    private String value;
    private String unit;
    private int unitType;

    @JsonProperty("Value")
    public String getValue() {
        return value;
    }
    @JsonProperty("Value")
    public void setValue(String value) {
        this.value = value;
    }
    @JsonProperty("Unit")
    public String getUnit() {
        return unit;
    }
    @JsonProperty("Unit")
    public void setUnit(String value) {
        this.unit = value;
    }
    @JsonProperty("UnitType")
    public int getUnitType() {
        return unitType;
    }
    @JsonProperty("UnitType")
    public void setUnitType(int value) {
        this.unitType = value;
    }
}
