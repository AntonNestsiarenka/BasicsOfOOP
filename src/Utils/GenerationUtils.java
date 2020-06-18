package Utils;

public class GenerationUtils {

    public static int randInt(int lowLimit, int highLimit)
    {
        // Генерация случайного целого значения в диапазоне [lowLimit, highlimit].
        if (lowLimit > highLimit)
        {
            int temp = lowLimit;
            lowLimit = highLimit;
            highLimit = temp;
        }
        int randomNumber = lowLimit + (int)(Math.random() * (highLimit - lowLimit + 1));
        return randomNumber;
    }

    public static double uniform(double lowLimit, double highLimit)
    {
        // Генерация случайного действительного значения в диапазоне [lowLimit, highlimit).
        if (lowLimit > highLimit)
        {
            double temp = lowLimit;
            lowLimit = highLimit;
            highLimit = temp;
        }
        double randomNumber = lowLimit + Math.random() * (highLimit - lowLimit);
        return randomNumber;
    }

    public static int[] createAndFill1DArrayRandom(int size, int limitA, int limitB) {
        // Функция создает целочисленный массив размерности size и заполняет его случайными значениями от [limitA, limitB].
        int array[] = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = randInt(limitA, limitB);
        return array;
    }

    public static double[] createAndFill1DArrayRandom(int size, double limitA, double limitB) {
        // Функция создает массив действительных чисел размерности size и заполняет его случайными значениями от [limitA, limitB).
        double array[] = new double[size];
        for (int i = 0; i < size; i++)
            array[i] = uniform(limitA, limitB);
        return array;
    }
}