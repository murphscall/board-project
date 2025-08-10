package com.kimje.springboard.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends UserBaseModel {
	private  String provider;
	private  String providerId;

}
