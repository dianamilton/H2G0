package com.example.dianamilton.h2go;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* Find By Name JUnit Test from UserDAO.java
* @author Christina Bui
* @version 1.0
**/


public class FindByNameTest {
	/**
     * This method is run before each test
     * @throws java.lang.Exception
     */
	@Rule
	public ActivityTestRule findbyname = new ActivityTestRule<>(
		UserDAO.class);

	/**
	* Test for findByName()
	*/
	@Test
	public void testFindByName() {
		database = NULL;
		Assert.assertFalse("Invalid database.", findByName.rawQuery(query,null));
		name = "";
		Assert.assertFalse("No name submitted.", findByName.rawQuery(query,null));
		name = "1";
		Assert.assertFalse("Name cannot contain numbers.", findByName.rawQuery(query,null));
		name = "@";
		Assert.assertFalse("Name cannot contain invalid characters.", findByName.rawQuery(query,null));
	}
}