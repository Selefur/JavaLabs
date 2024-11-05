package org.example;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Створити застосунок для перегляду списку файлів і додавання файлу в список.
// Початкові записи в списку (для 5 текстових файлів з розширенням .txt) створюються в програмному коді і є об'єктом класу HashMap,
// де ключем є ім'я файлу (типу String), а значенням - об'єкт типу TextFile, що містить два елементи String - абсолютний шлях до файлу (без імені файлу )
// і короткий опис вмісту файлу.
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
        fileMap.put("file1.txt", new TextFile("C:/files/", "123"));
        fileMap.put("file2.txt", new TextFile("C:/files/", "4562"));
        fileMap.put("file3.txt", new TextFile("C:/files/", "Holla"));
        fileMap.put("file4.txt", new TextFile("C:/files/", "Amigo"));
        fileMap.put("file5.txt", new TextFile("C:/files/", "Konichiwa"));
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

