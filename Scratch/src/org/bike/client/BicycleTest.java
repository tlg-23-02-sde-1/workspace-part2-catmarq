package org.bike.client;

import org.bike.Bicycle;

public class BicycleTest {
    public static void main(String[] args) {
        Bicycle bike1 = new Bicycle("Blue", 50.0, 6);
        System.out.println(bike1);
        System.out.println();
        Bicycle bike2 = new Bicycle("Green", 125.0, 10);
        System.out.println(bike2);

    }

}
