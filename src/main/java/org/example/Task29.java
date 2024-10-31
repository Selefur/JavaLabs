package org.example;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task29 {
    public HashMap<String, TextFile> fileMap;

    public static void main(String[] args) {
        Task29 fileManager = new Task29();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введіть команду (додати(1), переглянути(2), вихід(3))):");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "1":
                    System.out.print("Введіть ім'я файлу: ");
                    String fileName = scanner.nextLine();
                    System.out.print("Введіть шлях до файлу: ");
                    String path = scanner.nextLine();
                    System.out.print("Введіть опис: ");
                    String description = scanner.nextLine();
                    fileManager.addFile(fileName, path, description);
                    break;
                case "2":
                    fileManager.displayFiles();
                    break;
                case "3":
                    System.out.println("Вихід з програми.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Невідома команда.");
            }
        }
    }
    public Task29() {
        fileMap = new HashMap<>();
        initializeFiles();
    }

    private void initializeFiles() {
        fileMap.put("file1.txt", new TextFile("C:/files/", "Опис вмісту файлу 1"));
        fileMap.put("file2.txt", new TextFile("C:/files/", "Опис вмісту файлу 2"));
        fileMap.put("file3.txt", new TextFile("C:/files/", "Опис вмісту файлу 3"));
        fileMap.put("file4.txt", new TextFile("C:/files/", "Опис вмісту файлу 4"));
        fileMap.put("file5.txt", new TextFile("C:/files/", "Опис вмісту файлу 5"));
    }

    public void addFile(String fileName, String path, String description) {
        if (!fileMap.containsKey(fileName)) {
            TextFile newFile = new TextFile(path, description);
            fileMap.put(fileName, newFile);
            System.out.println("Файл додано: " + fileName);
        } else {
            System.out.println("Файл з такою назвою вже існує.");
        }
    }

    public void displayFiles() {
        System.out.println("Список файлів:");
        List<String> sortedFileNames = new ArrayList<>(fileMap.keySet());
        Collections.sort(sortedFileNames);

        for (String fileName : sortedFileNames) {
            TextFile file = fileMap.get(fileName);
            System.out.println(fileName + " - " + file.getDescription());
        }
    }
}

class TextFile {
    private String path;
    private String description;

    public TextFile(String path, String description) {
        this.path = path;
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public String getDescription() {
        return description;
    }
}

