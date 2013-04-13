package com.github.pietrom.jaccount;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {
	private static final String USERNAME = "pietrom";
	private static final String KEY_A = "a-key";
	private static final String VALUE = "a-value";

	@Test
	public void usernameIsAccessible() throws Exception {
		Account account = new Account(USERNAME);
		assertEquals(USERNAME, account.getUsername());
	}
	
	@Test
	public void givenAnAccountWithoutPropertiesThenGetPropertyReturnsNull() throws Exception {
		PropertiesSource account = new Account(USERNAME);
		assertNull(account.getProperty(KEY_A));
	}
}
