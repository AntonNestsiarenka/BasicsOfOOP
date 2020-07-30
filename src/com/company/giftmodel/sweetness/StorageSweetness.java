package com.company.giftmodel.sweetness;

import com.company.giftmodel.sweetness.factorys.*;
import com.company.giftmodel.sweetness.sweetnessChildren.Candy;
import com.company.giftmodel.sweetness.sweetnessChildren.Chocolate;
import com.company.giftmodel.sweetness.sweetnessChildren.Halva;
import com.company.giftmodel.sweetness.sweetnessChildren.Marshmallow;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class StorageSweetness {

    private static StorageSweetness storageSweetness = null;
    private ArrayList<Sweetness> allSweetness;

    private StorageSweetness() {
        allSweetness = new ArrayList<Sweetness>();
    }

    public static StorageSweetness createInstance()
    {
        if (storageSweetness == null)
        {
            storageSweetness = new StorageSweetness();
        }
        return storageSweetness;
    }

    public static StorageSweetness getStorageSweetness() {
        return storageSweetness;
    }

    public ArrayList<Sweetness> getAllSweetness() {
        return allSweetness;
    }

    public void addSweetness(Sweetness sweetness)
    {
        allSweetness.add(sweetness);
    }

    public void removeSweetness(Sweetness sweetness)
    {
        allSweetness.remove(sweetness);
    }

    public void clearStorage()
    {
        allSweetness.clear();
    }

    public void storageSweetnessInit()
    {
        FileReader fileReader= null;
        try {
            fileReader = new FileReader("candydata.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(fileReader);
        SweetnessFactory sweetnessFactory = new CandyFactory();
        while (scanner.hasNextLine())
        {
            String[] str = scanner.nextLine().trim().split(" \\| ");
            Candy candy = (Candy) sweetnessFactory.createSweetness();
            candy.setName(str[0]);
            candy.setManufacturer(str[1]);
            candy.setWeight(Double.valueOf(str[2]));
            candy.setTypeOfCandy(Candy.TypeOfCandy.valueOf(str[3].toUpperCase()));
            allSweetness.add(candy);
        }
        scanner.close();
        try {
            fileReader = new FileReader("chocolatedata.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner = new Scanner(fileReader);
        sweetnessFactory = new ChocolateFactory();
        while (scanner.hasNextLine())
        {
            String[] str = scanner.nextLine().trim().split(" \\| ");
            Chocolate chocolate = (Chocolate) sweetnessFactory.createSweetness();
            chocolate.setName(str[0]);
            chocolate.setManufacturer(str[1]);
            chocolate.setWeight(Double.valueOf(str[2]));
            chocolate.setTypeOfChocolate(Chocolate.TypeOfChocolate.valueOf(str[3].toUpperCase()));
            allSweetness.add(chocolate);
        }
        scanner.close();
        try {
            fileReader = new FileReader("halvadata.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner = new Scanner(fileReader);
        sweetnessFactory = new HalvaFactory();
        while (scanner.hasNextLine())
        {
            String[] str = scanner.nextLine().trim().split(" \\| ");
            Halva halva = (Halva) sweetnessFactory.createSweetness();
            halva.setName(str[0]);
            halva.setManufacturer(str[1]);
            halva.setWeight(Double.valueOf(str[2]));
            halva.setTypeOfHalva(Halva.TypeOfHalva.valueOf(str[3].toUpperCase()));
            allSweetness.add(halva);
        }
        scanner.close();
        try {
            fileReader = new FileReader("marshmallowdata.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner = new Scanner(fileReader);
        sweetnessFactory = new MarshmallowFactory();
        while (scanner.hasNextLine())
        {
            String[] str = scanner.nextLine().trim().split(" \\| ");
            Marshmallow marshmallow = (Marshmallow) sweetnessFactory.createSweetness();
            marshmallow.setName(str[0]);
            marshmallow.setManufacturer(str[1]);
            marshmallow.setWeight(Double.valueOf(str[2]));
            marshmallow.setTypeOfMarshmallow(Marshmallow.TypeOfMarshmallow.valueOf(str[3].toUpperCase()));
            allSweetness.add(marshmallow);
        }
        scanner.close();
    }

    public void printAllSweetness()
    {
        System.out.println("Наименования всех доступных сладостей.");
        int i = 1;
        for (Sweetness sweetness : allSweetness)
        {
            String number = i++ + ". ";
            if (sweetness instanceof Candy) {
                Candy candy = (Candy) sweetness;
                System.out.println(number + candy.toString());
            }
            else if (sweetness instanceof Chocolate)
            {
                Chocolate chocolate = (Chocolate) sweetness;
                System.out.println(number + chocolate.toString());
            }
            else if (sweetness instanceof Halva)
            {
                Halva halva = (Halva) sweetness;
                System.out.println(number + halva.toString());
            }
            else if (sweetness instanceof Marshmallow)
            {
                Marshmallow marshmallow = (Marshmallow) sweetness;
                System.out.println(number + marshmallow.toString());
            }
        }
    }
}