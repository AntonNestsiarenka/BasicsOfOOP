package com.company.giftmodel.sweetness;

import com.company.giftmodel.sweetness.factorys.CandyFactory;
import com.company.giftmodel.sweetness.factorys.ChocolateFactory;
import com.company.giftmodel.sweetness.factorys.HalvaFactory;
import com.company.giftmodel.sweetness.factorys.MarshmallowFactory;
import com.company.giftmodel.sweetness.sweetnessChildren.Candy;
import com.company.giftmodel.sweetness.sweetnessChildren.Chocolate;
import com.company.giftmodel.sweetness.sweetnessChildren.Halva;
import com.company.giftmodel.sweetness.sweetnessChildren.Marshmallow;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        CandyFactory candyFactory = new CandyFactory();
        while (scanner.hasNextLine())
        {
            String[] str = scanner.nextLine().trim().split(" \\| ");
            Candy candy = (Candy) candyFactory.createSweetness();
            candy.setName(str[0]);
            candy.setManufacturer(str[1]);
            candy.setWeight(Double.valueOf(str[2]));
            if (str[3].equals(Candy.TypeOfCandy.CHOCOLATE.getTypeOfCandy())) {
                candy.setTypeOfCandy(Candy.TypeOfCandy.CHOCOLATE);
            }
            else if (str[3].equals(Candy.TypeOfCandy.CARAMEL.getTypeOfCandy())) {
                candy.setTypeOfCandy(Candy.TypeOfCandy.CARAMEL);
            }
            else if (str[3].equals(Candy.TypeOfCandy.IRIS.getTypeOfCandy())) {
                candy.setTypeOfCandy(Candy.TypeOfCandy.IRIS);
            }
            else if (str[3].equals(Candy.TypeOfCandy.LOLLIPOP.getTypeOfCandy())) {
                candy.setTypeOfCandy(Candy.TypeOfCandy.LOLLIPOP);
            }
            allSweetness.add(candy);
        }
        try {
            fileReader = new FileReader("chocolatedata.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner = new Scanner(fileReader);
        ChocolateFactory chocolateFactory = new ChocolateFactory();
        while (scanner.hasNextLine())
        {
            String[] str = scanner.nextLine().trim().split(" \\| ");
            Chocolate chocolate = (Chocolate) chocolateFactory.createSweetness();
            chocolate.setName(str[0]);
            chocolate.setManufacturer(str[1]);
            chocolate.setWeight(Double.valueOf(str[2]));
            if (str[3].equals(Chocolate.TypeOfChocolate.MILK.getTypeOfChocolate())) {
                chocolate.setTypeOfChocolate(Chocolate.TypeOfChocolate.MILK);
            }
            else if (str[3].equals(Chocolate.TypeOfChocolate.BITTER.getTypeOfChocolate())) {
                chocolate.setTypeOfChocolate(Chocolate.TypeOfChocolate.BITTER);
            }
            else if (str[3].equals(Chocolate.TypeOfChocolate.WHITE.getTypeOfChocolate())) {
                chocolate.setTypeOfChocolate(Chocolate.TypeOfChocolate.WHITE);
            }
            allSweetness.add(chocolate);
        }
        try {
            fileReader = new FileReader("halvadata.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner = new Scanner(fileReader);
        HalvaFactory halvaFactory = new HalvaFactory();
        while (scanner.hasNextLine())
        {
            String[] str = scanner.nextLine().trim().split(" \\| ");
            Halva halva = (Halva) halvaFactory.createSweetness();
            halva.setName(str[0]);
            halva.setManufacturer(str[1]);
            halva.setWeight(Double.valueOf(str[2]));
            if (str[3].equals(Halva.TypeOfHalva.SUNFLOWER.getTypeOfHalva())) {
                halva.setTypeOfHalva(Halva.TypeOfHalva.SUNFLOWER);
            }
            else if (str[3].equals(Halva.TypeOfHalva.PEANUT.getTypeOfHalva())) {
                halva.setTypeOfHalva(Halva.TypeOfHalva.PEANUT);
            }
            else if (str[3].equals(Halva.TypeOfHalva.TAHINI.getTypeOfHalva())) {
                halva.setTypeOfHalva(Halva.TypeOfHalva.TAHINI);
            }
            else if (str[3].equals(Halva.TypeOfHalva.WALNUT.getTypeOfHalva())) {
                halva.setTypeOfHalva(Halva.TypeOfHalva.WALNUT);
            }
            allSweetness.add(halva);
        }
        try {
            fileReader = new FileReader("marshmallowdata.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner = new Scanner(fileReader);
        MarshmallowFactory marshmallowFactory = new MarshmallowFactory();
        while (scanner.hasNextLine())
        {
            String[] str = scanner.nextLine().trim().split(" \\| ");
            Marshmallow marshmallow = (Marshmallow) marshmallowFactory.createSweetness();
            marshmallow.setName(str[0]);
            marshmallow.setManufacturer(str[1]);
            marshmallow.setWeight(Double.valueOf(str[2]));
            if (str[3].equals(Marshmallow.TypeOfMarshmallow.WHITE.getTypeOfMarshmallow())) {
                marshmallow.setTypeOfMarshmallow(Marshmallow.TypeOfMarshmallow.WHITE);
            }
            else if (str[3].equals(Marshmallow.TypeOfMarshmallow.PINK.getTypeOfMarshmallow())) {
                marshmallow.setTypeOfMarshmallow(Marshmallow.TypeOfMarshmallow.PINK);
            }
            else if (str[3].equals(Marshmallow.TypeOfMarshmallow.GREEN.getTypeOfMarshmallow())) {
                marshmallow.setTypeOfMarshmallow(Marshmallow.TypeOfMarshmallow.GREEN);
            }
            else if (str[3].equals(Marshmallow.TypeOfMarshmallow.CHOCOLATE.getTypeOfMarshmallow())) {
                marshmallow.setTypeOfMarshmallow(Marshmallow.TypeOfMarshmallow.CHOCOLATE);
            }
            allSweetness.add(marshmallow);
        }
        scanner.close();
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printAllSweetness()
    {
        System.out.println("Наименования всех доступных сладостей.");
        int i = 1;
        for (Sweetness sweetness : allSweetness)
        {
            String number = String.valueOf(i++) + ". ";
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