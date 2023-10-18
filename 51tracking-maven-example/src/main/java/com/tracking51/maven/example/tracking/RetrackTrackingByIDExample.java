package com.tracking51.maven.example.tracking;

import com.tracking51.Tracking51;
import com.tracking51.exception.Tracking51Exception;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.tracking.Tracking;

import java.io.IOException;

public class RetrackTrackingByIDExample {

    public static void main(String[] args) {
        try {
            String apiKey = "you api key";
            Tracking51 tracking51 = new Tracking51(apiKey);
            String idString = "9a035f5cdd0437c55d48e223c705a66c";
            Tracking51Response result = tracking51.trackings.RetrackTrackingByID(idString);
            System.out.println(result.getMeta().getCode());
            if(result.getData() != null){
                Tracking  tracking= (Tracking) result.getData();
                System.out.println(tracking.getTrackingNumber());
            }
        } catch (Tracking51Exception e) {
            System.err.println("error：" + e.getMessage());
        } catch (IOException e) {
            System.err.println("error：" + e.getMessage());
        }
    }

}
