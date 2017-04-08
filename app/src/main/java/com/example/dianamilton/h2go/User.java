package com.example.dianamilton.h2go;

import android.widget.Spinner;
import java.util.Date;

/**
 * Created by dianamilton on 3/2/17.
 */

/**
 * all aspects for user login
 */
public class User {

    private String name;
    private String passcode;
    private String email;
    private String number;
    private String address;
    private String type;

    public User() {
        name = "John";
        passcode ="Random";
        email="Random@gmail.com";
        number = "1111111";
        address = "georgia tech";
        type ="User";
    }


    public void setPasscode(String passcode) { this.passcode = passcode; }
    public String getPasscode() { return passcode; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public void setNumber(String number) { this.number = number; }
    public String getNumber() { return number; }
    public void setAddress(String address) { this.address = address; }
    public String getAddress() { return address; }
    public void setType(String type) { this.type = type; }
    public String getType() { return type; }


    public String toString() {
        return "Name: " +name +"\n" +
                "Email: " +email +"\n" +
                "Number: " +number +"\n" +
                "Address: " +address +"\n" +
                "Type: " +type +"\n";
    }

}
