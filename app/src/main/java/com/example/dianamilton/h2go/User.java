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

    /**
     * Setter for passcode
     * @param passcode
     */
    public void setPasscode(String passcode) { this.passcode = passcode; }


    /**
     * Getter for passcode
     * @return passcode
     */
    public String getPasscode() { return passcode; }

    /**
     * Getter for name
     * @return name
     */
    public String getName() { return name; }

    /**
     * Setter for name
     * @param name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Getter for email
     * @return email
     */
    public String getEmail() { return email; }

    /**
     * Setter for email
     * @param email
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Setter for phone number
     * @param number
     */
    public void setNumber(String number) { this.number = number; }

    /**
     * Getter for phone number
     * @return number
     */
    public String getNumber() { return number; }

    /**
     * Setter for address
     * @param address
     */
    public void setAddress(String address) { this.address = address; }

    /**
     * Getter for address
     * @return address
     */
    public String getAddress() { return address; }

    /**
     * Setter for type of worker
     * @param type
     */
    public void setType(String type) { this.type = type; }

    /**
     * Getter for type of worker
     * @return type
     */
    public String getType() { return type; }


    /**
     * @return string that is presented in list view, shows information
     */
    public String toString() {
        return "Name: " +name +"\n" +
                "Email: " +email +"\n" +
                "Number: " +number +"\n" +
                "Address: " +address +"\n" +
                "Type: " +type +"\n";
    }

}
