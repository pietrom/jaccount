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
		boolean matched = false;
		Iterator<Role> it = roles.iterator();
		while(!matched && it.hasNext()) {
			matched = it.next().matches(roleName);
		}
		return matched;
	}

	@Override
	public Object getProperty(String key) {
		Object value = super.getProperty(key);
		if (value == null) {
			Iterator<Role> it = roles.iterator();
			while (value == null && it.hasNext()) {
				value = it.next().getProperty(key);
			}
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
