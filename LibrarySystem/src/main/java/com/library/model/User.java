package com.library.model;

public class User {
    private String username;
    private String password;
    private String membershipNumber;

    public User(String username, String password, String membershipNumber) {
        this.username = username;
        this.password = password;
        this.membershipNumber = membershipNumber;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }
}
