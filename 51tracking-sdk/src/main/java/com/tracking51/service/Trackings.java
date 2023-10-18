package com.tracking51.service;

import com.tracking51.exception.Tracking51Exception;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.tracking.CreateTrackingParams;
import com.tracking51.model.tracking.GetTrackingResultsParams;
import com.tracking51.model.tracking.UpdateTrackingParams;

import java.io.IOException;
import java.util.List;

public interface Trackings {

    Tracking51Response CreateTracking(CreateTrackingParams createTrackingParams) throws Tracking51Exception,IOException;

    Tracking51Response GetTrackingResults(GetTrackingResultsParams trackingResultsParams) throws IOException;

    Tracking51Response BatchCreateTrackings(List<CreateTrackingParams> paramsList) throws Tracking51Exception,IOException;

    Tracking51Response UpdateTrackingByID(String idSting, UpdateTrackingParams updateTrackingParams) throws Tracking51Exception,IOException;

    Tracking51Response DeleteTrackingByID(String idSting) throws Tracking51Exception,IOException;

    Tracking51Response RetrackTrackingByID(String idSting) throws Tracking51Exception,IOException;

}
