package com.company.textfilemodel.file;

import Utils.MyException;
import com.company.textfilemodel.directory.Directory;

import java.util.Objects;

public abstract class File<T> {

    /* Класс описывает файл. */

    private String fileName;
    private String extension;
    private T content = null;
    private Directory location;

    public File(String fileName, String extension, T content, Directory location)
    {
        this.fileName = fileName;
        this.extension = extension;
        this.content = content;
        this.location = location;
    }

    public File(String fileName, String extension, Directory location) {
        this.fileName = fileName;
        this.extension = extension;
        this.location = location;
    }

    public String getFileName() {
        return fileName;
    }

    private void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Directory getLocation() {
        return location;
    }

    public void renameFile(String newName) throws MyException {
        if (this.getLocation().getFileByName(newName) == null)
            this.setFileName(newName);
        else
            throw new MyException("Файл с таким именем уже существует. Попробуйте другое имя.");
    }

    public void deleteFile()
    {
        this.getLocation().deleteFileFromDirectory(this);
    }

    public abstract void addContentToFile(T content);

    public abstract void clearContentOfFile();

    public abstract void printContentOfFile();

    @Override
    public String toString() {
        return fileName + "." + extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File<?> file = (File<?>) o;
        return Objects.equals(fileName, file.fileName) &&
                Objects.equals(extension, file.extension) &&
                Objects.equals(location, file.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, extension, location);
    }

    public void printFileName()
    {
        System.out.println(toString());
    }
}