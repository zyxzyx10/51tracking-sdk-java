package example.airWaybill;

import com.tracking51.Tracking51;
import com.tracking51.exception.Tracking51Exception;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.airWaybill.AirWaybill;
import com.tracking51.model.airWaybill.AirWaybillParams;

import java.io.IOException;

public class AwbExample {

    public static void main(String[] args) {
        try {
            String apiKey = "you api key";
            Tracking51 tracking51 = new Tracking51(apiKey);
            AirWaybillParams detectParams = new AirWaybillParams();
            detectParams.setAwbNumber("235-69030430");
            Tracking51Response result = tracking51.airWaybills.CreateAnAirWayBill(detectParams);
            System.out.println(result.getMeta().getCode());
            if(result.getData() != null){
                AirWaybill airWaybills = (AirWaybill) result.getData();
                System.out.println(airWaybills);
                System.out.println(airWaybills.getAwbNumber());
                System.out.println(airWaybills.getAirlineInfo().getName());
                System.out.println(airWaybills.getFlightInfo().get("TK0721").getDepartStation());
            }

        } catch (Tracking51Exception e) {
            System.err.println("error：" + e.getMessage());
        } catch (IOException e) {
            System.err.println("error：" + e.getMessage());
        }
    }

}
