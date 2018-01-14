package com.psl.tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;

import com.psl.dao.UserDao;
import com.psl.entity.User;

public class UserIT extends TestCase {
	private static UserDao userDao = null;
	private static User user1 = null, user2 = null;

	@BeforeClass
	public void setUp() {
		userDao = mock(UserDao.class);
		user1 = new User(1001, "Ganesh", "Naik", "admin", "1234", "Administrator");
		user2 = new User(1002, "Rohan", "Patel", "rohan_patel", "1234567", "Administrator");
		when(userDao.getUser()).thenReturn(user1, user2);
		
		when(userDao.authenticateUser("admin", "1234")).thenReturn(user1.getEmployeeID()+"");
		when(userDao.authenticateUser("rohan_patel", "1234567")).thenReturn(user2.getEmployeeID()+"");
		
		when(userDao.addUser(user1)).thenReturn(true);
	}

	@Test
	public void testAuthenticateUser() {
		assertEquals("1001", userDao.authenticateUser("admin", "1234"));
	}
}