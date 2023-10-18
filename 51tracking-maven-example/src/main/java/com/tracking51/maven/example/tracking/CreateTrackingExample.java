package com.tracking51.maven.example.tracking;

import com.tracking51.Tracking51;
import com.tracking51.exception.Tracking51Exception;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.tracking.CreateTrackingParams;
import com.tracking51.model.tracking.Tracking;

import java.io.IOException;

public class CreateTrackingExample {

    public static void main(String[] args) {
        try {
            String apiKey = "you api key";
            Tracking51 tracking51 = new Tracking51(apiKey);
            CreateTrackingParams createTrackingParams = new CreateTrackingParams();
            createTrackingParams.setTrackingNumber("92612903029511573030094537");
            createTrackingParams.setCourierCode("usps");
            Tracking51Response result = tracking51.trackings.CreateTracking(createTrackingParams);
            System.out.println(result.getMeta().getCode());
            if(result.getData() != null){
                Tracking trackings = (Tracking) result.getData();
                System.out.println(trackings);
                System.out.println(trackings.getTrackingNumber());
            }
        } catch (Tracking51Exception e) {
            System.err.println("error：" + e.getMessage());
        } catch (IOException e) {
            System.err.println("error：" + e.getMessage());
        }
    }

}
