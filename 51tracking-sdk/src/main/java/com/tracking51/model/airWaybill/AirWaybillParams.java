package com.tracking51.model.airWaybill;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AirWaybillParams {

    @JsonProperty("awb_number")
    private String awbNumber;

}
