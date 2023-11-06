package com.tracking51.service;

import com.tracking51.model.Tracking51Response;

import java.io.IOException;

public interface Couriers {

    Tracking51Response getAllCouriers() throws IOException;

}
