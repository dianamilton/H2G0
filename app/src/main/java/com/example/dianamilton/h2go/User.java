package com.example.dianamilton.h2go;

import android.widget.Spinner;
import java.util.Date;

/**
 * Created by dianamilton on 3/2/17.
 */

/**
 *
 */
public class User {

    private String name;
    private String passcode;
    private String email;
    private String number;
    private String address;
    private String type;

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

}
