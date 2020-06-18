package com.company.giftmodel;

import Utils.GenerationUtils;
import Utils.InputOutputUtils;
import com.company.Person;
import com.company.giftmodel.gift.giftChildren.GiftSweetness;
import com.company.giftmodel.gift.factorys.GiftSweetnessFactory;
import com.company.giftmodel.packing.packingChildren.GiftPacking;
import com.company.giftmodel.packing.packingChildren.giftPackingChildren.GiftSweetnessPacking;
import com.company.giftmodel.packing.StorageGiftSweetnessPacking;
import com.company.giftmodel.sweetness.StorageSweetness;

import java.util.ArrayList;
import java.util.Objects;

public class Client extends Person implements CreateGift {

    private static long idUnique = 0;

    private long id;
    private String email;
    private ArrayList<GiftSweetness> giftsSweetness;

    public Client()
    {
        id = idUnique++;
        email = "";
        giftsSweetness = new ArrayList<GiftSweetness>();
    }

    public Client(String surname, String name, String patronymic, int age, Sex sex, String email) {
        super(surname, name, patronymic, age, sex);
        id = idUnique;
        this.email = email;
        giftsSweetness = new ArrayList<GiftSweetness>();
    }

    public void addGiftSweetness(GiftSweetness giftSweetness)
    {
        giftsSweetness.add(giftSweetness);
    }

    public void clearGiftsSweetness()
    {
        giftsSweetness.clear();
    }

    public static long getIdUnique() {
        return idUnique;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Пользователь id: " + id
                + " | " + getSurname()
                + " " +  getName()
                + " " + getPatronymic()
                + " | Возраст: " + getAge()
                + " | Пол: " + getSex().toString()
                + " | Email: " + email + "\n");
        int i = 1;
        for (GiftSweetness giftSweetness : giftsSweetness)
        {
            str.append(String.valueOf(i++) + ". " + giftSweetness.toString());
        }
        return str.toString();
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }

    @Override
    public void createGiftSweetness() {
        String nameOfGift = InputOutputUtils.inputLine("Введите название подарка: ");
        StorageGiftSweetnessPacking  storageGiftSweetnessPacking = StorageGiftSweetnessPacking.getStorageGiftSweetnessPacking();
        storageGiftSweetnessPacking.printAllGiftSweetnessPackings();
        int numberOfGiftPacking = InputOutputUtils.inputUInt("Введите номер желаемой подарочной упаковки из предложенного выше списка: ");
        if (numberOfGiftPacking >= 1 && numberOfGiftPacking <= storageGiftSweetnessPacking.getGiftSweetnessPackings().size())
        {
            GiftSweetnessFactory giftSweetnessFactory = new GiftSweetnessFactory();
            double maxWeight = storageGiftSweetnessPacking.getGiftSweetnessPackings().get(numberOfGiftPacking - 1).getMaxWeight();
            GiftPacking.TypeOfGiftPacking typeOfGiftPacking = storageGiftSweetnessPacking.getGiftSweetnessPackings().get(numberOfGiftPacking - 1).getTypeOfGiftPacking();
            addGiftSweetness((GiftSweetness) (giftSweetnessFactory.createGift(nameOfGift, new GiftSweetnessPacking(maxWeight, GiftPacking.TypeOfGiftPacking.valueOf(typeOfGiftPacking.name())))));
            addSweetnessToGift();
        }
        else
        {
            System.out.println("Подарочной упаковки с таким номером нет в наличии. Подарок не создан.");
        }
    }

    @Override
    public void createGiftSweetnessMix() {
        String nameOfGift = InputOutputUtils.inputLine("Введите название подарка: ");
        StorageGiftSweetnessPacking  storageGiftSweetnessPacking = StorageGiftSweetnessPacking.getStorageGiftSweetnessPacking();
        storageGiftSweetnessPacking.printAllGiftSweetnessPackings();
        int numberOfGiftPacking = InputOutputUtils.inputUInt("Введите номер желаемой подарочной упаковки из предложенного выше списка: ");
        if (numberOfGiftPacking >= 1 && numberOfGiftPacking <= storageGiftSweetnessPacking.getGiftSweetnessPackings().size())
        {
            GiftSweetnessFactory giftSweetnessFactory = new GiftSweetnessFactory();
            double maxWeight = storageGiftSweetnessPacking.getGiftSweetnessPackings().get(numberOfGiftPacking - 1).getMaxWeight();
            GiftPacking.TypeOfGiftPacking typeOfGiftPacking = storageGiftSweetnessPacking.getGiftSweetnessPackings().get(numberOfGiftPacking - 1).getTypeOfGiftPacking();
            addGiftSweetness((GiftSweetness) giftSweetnessFactory.createGift(nameOfGift, new GiftSweetnessPacking(maxWeight, GiftPacking.TypeOfGiftPacking.valueOf(typeOfGiftPacking.name()))));
        }
        else
        {
            System.out.println("Подарочной упаковки с таким номером нет в наличии. Подарок не создан.");
            return;
        }
        StorageSweetness storageSweetness = StorageSweetness.getStorageSweetness();
        int numberOfSweetness = GenerationUtils.randInt(0, storageSweetness.getAllSweetness().size() - 1);
        while(((GiftSweetnessPacking)(giftsSweetness.get(giftsSweetness.size() - 1).getPacking())).addSweetness(storageSweetness.getAllSweetness().get(numberOfSweetness)))
        {
            numberOfSweetness = GenerationUtils.randInt(0, storageSweetness.getAllSweetness().size() - 1);
        }
    }

    @Override
    public void addSweetnessToGift() {
        StorageSweetness storageSweetness = StorageSweetness.getStorageSweetness();
        boolean flag = true;
        System.out.println("Меню доступных команд консоли для добавления сладостей в подарок:\n" +
                "1. add\n" +
                "2. addByQuantity\n" +
                "3. finish\n" +
                "4. giftInfo\n" +
                "5. help");
        while (flag)
        {
            String command = InputOutputUtils.inputLine("Введите команду: ").toLowerCase();
            switch (command)
            {
                case ("add"):
                {
                    storageSweetness.printAllSweetness();
                    int numberOfSweetness = InputOutputUtils.inputUInt("Введите номер желаемой сладости из предложенного выше списка для добавления в подарок: ");
                    if (numberOfSweetness >= 1 && numberOfSweetness <= storageSweetness.getAllSweetness().size())
                    {
                        if (((GiftSweetnessPacking)(giftsSweetness.get(giftsSweetness.size() - 1).getPacking())).addSweetness(storageSweetness.getAllSweetness().get(numberOfSweetness - 1)))
                        {
                            System.out.println("Сладость " + storageSweetness.getAllSweetness().get(numberOfSweetness - 1).getName() + " добавлена в подарок.");
                        }
                        else
                        {
                            System.out.println("Сладость " + storageSweetness.getAllSweetness().get(numberOfSweetness - 1).getName() + " не добавлена в подарок. Подарочная упаковка заполнена полностью.");
                        }
                    }
                    else
                    {
                        System.out.println("Заданная пользователем сладость недоступна.");
                    }
                    break;
                }
                case ("addbyquantity"):
                {
                    storageSweetness.printAllSweetness();
                    int numberOfSweetness = InputOutputUtils.inputUInt("Введите номер желаемой сладости из предложенного выше списка для добавления в подарок: ");
                    int countOfSweetness = InputOutputUtils.inputUInt("Введите количество сладостей для добавления в подарок: ");
                    if (numberOfSweetness >= 1 && numberOfSweetness <= storageSweetness.getAllSweetness().size())
                    {
                        int countOfAdded = ((GiftSweetnessPacking)(giftsSweetness.get(giftsSweetness.size() - 1).getPacking())).addSweetness(storageSweetness.getAllSweetness().get(numberOfSweetness - 1), countOfSweetness);
                        System.out.printf("Сладость %s добавлена в подарок в количестве %d шт.\n",storageSweetness.getAllSweetness().get(numberOfSweetness - 1).getName(), countOfAdded);
                    }
                    else
                    {
                        System.out.println("Заданная пользователем сладость недоступна.");
                    }
                    break;
                }
                case ("finish"):
                {
                    String str = InputOutputUtils.inputLine("Вы уверены, что хотите закончить добавление в подарок? После завершения добавления, в данный подарок будет невозможно ничего добавить. Введите Yes / No: ").toLowerCase();
                    if (str.equals("yes"))
                    {
                        System.out.println("Добавление сладостей в подарок завершено.");
                        flag = false;
                    }
                    break;
                }
                case ("giftinfo"):
                {
                    giftsSweetness.get(giftsSweetness.size() - 1).printInfo();
                    break;
                }
                case ("help"):
                {
                    System.out.println("Меню доступных команд для ввода в консоль:\n" +
                            "1. add - добавить заданную пользователем сладость в подарок.\n" +
                            "2. addByQuantity - добавить заданную пользователем сладость в подарок в заданном пользователем количестве.\n" +
                            "3. finish - завершить добавление сладостей в подарок.\n" +
                            "4. giftInfo - вывод информации о заполняемом сладостями подарке.\n" +
                            "5. help - выводит в консоль информацию о всех доступных командах добавления.\n" +
                            "Команды можно вводить без учета регистра.");
                    break;
                }
                default:
                {
                    System.out.println("Введенная команда недоступна. Чтобы посмотреть список доступных команд введите в консоль команду help");
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(email, client.email) &&
                Objects.equals(giftsSweetness, client.giftsSweetness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, email, giftsSweetness);
    }
}