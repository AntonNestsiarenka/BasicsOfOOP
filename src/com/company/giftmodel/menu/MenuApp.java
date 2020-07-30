package com.company.giftmodel.menu;

import Utils.GenerationUtils;
import Utils.InputUtils;
import com.company.giftmodel.client.Client;
import com.company.giftmodel.gift.factorys.GiftFactory;
import com.company.giftmodel.gift.factorys.GiftSweetnessFactory;
import com.company.giftmodel.gift.giftChildren.GiftSweetness;
import com.company.giftmodel.packing.StorageGiftSweetnessPacking;
import com.company.giftmodel.packing.packingChildren.GiftPacking;
import com.company.giftmodel.packing.packingChildren.giftPackingChildren.GiftSweetnessPacking;
import com.company.giftmodel.sweetness.StorageSweetness;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuApp {

    public static final String MAIN_MENU = "Main command menu:\n" +
            "1. createGiftSweetness\n" +
            "2. createGiftSweetnessMix\n" +
            "3. printInfoMyGifts\n" +
            "4. clearMyGifts\n" +
            "5. help\n" +
            "6. quit\n";

    public static final String ADD_SWEETNESS_MENU = "Add sweetness command menu:\n" +
            "1. add\n" +
            "2. addByQuantity\n" +
            "3. finish\n" +
            "4. giftInfo\n" +
            "5. help\n" +
            "6. quit\n";

    private Client client;
    private StorageSweetness storageSweetness;
    private StorageGiftSweetnessPacking storageGiftSweetnessPacking;
    private Scanner scanner;

    public MenuApp(Client client, StorageSweetness storageSweetness, StorageGiftSweetnessPacking storageGiftSweetnessPacking) {
        this.client = client;
        this.storageSweetness = storageSweetness;
        this.storageGiftSweetnessPacking = storageGiftSweetnessPacking;
        scanner = new Scanner(System.in);
    }

    public void mainMenu()
    {
        boolean flag = true;
        System.out.println(MAIN_MENU);
        while (flag)
        {
            String command = InputUtils.inputLine("Enter command: ").toLowerCase();
            switch (command)
            {
                case ("creategiftsweetness"):
                case ("1"):
                {
                    createGiftSweetness();
                    break;
                }
                case ("creategiftsweetnessmix"):
                case ("2"):
                {
                    createGiftSweetnessMix();
                    break;
                }
                case ("printinfomygifts"):
                case ("3"):
                {
                    client.printInfo();
                    break;
                }
                case ("clearmygifts"):
                case ("4"):
                {
                    client.clearGiftsSweetness();
                    break;
                }
                case ("help"):
                case ("5"):
                {
                    System.out.println("Description of all commands:\n" +
                            "1. createGiftSweetness - create a gift and fill it with sweets of the user's choice.\n" +
                            "2. createGiftSweetnessMix - create a gift and fill it with sweets at random.\n" +
                            "3. printInfoMyGifts - display all information about all gifts created by the user to the console.\n" +
                            "4. clearMyGifts - delete all gifts created by the user.\n" +
                            "5. help - description of all commands.\n" +
                            "6. quit - application shutdown.\n" +
                            "Commands can be entered case insensitive or using numbers.");
                    break;
                }
                case ("quit"):
                case ("6"):
                {
                    flag = false;
                    scanner.close();
                    break;
                }
                default:
                {
                    System.out.println("Such a console command does not exist. For help, type help in the console.");
                }
            }
        }
    }

    private void addSweetnessMenu()
    {
        boolean flag = true;
        System.out.println(ADD_SWEETNESS_MENU);
        while (flag)
        {
            String command = InputUtils.inputLine("Enter command: ").toLowerCase();
            switch (command)
            {
                case ("add"):
                case ("1"):
                {
                    storageSweetness.printAllSweetness();
                    int numberOfSweetness = InputUtils.inputUInt("Enter the number of the desired sweets from the list above to add as a gift: ", scanner);
                    if (numberOfSweetness >= 1 && numberOfSweetness <= storageSweetness.getAllSweetness().size())
                    {
                        ArrayList<GiftSweetness> giftsOfClient = client.getGiftsSweetness();
                        if (((GiftSweetnessPacking)(giftsOfClient.get(giftsOfClient.size() - 1).getPacking())).addSweetness(storageSweetness.getAllSweetness().get(numberOfSweetness - 1)))
                        {
                            System.out.println("Sweetness " + storageSweetness.getAllSweetness().get(numberOfSweetness - 1).getName() + " added as a gift.");
                        }
                        else
                        {
                            System.out.println("Sweetness " + storageSweetness.getAllSweetness().get(numberOfSweetness - 1).getName() + " not added as a gift. Gift wrap is full.");
                        }
                    }
                    else
                    {
                        System.out.println("User-defined sweetness not available.");
                    }
                    break;
                }
                case ("addbyquantity"):
                case ("2"):
                {
                    storageSweetness.printAllSweetness();
                    int numberOfSweetness = InputUtils.inputUInt("Enter the number of the desired sweets from the list above to add as a gift: ", scanner);
                    int countOfSweetness = InputUtils.inputUInt("Enter the number of sweets to add as a gift: ", scanner);
                    if (numberOfSweetness >= 1 && numberOfSweetness <= storageSweetness.getAllSweetness().size())
                    {
                        ArrayList<GiftSweetness> giftsOfClient = client.getGiftsSweetness();
                        int countOfAdded = ((GiftSweetnessPacking)(giftsOfClient.get(giftsOfClient.size() - 1).getPacking())).addSweetness(storageSweetness.getAllSweetness().get(numberOfSweetness - 1), countOfSweetness);
                        System.out.printf("Sweetness %s added as a gift in quantity %d pcs.\n",storageSweetness.getAllSweetness().get(numberOfSweetness - 1).getName(), countOfAdded);
                    }
                    else
                    {
                        System.out.println("User-defined sweetness not available.");
                    }
                    break;
                }
                case ("finish"):
                case ("3"):
                {
                    String str = InputUtils.inputLine("Are you sure you want to finish adding a gift? After completing the addition, it will be impossible to add anything to this gift. Enter Yes / No: ").toLowerCase();
                    if (str.equals("yes"))
                    {
                        System.out.println("Completed the addition of sweets to the gift.");
                        flag = false;
                    }
                    break;
                }
                case ("giftinfo"):
                case ("4"):
                {
                    ArrayList<GiftSweetness> giftsOfClient = client.getGiftsSweetness();
                    giftsOfClient.get(giftsOfClient.size() - 1).printInfo();
                    break;
                }
                case ("help"):
                case ("5"):
                {
                    System.out.println("Description of all commands:\n" +
                            "1. add - add a user-defined sweetness as a gift.\n" +
                            "2. addByQuantity - add a user-specified sweetness as a gift in a user-specified amount.\n" +
                            "3. finish - finish adding sweets as a gift.\n" +
                            "4. giftInfo - displaying information about the gift filled with sweets.\n" +
                            "5. help - description of all commands.\n" +
                            "6. quit - application shutdown.\n" +
                            "Commands can be entered case insensitive or using numbers.");
                    break;
                }
                case ("quit"):
                case ("6"):
                {
                    scanner.close();
                    System.exit(0);
                }
                default:
                {
                    System.out.println("Such a console command does not exist. For help, type help in the console.");
                }
            }
        }
    }

    private void createGiftSweetness()
    {
        String nameOfGift = InputUtils.inputLine("Enter gift name: ");
        storageGiftSweetnessPacking.printAllGiftSweetnessPackings();
        int numberOfGiftPacking = InputUtils.inputUInt("Enter the number of the desired gift box from the list above: ", scanner);
        if (numberOfGiftPacking >= 1 && numberOfGiftPacking <= storageGiftSweetnessPacking.getGiftSweetnessPackings().size())
        {
            GiftFactory giftFactory = new GiftSweetnessFactory();
            double maxWeight = storageGiftSweetnessPacking.getGiftSweetnessPackings().get(numberOfGiftPacking - 1).getMaxWeight();
            GiftPacking.TypeOfGiftPacking typeOfGiftPacking = storageGiftSweetnessPacking.getGiftSweetnessPackings().get(numberOfGiftPacking - 1).getTypeOfGiftPacking();
            GiftSweetness giftSweetness = (GiftSweetness) giftFactory.createGift();
            giftSweetness.setName(nameOfGift);
            giftSweetness.setPacking(new GiftSweetnessPacking(maxWeight, typeOfGiftPacking));
            client.addGiftSweetness(giftSweetness);
            addSweetnessMenu();
        }
        else
        {
            System.out.println("Gift box with this number is out of stock. Gift not created.");
        }
    }

    private void createGiftSweetnessMix() {
        String nameOfGift = InputUtils.inputLine("Enter gift name: ");
        storageGiftSweetnessPacking.printAllGiftSweetnessPackings();
        int numberOfGiftPacking = InputUtils.inputUInt("Enter the number of the desired gift box from the list above: ", scanner);
        if (numberOfGiftPacking >= 1 && numberOfGiftPacking <= storageGiftSweetnessPacking.getGiftSweetnessPackings().size())
        {
            GiftFactory giftFactory = new GiftSweetnessFactory();
            double maxWeight = storageGiftSweetnessPacking.getGiftSweetnessPackings().get(numberOfGiftPacking - 1).getMaxWeight();
            GiftPacking.TypeOfGiftPacking typeOfGiftPacking = storageGiftSweetnessPacking.getGiftSweetnessPackings().get(numberOfGiftPacking - 1).getTypeOfGiftPacking();
            GiftSweetness giftSweetness = (GiftSweetness) giftFactory.createGift();
            giftSweetness.setName(nameOfGift);
            giftSweetness.setPacking(new GiftSweetnessPacking(maxWeight, typeOfGiftPacking));
            client.addGiftSweetness(giftSweetness);
        }
        else
        {
            System.out.println("Gift box with this number is out of stock. Gift not created.");
            return;
        }
        int numberOfSweetness = GenerationUtils.randInt(0, storageSweetness.getAllSweetness().size() - 1);
        ArrayList <GiftSweetness> giftsOfClient = client.getGiftsSweetness();
        while(((GiftSweetnessPacking)(giftsOfClient.get(giftsOfClient.size() - 1).getPacking())).addSweetness(storageSweetness.getAllSweetness().get(numberOfSweetness)))
        {
            numberOfSweetness = GenerationUtils.randInt(0, storageSweetness.getAllSweetness().size() - 1);
        }
    }
}
