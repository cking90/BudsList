package edu.gatech.hackgt.budslist.models;

public class User {
    private String email;
    private String password;
    private String name;
    private String phone_number;

    public User(String email, String password, String name, String phone_number) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone_number = phone_number;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
    public String getName() {
        return this.name;
    }
    public String getPhone_number() {
        return this.phone_number;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
