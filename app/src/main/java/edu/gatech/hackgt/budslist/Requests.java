package edu.gatech.hackgt.budslist;

import java.time.LocalDate;

public class Requests {
    private User seller;
    private User buyer;
    private LocalDate date;

    public Requests(User seller, User buyer, LocalDate date) {
        this.seller = seller;
        this.buyer = buyer;
        this.date = LocalDate.now();
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
    public void setSeller(User seller) {
        this.seller = seller;
    }
    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }
}
