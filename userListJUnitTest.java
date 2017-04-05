package com.example.dianamilton.h2go;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Junit to test UserList class for method getUser(),
 * method should return an array of User Objects
 * @author Nilay Mehta, nmehta73
 *
 */

public class userListJUnitTest {
    private User[] users = new User[5];
    private UserList userList = new UserList();

    @Before
    public void setUp() {
        User john = new User();
        john.setName("John");
        john.setPasscode("Random");
        john.setEmail("Random@gmail.com");
        john.setNumber("1111111");
        john.setAddress("georgia tech");
        john.setType("User");
        User tom = new User();
        tom.setName("Tom");
        tom.setPasscode("password123");
        tom.setEmail("tomemail@gmail.com");
        tom.setNumber("2347892342");
        tom.setAddress("87 asdf");
        tom.setType("User");
        User sally = new User();
        sally.setName("Sally");
        sally.setPasscode("hello22");
        sally.setEmail("sally@gmail.com");
        sally.setNumber("6392412375");
        sally.setAddress("43 sdafsdaf");
        sally.setType("Manager");
        User sam = new User();
        sam.setName("Sam");
        sam.setPasscode("samlovespinecones1");
        sam.setEmail("sam@sam.com");
        sam.setNumber("565542343");
        sam.setAddress("234 sjfl");
        sam.setType("User");
        User michelle = new User();
        michelle.setName("Michelle");
        michelle.setPasscode("skrtskrt777");
        michelle.setEmail("michelle@myspace.com");
        michelle.setNumber("123412342");
        michelle.setAddress("");
        michelle.setType("Worker");

        users[0] = john;
        users[1] = sally;
        users[2] = sam;
        users[3] = michelle;
        users[4] = tom;
        userList.addUser(sally);
        userList.addUser(sam);
        userList.addUser(michelle);
        userList.addUser(tom);
    }

    @Test
    public void usersTest() {
        User[] testArr = UserList.getUser();
        assertArrayEquals(users, testArr);
    }

}
