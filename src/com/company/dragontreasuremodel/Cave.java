package com.company.dragontreasuremodel;

import java.util.ArrayList;
import java.util.ListIterator;

public class Cave {

    private String name;
    private Dragon dragon;
    private ArrayList<Treasure> treasures;

    public Cave()
    {
        name = "";
        dragon = null;
        treasures = new ArrayList<Treasure>();
    }

    public Cave(String name, ArrayList<Treasure> treasures) {
        this.name = name;
        dragon = null;
        this.treasures = treasures;
    }

    public Cave(String name) {
        this.name = name;
        dragon = null;
        treasures = new ArrayList<Treasure>();
    }

    public Cave(String name, Dragon dragon) {
        this.name = name;
        this.dragon = dragon;
        treasures = new ArrayList<Treasure>();
        dragon.setCave(this);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTreasures(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
    }

    public Dragon getDragon() {
        return dragon;
    }

    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }

    public void addTreasure(Treasure treasure)
    {
        treasures.add(treasure);
    }

    public void removeTreasure(Treasure treasure)
    {
        treasures.remove(treasure);
    }

    public void clearTreasure()
    {
        treasures.clear();
    }

    public void sortTreasuresByPrice()
    {
        treasures.sort(Treasure::compareTo);
    }

    public void printAllTreasures()
    {
        for (Treasure treasure : treasures)
        {
            treasure.printInfo();
        }
    }

    public void printMostExpensiveTreasure()
    {
        System.out.println("Самое дорогое сокровище в пещере дракона: ");
        if (!treasures.isEmpty())
        {
            Treasure treasureWithMaxPrice = treasures.get(0);
            for (Treasure treasure : treasures) {
                if (treasure.getPrice() > treasureWithMaxPrice.getPrice()) {
                    treasureWithMaxPrice = treasure;
                }
            }
            treasureWithMaxPrice.printInfo();
        }
        else
        {
            System.out.println("В пещере нет сокровищ!");
        }
    }

    public void printTreasuresBySetPrice(double price)
    {
        sortTreasuresByPrice();
        ArrayList<Treasure> treasures = new ArrayList<Treasure>();
        double sum = 0;
        boolean flag = true;
        ListIterator<Treasure> iterator = this.treasures.listIterator();
        while (iterator.hasNext() && flag)
        {
            Treasure currentTreasure = iterator.next();
            if (sum + currentTreasure.getPrice() <= price)
            {
                treasures.add(currentTreasure);
                sum += currentTreasure.getPrice();
            }
            else
            {
                flag = false;
            }
        }
        System.out.printf("Сокровища на заданную сумму %f USD\n", price);
        for (Treasure treasure : treasures)
        {
            treasure.printInfo();
        }
    }

    @Override
    public String toString() {
        String text = (dragon != null) ? dragon.getName() : "";
        return name + text + treasures.toString();
    }

    public void printInfo()
    {
        System.out.println(toString());
    }
}