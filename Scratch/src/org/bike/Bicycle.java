package org.bike;

public class Bicycle {
    // fields
    String color;
    double price;
    int gears;

    // constructor
    public Bicycle() {
        // no-op
    }

    public Bicycle(String color, double price, int gears) {
        this.color = color;
        this.price = price;
        this.gears = gears;
    }

// business method

// helper method

// accessor method get/set/toString

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "color='" + color + '\'' +
                ", price=" + price +
                ", gears=" + gears +
                '}';
    }
}
