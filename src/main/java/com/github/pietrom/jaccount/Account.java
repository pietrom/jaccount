package com.github.pietrom.jaccount;

import java.util.HashMap;
import java.util.Map;

public class Account implements PropertiesSource {
	private final String username;
	private final Map<String, Object> properties;
	
	public Account(String username) {
		this.username = username;
		this.properties = new HashMap<String, Object>();
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
}
