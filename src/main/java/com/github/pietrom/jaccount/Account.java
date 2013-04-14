package com.github.pietrom.jaccount;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Account implements PropertiesSource {
	private final String username;
	private final Map<String, Object> properties;
	private final Collection<Role> roles;
	
	public Account(String username, Collection<Role> roles) {
		this.username = username;
		this.properties = new HashMap<String, Object>();
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public void addProperty(String key, Object value) {
		properties.put(key, value);
	}

	@Override
	public Object getProperty(String key) {
		return properties.get(key);
	}

	public Collection<Role> getRoles() {
		return Collections.unmodifiableCollection(roles);
	}
}
