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

    public void addUser (User user) {
        userList.add(user);
    }

    public User[] getUser() {
        User[] userArr = new User[userList.size()];
        for (int i = 0; i < userArr.length; i++) {
            userArr[i] = userList.get(i);
        }
        return userArr;
    }

}
