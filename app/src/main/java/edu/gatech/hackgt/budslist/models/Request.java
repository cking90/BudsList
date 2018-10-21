package edu.gatech.hackgt.budslist.models;

import java.time.LocalDate;

import edu.gatech.hackgt.budslist.models.User;

public class Request {
    private String buyer;
    private LocalDate date;
    private Book book;

    public Request(String buyer, Book book) {
        this.buyer = buyer;
        this.date = LocalDate.now();
        this.book = book;
    }

    public String getBuyer() {
        return this.buyer;
    }
    public LocalDate getDate() {
        return this.date;
    }
    public Book getBook() { return this.book; }
    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public boolean equals(Object other) {
        if (this == other) { return true; }
        if (!(other instanceof Request)) { return false; }
        return (((Request) other).buyer.equals(this.buyer)
                && ((Request) other).book.equals(this.book));
    }
    public String toString() {
        return book + " - " + book.getSeller().getName() + buyer;
    }
}
