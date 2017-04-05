package com.example.dianamilton.h2go;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Darren Trementozzi
 * @version 1.0
 *
 */
public class LoginTest {
    /**
     * This method is run before each test
     * @throws java.lang.Exception
     */
	@Rule
    public ActivityTestRule login = new ActivityTestRule<>(
            LoginActivity.class);
    /**
     * Test method for validate
     */
    @Test
    public void testValidate() {
    	email = "";
        Assert.assertFalse("Email passed but is empty", login.validate());
        password = "";
        Assert.assertFalse("Password passed but is empty", login.validate());
        password = "123";
        Assert.assertFalse("Password passed but is too short", login.validate());
        password = "12345678910";
        Assert.assertFalse("Password passed but is too long", login.validate());
    }
}
