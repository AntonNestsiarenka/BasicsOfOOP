package com.company.dragontreasuremodel.dragon;

import com.company.dragontreasuremodel.cave.Cave;

public class Dragon {

    /* Класс описывает дракона. */

    private String name;
    private Cave cave;

    public Dragon()
    {
        name = "";
        cave = null;
    }

    public Dragon(String name, Cave cave)
    {
        this.name = name;
        this.cave = cave;
        cave.setDragon(this);
    }

    public Dragon(String name) {
        this.name = name;
        cave = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cave getCave() {
        return cave;
    }

    public void setCave(Cave cave) {
        this.cave = cave;
    }

    @Override
    public String toString() {
        String text = (cave != null) ? cave.getName() : "";
        return name + text;
    }

    public void printInfo()
    {
        System.out.println(toString());
    }
}
