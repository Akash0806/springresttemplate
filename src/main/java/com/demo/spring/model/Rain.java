
package com.demo.spring.model;

import org.codehaus.jackson.annotate.*;

import java.util.HashMap;
import java.util.Map;

@JsonPropertyOrder({
        "3h"
})
public class Rain {

    @JsonProperty("3h")
    private Double _3h;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("3h")
    public Double get3h() {
        return _3h;
    }

    @JsonProperty("3h")
    public void set3h(Double _3h) {
        this._3h = _3h;
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
