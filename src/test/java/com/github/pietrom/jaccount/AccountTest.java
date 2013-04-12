package com.github.pietrom.jaccount;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {
	@Test
	public void usernameIsAccessible() throws Exception {
		Account account = new Account("pietrom");
		assertEquals("pietrom", account.getUsername());
	}
}
