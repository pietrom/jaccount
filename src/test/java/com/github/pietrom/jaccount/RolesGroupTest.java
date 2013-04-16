package com.github.pietrom.jaccount;

import static org.junit.Assert.*;

import org.junit.Test;

public class RolesGroupTest {
	@Test
	public void aRolesGroupLooksOutLikeARole() throws Exception {
		Role role1 = new Role("role-1");
		Role role2 = new Role("role-2");
		Role group = new RoleGroup("group");
		((RoleGroup)group).addRole(role1);
		((RoleGroup)group).addRole(role2);
		assertTrue(group.matches("role-1"));
		assertTrue(group.matches("role-2"));
		assertFalse(group.matches("role-3"));
	}
}
