package com.github.pietrom.jaccount;

import java.util.Collection;
import java.util.LinkedList;

public class RoleGroup extends Role {
	private final Collection<Role> roles;
	public RoleGroup(String name) {
		super(name);
		this.roles = new LinkedList<Role>();
	}

	public void addRole(Role role) {
		roles.add(role);
	}
	
	@Override
	public boolean matches(String roleName) {
		for (Role role : roles) {
			if(role.matches(roleName)) {
				return true;
			}
		}
		return false;
	}
}
