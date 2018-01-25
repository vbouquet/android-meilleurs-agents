
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
    "price_date",
    "has_sell_price",
    "has_sell_apartment_price",
    "address_has_city_price",
    "has_sell_house_price",
    "place",
    "rental",
    "sell",
    "has_rental_apartment_price"
})
public class Prices {

    @JsonProperty("price_date")
    private String priceDate;
    @JsonProperty("has_sell_price")
    private Boolean hasSellPrice;
    @JsonProperty("has_sell_apartment_price")
    private Boolean hasSellApartmentPrice;
    @JsonProperty("address_has_city_price")
    private Boolean addressHasCityPrice;
    @JsonProperty("has_sell_house_price")
    private Boolean hasSellHousePrice;
    @JsonProperty("place")
    private Place place;
    @JsonProperty("rental")
    private Rental rental;
    @JsonProperty("sell")
    private Sell sell;
    @JsonProperty("has_rental_apartment_price")
    private Boolean hasRentalApartmentPrice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("price_date")
    public String getPriceDate() {
        return priceDate;
    }

    @JsonProperty("price_date")
    public void setPriceDate(String priceDate) {
        this.priceDate = priceDate;
    }

    @JsonProperty("has_sell_price")
    public Boolean getHasSellPrice() {
        return hasSellPrice;
    }

    @JsonProperty("has_sell_price")
    public void setHasSellPrice(Boolean hasSellPrice) {
        this.hasSellPrice = hasSellPrice;
    }

    @JsonProperty("has_sell_apartment_price")
    public Boolean getHasSellApartmentPrice() {
        return hasSellApartmentPrice;
    }

    @JsonProperty("has_sell_apartment_price")
    public void setHasSellApartmentPrice(Boolean hasSellApartmentPrice) {
        this.hasSellApartmentPrice = hasSellApartmentPrice;
    }

    @JsonProperty("address_has_city_price")
    public Boolean getAddressHasCityPrice() {
        return addressHasCityPrice;
    }

    @JsonProperty("address_has_city_price")
    public void setAddressHasCityPrice(Boolean addressHasCityPrice) {
        this.addressHasCityPrice = addressHasCityPrice;
    }

    @JsonProperty("has_sell_house_price")
    public Boolean getHasSellHousePrice() {
        return hasSellHousePrice;
    }

    @JsonProperty("has_sell_house_price")
    public void setHasSellHousePrice(Boolean hasSellHousePrice) {
        this.hasSellHousePrice = hasSellHousePrice;
    }

    @JsonProperty("place")
    public Place getPlace() {
        return place;
    }

    @JsonProperty("place")
    public void setPlace(Place place) {
        this.place = place;
    }

    @JsonProperty("rental")
    public Rental getRental() {
        return rental;
    }

    @JsonProperty("rental")
    public void setRental(Rental rental) {
        this.rental = rental;
    }

    @JsonProperty("sell")
    public Sell getSell() {
        return sell;
    }

    @JsonProperty("sell")
    public void setSell(Sell sell) {
        this.sell = sell;
    }

    @JsonProperty("has_rental_apartment_price")
    public Boolean getHasRentalApartmentPrice() {
        return hasRentalApartmentPrice;
    }

    @JsonProperty("has_rental_apartment_price")
    public void setHasRentalApartmentPrice(Boolean hasRentalApartmentPrice) {
        this.hasRentalApartmentPrice = hasRentalApartmentPrice;
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
