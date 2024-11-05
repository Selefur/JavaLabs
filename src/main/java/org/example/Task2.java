package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//Створити застосунок для пошуку абонентів телефонної мережі.
// Початкові записи в списку (5 записів) створюються в програмному коді і є об'єктом класу HashMap.
// Ключем записи є семизначний номер телефону (типу String),
// а значенням - об'єкт Abonent, що містить три значення типу String: прізвище, ім'я та адреса. Передбачити можливість пошуку абонентів колекції по ключу.

public class Task2 {

    protected static Map<String, Abonent> phoneDirectory = new HashMap<>();

    protected static void initializeDirectory() {
        phoneDirectory.put("1234567", new Abonent("Іванов", "Іван", "Київ, вул. Хрещатик, 1"));
        phoneDirectory.put("2345678", new Abonent("Петров", "Петро", "Київ, вул. Лесі Українки, 5"));
        phoneDirectory.put("3456789", new Abonent("Сидоров", "Сидір", "Київ, вул. Січових Стрільців, 10"));
        phoneDirectory.put("4567890", new Abonent("Коваленко", "Марія", "Київ, вул. Грушевського, 12"));
        phoneDirectory.put("5678901", new Abonent("Шевченко", "Тарас", "Київ, вул. Шевченка, 8"));
    }

    protected static Abonent searchAbonent(String phoneNumber) {
        return phoneDirectory.get(phoneNumber);
    }

    public static void main(String[] args) {
        initializeDirectory();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введіть номер телефону для пошуку (або залиште порожнім для завершення): ");
            String phoneNumber = scanner.nextLine();

            if (phoneNumber.isEmpty()) {
                break;
            }

            Abonent abonent = searchAbonent(phoneNumber);
            if (abonent != null) {
                System.out.println("Абонент знайдений: " + abonent);
            } else {
                System.out.println("Абонента не знайдено.");
            }
        }

        System.out.println("Пошук завершено.");
        scanner.close();
    }
}
