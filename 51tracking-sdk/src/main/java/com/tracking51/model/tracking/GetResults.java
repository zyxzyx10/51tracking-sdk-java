package com.tracking51.model.tracking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetResults {

    @JsonProperty("success")
    private List<Tracking> success;

    @JsonProperty("rejected")
    private List<RejectedItem> rejected;

}
