package com.qatommy.interview.placeValue;

import org.junit.Test;

public class TimeUnitTests {

    @Test
    public void testTimeUnits() {
        final long MICROS_PER_DAY = 24l * 60l * 60l * 1000l * 1000l;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
    }
}
