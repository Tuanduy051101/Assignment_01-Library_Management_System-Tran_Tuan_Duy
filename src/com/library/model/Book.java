package com.library.model;

public class Book {
    private int stt;
    private String title;
    private String author;
    private int quantity;

    public Book() {
    }

    // getters, setters
    public int getStt() {
        return stt;
    }

    public void setStt(int id) {
        this.stt = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "stt=" + stt +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
