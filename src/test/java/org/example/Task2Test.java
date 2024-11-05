package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @BeforeAll
    static void setup() {
        // Ініціалізуємо телефонний довідник перед запуском тестів
        Task2.initializeDirectory();
    }

    @Test
    void testSearchExistingAbonent() {
        Abonent abonent = Task2.searchAbonent("1234567");
        assertNotNull(abonent, "Абонент повинен існувати");
        assertEquals("Іванов", abonent.getLastName());
        assertEquals("Іван", abonent.getFirstName());
        assertEquals("Київ, вул. Хрещатик, 1", abonent.getAddress());
    }

    @Test
    void testSearchNonExistingAbonent() {
        Abonent abonent = Task2.searchAbonent("0000000");
        assertNull(abonent, "Абонент з таким номером не повинен існувати");
    }

    @Test
    void testSearchAnotherExistingAbonent() {
        Abonent abonent = Task2.searchAbonent("4567890");
        assertNotNull(abonent, "Абонент повинен існувати");
        assertEquals("Коваленко", abonent.getLastName());
        assertEquals("Марія", abonent.getFirstName());
        assertEquals("Київ, вул. Грушевського, 12", abonent.getAddress());
    }
}
