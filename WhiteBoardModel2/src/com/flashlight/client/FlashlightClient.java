package com.flashlight.client;

import com.flashlight.Flashlight;
import com.flashlight.FlashlightTypes;

import java.time.LocalDate;

class FlashlightClient {

    public static void main(String[] args) {
        Flashlight f1 = new Flashlight(FlashlightTypes.LIFEGEAR, 160000, 100);
        Flashlight f2 = new Flashlight(FlashlightTypes.ENERGIZER, 90000, 98);
        Flashlight f3 = new Flashlight(FlashlightTypes.XHP90, 600, 65);
        Flashlight f4 = new Flashlight();

        f1.turnOn();
        f1.setBrand(FlashlightTypes.LIFEGEAR);
        f1.setLumens(150000);
        f1.setHealth(0);
        System.out.println(f1);

        f2.turnOn();
        System.out.println(f2);
        System.out.println(f3);

        System.out.println();

        System.out.println(f4);
        f4.setBrand(FlashlightTypes.STREAMLIGHT);
        System.out.println(f4);




    }



}
