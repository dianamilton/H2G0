package com.example.dianamilton.h2go;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Signup JUnit, for the validate method
 * @author dianamilton
 *
 */
public class SignUpTest {
	
	public ActivityTestRule signup = new ActivityTestRule<>(SignupActivity.java)
	
	
	@Test
	public void test() {
		name = "";
		Assert.assertFalse("Name passed but is empty", signup.validate());
		name = "ab";
		Assert.assertFalse("Name must be at least 3 characters", signup.validate());
		email = "";
        Assert.assertFalse("Email passed but is empty", signup.validate());
        email = "dsjafkfa";
        Assert.assertFalse("Emails require correct symbols and format", signup.validate());
        password = "";
        Assert.assertFalse("Password passed but is empty", signup.validate());
        password = "a1";
        Assert.assertFalse("Password passed but is too short", signup.validate());
        password = "a12";
        Assert.assertFalse("Password passed but is too short", signup.validate());
        password = "abcde12345";
        Assert.assertFalse("Password passed but is too long", signup.validate());
        password = "abcde123456";
        Assert.assertFalse("Password passed but is too long", signup.validate());
	}

}
