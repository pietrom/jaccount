package com.github.pietrom.jaccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RolesGroupTest {
	private Role role1, role2;
	private RolesGroup group;
	
	@Before
	public void initFixtures() {
		role1 = new Role("role-1");
		role2 = new Role("role-2");
		group = new RolesGroup("group");
		group.addRole(role1);
		group.addRole(role2);
	}
	@Test
	public void aRolesGroupLooksOutLikeARole() throws Exception {
		Role role = group;
		assertTrue(role.matches("role-1"));
		assertTrue(role.matches("role-2"));
		assertFalse(role.matches("role-3"));
	}
	
	@Test
	public void rolesGroupDelegatesGetPropertyToNestedRoles() throws Exception {
		role1.setProperty("a-key", "a-value");
		assertEquals("a-value", group.getProperty("a-key"));
	}
}
