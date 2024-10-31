package org.example;

public class Abonent {
    private String lastName;
    private String firstName;
    private String address;

    public Abonent(String lastName, String firstName, String address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Абонент: " + lastName + " " + firstName + ", Адреса: " + address;
    }
}
