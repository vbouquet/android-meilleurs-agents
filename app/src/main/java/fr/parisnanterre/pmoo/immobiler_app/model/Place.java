package fr.parisnanterre.pmoo.immobiler_app.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "region_id",
        "id",
        "iris_id",
        "zips",
        "name",
        "city_pop",
        "subregion_id",
        "type",
        "subcity_id",
        "slug",
        "street_id",
        "borough_id",
        "name_short",
        "street_length",
        "_geoloc",
        "short_title",
        "parcelle_id",
        "_tags",
        "geotype_label",
        "title",
        "source",
        "arrmun_ids",
        "highlighted_title",
        "neighborhood_id",
        "street_name",
        "block_id",
        "city_id"
})
public class Place {

    @JsonProperty("region_id")
    private Integer regionId;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("iris_id")
    private Integer irisId;
    @JsonProperty("zips")
    private List<String> zips = null;
    @JsonProperty("name")
    private String name;
    @JsonProperty("city_pop")
    private Double cityPop;
    @JsonProperty("subregion_id")
    private Integer subregionId;
    @JsonProperty("type")
    private Integer type;
    @JsonProperty("subcity_id")
    private Integer subcityId;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("street_id")
    private Integer streetId;
    @JsonProperty("borough_id")
    private Integer boroughId;
    @JsonProperty("name_short")
    private String nameShort;
    @JsonProperty("street_length")
    private Integer streetLength;
    @JsonProperty("_geoloc")
    private Geoloc geoloc;
    @JsonProperty("short_title")
    private String shortTitle;
    @JsonProperty("parcelle_id")
    private Integer parcelleId;
    @JsonProperty("_tags")
    private List<String> tags = null;
    @JsonProperty("geotype_label")
    private String geotypeLabel;
    @JsonProperty("title")
    private String title;
    @JsonProperty("source")
    private Source source;
    @JsonProperty("arrmun_ids")
    private Object arrmunIds;
    @JsonProperty("highlighted_title")
    private String highlightedTitle;
    @JsonProperty("neighborhood_id")
    private Object neighborhoodId;
    @JsonProperty("street_name")
    private String streetName;
    @JsonProperty("block_id")
    private Integer blockId;
    @JsonProperty("city_id")
    private Integer cityId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("region_id")
    public Integer getRegionId() {
        return regionId;
    }

    @JsonProperty("region_id")
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("iris_id")
    public Integer getIrisId() {
        return irisId;
    }

    @JsonProperty("iris_id")
    public void setIrisId(Integer irisId) {
        this.irisId = irisId;
    }

    @JsonProperty("zips")
    public List<String> getZips() {
        return zips;
    }

    @JsonProperty("zips")
    public void setZips(List<String> zips) {
        this.zips = zips;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("city_pop")
    public Double getCityPop() {
        return cityPop;
    }

    @JsonProperty("city_pop")
    public void setCityPop(Double cityPop) {
        this.cityPop = cityPop;
    }

    @JsonProperty("subregion_id")
    public Integer getSubregionId() {
        return subregionId;
    }

    @JsonProperty("subregion_id")
    public void setSubregionId(Integer subregionId) {
        this.subregionId = subregionId;
    }

    @JsonProperty("type")
    public Integer getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Integer type) {
        this.type = type;
    }

    @JsonProperty("subcity_id")
    public Integer getSubcityId() {
        return subcityId;
    }

    @JsonProperty("subcity_id")
    public void setSubcityId(Integer subcityId) {
        this.subcityId = subcityId;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("street_id")
    public Integer getStreetId() {
        return streetId;
    }

    @JsonProperty("street_id")
    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    @JsonProperty("borough_id")
    public Integer getBoroughId() {
        return boroughId;
    }

    @JsonProperty("borough_id")
    public void setBoroughId(Integer boroughId) {
        this.boroughId = boroughId;
    }

    @JsonProperty("name_short")
    public String getNameShort() {
        return nameShort;
    }

    @JsonProperty("name_short")
    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    @JsonProperty("street_length")
    public Integer getStreetLength() {
        return streetLength;
    }

    @JsonProperty("street_length")
    public void setStreetLength(Integer streetLength) {
        this.streetLength = streetLength;
    }

    @JsonProperty("_geoloc")
    public Geoloc getGeoloc() {
        return geoloc;
    }

    @JsonProperty("_geoloc")
    public void setGeoloc(Geoloc geoloc) {
        this.geoloc = geoloc;
    }

    @JsonProperty("short_title")
    public String getShortTitle() {
        return shortTitle;
    }

    @JsonProperty("short_title")
    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    @JsonProperty("parcelle_id")
    public Integer getParcelleId() {
        return parcelleId;
    }

    @JsonProperty("parcelle_id")
    public void setParcelleId(Integer parcelleId) {
        this.parcelleId = parcelleId;
    }

    @JsonProperty("_tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("_tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("geotype_label")
    public String getGeotypeLabel() {
        return geotypeLabel;
    }

    @JsonProperty("geotype_label")
    public void setGeotypeLabel(String geotypeLabel) {
        this.geotypeLabel = geotypeLabel;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("source")
    public Source getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(Source source) {
        this.source = source;
    }

    @JsonProperty("arrmun_ids")
    public Object getArrmunIds() {
        return arrmunIds;
    }

    @JsonProperty("arrmun_ids")
    public void setArrmunIds(Object arrmunIds) {
        this.arrmunIds = arrmunIds;
    }

    @JsonProperty("highlighted_title")
    public String getHighlightedTitle() {
        return highlightedTitle;
    }

    @JsonProperty("highlighted_title")
    public void setHighlightedTitle(String highlightedTitle) {
        this.highlightedTitle = highlightedTitle;
    }

    @JsonProperty("neighborhood_id")
    public Object getNeighborhoodId() {
        return neighborhoodId;
    }

    @JsonProperty("neighborhood_id")
    public void setNeighborhoodId(Object neighborhoodId) {
        this.neighborhoodId = neighborhoodId;
    }

    @JsonProperty("street_name")
    public String getStreetName() {
        return streetName;
    }

    @JsonProperty("street_name")
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @JsonProperty("block_id")
    public Integer getBlockId() {
        return blockId;
    }

    @JsonProperty("block_id")
    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    @JsonProperty("city_id")
    public Integer getCityId() {
        return cityId;
    }

    @JsonProperty("city_id")
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
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