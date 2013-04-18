package com.github.pietrom.jaccount;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

public class AccountTest {
	private static final String USERNAME = "pietrom";
	private static final String KEY_A = "a-key";
	private static final String VALUE = "a-value";
	private static final String ROLE_A_NAME = "role-a";
	private static final String ROLE_B_NAME = "role-b";
	private static final Role ROLE_A = new Role(ROLE_A_NAME);
	private static final Role ROLE_B = new Role(ROLE_B_NAME);

	@Test
	public void usernameIsAccessible() throws Exception {
		Account account = new Account(USERNAME, null);
		assertEquals(USERNAME, account.getUsername());
	}
	
	@Test
	public void givenAnAccountWithoutPropertiesThenGetPropertyReturnsNull() throws Exception {
		PropertiesSource account = new Account(USERNAME, null);
		assertNull(account.getProperty(KEY_A));
	}
	
	@Test
	public void givenAnAccountWithAPropertyThenItsGettable() throws Exception {
		PropertiesSource account = new Account(USERNAME, null);
		account.setProperty(KEY_A, VALUE);
		assertEquals(VALUE, account.getProperty(KEY_A));
	}
	
	@Test
	public void accountHasRolesAssociated() throws Exception {
		Collection<Role> roles = new HashSet<Role>();
		roles.add(ROLE_A);
		roles.add(ROLE_B);
		Account account = new Account(USERNAME, roles);
		assertTrue(account.getRoles().contains(ROLE_A));
	}
	
	@Test
	public void hasRole() throws Exception {
		Collection<Role> roles = new HashSet<Role>();
		roles.add(ROLE_A);
		roles.add(ROLE_B);
		Account account = new Account(USERNAME, roles);
		assertTrue(account.hasRole(ROLE_A_NAME));
	}
	
	@Test
	public void hasRoleGivenRoleGroup() throws Exception {
		Collection<Role> roles = new HashSet<Role>();
		RolesGroup group = new RolesGroup("a-group");
		group.addRole(ROLE_A);
		group.addRole(new Role("role-c"));
		roles.add(group);
		roles.add(ROLE_B);
		Account account = new Account(USERNAME, roles);
		assertTrue(account.hasRole(ROLE_A_NAME));
		assertTrue(account.hasRole(ROLE_B_NAME));
	}
}
