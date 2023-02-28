package com.entertainment;

import java.util.Objects;

// instance variables
public class Television {
    private String brand;
    private int volume;

    // HAS-A
    private Tuner tuner = new Tuner();

   // constructors
    public Television() {
    }

    public Television(String brandA, int volume) {
        setBrand(brandA);
        setVolume(volume);
    }

// accessor methods
    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int hashCode() {
        // this is a poorly written function, bc it easily results in hash collisions.
        // a hash collision is when different object have the same hashcode.
        // return getBrand().length() + getVolume();

        // we can use a java.util.Objects to help us create a scientifically correct hash function
        // ie, one that minimizes the probability of hash collisions

        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        // proceed only in obj is really a reference to a Television object
        if (obj instanceof Television) {
            // safely downcast to more specific type television, so we can call TV methods
            Television other = (Television) obj;

            // do the checks: brands are the same and volumes are the same
            result = Objects.equals(this.getBrand(), other.getBrand()) &&   // null safe check
                     this.getVolume() == other.getVolume();                 // volume is primitive int
        }

        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[brand=" + getBrand() + ", volume=" + getVolume() + ", currentChannel=" +
                getCurrentChannel() + "]";
    }
}