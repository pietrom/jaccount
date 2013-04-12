package com.github.pietrom.jaccount;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {
	private static final String USERNAME = "pietrom";

	@Test
	public void usernameIsAccessible() throws Exception {
		Account account = new Account(USERNAME);
		assertEquals(USERNAME, account.getUsername());
	}
	
	@Test
	public void accountIsAPropertiesSource() throws Exception {
		PropertiesSource account = new Account(USERNAME);
	}
}
