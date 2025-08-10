package com.kimje.springboard.common.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseModel {
	private Long id;
	private LocalDateTime createdAt;

}
