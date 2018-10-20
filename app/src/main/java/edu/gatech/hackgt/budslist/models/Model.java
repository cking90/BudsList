package edu.gatech.hackgt.budslist.models;


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




    public void addRequest(User buyer, User seller, Book book) {
        requests.add(new Request(buyer, seller, book));
    }
    public void removeRequest(Request request) {
        requests.remove(request);
    }
    public Request getRequest(String isbn, String sellerEmail, String buyerEmail) {
        for (Request r : requests) {
            if (r.getBook().getIsbn().equals(isbn) && r.getBuyer().getEmail().equals(buyerEmail)
                    && r.getSeller().getEmail().equals(sellerEmail)) {
                return r;
            }
        }
        return null;
    }







}
