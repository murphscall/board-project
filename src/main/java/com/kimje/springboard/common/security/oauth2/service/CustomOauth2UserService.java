package com.kimje.springboard.common.security.oauth2.service;


import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.kimje.springboard.common.security.oauth2.model.CustomOAuth2User;
import com.kimje.springboard.user.enums.UserRole;
import com.kimje.springboard.user.model.User;
import com.kimje.springboard.user.repository.UserRepository;
import com.kimje.springboard.common.security.oauth2.response.GoogleResponse;
import com.kimje.springboard.common.security.oauth2.response.KakaoResponse;
import com.kimje.springboard.common.security.oauth2.response.OAuth2Response;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomOauth2UserService extends DefaultOAuth2UserService {

	private final UserRepository userRepository;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

		OAuth2User oauth2User = super.loadUser(userRequest);
		// 인증 제공자 확인
		String provider = userRequest.getClientRegistration().getRegistrationId();
		// 해당 제공자에 맞는 클래스로 매핑
		OAuth2Response oAuth2Response = switch (provider) {
			case "kakao" -> new KakaoResponse(oauth2User.getAttributes());
			case "google" -> new GoogleResponse(oauth2User.getAttributes());
			default -> throw new IllegalArgumentException("지원하지 않는 소셜 로그인");
		};

		String providerId = oAuth2Response.getProviderId();

		User user = userRepository.findByProviderAndProviderId(provider , providerId);

		if(user == null) {
				user = new User ();
				user.setEmail(oAuth2Response.getEmail());
				user.setNickname(oAuth2Response.getName());
				user.setProvider(provider);
				user.setProviderId(providerId);
				user.setPictureUrl("");
				user.setRole(UserRole.USER);

				userRepository.save(user);
		}

		return new CustomOAuth2User(user , oauth2User.getAttributes());
	}
}
