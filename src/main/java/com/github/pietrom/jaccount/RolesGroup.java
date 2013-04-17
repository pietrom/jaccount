package com.github.pietrom.jaccount;

import java.util.Collection;
import java.util.LinkedList;

public class RolesGroup extends Role {
	private final Collection<Role> roles;
	public RolesGroup(String name) {
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
	
	@Override
	public Object getProperty(String key) {
		Object value = super.getProperty(key);
		if(value != null) {
			return value;
		}
		
		for(Role role : roles) {
			value = role.getProperty(key);
			if(value != null) {
				return value;
			}
		}
		return null;
	}
}
