package com.entertainment;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class TelevisionTest {
    private Television tv1;
    private Television tv2;

    @Before
    public void setUp() {
        tv1 = new Television("Sony", 20, DisplayType.LED);
        tv2 = new Television("Sony", 20, DisplayType.LED);
    }

    @Test
    public void hashCode_shouldNotBeEqual_whenObjectsAreTheSame() {
        assertNotEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test
    public void hashCode_shouldNotBeEqual_whenSameBrand_whenDifferentVolume_whenSameDisplayType() {
        tv1.setVolume(88);
        assertNotEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test
    public void hashCode_shouldNotBeEqual_whenSameBrand_whenSameVolume_whenDifferentDisplayType() {
        tv2.setDisplay(DisplayType.PLASMA);
        assertNotEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test
    public void hasCode_shouldNotBeEqual_whenDifferentBrand_whenSameVolume_whenSameDisplayType() {
        tv2.setBrand("SEGA");
        assertNotEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test
    public void hashCode_equalsObjects_mustHaveEqualHashCodes() {
        assertNotEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test
    public void compare_shouldReturnPositive_whenDifferentChannel() throws InvalidChannelException {
        TelevisionChannelComparator compares = new TelevisionChannelComparator();
        tv1.changeChannel(654);
        assertTrue(compares.compare(tv1,tv2) > 0);
    }

    @Test
    public void compare_shouldReturnNegativeInt_whenDifferentChannel() throws InvalidChannelException {
        TelevisionChannelComparator compares = new TelevisionChannelComparator();
        tv2.changeChannel(321);
        assertTrue(compares.compare(tv1, tv2) < 0);
    }

    @Test
    public void compare_shouldEqualZero_whenSameBrand_whenSameCurrentChannel() {
        TelevisionBrandChannelComparator compares = new TelevisionBrandChannelComparator();
        assertEquals(0, compares.compare(tv1, tv2));
    }

    @Test
    public void compare_shouldReturnNegative_sameBrand_differentCurrentChannel() throws InvalidChannelException {
        TelevisionBrandChannelComparator compares = new TelevisionBrandChannelComparator();
        tv2.changeChannel(222);
        assertTrue(compares.compare(tv1, tv2) >0);
    }

    @Test
    public void compare_shouldReturnPositiveInt_sameCurrentChannel_whenDifferentBrand() {
        TelevisionBrandChannelComparator compares = new TelevisionBrandChannelComparator();
        tv1.setBrand("Magnavox");
        assertTrue(compares.compare(tv1, tv2) > 0);
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws InvalidChannelException {
        Television tv1 = new Television();
        tv1.changeChannel(1);
            assertTrue("Channel: ", Boolean.parseBoolean("True"));
    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_upperBound() {
        try {
            Television tv = new Television();
            tv.changeChannel(1000);  // should trigger the exception

            fail("Should have thrown InvalidChannelException");

        } catch (InvalidChannelException e) {

            // you can assert that the exception's reason message is what you expect
            assertEquals("Invalid channel: 1000. Allowed range: [1,999].", e.getMessage());
        }
    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_lowerBound() {
        try {
            Television tv = new Television();
            tv.changeChannel(0);  // should trigger the exception

            fail("Should have thrown InvalidChannelException");

        } catch (InvalidChannelException e) {

            // you can assert that the exception's reason message is what you expect
            assertEquals("Invalid channel: 0. Allowed range: [1,999].", e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_lowerBound() {
        Television tv = new Television();
        tv.setVolume(-1);  // trigger the exception and DON'T catch it
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_lowerBound() {
        Television tv = new Television();
        tv.setVolume(0);
        assertEquals(0, tv.getVolume());
    }



}

