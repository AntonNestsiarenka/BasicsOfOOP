package com.company.giftmodel.packing.packingChildren.giftPackingChildren;

import com.company.giftmodel.packing.packingChildren.GiftPacking;
import com.company.giftmodel.sweetness.Sweetness;
import com.company.giftmodel.sweetness.sweetnessChildren.Candy;
import com.company.giftmodel.sweetness.sweetnessChildren.Chocolate;
import com.company.giftmodel.sweetness.sweetnessChildren.Halva;
import com.company.giftmodel.sweetness.sweetnessChildren.Marshmallow;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class GiftSweetnessPacking extends GiftPacking {

    private ArrayList<Sweetness> sweetness;

    public GiftSweetnessPacking() {
        super();
        sweetness = new ArrayList<Sweetness>();
    }

    public GiftSweetnessPacking(double maxWeight, TypeOfGiftPacking typeOfGiftPacking) {
        super(maxWeight, typeOfGiftPacking);
        sweetness = new ArrayList<Sweetness>();
    }

    public GiftSweetnessPacking(GiftSweetnessPacking other)
    {
        this(other.getMaxWeight(), TypeOfGiftPacking.valueOf(other.getTypeOfGiftPacking().name()));
    }

    public ArrayList<Sweetness> getSweetness() {
        return sweetness;
    }

    public double getCurrentWeightGiftPacking()
    {
        double sumWeight = 0;
        for (Sweetness sweetness : sweetness)
        {
            sumWeight += sweetness.getWeight();
        }
        return sumWeight;
    }

    public boolean addSweetness(Sweetness sweetness)
    {
        if (sweetness.getWeight() + getCurrentWeightGiftPacking() <= getMaxWeight()) {
            Sweetness sweetnessNew = null;
            if (sweetness instanceof Candy) {
                Candy candy = (Candy) sweetness;
                sweetnessNew = new Candy(candy);
            }
            else if (sweetness instanceof Chocolate)
            {
                Chocolate chocolate = (Chocolate) sweetness;
                sweetnessNew = new Chocolate(chocolate);
            }
            else if (sweetness instanceof Halva)
            {
                Halva halva = (Halva) sweetness;
                sweetnessNew = new Halva(halva);
            }
            else if (sweetness instanceof Marshmallow)
            {
                Marshmallow marshmallow = (Marshmallow) sweetness;
                sweetnessNew = new Marshmallow(marshmallow);
            }
            this.sweetness.add(sweetnessNew);
            return true;
        }
        return false;
    }

    public int addSweetness(Sweetness sweetness, int countOfSweetness)
    {
        int count = 0;
        for (int i = 0; i < countOfSweetness; i++) {
            if (addSweetness(sweetness)) {
                count++;
            } else {
                System.out.println("Сладость " + sweetness.getName() + " не добавлена в подарочную упаковку. Упаковка заполнена полностью.");
                break;
            }
        }
        return count;
    }

    public void removeSweetness(Sweetness sweetness)
    {
        this.sweetness.remove(sweetness);
    }

    public void clearSweetness()
    {
        sweetness.clear();
    }

    @Override
    public String toString() {
        StringBuilder newStr = new StringBuilder(getTypeOfGiftPacking().toString() + " | Максимально допустимый вес упаковки: " + getMaxWeight() + " | Объекты внутри подарочной упаковки:\n");
        for (int i = 0; i < sweetness.size(); i++)
        {
            newStr.append(sweetness.get(i).toString() + "\n");
        }
        newStr.append("Текущий вес упаковки: " + String.valueOf(getCurrentWeightGiftPacking()) + "г.\n");
        return newStr.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GiftSweetnessPacking giftSweetnessPacking = (GiftSweetnessPacking) o;
        return sweetness.equals(giftSweetnessPacking.sweetness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sweetness);
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }
}