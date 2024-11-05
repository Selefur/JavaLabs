package org.example;

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
        return "Книжка[" +
                "Назва = '" + title + '\'' +
                ", Автор = '" + author + '\'' +
                ", Видавництво = '" + publisher + '\'' +
                ", \n Рік = " + year +
                ", Ціна = " + price +
                ']';
    }
}