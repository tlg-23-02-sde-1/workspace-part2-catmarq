package com.crunch;

// natural order is determined by size (double)
class Radish implements Comparable<Radish> {
// fields
    private String color;
    private double size;
    private double tailLength;
    private int sprouts;


// constructor

    public Radish(String color, double size, double tailLength, int sprouts) {
       setColor(color);
       setSize(size);
       setTailLength(tailLength);
       setSprouts(sprouts);
    }

    // accessor method get/set/toString
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public int getSprouts() {
        return sprouts;
    }

    public void setSprouts(int sprouts) {
        this.sprouts = sprouts;
    }

    @Override
    public int compareTo(Radish other) {
        return Double.compare(this.getSize(), other.getSize());
    }

    // toString
    @Override
    public String toString() {
        return String.format("%s: color=%s, size=%s, tailLength=%s, sprouts=%s",
                getClass().getSimpleName(), getColor(), getSize(), getTailLength(), getSprouts());
    }

}
