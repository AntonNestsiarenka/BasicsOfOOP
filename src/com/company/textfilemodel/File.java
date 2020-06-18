package com.company.textfilemodel;

import Utils.MyException;

public abstract class File<T> {

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

    public void printFileName()
    {
        System.out.println(toString());
    }
}