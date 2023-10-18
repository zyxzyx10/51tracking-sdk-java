package example.tracking;

import com.tracking51.Tracking51;
import com.tracking51.exception.Tracking51Exception;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.tracking.Tracking;

import java.io.IOException;

public class DeleteTrackingByIDExample {

    public static void main(String[] args) {
        try {
            String apiKey = "you api key";
            Tracking51 tracking51 = new Tracking51(apiKey);
            String idString = "9a28d8ba030596de70c1b0134cdc8b0d";
            Tracking51Response result = tracking51.trackings.DeleteTrackingByID(idString);
            System.out.println(result);
            System.out.println(result.getMeta().getCode());
            if(result.getData() != null) {
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
