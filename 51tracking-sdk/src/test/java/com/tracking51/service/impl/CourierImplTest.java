package com.tracking51.service.impl;

import com.tracking51.Tracking51;
import com.tracking51.exception.Tracking51Exception;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.courier.Courier;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CourierImplTest {
    private Tracking51 tracking51;

    @Before
    public void setUp() throws Tracking51Exception {
        String apiKey = "apiKey";
        tracking51 = new Tracking51(apiKey);
    }

    @Test
    public void testGetAllCouriers() throws Exception {
        Tracking51Response response = tracking51.couriers.getAllCouriers();
        assertNotNull(response);
        if(response.getMeta().getCode() == 200){
            List<Courier> couriers = (List<Courier>) response.getData();
            for (Courier courier : couriers) {
                assertNotNull(courier);
            }
        }
    }

}
