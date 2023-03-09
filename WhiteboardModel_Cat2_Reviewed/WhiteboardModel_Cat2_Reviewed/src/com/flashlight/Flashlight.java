package com.flashlight;


import java.time.LocalDate;

/**
 * JR: No significant improvement over original submission, and flawed in several areas,
 * including an incomplete ClientArgs client class.
 *
 * Does not demonstrate good understanding of program concepts.
 *
 * See comments below and in the other classes.
 *
 * Code is clean, readable, well-formatted, though extraneous blank lines at the end
 * of method blocks should be removed.
 *
 * Class participation is adequate.
 *
 * Class names, package names, and overall structure are not correct.
 *  Given the base package name of com.flashlight,
 *  FlashlightValidationTest should be in package com.flashlight.test.
 */
public class Flashlight {

    private FlashlightTypes brand = FlashlightTypes.XHP90;
    private int lumens;

    // JR: better name = batteryLevel, or similar
    private int health;

    // JR: use Java naming conventions for variables, i.e., 'power'.
    // Better name = isOn, the way you're using it, otherwise it feels like a "powerLevel."
    private boolean Power;

    public static final int MIN_HEALTH = 1;
    public static final int MAX_HEALTH = 100;

    // JR: never used anywhere, so why have it?
    // Furthermore, it's never incremented, and stays 0 forever.  See no-arg ctor below.
    private static final int instanceCount = 0;

    private LocalDate dateOfManufacture = LocalDate.of(2021, 10, 10);


    // constructors
    public Flashlight() {
        // no-op
        // JR: here is where you would do the instanceCount++
    }

    public Flashlight(FlashlightTypes brand) {
        setBrand(brand);
    }

    public Flashlight(FlashlightTypes brand, int lumens)  {
        this(brand);
        setLumens(lumens);
    }

    // JR: delegate to 2-arg ctor above for brand, lumens, then call setter for health.
    // Also, provide a 4-arg ctor for all properties: brand, lumens, health, power.
    public Flashlight(FlashlightTypes brand, int lumens, int health) {
        this.brand = brand;
        this.lumens = lumens;
        this.health = health;
    }

    // JR: never called from any of the clients, so why have it?
    // As mentioned in class, don't put this in just because the Television labs did so -
    // that was to demonstrate static methods.  If you find it interesting, that's fine,
    // but then call it from FlashlightClient to see how it works, and implement it
    // correctly, by incrementing it in the no-arg ctor.
    public static int getInstanceCount() {
        return instanceCount;
    }

    // getters/setters

    public FlashlightTypes getBrand() {
        return brand;
    }

    /*
     * JR: exception handling (and throwing) was not needed, and done inappropriately below.
     *  1. No validation is needed for an enum type, the client only has 5 options:
     *          EVERBRITE, XHP90, STREAMLIGHT, LIFEGEAR, ENERGIZER
     *     This is the primary reason we use enums.
     *  2. "this.brand = brand" would never throw an exception, so no catch needed.
     *  3. Error message is insufficient.
     */
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

    // JR: the 'health' field at the top is type int, so the return type
    // of this method should be int, not double.
    public double getHealth() {
        return health;
    }

    // JR: use MIN_HEALTH constant instead of a hardcoded 1.
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

    /*
     * JR: no accompanying getter method, i.e., getManufactureDate().
     * While we sometimes provide a getter but no setter, it is very rare to do the opposite,
     * i.e., setter but no getter.
     * Your clients have no way to find out the manufactureDate of an existing Flashlight object.
     */
    public void setManufactureDate(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public boolean isPower() {
        return Power;
    }

    /*
     * JR: fairly uncreative and trivial, this is all they can do?
     * Perhaps that's true, or do a different type of thing, like Cat, which can:
     *  purr(), sleep(), eat(), climb(), pukeHairball(), etc.
     */
    public void turnOn() {
        this.Power = true;
        System.out.println("Power on " + "Battery health is: " + getHealth());
    }
    public void turnOff() {
        this.Power = false;
        System.out.println("Power off" + "Battery health is: " + getHealth());
    }

    // toString

    /*
     * JR: okay to use the generated toString() method, but change the direct field access
     * to call your own getter methods instead, like we do in class all the time.
     */
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
