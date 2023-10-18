package com.tracking51;

import com.tracking51.exception.ErrorEnums;
import com.tracking51.exception.Tracking51Exception;
import com.tracking51.service.AirWaybills;
import com.tracking51.service.Couriers;
import com.tracking51.service.Trackings;
import com.tracking51.service.impl.AirWaybillImpl;
import com.tracking51.service.impl.CourierImpl;
import com.tracking51.service.impl.TrackingImpl;

public class Tracking51 {

    public static String apiKey;

    public Couriers couriers;

    public AirWaybills airWaybills;

    public Trackings trackings;

    public Tracking51(String apiKey) throws Tracking51Exception {
         if(apiKey == ""){
             throw new Tracking51Exception(ErrorEnums.ErrEmptyAPIKey);
         }
         this.apiKey = apiKey;
         this.couriers = new CourierImpl();
         this.airWaybills = new AirWaybillImpl();
         this.trackings = new TrackingImpl();
    }
}
