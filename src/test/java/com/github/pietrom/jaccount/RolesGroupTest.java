package com.github.pietrom.jaccount;

import static org.junit.Assert.*;

import org.junit.Test;

public class RolesGroupTest {
	@Test
	public void aRolesGroupLooksOutLikeARole() throws Exception {
		Role role1 = new Role("role-1");
		Role role2 = new Role("role-2");
		Role group = new RolesGroup("group");
		((RolesGroup)group).addRole(role1);
		((RolesGroup)group).addRole(role2);
		assertTrue(group.matches("role-1"));
		assertTrue(group.matches("role-2"));
		assertFalse(group.matches("role-3"));
	}
	
	@Test
	public void rolesGroupDelegatesGetPropertyToNestedRoles() throws Exception {
		Role role1 = new Role("role-1");
		role1.setProperty("a-key", "a-value");
		Role role2 = new Role("role-2");
		RolesGroup group = new RolesGroup("group");
		group.addRole(role1);
		group.addRole(role2);
		assertEquals("a-value", group.getProperty("a-key"));
	}
}
