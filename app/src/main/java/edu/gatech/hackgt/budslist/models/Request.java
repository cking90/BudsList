package edu.gatech.hackgt.budslist.models;

import java.time.LocalDate;

import edu.gatech.hackgt.budslist.models.User;

public class Request {
    private User seller;
    private User buyer;
    private LocalDate date;
    private Book book;

    public Request(User seller, User buyer, Book book) {
        this.seller = seller;
        this.buyer = buyer;
        this.date = LocalDate.now();
        this.book = book;
    }
    public User getSeller() {
        return this.seller;
    }
    public User getBuyer() {
        return this.buyer;
    }
    public LocalDate getDate() {
        return this.date;
    }
    public Book getBook() { return this.book; }
    public void setSeller(User seller) {
        this.seller = seller;
    }
    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public boolean equals(Object other) {
        if (this == other) { return true; }
        if (!(other instanceof Request)) { return false; }
        return (((Request) other).seller.equals(this.seller)
                && ((Request) other).buyer.equals(this.buyer)
                && ((Request) other).book.equals(this.book));
    }
}
