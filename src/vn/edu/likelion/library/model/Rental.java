package vn.edu.likelion.library.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Rental {
    private Book book;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private int quantity;

    public Rental() {
    }

    // getters, setters
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getRentalDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return this.rentalDate.format(formatter);
    }

    public void setRentalDate() {
        this.rentalDate = LocalDate.now();
        this.rentalDate = this.rentalDate.plusDays(0);
    }

    public String getReturnDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return this.returnDate.format(formatter);
    }

    public void setReturnDate(String newDate) {
        this.returnDate = LocalDate.parse(newDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "book=" + book +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", quantity=" + quantity +
                '}';
    }
}


