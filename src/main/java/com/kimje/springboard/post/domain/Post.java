package com.kimje.springboard.post.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Long id ;
    private String title;
    private String content;
    private Long viewCount;
    private Long userId ;
    private LocalDateTime createdAt ;

}
