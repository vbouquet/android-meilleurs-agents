
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
    "high",
    "place",
    "accuracy",
    "low",
    "value"
})
public class Hybrid_ {

    @JsonProperty("high")
    private Integer high;
    @JsonProperty("place")
    private Place________ place;
    @JsonProperty("accuracy")
    private Integer accuracy;
    @JsonProperty("low")
    private Integer low;
    @JsonProperty("value")
    private Integer value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("high")
    public Integer getHigh() {
        return high;
    }

    @JsonProperty("high")
    public void setHigh(Integer high) {
        this.high = high;
    }

    @JsonProperty("place")
    public Place________ getPlace() {
        return place;
    }

    @JsonProperty("place")
    public void setPlace(Place________ place) {
        this.place = place;
    }

    @JsonProperty("accuracy")
    public Integer getAccuracy() {
        return accuracy;
    }

    @JsonProperty("accuracy")
    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    @JsonProperty("low")
    public Integer getLow() {
        return low;
    }

    @JsonProperty("low")
    public void setLow(Integer low) {
        this.low = low;
    }

    @JsonProperty("value")
    public Integer getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Integer value) {
        this.value = value;
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
