package com.company.giftmodel.packing;

import com.company.giftmodel.packing.factorys.GiftSweetnessPackingFactory;
import com.company.giftmodel.packing.packingChildren.GiftPacking;
import com.company.giftmodel.packing.packingChildren.giftPackingChildren.GiftSweetnessPacking;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class StorageGiftSweetnessPacking {

    private static StorageGiftSweetnessPacking storageGiftSweetnessPacking = null;
    private ArrayList<GiftSweetnessPacking> giftSweetnessPackings;

    private StorageGiftSweetnessPacking() {
        giftSweetnessPackings = new ArrayList<GiftSweetnessPacking>();
    }

    public ArrayList<GiftSweetnessPacking> getGiftSweetnessPackings() {
        return giftSweetnessPackings;
    }

    public static StorageGiftSweetnessPacking getStorageGiftSweetnessPacking() {
        return storageGiftSweetnessPacking;
    }

    public void addGiftSweetnessPacking(GiftSweetnessPacking giftSweetnessPacking)
    {
        giftSweetnessPackings.add(giftSweetnessPacking);
    }

    public void removeGiftSweetnessPacking(GiftSweetnessPacking giftSweetnessPacking)
    {
        giftSweetnessPackings.remove(giftSweetnessPacking);
    }

    public void clearStorage()
    {
        giftSweetnessPackings.clear();
    }

    public static StorageGiftSweetnessPacking createInstance()
    {
        if (storageGiftSweetnessPacking == null)
        {
            storageGiftSweetnessPacking = new StorageGiftSweetnessPacking();
        }
        return storageGiftSweetnessPacking;
    }

    public void storageGiftSweetnessPackingInit()
    {
        FileReader fileReader= null;
        try {
            fileReader = new FileReader("giftsweetnesspackingdata.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(fileReader);
        GiftSweetnessPackingFactory giftSweetnessPackingFactory = new GiftSweetnessPackingFactory();
        while (scanner.hasNextLine()) {
            String[] str = scanner.nextLine().trim().split(" \\| ");
            GiftPacking.TypeOfGiftPacking typeOfGiftPacking = GiftPacking.TypeOfGiftPacking.CARDBOARD;
            if (str[0].equals(GiftPacking.TypeOfGiftPacking.CARDBOARD.getTypeOfGiftPacking()))
            {
                typeOfGiftPacking = GiftPacking.TypeOfGiftPacking.CARDBOARD;
            }
            else if (str[0].equals(GiftPacking.TypeOfGiftPacking.TEXTILE.getTypeOfGiftPacking()))
            {
                typeOfGiftPacking = GiftPacking.TypeOfGiftPacking.TEXTILE;
            }
            else if (str[0].equals(GiftPacking.TypeOfGiftPacking.METAL.getTypeOfGiftPacking()))
            {
                typeOfGiftPacking = GiftPacking.TypeOfGiftPacking.METAL;
            }
            else if (str[0].equals(GiftPacking.TypeOfGiftPacking.WOODEN.getTypeOfGiftPacking()))
            {
                typeOfGiftPacking = GiftPacking.TypeOfGiftPacking.WOODEN;
            }
            for (int i = 1; i < str.length; i++) {
                giftSweetnessPackings.add(giftSweetnessPackingFactory.createGiftPacking(Double.valueOf(str[i]), typeOfGiftPacking));
            }
        }
    }

    public void printAllGiftSweetnessPackings()
    {
        System.out.println("Все доступные подарочные упаковки.");
        int i = 1;
        for (GiftSweetnessPacking giftSweetnessPacking : giftSweetnessPackings)
        {
            System.out.println(String.valueOf(i) + ". " + giftSweetnessPacking.toString());
            i++;
        }
    }
}
