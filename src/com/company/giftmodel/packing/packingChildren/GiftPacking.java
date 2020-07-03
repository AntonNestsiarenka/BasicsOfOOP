package com.company.giftmodel.packing.packingChildren;

import com.company.giftmodel.packing.Packing;

import java.util.Objects;

public abstract class GiftPacking extends Packing {

    private TypeOfGiftPacking typeOfGiftPacking;

    public GiftPacking() {
        super();
        typeOfGiftPacking = TypeOfGiftPacking.CARDBOARD;
    }

    public GiftPacking(double maxWeight, TypeOfGiftPacking typeOfGiftPacking) {
        super(maxWeight);
        this.typeOfGiftPacking = typeOfGiftPacking;
    }

    public TypeOfGiftPacking getTypeOfGiftPacking() {
        return typeOfGiftPacking;
    }

    public void setTypeOfGiftPacking(TypeOfGiftPacking typeOfGiftPacking) {
        this.typeOfGiftPacking = typeOfGiftPacking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GiftPacking giftPacking = (GiftPacking) o;
        return typeOfGiftPacking == giftPacking.typeOfGiftPacking;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfGiftPacking);
    }

    public enum TypeOfGiftPacking {

        TEXTILE("Текстильная"),
        WOODEN("Деревянная"),
        METAL("Металлическая"),
        CARDBOARD("Картонная");

        private String typeOfGiftPacking;

        TypeOfGiftPacking() {
            typeOfGiftPacking = "Картонная";
        }

        TypeOfGiftPacking(String typeOfGiftPacking) {
            this.typeOfGiftPacking = typeOfGiftPacking;
        }

        public String getTypeOfGiftPacking() {
            return typeOfGiftPacking;
        }

        public void setTypeOfGiftPacking(String typeOfGiftPacking) {
            this.typeOfGiftPacking = typeOfGiftPacking;
        }

        @Override
        public String toString() {
            return "Тип подарочной упаковки: " + typeOfGiftPacking;
        }

        public void printInfo()
        {
            System.out.println(toString());
        }
    }
}