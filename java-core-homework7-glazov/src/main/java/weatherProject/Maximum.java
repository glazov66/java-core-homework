package weatherProject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Maximum {
    private String value;
    private String unit;
    private String unitType;

    @JsonProperty("Value")
    public String  getValue() {
        return value;
    }
    @JsonProperty("Value")
    public void setValue(String  value) {
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
    public String getUnitType() {
        return unitType;
    }
    @JsonProperty("UnitType")
    public void setUnitType(String value) {
        this.unitType = value;
    }
}
