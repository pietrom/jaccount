package com.github.pietrom.jaccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RolesGroupTest {
	private static final String ROLE_1_NAME = "role-1";
	private static final String ROLE_2_NAME = "role-2";
	private static final String GROUP_NAME = "group";
	private static final String A_KEY = "a-key";
	private static final String A_VALUE = "a-value";
	private static final String B_KEY = "b-key";
	private static final String B_VALUE = "b-value";
	private Role role1, role2;
	private RolesGroup group;
	
	@Before
	public void initFixtures() {
		role1 = new Role(ROLE_1_NAME);
		role2 = new Role(ROLE_2_NAME);
		group = new RolesGroup(GROUP_NAME);
		group.addRole(role1);
		group.addRole(role2);
	}
	@Test
	public void aRolesGroupLooksOutLikeARole() throws Exception {
		Role role = group;
		assertTrue(role.matches(ROLE_1_NAME));
		assertTrue(role.matches(ROLE_2_NAME));
		assertFalse(role.matches("role-3"));
	}
	
	@Test
	public void rolesGroupDelegatesGetPropertyToNestedRoles() throws Exception {
		role1.setProperty(A_KEY, A_VALUE);
		assertEquals(A_VALUE, group.getProperty(A_KEY));
	}
	
	@Test
	public void rolesGroupHasItsOwnProperties() throws Exception {
		role1.setProperty(A_KEY, A_VALUE);
		group.setProperty(B_KEY, B_VALUE);
		assertEquals(B_VALUE, group.getProperty(B_KEY));
	}
	
	@Test
	public void rolesGroupOverridesPropertyDefinition() throws Exception {
		role1.setProperty(A_KEY, A_VALUE);
		group.setProperty(A_KEY, B_VALUE);
		assertEquals(B_VALUE, group.getProperty(A_KEY));
	}
	
	@Test
	public void givenNestedRolesWhichDefineTheSamePropertyWhenGroupIsQueriedThenValueFromFirstAddedRoleIsReturned() throws Exception {
		role1.setProperty(A_KEY, A_VALUE);
		role2.setProperty(A_KEY, B_VALUE);
		assertEquals(A_VALUE, group.getProperty(A_KEY));
	}
	
	@Test
	public void toStringContainsNestedRolesNames() throws Exception {
		assertTrue(group.toString().contains(ROLE_1_NAME));
		assertTrue(group.toString().contains(ROLE_2_NAME));
	}
	
	@Test
	public void toStringContainsGroup() throws Exception {
		assertTrue(group.toString().contains(GROUP_NAME));
	}
}
