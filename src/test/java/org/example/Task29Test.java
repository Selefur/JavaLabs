package org.example;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;

class Task29Test {
    private Task29 task29;

    @BeforeEach
    public void setUp() {
        task29 = new Task29();
    }

    @Test
    public void testAddFile() {
        String fileName = "newFile.txt";
        String path = "C:/newfiles/";
        String description = "Опис нового файлу";

        task29.addFile(fileName, path, description);

        // Перевірка, чи файл додано
        assertTrue(task29.fileMap.containsKey(fileName));
        assertEquals(description, task29.fileMap.get(fileName).getDescription());
    }

    @Test
    public void testAddDuplicateFile() {
        String fileName = "file1.txt";
        String path = "C:/files/";
        String description = "Опис вмісту файлу 1";

        task29.addFile(fileName, path, description);
        task29.addFile(fileName, path, description);

        assertEquals(5, task29.fileMap.size());
    }
    @Test
    public void testDisplayFiles() {
        // Підготовка для захоплення виводу
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        task29.displayFiles();

        String expectedOutput = "Список файлів:\n" +
                "file1.txt - Опис вмісту файлу 1\n" +
                "file2.txt - Опис вмісту файлу 2\n" +
                "file3.txt - Опис вмісту файлу 3\n" +
                "file4.txt - Опис вмісту файлу 4\n" +
                "file5.txt - Опис вмісту файлу 5\n";

        // Перевірка виводу
        assertEquals(expectedOutput, outputStream.toString().replace("\r", ""));

        // Відновлення стандартного виводу
        System.setOut(System.out);
    }
}
