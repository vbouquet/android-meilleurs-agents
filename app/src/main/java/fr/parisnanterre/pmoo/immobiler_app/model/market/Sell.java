
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
    "apartment",
    "house",
    "hybrid"
})
public class Sell {

    @JsonProperty("apartment")
    private Apartment_ apartment;
    @JsonProperty("house")
    private House house;
    @JsonProperty("hybrid")
    private Hybrid_ hybrid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("apartment")
    public Apartment_ getApartment() {
        return apartment;
    }

    @JsonProperty("apartment")
    public void setApartment(Apartment_ apartment) {
        this.apartment = apartment;
    }

    @JsonProperty("house")
    public House getHouse() {
        return house;
    }

    @JsonProperty("house")
    public void setHouse(House house) {
        this.house = house;
    }

    @JsonProperty("hybrid")
    public Hybrid_ getHybrid() {
        return hybrid;
    }

    @JsonProperty("hybrid")
    public void setHybrid(Hybrid_ hybrid) {
        this.hybrid = hybrid;
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
