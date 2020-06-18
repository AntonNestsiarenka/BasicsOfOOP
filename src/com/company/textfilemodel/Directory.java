package com.company.textfilemodel;

import java.util.ArrayList;

public class Directory {

    private String directoryName;
    private ArrayList<File> files;

    public Directory()
    {
        directoryName = "src";
        files = new ArrayList<File>();
    }

    public Directory(String directoryName, File...files) {
        this.directoryName = directoryName;
        this.files = new ArrayList<File>();
        for (File file : files)
        {
            addFileToDirectory(file);
        }
    }

    public Directory(String directoryName)
    {
        this.directoryName = directoryName;
        this.files = new ArrayList<File>();
    }

    public void addFileToDirectory(File file)
    {
        files.add(file);
    }

    public void addFilesToDirectory(File...file)
    {
        for (File file1 : file)
        {
            addFileToDirectory(file1);
        }
    }

    public void deleteFileFromDirectory(File file)
    {
        files.remove(file);
    }

    public void deleteAllFilesFromDirectory()
    {
        files.clear();
    }

    public File getFileByName(String fileName)
    {
        File fileFound = null;
        for (File file : files)
        {
            if (file.getFileName().equals(fileName))
            {
                fileFound = file;
                return fileFound;
            }
        }
        return fileFound;
    }

    public String getDirectory() {
        return directoryName;
    }

    public void setDirectory(String directory) {
        this.directoryName = directory;
    }

    public void printAllFileNames()
    {
        for (File file : files)
        {
            file.printFileName();
        }
    }

    @Override
    public String toString() {
        return directoryName;
    }

    public void printDirectoryInfo()
    {
        System.out.println("Name of directory: " + directoryName);
        for (File file : files)
        {
            file.printFileName();
        }
        System.out.println();
    }
}