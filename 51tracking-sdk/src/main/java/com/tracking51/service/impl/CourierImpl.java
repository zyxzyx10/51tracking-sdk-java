package com.tracking51.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.courier.Courier;
import com.tracking51.service.Couriers;

import java.io.IOException;
import java.util.List;

public class CourierImpl extends BaseTracking implements Couriers {
    public Tracking51Response getAllCouriers() throws IOException{
        String apiPath =  "/couriers/all";
        String body = requestHelper.sendApiRequest(apiPath, "GET",null, null);
        Tracking51Response response = objectMapper.readValue(body, new TypeReference<Tracking51Response<List<Courier>>>() {});
        return response;
    }

}
