package edu.gatech.hackgt.budslist.models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserManager {

    private final Map<String,User> users = new HashMap<>();

    void addUser(String email, String password, String name, long phone_number) {
        User user = new User(email, password, name, phone_number);
        users.put(email, user);
    }

    void removeUser(String email) {
        users.remove(email);
    }


    Map<String, User> getUsers() {
        return users;
    }


    public User getUserByEmail(String email) {
        return users.get(email);
    }

}
