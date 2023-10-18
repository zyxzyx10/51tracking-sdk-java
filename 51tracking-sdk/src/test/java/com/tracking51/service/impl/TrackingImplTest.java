package com.tracking51.service.impl;

import com.tracking51.Tracking51;
import com.tracking51.exception.Tracking51Exception;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.tracking.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrackingImplTest {

    private Tracking51 tracking51;

    @Before
    public void setUp() throws Tracking51Exception {
        String apiKey = "apiKey";
        tracking51 = new Tracking51(apiKey);
    }

    @Test
    public void testCreateTrackingSuccess() throws IOException, Tracking51Exception {
        CreateTrackingParams createTrackingParams = new CreateTrackingParams();
        createTrackingParams.setTrackingNumber("12345678902");
        createTrackingParams.setCourierCode("usps");

        Tracking51Response response = tracking51.trackings.CreateTracking(createTrackingParams);

        assertNotNull(response);
        if( response.getMeta().getCode() == 200){
            Tracking trackingData = (Tracking) response.getData();
            assertNotNull(trackingData);
        }
    }

    @Test(expected = Tracking51Exception.class)
    public void testCreateTrackingMissingTrackingNumber() throws IOException, Tracking51Exception {
        CreateTrackingParams createTrackingParams = new CreateTrackingParams();
        createTrackingParams.setCourierCode("usps");
        tracking51.trackings.CreateTracking(createTrackingParams);
    }

    @Test(expected = Tracking51Exception.class)
    public void testCreateTrackingMissingCourierCode() throws IOException, Tracking51Exception {
        CreateTrackingParams createTrackingParams = new CreateTrackingParams();
        createTrackingParams.setTrackingNumber("1234567890");
        tracking51.trackings.CreateTracking(createTrackingParams);
    }

    @Test
    public void testGetTrackingResults() throws IOException {
        GetTrackingResultsParams trackingResultsParams = new GetTrackingResultsParams();
        Tracking51Response response = tracking51.trackings.GetTrackingResults(trackingResultsParams);

        assertNotNull(response);
        if(response.getMeta().getCode() == 200){
            GetResults getResults = (GetResults) response.getData();
            assertNotNull(getResults);
        }

    }

    @Test
    public void testBatchCreateTrackings() throws IOException, Tracking51Exception {
        List<CreateTrackingParams> paramsList = new ArrayList<>();

        CreateTrackingParams createTrackingParams1 = new CreateTrackingParams();
        createTrackingParams1.setTrackingNumber("92632903279511573030094832");
        createTrackingParams1.setCourierCode("usps");

        CreateTrackingParams createTrackingParams2 = new CreateTrackingParams();
        createTrackingParams2.setTrackingNumber("92642903289511563039994932");
        createTrackingParams2.setCourierCode("usps");

        paramsList.add(createTrackingParams1);
        paramsList.add(createTrackingParams2);

        Tracking51Response response = tracking51.trackings.BatchCreateTrackings(paramsList);

        assertNotNull(response);
        if(response.getMeta().getCode() == 200) {
            BatchResults batchResults = (BatchResults) response.getData();
            assertNotNull(batchResults);
        }

    }

    @Test(expected = Tracking51Exception.class)
    public void testBatchCreateTrackingsWithTooManyParams() throws IOException, Tracking51Exception {
        List<CreateTrackingParams> paramsList = new ArrayList<>();
        for (int i = 0; i < 41; i++) {
            CreateTrackingParams params = new CreateTrackingParams();
            params.setTrackingNumber("92632903279511573030094832");
            params.setCourierCode("usps");
            paramsList.add(params);
        }
        tracking51.trackings.BatchCreateTrackings(paramsList);
    }

    @Test(expected = Tracking51Exception.class)
    public void testCreateTrackingWithEmptyTrackingNumber() throws IOException, Tracking51Exception {
        List<CreateTrackingParams> paramsList = new ArrayList<>();
        CreateTrackingParams createTrackingParams1 = new CreateTrackingParams();
        createTrackingParams1.setTrackingNumber("92632903279511573030094832");
        createTrackingParams1.setCourierCode("");
        paramsList.add(createTrackingParams1);

        tracking51.trackings.BatchCreateTrackings(paramsList);
    }

    @Test(expected = Tracking51Exception.class)
    public void testCreateTrackingWithEmptyCourierCode() throws IOException, Tracking51Exception {
        List<CreateTrackingParams> paramsList = new ArrayList<>();
        CreateTrackingParams createTrackingParams1 = new CreateTrackingParams();
        createTrackingParams1.setTrackingNumber("");
        createTrackingParams1.setCourierCode("usps");
        paramsList.add(createTrackingParams1);
        tracking51.trackings.BatchCreateTrackings(paramsList);
    }

    @Test(expected = Tracking51Exception.class)
    public void testUpdateTrackingByIDWithEmptyId() throws IOException, Tracking51Exception {
        String idString = "";
        UpdateTrackingParams updateParams = new UpdateTrackingParams();
        tracking51.trackings.UpdateTrackingByID(idString, updateParams);
    }

    @Test
    public void testUpdateTrackingByIDWithValidData() throws IOException, Tracking51Exception {
        String idString = "9a1d4297af041fc4165206016d108130";
        UpdateTrackingParams updateParams = new UpdateTrackingParams();
        updateParams.setCustomerName("New name");
        updateParams.setNote("New tests order note");

        Tracking51Response response = tracking51.trackings.UpdateTrackingByID(idString, updateParams);

        assertNotNull(response);
        if( response.getMeta().getCode() == 200){
            UpdateTracking updateTracking = (UpdateTracking) response.getData();
            assertNotNull(updateTracking);
        }
    }

    @Test(expected = Tracking51Exception.class)
    public void testDeleteTrackingByIDWithEmptyId() throws IOException, Tracking51Exception {
        String idString = "";
        tracking51.trackings.DeleteTrackingByID(idString);
    }

    @Test
    public void testDeleteTrackingByIDWithValidId() throws IOException, Tracking51Exception {
        String idString = "9a1d4297af041fc4165206016d108130";

        Tracking51Response response = tracking51.trackings.DeleteTrackingByID(idString);

        assertNotNull(response);
        if( response.getMeta().getCode() == 200){
            Tracking tracking = (Tracking) response.getData();
            assertNotNull(tracking);
        }
    }

    @Test(expected = Tracking51Exception.class)
    public void testRetrackTrackingByIDWithEmptyId() throws IOException, Tracking51Exception {
        String idString = "";
        tracking51.trackings.RetrackTrackingByID(idString);
    }

    @Test
    public void testRetrackTrackingByIDWithValidId() throws IOException, Tracking51Exception {
        String idString = "123456";

        Tracking51Response response = tracking51.trackings.RetrackTrackingByID(idString);

        assertNotNull(response);
        if( response.getMeta().getCode() == 200){
            Tracking tracking = (Tracking) response.getData();
            assertNotNull(tracking);
        }
    }

}
