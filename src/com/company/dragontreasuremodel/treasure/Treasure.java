package com.company.dragontreasuremodel.treasure;

public class Treasure implements Comparable<Treasure> {

    /* Класс описывает сокровище. */

    private String name;
    double price; // usd

    public Treasure()
    {
        name = "";
        price = 0;
    }

    public Treasure(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Treasure o) {
        return Double.compare(this.getPrice(), o.getPrice());
    }

    @Override
    public String toString() {
        return name + " - " + price + " USD";
    }

    public void printInfo()
    {
        System.out.println(toString());
    }
}
