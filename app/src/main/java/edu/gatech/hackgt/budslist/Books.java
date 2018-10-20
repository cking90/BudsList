package edu.gatech.hackgt.budslist;

public class Books {
    private Courses course;
    private User seller;
    private String name;
    private int price;
    private String isbn;
    private String edition;

    public Books(Courses course, User seller, String name, int price, String isbn, String edition) {
        this.course = course;
        this.seller = seller;
        this.name = name;
        this.price = price;
        this.isbn = isbn;
        this.edition = edition;
    }

    public Courses getCourse() {
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
    public void setCourse(Courses course) {
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
}
