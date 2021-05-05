package com.example.chandiwalaapp;

public class UserDetails {
    public String userName;
    public String phoneNumber;
    public String email;
    public String address;

    public UserDetails(String userNameText, String phoneNumberText, String emailText, String addressText) {
        this.userName = userNameText;
        this.phoneNumber = phoneNumberText;
        this.email = emailText;
        this.address = addressText;
    }
}
