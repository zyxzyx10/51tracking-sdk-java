package com.tracking51.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tracking51.exception.ErrorEnums;
import com.tracking51.exception.Tracking51Exception;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.airWaybill.AirWaybill;
import com.tracking51.model.airWaybill.AirWaybillParams;
import com.tracking51.service.AirWaybills;
import com.tracking51.utils.StrUtils;

import java.io.IOException;

public class AirWaybillImpl extends BaseTracking implements AirWaybills {

    public Tracking51Response CreateAnAirWayBill(AirWaybillParams airWaybillParams) throws Tracking51Exception,IOException{
        if(StrUtils.isEmpty(airWaybillParams.getAwbNumber())) {
            throw new Tracking51Exception(ErrorEnums.ErrMissingAwbNumber);
        }
        if(airWaybillParams.getAwbNumber().length() != 12) {
            throw new Tracking51Exception(ErrorEnums.ErrInvalidAirWaybillFormat);
        }
        String apiPath =  "/awb";
        String body = requestHelper.sendApiRequest(apiPath, "POST", null,  airWaybillParams);
        Tracking51Response response = objectMapper.readValue(body, new TypeReference<Tracking51Response<AirWaybill>>() {});
        return response;
    }

}
