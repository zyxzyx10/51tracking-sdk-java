package com.tracking51.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tracking51.exception.ErrorEnums;
import com.tracking51.exception.Tracking51Exception;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.tracking.*;
import com.tracking51.service.Trackings;
import com.tracking51.utils.StrUtils;

import java.io.IOException;
import java.util.List;

public class TrackingImpl extends BaseTracking implements Trackings {

    public Tracking51Response CreateTracking(CreateTrackingParams createTrackingParams) throws Tracking51Exception,IOException{
        if(StrUtils.isEmpty(createTrackingParams.getTrackingNumber())) {
            throw new Tracking51Exception(ErrorEnums.ErrMissingTrackingNumber);
        }
        if(StrUtils.isEmpty(createTrackingParams.getCourierCode())) {
            throw new Tracking51Exception(ErrorEnums.ErrMissingCourierCode);
        }
        String apiPath =  "/trackings/create";
        String body = requestHelper.sendApiRequest(apiPath, "POST",null, createTrackingParams);
        Tracking51Response response = objectMapper.readValue(body, new TypeReference<Tracking51Response<Tracking>>() {});
        return response;
    }

    public Tracking51Response GetTrackingResults(GetTrackingResultsParams trackingResultsParams) throws IOException{
        String apiPath =  "/trackings/get";
        String body = requestHelper.sendApiRequest(apiPath, "GET", trackingResultsParams,null);
        Tracking51Response response = objectMapper.readValue(body, new TypeReference<Tracking51Response<GetResults>>() {});
        return response;
    }

    public Tracking51Response BatchCreateTrackings(List<CreateTrackingParams> paramsList) throws Tracking51Exception,IOException{
        if(paramsList.size() > 40){
            throw new Tracking51Exception(ErrorEnums.ErrMaxTrackingNumbersExceeded);
        }

        for (CreateTrackingParams params : paramsList) {
            if(StrUtils.isEmpty(params.getTrackingNumber())){
                throw new Tracking51Exception(ErrorEnums.ErrMissingTrackingNumber);
            }
            if(StrUtils.isEmpty(params.getCourierCode())){
                throw new Tracking51Exception(ErrorEnums.ErrMissingCourierCode);
            }
        }

        String apiPath =  "/trackings/batch";
        String body = requestHelper.sendApiRequest(apiPath, "POST",null, paramsList);
        Tracking51Response response = objectMapper.readValue(body, new TypeReference<Tracking51Response<BatchResults>>() {});
        return response;
    }

    public Tracking51Response UpdateTrackingByID(String idSting, UpdateTrackingParams updateTrackingParams) throws Tracking51Exception,IOException{
        if(StrUtils.isEmpty(idSting)){
            throw new Tracking51Exception(ErrorEnums.ErrEmptyId);
        }
        String apiPath =  "/trackings/update/"+idSting;
        String body = requestHelper.sendApiRequest(apiPath, "PUT",null, updateTrackingParams);
        Tracking51Response response = objectMapper.readValue(body, new TypeReference<Tracking51Response<UpdateTracking>>() {});
        return response;
    }

    public Tracking51Response DeleteTrackingByID(String idSting) throws Tracking51Exception,IOException{
        if(StrUtils.isEmpty(idSting)){
            throw new Tracking51Exception(ErrorEnums.ErrEmptyId);
        }
        String apiPath =  "/trackings/delete/"+idSting;
        String body = requestHelper.sendApiRequest(apiPath, "DELETE",null, null);
        Tracking51Response response = objectMapper.readValue(body, new TypeReference<Tracking51Response<Tracking>>() {});
        return response;
    }

    public Tracking51Response RetrackTrackingByID(String idSting) throws Tracking51Exception,IOException{
        if(StrUtils.isEmpty(idSting)){
            throw new Tracking51Exception(ErrorEnums.ErrEmptyId);
        }
        String apiPath =  "/trackings/retrack/"+idSting;
        String body = requestHelper.sendApiRequest(apiPath, "POST",null, null);
        Tracking51Response response = objectMapper.readValue(body, new TypeReference<Tracking51Response<Tracking>>() {});
        return response;
    }


}
