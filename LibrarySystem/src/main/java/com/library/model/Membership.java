package com.library.model;

public class Membership {
    private String membershipNumber;
    private String memberName;
    private String duration; // e.g., "6 months", "1 year"

    public Membership(String membershipNumber, String memberName, String duration) {
        this.membershipNumber = membershipNumber;
        this.memberName = memberName;
        this.duration = duration;
    }

    // Getters and Setters
    public String getMembershipNumber() {
        return membershipNumber;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getDuration() {
        return duration;
    }
}
