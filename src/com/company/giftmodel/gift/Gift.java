package com.company.giftmodel.gift;

import com.company.giftmodel.packing.packingChildren.GiftPacking;

import java.util.Objects;

public abstract class Gift {

    private String name;
    private GiftPacking packing;

    public Gift() {
        name = "";
        packing = null;
    }

    public Gift(String name, GiftPacking packing) {
        this.name = name;
        this.packing = packing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GiftPacking getPacking() {
        return packing;
    }

    public void setPacking(GiftPacking packing) {
        this.packing = packing;
    }

    @Override
    public String toString() {
        return "Подарок: " + name + " | " + packing.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gift gift = (Gift) o;
        return Objects.equals(name, gift.name) &&
                Objects.equals(packing, gift.packing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, packing);
    }

    public void printInfo()
    {
        System.out.println(toString());
    }
}