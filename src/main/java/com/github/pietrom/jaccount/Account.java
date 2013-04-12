package com.github.pietrom.jaccount;

public class Account implements PropertiesSource {
	private final String username;
	
	public Account(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
}
