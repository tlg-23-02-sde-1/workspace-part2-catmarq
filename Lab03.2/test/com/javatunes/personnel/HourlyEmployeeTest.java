package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    // object under test
    private HourlyEmployee emp;

    @Before
    public void setUp() {
        emp = new HourlyEmployee("Mark", Date.valueOf("2020-02-02"), 40.0, 40.0);
    }

    @Test
    public void testPay() {
        assertEquals(1600.0, emp.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(400.0, emp.payTaxes(), .001);
    }
}