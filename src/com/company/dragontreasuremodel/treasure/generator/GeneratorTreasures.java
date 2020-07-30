package com.company.dragontreasuremodel.treasure.generator;

import Utils.GenerationUtils;
import Utils.MyException;
import com.company.dragontreasuremodel.treasure.Treasure;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public final class GeneratorTreasures {

    /* Генератор сокровищ. */

    private static ArrayList<String> namesOfTreasures;

    public GeneratorTreasures()
    {
        namesOfTreasures = new ArrayList<String>();
        generatorInit();
    }

    public Treasure generateTreasureRandom() throws MyException {
        if (namesOfTreasures.size() != 0)
            return new Treasure(namesOfTreasures.get(GenerationUtils.randInt(0, namesOfTreasures.size() - 1)), GenerationUtils.uniform(350, 25000));
        throw new MyException("Генератор инециализирован некорректно. Для выборки нужно хотя бы одно имя.");
    }

    public static ArrayList<String> getNamesOfTreasures() {
        return namesOfTreasures;
    }

    public void generatorInit()
    {
        namesOfTreasures.clear();
        FileReader fileReader= null;
        try {
            fileReader = new FileReader("treasurenames.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine())
        {
            namesOfTreasures.add(scanner.nextLine().trim());
        }
        scanner.close();
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}