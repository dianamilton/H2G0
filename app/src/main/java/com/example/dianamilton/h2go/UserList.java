package com.example.dianamilton.h2go;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by dianamilton on 3/2/17.
 */

/**
 * user list method, add user, get user - saves user in arraylist/array
 */
public class UserList {
    static ArrayList<User> userList = new ArrayList<>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference usersRef = database.getReference("Users");

    public UserList() {
        User defaultUser = new User();
        userList.add(defaultUser);


//        usersRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                UserList userList1 = dataSnapshot.getValue(UserList.class);
//                userList = userList1.getList();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                System.out.println("The read failed: " + databaseError.getCode());
//            }
//        });



    }

    public void addUser (User user) {
        userList.add(user);
    }

    public static User[] getUser() {
        User[] userArr = new User[userList.size()];
        for (int i = 0; i < userArr.length; i++) {
            userArr[i] = userList.get(i);
        }
        return userArr;
    }


    public ArrayList<User> getList(){
        return userList;
    }

}
