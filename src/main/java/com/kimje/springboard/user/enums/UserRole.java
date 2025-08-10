package com.kimje.springboard.user.enums;

public enum UserRole {
	USER("ROLE_USER"), // 일반 사용자
	ADMIN("ROLE_ADMIN"); // 관리자

	private final String value;

	UserRole(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
