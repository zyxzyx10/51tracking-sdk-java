package com.tracking51.maven.example.tracking;

import com.tracking51.Tracking51;
import com.tracking51.exception.Tracking51Exception;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.tracking.GetResults;
import com.tracking51.model.tracking.GetTrackingResultsParams;
import com.tracking51.model.tracking.RejectedItem;
import com.tracking51.model.tracking.Tracking;

import java.io.IOException;

public class TrackingResultExample {

    public static void main(String[] args) {
        try {
            String apiKey = "you api key";
            Tracking51 tracking51 = new Tracking51(apiKey);

            GetTrackingResultsParams trackingParams = new GetTrackingResultsParams();
            trackingParams.setTrackingNumbers("92612903029511573030094537,92612903029511573030094531");
            trackingParams.setCourierCode("usps");
            trackingParams.setCreatedDateMin("2023-08-23T06:00:00+00:00");
            trackingParams.setCreatedDateMax("2023-09-18T06:00:00+00:00");
            Tracking51Response<GetResults> result = tracking51.trackings.GetTrackingResults(trackingParams);

            System.out.println(result.getMeta().getCode());
            System.out.println(result.getMeta().getMessage());

            GetResults getResults = result.getData();

            if(getResults != null){
                for (Tracking tracking : getResults.getSuccess()) {
                    String id = tracking.getId();
                    String trackingNumber = tracking.getTrackingNumber();
                    String courierCode = tracking.getCourierCode();
                    System.out.println("id："+id);
                    System.out.println("trackingNumber："+trackingNumber);
                    System.out.println("courierCode："+courierCode);
                }

                for (RejectedItem rejectedItem : getResults.getRejected()) {
                    String trackingNumber = rejectedItem.getTrackingNumber();
                    int rejectedCode = rejectedItem.getRejectedCode();
                    String rejectedMessage = rejectedItem.getRejectedMessage();
                    System.out.println("trackingNumber："+trackingNumber);
                    System.out.println("rejectedCode："+rejectedCode);
                    System.out.println("rejectedMessage："+rejectedMessage);
                }
            }

        } catch (Tracking51Exception e) {
            System.err.println("error：" + e.getMessage());
        } catch (IOException e) {
            System.err.println("error：" + e.getMessage());
        }
    }

}
