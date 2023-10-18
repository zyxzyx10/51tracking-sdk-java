package com.tracking51.service;

import com.tracking51.exception.Tracking51Exception;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.airWaybill.AirWaybillParams;

import java.io.IOException;

public interface AirWaybills {

    Tracking51Response CreateAnAirWayBill(AirWaybillParams airWaybillParams) throws Tracking51Exception,IOException;

}
