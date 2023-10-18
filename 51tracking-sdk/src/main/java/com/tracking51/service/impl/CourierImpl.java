package com.tracking51.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tracking51.exception.ErrorEnums;
import com.tracking51.exception.Tracking51Exception;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.courier.Courier;
import com.tracking51.model.courier.DetectParams;
import com.tracking51.service.Couriers;
import com.tracking51.utils.StrUtils;

import java.io.IOException;
import java.util.List;

public class CourierImpl extends BaseTracking implements Couriers {
    public Tracking51Response getAllCouriers() throws IOException{
        String apiPath =  "/couriers/all";
        String body = requestHelper.sendApiRequest(apiPath, "GET",null, null);
        Tracking51Response response = objectMapper.readValue(body, new TypeReference<Tracking51Response<List<Courier>>>() {});
        return response;
    }

    public Tracking51Response detect(DetectParams detectParams) throws Tracking51Exception,IOException {
        if(StrUtils.isEmpty(detectParams.getTrackingNumber())) {
            throw new Tracking51Exception(ErrorEnums.ErrMissingTrackingNumber);
        }
        String apiPath =  "/couriers/detect";
        String body = requestHelper.sendApiRequest(apiPath, "POST",null, detectParams);
        Tracking51Response response = objectMapper.readValue(body, new TypeReference<Tracking51Response<List<Courier>>>() {});
        return response;
    }

}
