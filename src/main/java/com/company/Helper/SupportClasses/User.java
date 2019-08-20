package com.company.Helper.SupportClasses;

import com.company.Helper.Log;

public class User {
    public String username;
    public String password;

    private String phoneNumber;

    public User(String _username, String _password) {
        username = _username;
        password = _password;
    }

    public void SetPhoneNumber(String newPhoneNumber) {
        phoneNumber = newPhoneNumber;
    }

    public String GetPhoneNumber() {
        if (!phoneNumber.equals("")) {
            return phoneNumber;
        }else{
            Log.error("User doesn't have an associated phone number");
            return null;
        }
    }
}