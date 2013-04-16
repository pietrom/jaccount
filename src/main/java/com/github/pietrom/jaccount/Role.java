package com.github.pietrom.jaccount;

public class Role implements PropertiesSource {
	private final String name;
	private final PropertiesSource propertiesSource;

	public Role(String name) {
		this.name = name;
		this.propertiesSource = new SimplePropertiesSource();
	}

	@Override
	public void setProperty(String key, Object value) {
		propertiesSource.setProperty(key, value);
	}

	@Override
	public Object getProperty(String keyA) {
		return propertiesSource.getProperty(keyA);
	}

	public boolean matches(String roleName) {
		return name.equals(roleName);
	}
}
