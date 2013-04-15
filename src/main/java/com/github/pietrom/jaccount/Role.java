package com.github.pietrom.jaccount;

public class Role implements PropertiesSource {
	private final PropertiesSource propertiesSource;

	public Role(String name) {
		propertiesSource = new SimplePropertiesSource();
	}

	@Override
	public void setProperty(String key, Object value) {
		propertiesSource.setProperty(key, value);
	}

	@Override
	public Object getProperty(String keyA) {
		return propertiesSource.getProperty(keyA);
	}
}
