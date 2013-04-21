package com.github.pietrom.jaccount;

import java.util.Collection;
import java.util.Iterator;
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
		Iterator<Role> it = roles.iterator();
		while(value == null && it.hasNext()) {
			value = it.next().getProperty(key);
		}
		return value;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString()).append(": [");
		for (Role role : roles) {
			builder.append(role.toString()).append(",");
		}
		builder.replace(builder.lastIndexOf(","), builder.length(), "").append("]");
		return builder.toString();
	}
}
