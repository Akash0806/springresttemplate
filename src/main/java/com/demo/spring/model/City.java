
package com.demo.spring.model;

import org.codehaus.jackson.annotate.*;

import java.util.HashMap;
import java.util.Map;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cod",
        "calctime",
        "cnt",
        "list"
})
public class City {

    @JsonProperty("cod")
    private String cod;
    @JsonProperty("calctime")
    private Double calctime;
    @JsonProperty("cnt")
    private Integer cnt;
    @JsonProperty("list")
    private java.util.List<CityList> list = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cod")
    public String getCod() {
        return cod;
    }

    @JsonProperty("cod")
    public void setCod(String cod) {
        this.cod = cod;
    }

    @JsonProperty("calctime")
    public Double getCalctime() {
        return calctime;
    }

    @JsonProperty("calctime")
    public void setCalctime(Double calctime) {
        this.calctime = calctime;
    }

    @JsonProperty("cnt")
    public Integer getCnt() {
        return cnt;
    }

    @JsonProperty("cnt")
    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    @JsonProperty("list")
    public java.util.List<CityList> getList() {
        return list;
    }

    @JsonProperty("list")
    public void setList(java.util.List<CityList> list) {
        this.list = list;
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
