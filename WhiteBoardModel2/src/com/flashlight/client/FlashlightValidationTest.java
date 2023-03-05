package com.flashlight.client;

import com.flashlight.Flashlight;
import com.flashlight.FlashlightTypes;

class FlashlightValidationTest {

    public static void main(String[] args) {
        Flashlight f1 = new Flashlight();
        f1.setHealth(0);        // PWR off, health 0
        System.out.println(f1);
        System.out.println();

        f1.setHealth(100);   // fully charged
        System.out.println(f1);
        System.out.println();

        f1.setHealth(1);    // health 5
        System.out.println(f1);
        System.out.println();

        f1.setHealth(101);    // correct call.
        System.out.println(f1);
        System.out.println();


    }


}
