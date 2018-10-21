package edu.gatech.hackgt.budslist.models;

public class Book {
    private Course course;
    private User seller;
    private String name;
    private String price;
    private String isbn;
    private String author;
    private Binding type;

    public Book(Course course, User seller, String name, String price,
                String isbn, String author, Binding type) {
        this.course = course;
        this.seller = seller;
        this.name = name;
        this.price = price;
        this.isbn = isbn;
        this.author = author;
        this.type = type;
    }

    public Course getCourse() {
        return this.course;
    }
    public User getSeller() {
        return this.seller;
    }
    public String getName() {
        return this.name;
    }
    public String getPrice() {
        return this.price;
    }
    public String getIsbn() {
        return this.isbn;
    }
    public String getAuthor() {return this.author; }
    public Binding getType() {
        return this.type;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public void setSeller(User seller) {
        this.seller = seller;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setAuthor(String author) { this.author = author; }


    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Book)) {
            return false;
        }
        Book that = (Book) other;
        return this.getSeller().equals(that.getSeller())
                && this.getPrice().equals(that.getPrice())
                && this.getIsbn().equals(that.getIsbn());
    }

    public String toString() {
        return name + ": $" + price;
    }
}
