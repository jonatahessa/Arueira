package com.bebidas.arueira.controle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataTesterTest {

    @Test
    void testZeroSeconds() {
        assertEquals("now", DataTester.formatPeriod(0));
    }

    @Test
    void testOnlySeconds() {
        assertEquals("5 seconds", DataTester.formatPeriod(5));
    }

    @Test
    void testMinutesAndSeconds() {
        assertEquals("1 minute and 2 seconds", DataTester.formatPeriod(62));
    }

    @Test
    void testHoursMinutesAndSeconds() {
        assertEquals("1 hour, 1 minute and 2 seconds", DataTester.formatPeriod(3662));
    }

    @Test
    void testDaysHoursMinutesAndSeconds() {
        assertEquals("1 day, 1 hour, 1 minute and 2 seconds", DataTester.formatPeriod(90062));
    }

    @Test
    void testMonthsDaysHoursMinutesAndSeconds() {
        assertEquals("1 month, 12 hours, 1 minute and 2 seconds",
                DataTester.formatPeriod(2635262));
    }

    @Test
    void testYearsMonthsDaysHoursMinutesAndSeconds() {
        assertEquals("1 year, 1 month, 17 hours, 11 minutes and 2 seconds",
                DataTester.formatPeriod(34189862));
    }

    @Test
    void testMultipleUnits() {
        assertEquals("2 years, 2 months, 1 day, 8 hours, 46 minutes and 7 seconds",
                DataTester.formatPeriod(68373967));
    }

    @Test
    void testLargePeriod() {
        assertEquals("3 years, 4 months, 11 days, 11 hours, 7 minutes and 8 seconds",
                DataTester.formatPeriod(105966428));
    }
}
