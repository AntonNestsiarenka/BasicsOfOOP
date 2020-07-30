package com.company.dragontreasuremodel.menu;

import Utils.InputUtils;
import com.company.dragontreasuremodel.cave.Cave;

import java.util.Scanner;

public class Menu {

    public static final String MAIN_MENU = "Main command menu:\n" +
            "1. showAllTreasures\n" +
            "2. showMostExpensiveTreasure\n" +
            "3. showTreasuresBySetPrice\n" +
            "4. help\n" +
            "5. quit\n";

    private Cave cave;
    private Scanner scanner;

    public Menu(Cave cave, Scanner scanner) {
        this.cave = cave;
        this.scanner = scanner;
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
                case ("showalltreasures"):
                case ("1"):
                {
                    cave.printAllTreasures();
                    break;
                }
                case ("showmostexpensivetreasure"):
                case ("2"):
                {
                    cave.printMostExpensiveTreasure();
                    break;
                }
                case ("showtreasuresbysetprice"):
                case ("3"):
                {
                    double sum = InputUtils.inputUDouble("Enter the required amount: ", scanner);
                    cave.printTreasuresBySetPrice(sum);
                    break;
                }
                case ("help"):
                case ("4"):
                {
                    System.out.println("Description of all commands:\n" +
                            "1. showAllTreasures - prints to the console information about all the treasures in the dragon's cave.\n" +
                            "2. showMostExpensiveTreasure - displays information about the most expensive treasure in the dragon's cave to the console.\n" +
                            "3. showTreasuresBySetPrice - makes a selection of treasures for a user-specified amount and prints information to the console.\n" +
                            "4. help - description of all commands.\n" +
                            "5. quit - application shutdown.\n" +
                            "Commands can be entered case insensitive or using numbers.");
                    break;
                }
                case ("quit"):
                case ("5"):
                {
                    flag = false;
                    break;
                }
                default:
                {
                    System.out.println("Such a console command does not exist. For help, type help in the console.");
                }
            }
        }
    }
}
