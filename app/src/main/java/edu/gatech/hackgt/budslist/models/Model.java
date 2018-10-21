package edu.gatech.hackgt.budslist.models;


import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {

    /**
     * the facade maintains references to any required model classes
     */
    private final Map<String,User> users = new HashMap<>();

    private final List<Request> requests = new ArrayList<>();

    private final List<Book> books = new ArrayList<>();

    private String currentUser;

    /**
     * Singleton pattern
     */
    private static Model instance = new Model();


    /**
     * private constructor for facade pattern
     */
    private Model() {

    }

    /**
     * Singleton pattern accessor for instance
     *
     *
     * @return the one and only one instance of this facade
     */
    public static Model getInstance() { return instance; }

    public void addUser(String email, String password, String name, String phone_number) {
        User user = new User(email, password, name, phone_number);
        users.put(email, user);
    }
    public void removeUser(String email) {
        users.remove(email);
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public User getUserByEmail(String email) {
        return users.get(email);
    }

    public String getCurrentUser() {
        return this.currentUser;
    }

    public void setCurrentUser(String user) {
        this.currentUser = user;
    }



    public void addRequest(String buyer, Book book) {
        requests.add(new Request(buyer, book));
    }
    public void removeRequest(Request request) {
        requests.remove(request);
    }

    public List<Request> getRequestsForBuyer(String buyerEmail) {
        List<Request> requests = new ArrayList<>();
        for (Request r : this.requests) {
            if (r.getBuyer().equals(buyerEmail)) {
                requests.add(r);
                Log.d("Erm", "Rip");
            }
        }
        return requests;
    }

    public List<Request> getRequestsForSeller(String sellerEmail) {
        List<Request> requests = new ArrayList<>();
        for (Request r : this.requests) {
            if (r.getBook().getSeller().getEmail().equals(sellerEmail)) {
                requests.add(r);
                Log.d("Erm", "Rip");
            }
        }
        return requests;
    }

    public List<Request> getRequests() {
        return this.requests;
    }

    public void addBook(Course course, User seller, String name, String price, String isbn,
                        String author, Binding type) {
        books.add(new Book(course, seller, name, price, isbn, author, type));
    }
    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooksWithSellerEmail(String sellerEmail) {
        List<Book> books = new ArrayList<>();
        for (Book b : this.books) {
            if (b.getSeller().getEmail().equals(sellerEmail)) {
                books.add(b);
            }
        }
        return books;
    }

    public Book getBookWith_seller_price_isbn(String sellerEmail, String price, String isbn) {
        Log.d("Bruh2", "Enter model Method");
        for (Book b : this.getBooks()) {
            Log.d("banana",b.getName());
            if (b.getSeller().getEmail().trim().equals(sellerEmail.trim())
                    && price.trim().equals(b.getPrice().trim())
                    && isbn.trim().equals(b.getIsbn().trim())) {
                return b;
            }
        }
        return null;
    }
    public Request getRequest_book_buyer(Book book, String buyerEmail) {
        for(Request r: this.requests) {
            if(r.getBook().equals(book) && r.getBuyer().equals(buyerEmail)) {
                return r;
            }
        }
        return null;
    }

    public List<Book> getBooks() {
        return books;
    }


}
