package com.github.pietrom.jaccount;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoleTest {
	private static final String ROLE_NAME = "role-name";
	private static final String KEY_A = "key-a";
	private static final String VALUE = "value-a";

	@Test
	public void givenARoleWithoutPropertiesThenGetPropertyReturnsNull()
			throws Exception {
		PropertiesSource role = new Role(ROLE_NAME);
		assertNull(role.getProperty(KEY_A));
	}

	@Test
	public void givenARoleWithAPropertyThenItsGettable() throws Exception {
		PropertiesSource account = new Role(ROLE_NAME);
		account.setProperty(KEY_A, VALUE);
		assertEquals(VALUE, account.getProperty(KEY_A));
	}

	@Test
	public void matchesMethodTestsRoleName() throws Exception {
		Role role = new Role(ROLE_NAME);
		assertTrue(role.matches(ROLE_NAME));
		assertFalse(role.matches(KEY_A));
	}

	@Test
	public void toStringReturnsRoleName() throws Exception {
		assertEquals(ROLE_NAME, new Role(ROLE_NAME).toString());
	}
}
