package com.tracking51.model.tracking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RejectedItem {

    @JsonProperty("tracking_number")
    private String trackingNumber;

    @JsonProperty("rejectedCode")
    private Integer rejectedCode;

    @JsonProperty("rejectedMessage")
    private String rejectedMessage;

}
