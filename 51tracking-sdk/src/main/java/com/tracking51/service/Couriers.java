package com.tracking51.service;

import com.tracking51.exception.Tracking51Exception;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.courier.DetectParams;

import java.io.IOException;

public interface Couriers {

    Tracking51Response getAllCouriers() throws IOException;

    Tracking51Response detect(DetectParams detectParams) throws Tracking51Exception,IOException;

}
