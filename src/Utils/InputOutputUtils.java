package Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputOutputUtils {

    public static int inputNaturalNumber(String str) {
        // Функция для ввода натурального числа из консоли.
        System.out.print(str);
        Scanner in = new Scanner(System.in);
        int number;
        try {
            number = in.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Введенные данные некорректны. На ввод ожидается целое число.");
            return inputNaturalNumber(str);
        }
        if (number > 0)
            return number;
        System.out.println("Число должно быть > 0.");
        return inputNaturalNumber(str);
    }

    public static int inputUInt(String str) {
        // Функция для ввода целочисленного положительного значения из консоли.
        System.out.print(str);
        Scanner in = new Scanner(System.in);
        int number;
        try {
            number = in.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Введенные данные некорректны. На ввод ожидается целое число.");
            return inputUInt(str);
        }
        if (number >= 0)
            return number;
        System.out.println("Число должно быть положительным.");
        return inputUInt(str);
    }

    public static int inputInt(String str) {
        // Функция для ввода целочисленного значения из консоли.
        System.out.print(str);
        Scanner in = new Scanner(System.in);
        int number;
        try {
            number = in.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Введенные данные некорректны. На ввод ожидается целое число.");
            return inputInt(str);
        }
        return number;
    }

    public static double inputDouble(String str) {
        // Функция для ввода действительного значения из консоли.
        System.out.print(str);
        Scanner in = new Scanner(System.in);
        double number;
        try {
            number = in.nextDouble();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Введенные данные некорректны. На ввод ожидается действительное число.");
            return inputDouble(str);
        }
        return number;
    }

    public static double inputUDouble(String str) {
        // Функция для ввода действительного положительного значения из консоли.
        System.out.print(str);
        Scanner in = new Scanner(System.in);
        double number;
        try {
            number = in.nextDouble();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Введенные данные некорректны. На ввод ожидается действительное число.");
            return inputUDouble(str);
        }
        if (number >= 0)
            return number;
        System.out.println("Число должно быть положительным.");
        return inputUDouble(str);
    }

    public static String inputLine(String str) {
        // Функция для ввода строки из консоли.
        System.out.print(str);
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        return text;
    }
}