
package fr.parisnanterre.pmoo.immobiler_app.model.market;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "top_percentile",
    "low",
    "low_percentile",
    "accuracy",
    "value",
    "high",
    "place"
})
public class Apartment_ {

    @JsonProperty("top_percentile")
    private Integer topPercentile;
    @JsonProperty("low")
    private Integer low;
    @JsonProperty("low_percentile")
    private Integer lowPercentile;
    @JsonProperty("accuracy")
    private Integer accuracy;
    @JsonProperty("value")
    private Integer value;
    @JsonProperty("high")
    private Integer high;
    @JsonProperty("place")
    private Place______ place;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("top_percentile")
    public Integer getTopPercentile() {
        return topPercentile;
    }

    @JsonProperty("top_percentile")
    public void setTopPercentile(Integer topPercentile) {
        this.topPercentile = topPercentile;
    }

    @JsonProperty("low")
    public Integer getLow() {
        return low;
    }

    @JsonProperty("low")
    public void setLow(Integer low) {
        this.low = low;
    }

    @JsonProperty("low_percentile")
    public Integer getLowPercentile() {
        return lowPercentile;
    }

    @JsonProperty("low_percentile")
    public void setLowPercentile(Integer lowPercentile) {
        this.lowPercentile = lowPercentile;
    }

    @JsonProperty("accuracy")
    public Integer getAccuracy() {
        return accuracy;
    }

    @JsonProperty("accuracy")
    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    @JsonProperty("value")
    public Integer getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Integer value) {
        this.value = value;
    }

    @JsonProperty("high")
    public Integer getHigh() {
        return high;
    }

    @JsonProperty("high")
    public void setHigh(Integer high) {
        this.high = high;
    }

    @JsonProperty("place")
    public Place______ getPlace() {
        return place;
    }

    @JsonProperty("place")
    public void setPlace(Place______ place) {
        this.place = place;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
