package com.library.model;

public class Fine {
    private String membershipNumber;
    private double amount;

    public Fine(String membershipNumber, double amount) {
        this.membershipNumber = membershipNumber;
        this.amount = amount;
    }

    // Getters and Setters
    public String getMembershipNumber() {
        return membershipNumber;
    }

    public double getAmount() {
        return amount;
    }
}
