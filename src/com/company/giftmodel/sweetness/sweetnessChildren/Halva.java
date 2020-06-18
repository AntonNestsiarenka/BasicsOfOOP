package com.company.giftmodel.sweetness.sweetnessChildren;

import com.company.giftmodel.sweetness.Sweetness;

import java.util.Objects;

public class Halva extends Sweetness {

    private TypeOfHalva typeOfHalva;

    public Halva() {
        super();
        typeOfHalva = TypeOfHalva.SUNFLOWER;
    }

    public Halva(String name, String manufacturer, double weight, TypeOfHalva typeOfHalva) {
        super(name, manufacturer, weight);
        this.typeOfHalva = typeOfHalva;
    }

    public Halva(Halva other)
    {
        this(other.getName(), other.getManufacturer(), other.getWeight(), TypeOfHalva.valueOf(other.getTypeOfHalva().name()));
    }

    public TypeOfHalva getTypeOfHalva() {
        return typeOfHalva;
    }

    public void setTypeOfHalva(TypeOfHalva typeOfHalva) {
        this.typeOfHalva = typeOfHalva;
    }

    @Override
    public String toString() {
        return typeOfHalva.toString()
                + " | Название: " + getName()
                + " | Производитель: " + getManufacturer()
                + " | Вес: " + getWeight() + "г.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Halva halva = (Halva) o;
        return typeOfHalva == halva.typeOfHalva;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfHalva);
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }

    public enum TypeOfHalva {

        SUNFLOWER("Подсолнечная"),
        TAHINI("Тахинная"),
        PEANUT("Арахисовая"),
        WALNUT("Ореховая");

        private String typeOfHalva;

        TypeOfHalva() {
            typeOfHalva = "Подсолнечная";
        }

        TypeOfHalva(String typeOfHalva) {
            this.typeOfHalva = typeOfHalva;
        }

        public String getTypeOfHalva() {
            return typeOfHalva;
        }

        public void setTypeOfHalva(String typeOfHalva) {
            this.typeOfHalva = typeOfHalva;
        }

        @Override
        public String toString() {
            return "Тип халвы: " + typeOfHalva;
        }

        public void printInfo()
        {
            System.out.println(toString());
        }
    }
}