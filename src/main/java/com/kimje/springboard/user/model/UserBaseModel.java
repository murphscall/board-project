package com.kimje.springboard.user.model;

import com.kimje.springboard.user.enums.UserRole;
import com.kimje.springboard.common.model.BaseModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class UserBaseModel  extends BaseModel {
	private String email;
	private String pictureUrl;
	private String nickname;
	private UserRole role;

}
