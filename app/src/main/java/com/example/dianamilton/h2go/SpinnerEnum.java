package com.example.dianamilton.h2go;

/**
 * Created by dianamilton on 2/23/17.
 */

/**
 * creates spinner for sign up activity
 */
public enum SpinnerEnum {
    User("User"), Admin("Admin"), Worker("Worker"), Manager("Manager");
    private final String userType;

    SpinnerEnum(String type) {
        userType = type;
    }

    public String toString() {
        return userType;
    }
}
