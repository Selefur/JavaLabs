package org.example;

import java.util.*;

public class Task17 {
    private HashMap<Integer, Book> bookCatalog;

    public Task17() {
        bookCatalog = new HashMap<>();
        initializeCatalog();
    }

    private void initializeCatalog() {
        bookCatalog.put(978123456, new Book("Java Programming", "Іванов Іван Іванович", "Tech Press", 2020, 29.99f));
        bookCatalog.put(978098765, new Book("Effective Java", "Петров Петро Петрович", "Code Books", 2018, 39.99f));
        bookCatalog.put(978123098, new Book("Clean Code", "Сидоров Сидор Сидорович", "Programming Books", 2017, 25.99f));
        bookCatalog.put(978567890, new Book("Design Patterns", "Ковалев Коваль Ковалевич", "Design Press", 2019, 34.99f));
        bookCatalog.put(978123436, new Book("The Pragmatic Programmer", "Гриценко Григорій Григорійович", "Pragmatic Books", 2021, 45.99f));
    }

    public Book searchBookByISBN(int isbn) {
        return bookCatalog.get(isbn);
    }

    public List<Book> sortByAuthor() {
        List<Book> sortedBooks = new ArrayList<>(bookCatalog.values());
        sortedBooks.sort(Comparator.comparing(Book::getAuthor));
        return sortedBooks;
    }

    public List<Book> sortByYear() {
        List<Book> sortedBooks = new ArrayList<>(bookCatalog.values());
        sortedBooks.sort(Comparator.comparingInt(Book::getYear));
        return sortedBooks;
    }

    public boolean isUniqueBook(Book book) {
        Set<Book> uniqueBooks = new TreeSet<>(Comparator.comparing(Book::getAuthor));
        return uniqueBooks.add(book);
    }

    public static void main(String[] args) {
        Task17 catalog = new Task17();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ISBN to search for a book: ");
        int isbn = scanner.nextInt();
        Book book = catalog.searchBookByISBN(isbn);
        if (book != null) {
            System.out.println("Found Book: " + book);
        } else {
            System.out.println("Book not found.");
        }

        System.out.print("\nSort by (1) Author or (2) Year? ");
        int choice = scanner.nextInt();

        List<Book> sortedBooks;
        if (choice == 1) {
            sortedBooks = catalog.sortByAuthor();
            System.out.println("\nBooks sorted by Author:");
        } else if (choice == 2) {
            sortedBooks = catalog.sortByYear();
            System.out.println("\nBooks sorted by Year:");
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        sortedBooks.forEach(System.out::println);

        boolean isUnique = catalog.isUniqueBook(new Book("Java Programming", "Ivanov Ivan Ivanovych", "Tech Press", 2020, 29.99f));
        System.out.println("\nIs the book unique? " + isUnique);

        scanner.close();
    }
}

class Book {
    private String title;
    private String author;
    private String publisher;
    private int year;
    private float price;

    public Book(String title, String author, String publisher, int year, float price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
