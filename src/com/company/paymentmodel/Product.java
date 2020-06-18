package com.company.paymentmodel;

public class Product {

    private static long idUnique = 0;

    private long id;
    private String name;
    private String description;
    private double price; // usd

    public Product()
    {
        id = idUnique++;
        name = "";
        description = "";
        price = 0;
    }

    public Product(String name, String description, double price) {
        id = idUnique++;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public static long getIdUnique() {
        return idUnique;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product id: " + id
                + " | " + getName()
                + " | " + getDescription()
                + " | " + getPrice() + " USD";
    }

    public void printInfo()
    {
        System.out.println(toString());
    }
}