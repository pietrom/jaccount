package com.github.pietrom.jaccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class RoleTest {
	private static final String KEY_A = "key-a";
	private static final String VALUE = "value-a";

	@Test
	public void givenARoleWithoutPropertiesThenGetPropertyReturnsNull() throws Exception {
		PropertiesSource role = new Role("role-name");
		assertNull(role.getProperty(KEY_A));
	}
	
	@Test
	public void givenARoleWithAPropertyThenItsGettable() throws Exception {
		PropertiesSource account = new Role("role-name");
		account.setProperty(KEY_A, VALUE);
		assertEquals(VALUE, account.getProperty(KEY_A));
	}
}
