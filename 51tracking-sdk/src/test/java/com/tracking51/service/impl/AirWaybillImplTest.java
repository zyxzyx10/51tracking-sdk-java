package com.tracking51.service.impl;

import com.tracking51.Tracking51;
import com.tracking51.exception.Tracking51Exception;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.airWaybill.AirWaybill;
import com.tracking51.model.airWaybill.AirWaybillParams;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import static org.junit.Assert.*;

public class AirWaybillImplTest {

    private Tracking51 tracking51;

    @Before
    public void setUp() throws Tracking51Exception {
        String apiKey = "apiKey";
        tracking51 = new Tracking51(apiKey);
    }

    @Test
    public void testCreateAnAirWayBillSuccess() throws IOException, Tracking51Exception {
        AirWaybillParams airWaybillParams = new AirWaybillParams();
        airWaybillParams.setAwbNumber("235-69030430");  // 符合要求的 awbNumber

        Tracking51Response response = tracking51.airWaybills.CreateAnAirWayBill(airWaybillParams);

        System.out.println(response);
        assertNotNull(response);
        if(response.getMeta().getCode() == 200){
            AirWaybill airWaybillData = (AirWaybill) response.getData();
            assertNotNull(airWaybillData);
        }

    }

    @Test(expected = Tracking51Exception.class)
    public void testCreateAnAirWayBillMissingAwbNumber() throws IOException, Tracking51Exception {
        AirWaybillParams airWaybillParams = new AirWaybillParams();
        tracking51.airWaybills.CreateAnAirWayBill(airWaybillParams);
    }

    @Test(expected = Tracking51Exception.class)
    public void testCreateAnAirWayBillInvalidAwbNumberFormat() throws IOException, Tracking51Exception {
        AirWaybillParams airWaybillParams = new AirWaybillParams();
        airWaybillParams.setAwbNumber("123456");
        tracking51.airWaybills.CreateAnAirWayBill(airWaybillParams);
    }
}
