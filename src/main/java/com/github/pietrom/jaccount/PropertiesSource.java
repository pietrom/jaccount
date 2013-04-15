package com.github.pietrom.jaccount;

public interface PropertiesSource {
	public abstract void setProperty(String key, Object value);

	public abstract Object getProperty(String keyA);
}
