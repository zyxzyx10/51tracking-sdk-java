package com.tracking51.maven.example.tracking;

import com.tracking51.Tracking51;
import com.tracking51.exception.Tracking51Exception;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.tracking.UpdateTracking;
import com.tracking51.model.tracking.UpdateTrackingParams;

import java.io.IOException;

public class UpdateTrackingByIDExample {

    public static void main(String[] args) {
        try {
            String apiKey = "you api key";
            Tracking51 tracking51 = new Tracking51(apiKey);
            String idString = "9a035f5cdd0437c55d48e223c705a66c";
            UpdateTrackingParams updateTrackingParams = new UpdateTrackingParams();
            updateTrackingParams.setCustomerName("New name");
            updateTrackingParams.setNote("New tests order note");
            Tracking51Response result = tracking51.trackings.UpdateTrackingByID(idString, updateTrackingParams);
            System.out.println(result.getMeta().getCode());
            if(result.getData() != null){
                UpdateTracking  updateTracking= (UpdateTracking) result.getData();
                System.out.println(updateTracking);
                System.out.println(updateTracking.getTrackingNumber());
            }
        } catch (Tracking51Exception e) {
            System.err.println("error：" + e.getMessage());
        } catch (IOException e) {
            System.err.println("error：" + e.getMessage());
        }
    }

}
