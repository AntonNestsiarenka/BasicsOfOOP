package com.company.giftmodel.packing;

import com.company.giftmodel.packing.factorys.GiftPackingFactory;
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
            return;
        }
        Scanner scanner = new Scanner(fileReader);
        GiftPackingFactory giftPackingFactory = new GiftSweetnessPackingFactory();
        while (scanner.hasNextLine()) {
            String[] str = scanner.nextLine().trim().split(" \\| ");
            for (int i = 1; i < str.length; i++) {
                GiftSweetnessPacking giftSweetnessPacking = (GiftSweetnessPacking) giftPackingFactory.createGiftPacking();
                giftSweetnessPacking.setTypeOfGiftPacking(GiftPacking.TypeOfGiftPacking.valueOf(str[0].toUpperCase()));
                giftSweetnessPacking.setMaxWeight(Double.valueOf(str[i]));
                giftSweetnessPackings.add(giftSweetnessPacking);
            }
        }
    }

    public void printAllGiftSweetnessPackings()
    {
        System.out.println("Все доступные подарочные упаковки.");
        int i = 1;
        for (GiftSweetnessPacking giftSweetnessPacking : giftSweetnessPackings)
        {
            System.out.println(i + ". " + giftSweetnessPacking.toString());
            i++;
        }
    }
}