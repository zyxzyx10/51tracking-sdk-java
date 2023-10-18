package com.tracking51.maven.example.courier;

import com.tracking51.Tracking51;
import com.tracking51.exception.Tracking51Exception;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.courier.Courier;
import com.tracking51.model.courier.DetectParams;

import java.io.IOException;
import java.util.List;

public class DetectCourierExample {

    public static void main(String[] args) {
        try {
            String apiKey = "you api key";
            Tracking51 tracking51 = new Tracking51(apiKey);
            DetectParams detectParams = new DetectParams();
            detectParams.setTrackingNumber("92642903289511563030094932");
            Tracking51Response result = tracking51.couriers.detect(detectParams);
            System.out.println(result.getMeta().getCode());
            if(result.getData() != null){
                List<Courier> couriers = (List<Courier>) result.getData();
                for (Courier courier : couriers) {
                    String courierName = courier.getCourierName();
                    String courierCode = courier.getCourierCode();
                    System.out.println(courierName+"---"+courierCode);
                }
            }
        } catch (Tracking51Exception e) {
            System.err.println("error：" + e.getMessage());
        } catch (IOException e) {
            System.err.println("error：" + e.getMessage());
        }
    }

}
