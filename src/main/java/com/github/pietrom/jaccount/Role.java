package com.github.pietrom.jaccount;

import java.util.HashMap;
import java.util.Map;

public class Role implements PropertiesSource {
	private final Map<String, Object> properties;
	
	public Role(String name) {
		properties = new HashMap<String, Object>();
	}

	@Override
	public void setProperty(String key, Object value) {
		properties.put(key, value);
	}

	@Override
	public Object getProperty(String key) {
		return properties.get(key);
	}
}
