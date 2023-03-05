package com.flashlight;


import java.time.LocalDate;

public class Flashlight {

    private FlashlightTypes brand = FlashlightTypes.XHP90;
    private int lumens;
    private int health;
    private boolean Power;

    public static final int MIN_HEALTH = 1;
    public static final int MAX_HEALTH = 100;
    private static final int instanceCount = 0;
    private LocalDate dateOfManufacture = LocalDate.of(2021, 10, 10);


    // constructors
    public Flashlight() {
        // no-op
    }

    public Flashlight(FlashlightTypes brand) {
        setBrand(brand);
    }

    public Flashlight(FlashlightTypes brand, int lumens)  {
        this(brand);
        setLumens(lumens);
    }

    public Flashlight(FlashlightTypes brand, int lumens, int health) {
        this.brand = brand;
        this.lumens = lumens;
        this.health = health;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    // getters/setters

    public FlashlightTypes getBrand() {
        return brand;
    }

    public void setBrand(FlashlightTypes brand) {
        try {
            this.brand = brand;
        } catch (IllegalArgumentException e) {
            System.out.println("Nope");
        }
    }

//    public void setBrand(String brand) {
//        switch (brand) {
//            case "XHP90":
//            case "Everbright":
//            case "Lifegear":
//            case "Streamlight":
//            case "Energizer":
//                this.brand = brand;
//            default:
//                System.out.println("Invalid Brand: " + brand + ", valid brands are " +
//                        "XHP90, Everbright, Lifegear, Streamlight, Energizer");
//        }
//    }

    public int getLumens() {
        return lumens;
    }

    public void setLumens(int lumens) {
        this.lumens = lumens;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth (int health) {
        if (health >=1 && health <MAX_HEALTH ) {
            this.health = health;
            System.out.println("Power level" + getHealth());
        } else if (health == MAX_HEALTH) {
            this.health = health;
            System.out.println("Fully Charged" + getHealth());
        } else if (health >MAX_HEALTH){
            this.health = MAX_HEALTH;
            System.out.printf("INVALID RANGE stop charging at 100: %s, valid range is %s-%s\n",
                    health, MIN_HEALTH, MAX_HEALTH);
        } else if (health <= 0) {
            this.health = 0;
            turnOff();
        }
    }

    public void setManufactureDate(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public boolean isPower() {
        return Power;
    }

    public void turnOn() {
        this.Power = true;
        System.out.println("Power on " + "Battery health is: " + getHealth());
    }
    public void turnOff() {
        this.Power = false;
        System.out.println("Power off" + "Battery health is: " + getHealth());
    }

    // toString


    @Override
    public String toString() {
        return "Flashlight{" +
                "brand='" + brand + '\'' +
                ", lumens=" + lumens +
                ", health=" + health +
                ", Power=" + Power +
                '}';
    }
}
