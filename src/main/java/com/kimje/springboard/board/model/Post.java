package com.kimje.springboard.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import com.kimje.springboard.common.model.BaseModel;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseModel {
    private String title;
    private String content;
    private Long viewCount;
    private Long userId ;
}
