package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Task13Test {
    private Task13 libraryNetwork;

    @BeforeEach
    public void setUp() {
        libraryNetwork = new Task13();
    }

    @Test
    public void testSearchAbonent() {
        Abonent foundAbonent = libraryNetwork.searchAbonent(1);
        assertNotNull(foundAbonent);
        assertEquals("Абаголь", foundAbonent.getLastName());
        assertEquals("Іван", foundAbonent.getFirstName());
        assertEquals("вул. Перемоги, 1", foundAbonent.getAddress());
    }

    @Test
    public void testSearchNonExistentAbonent() {
        Abonent foundAbonent = libraryNetwork.searchAbonent(99);
        assertNull(foundAbonent);
    }

    @Test
    public void testUpdateAbonent() {
        libraryNetwork.updateAbonent(1, "НовеПрізвище", "НовеІм'я", "Нова адреса");
        Abonent updatedAbonent = libraryNetwork.searchAbonent(1);
        assertNotNull(updatedAbonent);
        assertEquals("НовеПрізвище", updatedAbonent.getLastName());
        assertEquals("НовеІм'я", updatedAbonent.getFirstName());
        assertEquals("Нова адреса", updatedAbonent.getAddress());
    }

    @Test
    public void testSortAbonentsByLastName() {
        List<Abonent> sortedAbonents = libraryNetwork.sortAbonentsByLastName();
        assertEquals("Абаголь", sortedAbonents.get(0).getLastName());
        assertEquals("Грищенко", sortedAbonents.get(1).getLastName());
        assertEquals("Коваленко", sortedAbonents.get(2).getLastName());
        assertEquals("Петренко", sortedAbonents.get(3).getLastName());
        assertEquals("Сидорович", sortedAbonents.get(4).getLastName());
    }
}
