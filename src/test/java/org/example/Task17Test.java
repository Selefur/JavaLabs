package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class Task17Test {
    private Task17 catalog;

    @BeforeEach
    void setUp() {
        catalog = new Task17();
    }

    @Test
    void testSearchBookByISBN() {
        Book book = catalog.searchBookByISBN(978123456);
        assertNotNull(book);
        assertEquals("Java Programming", book.getTitle());

        Book notFoundBook = catalog.searchBookByISBN(123456789);
        assertNull(notFoundBook);
    }

    @Test
    void testSearchBookByTitle() {
        List<Book> books = catalog.searchBookByTitle("Java Programming");
        assertEquals(1, books.size());
        assertEquals("Анасенко. І. В.", books.get(0).getAuthor());

        List<Book> notFoundBooks = catalog.searchBookByTitle("Unknown Title");
        assertTrue(notFoundBooks.isEmpty());
    }

    @Test
    void testSearchBookByAuthor() {
        List<Book> books = catalog.searchBookByAuthor("Петров П. П.");
        assertEquals(1, books.size());
        assertEquals("Effective Java", books.get(0).getTitle());

        List<Book> notFoundBooks = catalog.searchBookByAuthor("Unknown Author");
        assertTrue(notFoundBooks.isEmpty());
    }

    @Test
    void testSearchBookByPublisher() {
        List<Book> books = catalog.searchBookByPublisher("Tech Press");
        assertEquals(1, books.size());
        assertEquals("Java Programming", books.get(0).getTitle());

        List<Book> notFoundBooks = catalog.searchBookByPublisher("Unknown Publisher");
        assertTrue(notFoundBooks.isEmpty());
    }

    @Test
    void testSearchBookByYear() {
        List<Book> books = catalog.searchBookByYear(2023);
        assertEquals(1, books.size());
        assertEquals("Java Programming", books.get(0).getTitle());

        List<Book> notFoundBooks = catalog.searchBookByYear(2000);
        assertTrue(notFoundBooks.isEmpty());
    }

    @Test
    void testSortByAuthor() {
        List<Book> sortedBooks = catalog.sortByAuthor();
        assertEquals("Анасенко. І. В.", sortedBooks.get(0).getAuthor());
        assertEquals("Гриц Г. Д.", sortedBooks.get(1).getAuthor());
    }

    @Test
    void testSortByYear() {
        List<Book> sortedBooks = catalog.sortByYear();
        assertEquals(2017, sortedBooks.get(0).getYear());
        assertEquals(2021, sortedBooks.get(4).getYear());
    }

    @Test
    void testIsUniqueBook() {
        Book newUniqueBook = new Book("New Book Title", "Новий Автор", "New Publisher", 2022, 49.99f);
        boolean isUnique = catalog.isUniqueBook(newUniqueBook);
        assertTrue(isUnique);


    }
    @Test
    void testIsNotUniqueBook()
    {
        Book duplicateBook = new Book("The Pragmatic Programmer", "Гриценко Г. Д.", "Pragmatic Books", 2021, 45.99f);
        boolean isDuplicateUnique = catalog.isUniqueBook(duplicateBook);
        assertFalse(isDuplicateUnique);
    }
}
