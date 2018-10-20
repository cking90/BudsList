package edu.gatech.hackgt.budslist.models;


import java.util.Map;

public class Model {

    /**
     * the facade maintains references to any required model classes
     */
    private UserManager um;

    /**
     * Singleton pattern
     */
    private static Model instance = new Model();


    /**
     * private constructor for facade pattern
     */
    private Model() {
        um = new UserManager();
    }

    /**
     * Singleton pattern accessor for instance
     *
     *
     * @return the one and only one instance of this facade
     */
    public static Model getInstance() { return instance; }

    public Map<String,User> getStudentsAsMap() {
        return um.getUsers();
    }

    public User getUserByName(final String name) {
        return um.getUserByName(name);
    }

    public void addNewUser(String email, String password, String name, long phone_number) {
        um.addUser(email, password, name, phone_number);

    }

    void addUser(User user) {
        um.addUser(user);
    }

    void removeUser(User user) {
        um.removeUser(user);
    }



}
