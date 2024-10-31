package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Task13 {
    private HashMap<Integer, Abonent> abonents;

    public static void main(String[] args) {
        Task13 libraryNetwork = new Task13();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть номер абонента для пошуку: ");
        int abonentNumber = scanner.nextInt();
        scanner.nextLine();

        Abonent foundAbonent = libraryNetwork.searchAbonent(abonentNumber);
        if (foundAbonent != null) {
            System.out.println("Пошук абонента з номером " + abonentNumber + ":");
            System.out.println(foundAbonent);

            // Запит на зміну даних
            System.out.print("Бажаєте змінити дані абонента? (так/ні): ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("так")) {
                System.out.print("Введіть нове прізвище: ");
                String newLastName = scanner.nextLine();
                System.out.print("Введіть нове ім'я: ");
                String newFirstName = scanner.nextLine();
                System.out.print("Введіть нову адресу: ");
                String newAddress = scanner.nextLine();

                libraryNetwork.updateAbonent(abonentNumber, newLastName, newFirstName, newAddress);
                System.out.println("Змінений абонент з номером " + abonentNumber + ":");
                System.out.println(libraryNetwork.searchAbonent(abonentNumber));
            }
        } else {
            System.out.println("Абонента з номером " + abonentNumber + " не знайдено.");
        }

        // Сортування абонентів
        System.out.println("Список абонентів, відсортованих за прізвищем:");
        List<Abonent> sortedAbonents = libraryNetwork.sortAbonentsByLastName();
        for (Abonent abonent : sortedAbonents) {
            System.out.println(abonent);
        }

        scanner.close(); // Закриваємо сканер
    }

    public Task13() {
        abonents = new HashMap<>();
        initializeAbonents();
    }

    private void initializeAbonents() {
        abonents.put(1, new Abonent("Абаголь", "Іван", "вул. Перемоги, 1"));
        abonents.put(2, new Abonent("Петренко", "Петро", "вул. Шевченка, 2"));
        abonents.put(3, new Abonent("Сидорович", "Сидор", "вул. Миру, 3"));
        abonents.put(4, new Abonent("Коваленко", "Олена", "вул. Козацька, 4"));
        abonents.put(5, new Abonent("Грищенко", "Марія", "вул. Незалежності, 5"));
    }

    public Abonent searchAbonent(int number) {
        return abonents.get(number);
    }

    public void updateAbonent(int number, String lastName, String firstName, String address) {
        Abonent abonent = new Abonent(lastName, firstName, address);
        abonents.put(number, abonent); // Оновлюємо дані абонента
    }

    public List<Abonent> sortAbonentsByLastName() {
        // Створюємо новий список абонентів та сортуємо його за прізвищем
        List<Abonent> sortedAbonents = new ArrayList<>(abonents.values());
        sortedAbonents.sort(Comparator.comparing(Abonent::getLastName));
        return sortedAbonents;
    }
}