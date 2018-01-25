
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
    "t4_plus",
    "t1",
    "hybrid",
    "t3",
    "t2"
})
public class Apartment {

    @JsonProperty("t4_plus")
    private T4Plus t4Plus;
    @JsonProperty("t1")
    private T1 t1;
    @JsonProperty("hybrid")
    private Hybrid hybrid;
    @JsonProperty("t3")
    private T3 t3;
    @JsonProperty("t2")
    private T2 t2;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("t4_plus")
    public T4Plus getT4Plus() {
        return t4Plus;
    }

    @JsonProperty("t4_plus")
    public void setT4Plus(T4Plus t4Plus) {
        this.t4Plus = t4Plus;
    }

    @JsonProperty("t1")
    public T1 getT1() {
        return t1;
    }

    @JsonProperty("t1")
    public void setT1(T1 t1) {
        this.t1 = t1;
    }

    @JsonProperty("hybrid")
    public Hybrid getHybrid() {
        return hybrid;
    }

    @JsonProperty("hybrid")
    public void setHybrid(Hybrid hybrid) {
        this.hybrid = hybrid;
    }

    @JsonProperty("t3")
    public T3 getT3() {
        return t3;
    }

    @JsonProperty("t3")
    public void setT3(T3 t3) {
        this.t3 = t3;
    }

    @JsonProperty("t2")
    public T2 getT2() {
        return t2;
    }

    @JsonProperty("t2")
    public void setT2(T2 t2) {
        this.t2 = t2;
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
