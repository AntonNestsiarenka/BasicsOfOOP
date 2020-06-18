package com.company.textfilemodel;

public class TextFile extends File<String> {

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
    public void addContentToFile(String content) {
        if (this.getContent() == null)
            this.setContent(content);
        else
            this.setContent(this.getContent() + content);
    }

    @Override
    public void clearContentOfFile() {
        setContent("");
    }

    @Override
    public void printContentOfFile() {
        System.out.println(getContent());
    }
}