package edu.gatech.hackgt.budslist.models;

public class Book {
    private Course course;
    private User seller;
    private String name;
    private int price;
    private String isbn;
    private String edition;
    private String author;
    private String publisher;

    public Book(Course course, User seller, String name, int price, String isbn, String edition, String author, String publisher) {
        this.course = course;
        this.seller = seller;
        this.name = name;
        this.price = price;
        this.isbn = isbn;
        this.edition = edition;
        this.author = author;
        this.publisher = publisher;
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
    public int getPrice() {
        return this.price;
    }
    public String getIsbn() {
        return this.isbn;
    }
    public String getEdition() {
        return this.edition;
    }
    public String getAuthor() {return this.author; }
    public String getPublisher() {return this.publisher; }
    public void setCourse(Course course) {
        this.course = course;
    }
    public void setSeller(User seller) {
        this.seller = seller;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setEdition(String edition) {
        this.edition = edition;
    }
    public void setAuthor(String author) { this.author = author; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Book)) {
            return false;
        }
        Book that = (Book) other;
        return this.isbn.equals(that.isbn);
    }
}
  enum Type {
    LOOSE_LEAF, HARD_COVER, PAPER_BACK
}
