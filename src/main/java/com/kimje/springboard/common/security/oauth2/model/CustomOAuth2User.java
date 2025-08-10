package com.kimje.springboard.common.security.oauth2.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.kimje.springboard.user.enums.UserRole;
import com.kimje.springboard.user.model.User;

public class CustomOAuth2User implements OAuth2User {

	private User user;
	private Map<String,Object> attributes;

	public CustomOAuth2User(User user , Map<String,Object> attributes){
		this.user = user;
		this.attributes = attributes;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return this.attributes;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
	}

	@Override
	public String getName() {
		return String.valueOf(user.getId());
	}

	public Long getId() {
		return user.getId();
	}

	public String getEmail() {
		return user.getEmail();
	}

	public String getNickname() {
		return user.getNickname();
	}

	public String getPictureUrl() {
		return user.getPictureUrl();
	}

	public UserRole getRole() {
		return user.getRole();
	}
}
