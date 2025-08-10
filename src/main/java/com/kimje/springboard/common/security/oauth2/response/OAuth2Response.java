package com.kimje.springboard.common.security.oauth2.response;

public interface OAuth2Response {
	String getProvider();
	String getProviderId();
	String getEmail();
	String getName();
}
