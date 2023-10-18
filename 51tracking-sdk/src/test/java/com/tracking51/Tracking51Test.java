package com.tracking51;

import com.tracking51.exception.Tracking51Exception;
import org.junit.Before;
import org.junit.Test;

public class Tracking51Test {

    private Tracking51 tracking51;

    @Before
    public void setUp() throws Tracking51Exception {
        String apiKey = "apiKey";
        tracking51 = new Tracking51(apiKey);
    }

    @Test(expected = Tracking51Exception.class)
    public void testConstructorWithEmptyApiKey() throws Tracking51Exception {
        new Tracking51("");
    }

}
