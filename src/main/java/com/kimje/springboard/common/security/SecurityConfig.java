package com.kimje.springboard.common.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.kimje.springboard.common.security.oauth2.OAuth2SuccessHandler;
import com.kimje.springboard.common.security.oauth2.service.CustomOauth2UserService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private CustomOauth2UserService customOauth2UserService;
	private OAuth2SuccessHandler oAuth2SuccessHandler;
	public SecurityConfig(CustomOauth2UserService customOauth2UserService , OAuth2SuccessHandler oAuth2SuccessHandler){
		this.customOauth2UserService = customOauth2UserService;
		this.oAuth2SuccessHandler = oAuth2SuccessHandler;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{


		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/","/css/**", "/js/**", "/images/**", "/users/join", "/login").permitAll()
				.anyRequest().authenticated()
			)

			.oauth2Login(oauth2 -> oauth2
				.defaultSuccessUrl("/")
				.userInfoEndpoint(userInfo -> userInfo
					.userService(customOauth2UserService) // 💡 커스텀 서비스 등록
				)
				.successHandler(oAuth2SuccessHandler)
				.permitAll()
			)
			.logout(logout -> logout
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)       // 세션 무효화
				.deleteCookies("JSESSIONID")
			);


		return http.build();
	}

}
