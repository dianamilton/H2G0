package com.example.dianamilton.h2go;

import java.util.ArrayList;

/**
 * Created by dianamilton on 3/2/17.
 */

/**
 * user list method, add user, get user - saves user in arraylist/array
 */
public class UserList {
    ArrayList<User> userList = new ArrayList<>();

    /**
     * Adds parameter of user object to arraylist
     * @param user
     */
    public void addUser (User user) {
        userList.add(user);
    }

    /**
     * Iterates through arraylist of users and adds to a user array that can be editted
     * @return array of users
     */
    public User[] getUser() {
        User[] userArr = new User[userList.size()];
        for (int i = 0; i < userArr.length; i++) {
            userArr[i] = userList.get(i);
        }
        return userArr;
    }

}
