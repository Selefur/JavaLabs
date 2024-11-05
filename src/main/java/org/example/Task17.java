package org.example;

import java.util.*;
//Створити застосунок для пошуку книг в бібліотечному каталозі по заданому критерію.
// Початкові записи в списку книг (5 записів) створюються в програмному коді і є об'єктом класу HashMap.
// Ключем записи є індекс ISBN книги (типу Integer), а значенням - об'єкт Book, що містить найменування книги, прізвище, ім'я та по батькові (ПІБ) учасника,
// видавництво (всі записи типу String), рік видання (типу int) і ціну книги (типу float).
// Передбачити можливість сортування каталогу по ПІБ автора або роком видання, для чого використовувати ArrayList.
// Передбачити можливість перевірки унікальності книги за допомогою TreeSet

public class Task17 {
    private HashMap<Integer, Book> bookCatalog;
    private Set<Book> uniqueBooks;

    public Task17() {
        bookCatalog = new HashMap<>();
        uniqueBooks = new TreeSet<>(Comparator.comparing(Book::getTitle));
        initializeCatalog();
    }

    private void initializeCatalog() {
        bookCatalog.put(978123456, new Book("Java Programming", "Анасенко. І. В.", "Tech Press", 2023, 29.99f));
        bookCatalog.put(978098765, new Book("Effective Java", "Петров П. П.", "Code Books", 2018, 39.99f));
        bookCatalog.put(978123098, new Book("Clean Code", "Сидоров С. К.", "Programming Books", 2017, 25.99f));
        bookCatalog.put(978567890, new Book("Design Patterns", "Ковалев О. В.", "Design Press", 2019, 34.99f));
        bookCatalog.put(978123436, new Book("The Pragmatic Programmer", "Гриценко Г. Д.", "Pragmatic Books", 2021, 45.99f));
        bookCatalog.put(978126636, new Book("The Pragmatic Programmer", "Гриц Г. Д.", "Pragmatic Books", 2021, 45.99f));

        uniqueBooks.addAll(bookCatalog.values());
    }

    public static void main(String[] args) {
        Task17 catalog = new Task17();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Оберіть критерій пошуку: ");
        System.out.println("1 - Пошук за ISBN");
        System.out.println("2 - Пошук за Назвою");
        System.out.println("3 - Пошук за Автором");
        System.out.println("4 - Пошук за Видавництвом");
        System.out.println("5 - Пошук за Роком видання");
        System.out.print("Введіть номер критерію пошуку: ");
        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        switch (searchChoice) {
            case 1 -> {
                System.out.print("Введіть ISBN: ");
                int isbn = scanner.nextInt();
                Book book = catalog.searchBookByISBN(isbn);
                System.out.println(book != null ? "Знайдена книжка: " + book : "Книжка не знайдена.");
            }
            case 2 -> {
                System.out.print("Введіть Назву: ");
                String title = scanner.nextLine();
                List<Book> books = catalog.searchBookByTitle(title);
                books.forEach(System.out::println);
            }
            case 3 -> {
                System.out.print("Введіть Автора: ");
                String author = scanner.nextLine();
                List<Book> books = catalog.searchBookByAuthor(author);
                books.forEach(System.out::println);
            }
            case 4 -> {
                System.out.print("Введіть Видавництва: ");
                String publisher = scanner.nextLine();
                List<Book> books = catalog.searchBookByPublisher(publisher);
                books.forEach(System.out::println);
            }
            case 5 -> {
                System.out.print("Введіть Рік видавництва: ");
                int year = scanner.nextInt();
                List<Book> books = catalog.searchBookByYear(year);
                books.forEach(System.out::println);
            }
            default -> System.out.println("Невірний номер.");
        }

        System.out.print("\nСортувати за Автором(1) чи Роком(2)? ");
        int choice = scanner.nextInt();

        List<Book> sortedBooks;
        if (choice == 1) {
            sortedBooks = catalog.sortByAuthor();
            System.out.println("\nКнижки відсортовано за Автором:");
        } else if (choice == 2) {
            sortedBooks = catalog.sortByYear();
            System.out.println("\nКнижки відсортовано за Роком видаництва:");
        } else {
            System.out.println("Невірний номер.");
            return;
        }

        sortedBooks.forEach(System.out::println);

        // Перевірка унікальності
        boolean isUnique = catalog.isUniqueBook(new Book("Designййй", "Гриценко Г. Д.", "Pragmatic Books", 2021, 45.99f));
        System.out.println("\nУнікальна книжка? " + isUnique);

        scanner.close();
    }

    public Book searchBookByISBN(int isbn) {
        return bookCatalog.get(isbn);
    }

    public List<Book> searchBookByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookCatalog.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchBookByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookCatalog.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchBookByPublisher(String publisher) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookCatalog.values()) {
            if (book.getPublisher().equalsIgnoreCase(publisher)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchBookByYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookCatalog.values()) {
            if (book.getYear() == year) {
                result.add(book);
            }
        }
        return result;
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
        return uniqueBooks.add(book);
    }
}
