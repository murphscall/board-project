package com.kimje.springboard.board.dto;

import lombok.Getter;

@Getter
public class PostRequestDTO {
    private String title;
    private String content;
    private Long userId;
}
