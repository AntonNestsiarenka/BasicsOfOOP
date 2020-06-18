package com.company;

import Utils.InputOutputUtils;
import Utils.MyException;
import com.company.calendarmodel.Calendar;
import com.company.calendarmodel.Month;
import com.company.dragontreasuremodel.Cave;
import com.company.dragontreasuremodel.Dragon;
import com.company.dragontreasuremodel.GeneratorTreasures;
import com.company.giftmodel.Client;
import com.company.giftmodel.packing.StorageGiftSweetnessPacking;
import com.company.giftmodel.sweetness.StorageSweetness;
import com.company.paymentmodel.Product;
import com.company.paymentmodel.User;
import com.company.textfilemodel.Directory;
import com.company.textfilemodel.TextFile;

public class Main {

    /**********************************************************************************************************/
    /********************************************* Basics Of OOP **********************************************/
    /**********************************************************************************************************/


    public static void task1()
    {
        /* Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
           вывести на консоль содержимое, дополнить, удалить. */
        Directory directory1 = new Directory("Documents");
        Directory directory2 = new Directory("Others");
        Directory directory3 = new Directory("MyFiles");
        Directory directory4 = new Directory("ProjectMystery");

        TextFile textFile1 = TextFile.createTextFile("City17", directory3);
        TextFile textFile2 = TextFile.createTextFile("MyFunc", directory1);
        TextFile textFile3 = TextFile.createTextFile("MyFunc", directory1);
        TextFile textFile4 = TextFile.createTextFile("Characteristics", directory2);
        TextFile textFile5 = TextFile.createTextFile("Prices", directory2);
        TextFile textFile6 = TextFile.createTextFile("ConceptOfGame", directory4);

        directory1.printDirectoryInfo();
        directory2.printDirectoryInfo();
        directory3.printDirectoryInfo();
        directory4.printDirectoryInfo();

        System.out.println("Добавляем текст в файл MyFunc.txt");
        textFile2.addContentToFile("pow(x, 2) + 25 * x");
        System.out.print("Содержимое файла ");
        textFile2.printFileName();
        textFile2.printContentOfFile();
        System.out.println();
        System.out.println("Добавляем еще текст в файл MyFunc.txt");
        textFile2.addContentToFile("\nsqrt(pow(x, 2) + pow(y, 2)");
        System.out.print("Содержимое файла ");
        textFile2.printFileName();
        textFile2.printContentOfFile();
        System.out.println();

        System.out.println("Переименовываем файл MyFunc.txt в MyFunc3");
        try {
            textFile2.renameFile("MyFunc3");
        } catch (MyException e) {
            e.printStackTrace();
        }
        directory1.printDirectoryInfo();
        System.out.println("Удаляем файл MyFunc3.txt из директории");
        directory1.deleteFileFromDirectory(textFile2);

        directory1.printDirectoryInfo();
    }

    public static void task2()
    {
        /* Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
           нескольких товаров. */
        Product product1 = new Product("Apple iPhone X 64Gb Space Gray (Серый космос)", "Cмартфон", 699);
        Product product2 = new Product("Samsung UE43RU7120UXRU", "Телевизор", 499);
        Product product3 = new Product("Программирование на Java", "Книга", 35);
        Product product4 = new Product("Magnetic Bike TC545", "Велотренажер", 299);
        Product product5 = new Product("Nvidia GeForse RTX 3080Ti", "Видеокарта", 1500);
        Product product6 = new Product("Garrett GT1756VK", "Турбина", 525);
        Product product7 = new Product("Shell Helix Ultra 5W-30 A3/B4 4l", "Моторное масло", 42);
        Product product8 = new Product("Castrol EDGE 0W-30 A3/B4 4l", "Моторное масло", 50);
        Product product9 = new Product("LG PC09SQ", "Сплит-система", 750);

        User user1 = new User("Вежновец", "Олег", "Александрович", 39, Person.Sex.MAN, "vezhnovec1209@gmail.com");
        User user2 = new User("Еремина", "Татьяна", "Анатольевна", 33, Person.Sex.WOMEN, "tanyaEremina44@tut.by");
        user1.addToPayment(product6);
        try {
            user1.addToPayment(product7, 2);
        } catch (MyException e) {
            e.printStackTrace();
        }
        user1.addToPayment(product3);

        user2.addToPayment(product1);
        user2.addToPayment(product4);
        try {
            user2.addToPayment(product3, 2);
        } catch (MyException e) {
            e.printStackTrace();
        }
        user2.addToPayment(product9);

        System.out.println("Покупки пользователя " + user1.toString());
        user1.getPayment().printPaymentInfo();
        System.out.println();
        System.out.println("Покупки пользователя " + user2.toString());
        user2.getPayment().printPaymentInfo();
    }

    public static void task3()
    {
        /* Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о выходных
           и праздничных днях. */
        Calendar calendar = new Calendar(2020);
        calendar.fillDayOff();
        Calendar.Holiday holiday1 = calendar.new Holiday("Orthodox Christmas", 7, Month.JANUARY);
        Calendar.Holiday holiday2 = calendar.new Holiday("International Women's Day", 8, Month.MARCH);
        Calendar.Holiday holiday3 = calendar.new Holiday("Victory Day", 9, Month.MAY);
        Calendar.Holiday holiday4 = calendar.new Holiday("Independence Day", 3, Month.JULY);
        Calendar.Holiday holiday5 = calendar.new Holiday("Defender of the Fatherland Day", 23, Month.FEBRUARY);
        Calendar.Holiday holiday6 = calendar.new Holiday("New Year", 1, Month.JANUARY);
        calendar.printCalendar();
        System.out.println("Выходные и праздничные дни");
        calendar.printHolidaysInfo();
    }

    public static void task4()
    {
        /* Создать консольное приложение, удовлетворяющее следующим требованиям:
           • Приложение должно быть объектно-, а не процедурно-ориентированным.
           • Каждый класс должен иметь отражающее смысл название и информативный состав.
           • Наследование должно применяться только тогда, когда это имеет смысл.
           • При кодировании должны быть использованы соглашения об оформлении кода java code convention.
           • Классы должны быть грамотно разложены по пакетам.
           • Консольное меню должно быть минимальным.
           • Для хранения данных можно использовать файлы.

           Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере
           дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и выбора
           сокровищ на заданную сумму. */
        Cave cave = new Cave("Пещера гигантов");
        Dragon dragon = new Dragon("Дрогон", cave);
        GeneratorTreasures generatorTreasures = new GeneratorTreasures();
        for (int i = 0; i < 100; i++)
        {
            try {
                cave.addTreasure(generatorTreasures.generateTreasureRandom());
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
        boolean flag = true;
        System.out.println("Меню доступных команд для ввода в консоль:\n" +
                "1. showAllTreasures\n" +
                "2. showMostExpensiveTreasure\n" +
                "3. showTreasuresBySetPrice\n" +
                "4. help\n" +
                "5. quit");
        while (flag)
        {
            String command = InputOutputUtils.inputLine("Введите команду: ").toLowerCase();
            switch (command)
            {
                case ("showalltreasures"):
                {
                    cave.printAllTreasures();
                    break;
                }
                case ("showmostexpensivetreasure"):
                {
                    cave.printMostExpensiveTreasure();
                    break;
                }
                case ("showtreasuresbysetprice"):
                {
                    double sum = InputOutputUtils.inputUDouble("Введите требуемую сумму: ");
                    cave.printTreasuresBySetPrice(sum);
                    break;
                }
                case ("help"):
                {
                    System.out.println("Меню доступных команд для ввода в консоль:\n" +
                            "1. showAllTreasures - выводит в консоль информацию о всех сокровищах в пещере дракона.\n" +
                            "2. showMostExpensiveTreasure - выводит в консоль информацию о самом дорогом сокровище в пещере дракона.\n" +
                            "3. showTreasuresBySetPrice - делает выборку сокровищ на заданную пользователем сумму и выводит информацию в консоль.\n" +
                            "4. help - выводит в консоль информацию о всех доступных командах данного приложения.\n" +
                            "5. quit - завершает работу программы.\n" +
                            "Команды можно вводить без учета регистра.");
                    break;
                }
                case ("quit"):
                {
                    flag = false;
                    break;
                }
                default:
                {
                    System.out.println("Введенная команда недоступна. Чтобы посмотреть список доступных команд введите в консоль команду help");
                }
            }
        }
    }

    public static void task5()
    {
        /* Создать консольное приложение, удовлетворяющее следующим требованиям:
           • Корректно спроектируйте и реализуйте предметную область задачи.
           • Для создания объектов из иерархии классов продумайте возможность использования порождающих шаблонов проектирования.
           • Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
           • для проверки корректности переданных данных можно применить регулярные выражения.
           • Меню выбора действия пользователем можно не реализовывать, используйте заглушку.
           • Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().

           Вариант B. Подарки. Реализовать приложение, позволяющее создавать подарки (объект, представляющий собой
           подарок). Составляющими целого подарка являются сладости и упаковка. */
        Client client = new Client("Леонова", "Анна", "Георгиевна", 31, Person.Sex.WOMEN, "leon47anna@yandex.ru");
        StorageSweetness storageSweetness = StorageSweetness.createInstance();
        StorageGiftSweetnessPacking storageGiftSweetnessPacking = StorageGiftSweetnessPacking.createInstance();
        storageSweetness.storageSweetnessInit();
        storageGiftSweetnessPacking.storageGiftSweetnessPackingInit();
        boolean flag = true;
        System.out.println("Меню доступных команд для ввода в консоль:\n" +
                "1. createGiftSweetness\n" +
                "2. createGiftSweetnessMix\n" +
                "3. printInfoMyGifts\n" +
                "4. clearMyGifts\n" +
                "5. help\n" +
                "6. quit");
        while (flag)
        {
            String command = InputOutputUtils.inputLine("Введите команду: ").toLowerCase();
            switch (command)
            {
                case ("creategiftsweetness"):
                {
                    client.createGiftSweetness();
                    break;
                }
                case ("creategiftsweetnessmix"):
                {
                    client.createGiftSweetnessMix();
                    break;
                }
                case ("printinfomygifts"):
                {
                    client.printInfo();
                    break;
                }
                case ("clearmygifts"):
                {
                    client.clearGiftsSweetness();
                    break;
                }
                case ("help"):
                {
                    System.out.println("Меню доступных команд для ввода в консоль:\n" +
                            "1. createGiftSweetness - создать подарок и заполнить его сладостями по выбору пользователя.\n" +
                            "2. createGiftSweetnessMix - создать подарок и заполнить его сладостями случайным образом.\n" +
                            "3. printInfoMyGifts - вывести в консоль всю информацию обо всех созданных пользователем подарках.\n" +
                            "4. clearMyGifts - удалить все подарки созданные пользователем.\n" +
                            "5. help - вывести в консоль информацию о всех доступных командах данного приложения.\n" +
                            "6. quit - завершает работу программы.\n" +
                            "Команды можно вводить без учета регистра.");
                    break;
                }
                case ("quit"):
                {
                    flag = false;
                    break;
                }
                default:
                {
                    System.out.println("Введенная команда недоступна. Чтобы посмотреть список доступных команд введите в консоль команду help");
                }
            }
        }
    }

    public static void main(String[] args) {
        task5();
    }
}