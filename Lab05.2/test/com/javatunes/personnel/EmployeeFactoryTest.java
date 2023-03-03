package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class EmployeeFactoryTest {
    private Map<String, String> seMap;
    private Map<String, String> heMap;

    /**
     * client input request is a Map<String,String>, here's a sample
     * key        value
     * ---        -----
     * type       HE or SE
     * name       Jackie
     * hireDate   1990-08-24
     * <p>
     * salary     50000.00
     * OR
     * rate       50.0
     * hours      40.0
     * <p>
     * NOTES:
     * 1. yes, we have redundant setup code, and even some redundant test code (to keep it simple)
     * 2. this is representative of how UIs send user input data to an application:
     * - Java Swing UI components all return their input data as strings
     * - in webapps, HTTP requests from browsers (e.g., a form submission) carry all values as strings
     */
    @Before
    public void init() {
        seMap = new HashMap<>();
        seMap.put("type", "SE");
        seMap.put("name", "Jackie");
        seMap.put("hireDate", "1990-08-24");
        seMap.put("salary", "50000.0");

        heMap = new HashMap<>();
        heMap.put("type", "HE");
        heMap.put("name", "Jackie");
        heMap.put("hireDate", "1990-08-24");
        heMap.put("rate", "50.0");
        heMap.put("hours", "40.0");
    }

    /**
     * TASK: verify that passing seMap into your factory returns a SalariedEmployee, with all properties set.
     * to check an object's type, you can use instanceof or check its Class object (preferred):
     * assertEquals(SalariedEmployee.class, emp.getClass())
     */
    @Test
    public void testCreateEmployeeSalaried() {
        // TODO
    }

    /**
     * TASK: verify that passing heMap into your factory returns a HourlyEmployee, with all properties set.
     */
    @Test
    public void testCreateEmployeeHourly() {
        // TODO
    }

    /**
     * TASK: verify that passing a map with an invalid "type" value results in IllegalArgumentException.
     * The only valid values for "type" are "HE" or "SE".
     */
    @Test(expected = IllegalArgumentException.class)
    public void createEmployee_shouldThrowIllegalArgumentException_whenInvalidType_expectedAttribute() {
        seMap.put("type", "INVALID-TYPE");
        EmployeeFactory.createEmployee(seMap); // should trigger the exception
    }

    @Test
    public void createEmployee_shouldThrowIllegalArgumentException_whenInvalidType_tryCatchFail() {
        seMap.put("type", "INVALID-TYPE");
        try {
            EmployeeFactory.createEmployee(seMap);  // should trigger the exception
            fail("should have thrown IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            assertEquals("Invalid type: INVALID-TYPE", e.getMessage());
        }
    }

    @Test
    public void createEmployee_shouldReturnSalariedEmployee_whenTypeIsSE() {
        Employee emp = EmployeeFactory.createEmployee(seMap);

        // assertTrue(emp instanceof SalariedEmployee);
        assertEquals(SalariedEmployee.class, emp.getClass());
        // check that name, hireDate, and salary are correct
        assertEquals("Jackie", emp.getName());
        assertEquals(Date.valueOf("1990-08-24"), emp.getHireDate());

        // downcast "emp" reference to more specific type SalariedEmployee
        SalariedEmployee semp = (SalariedEmployee) emp;
        assertEquals("50000.0", semp.getSalary().toString());
    }

    @Test
    public void CreateEmployee_shouldReturnHourlyEmployee_whenTypeHE() {
        Employee emp = EmployeeFactory.createEmployee(heMap);

        assertEquals(HourlyEmployee.class, emp.getClass());
        // check that name, hireDate, rate, hours are correct
        checkNameHireDate(emp);

        //downcast
        HourlyEmployee hemp = (HourlyEmployee) emp;
        assertEquals(50.0, hemp.getRate(), .001);
        assertEquals(40.0, hemp.getHours(), .001);
    }

    private void checkNameHireDate(Employee emp) {
        assertEquals("Jackie", emp.getName());
        assertEquals("1990-08-24", emp.getHireDate().toString());
    }
}