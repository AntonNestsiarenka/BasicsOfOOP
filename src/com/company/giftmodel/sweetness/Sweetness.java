package com.company.giftmodel.sweetness;

import java.util.Objects;

public abstract class Sweetness {

    private String name;
    private String manufacturer;
    private double weight;

    public Sweetness() {
        name = "";
        manufacturer = "";
        weight = 0;
    }

    public Sweetness(String name, String manufacturer, double weight) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract String toString();

    public abstract void printInfo();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sweetness sweetness = (Sweetness) o;
        return Double.compare(sweetness.weight, weight) == 0 &&
                Objects.equals(name, sweetness.name) &&
                Objects.equals(manufacturer, sweetness.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, manufacturer, weight);
    }
}