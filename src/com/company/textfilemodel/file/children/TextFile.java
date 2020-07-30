package com.company.textfilemodel.file.children;

import com.company.textfilemodel.directory.Directory;
import com.company.textfilemodel.file.File;

public final class TextFile extends File<String> {

    /* Класс описывает текстовый файл. */

    private TextFile(String fileName, Directory directory)
    {
        super(fileName, "txt", directory);
        directory.addFileToDirectory(this);
    }

    private TextFile(String fileName, String content, Directory directory)
    {
        super(fileName, "txt", content, directory);
        directory.addFileToDirectory(this);
    }

    public static TextFile createTextFile(String fileName, Directory directory)
    {
        /* Создает текстовый в заданной директории. Если такое имя уже есть дописывает в конец число, чтобы файл
           был уникальным. */
        if (directory.getFileByName(fileName) == null)
        {
            return new TextFile(fileName, directory);
        }
        else
        {
            String newFileName = new String(fileName + 1);
            int i = 2;
            while (directory.getFileByName(newFileName) != null)
            {
                newFileName = new String(fileName + i);
                i++;
            }
            return new TextFile(newFileName, directory);
        }
    }

    public static TextFile createTextFile(String fileName, String content, Directory directory)
    {
        /* Создает текстовый в заданной директории с заданным контентом. Если такое имя уже есть дописывает в конец
           число, чтобы файл был уникальным. */
        if (directory.getFileByName(fileName) == null)
        {
            return new TextFile(fileName, content, directory);
        }
        else
        {
            String newFileName = new String(fileName + 1);
            int i = 2;
            while (directory.getFileByName(newFileName) != null)
            {
                newFileName = new String(fileName + i);
                i++;
            }
            return new TextFile(newFileName, content, directory);
        }
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void addContentToFile(String content) {
        // Добавляет некоторый текст в файл.
        if (this.getContent() == null)
            this.setContent(content);
        else
            this.setContent(this.getContent() + content);
    }

    @Override
    public void clearContentOfFile() {
        // Очищает содержимое текстового файла.
        setContent("");
    }

    @Override
    public void printContentOfFile() {
        // Выводит содержимое файла.
        System.out.println(getContent());
    }
}