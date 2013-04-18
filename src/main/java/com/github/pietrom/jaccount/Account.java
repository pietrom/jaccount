package com.github.pietrom.jaccount;

import java.util.Collection;
import java.util.Collections;

public class Account implements PropertiesSource {
	private final String username;
	private final PropertiesSource propertiesSource;
	private final Collection<Role> roles;
	
	public Account(String username, Collection<Role> roles) {
		this.username = username;
		this.propertiesSource = new SimplePropertiesSource();
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public void setProperty(String key, Object value) {
		propertiesSource.setProperty(key, value);
	}

	@Override
	public Object getProperty(String key) {
		return propertiesSource.getProperty(key);
	}

	public Collection<Role> getRoles() {
		return Collections.unmodifiableCollection(roles);
	}

	public boolean hasRole(String roleName) {
		for (Role role : roles) {
			if(role.matches(roleName)) {
				return true;
			}
		}
		return false;
	}
}
