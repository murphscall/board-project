package com.kimje.springboard.post.dto;

import com.kimje.springboard.post.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class PostResponseDTO {
    private Long id;
    private String title;
    private String content;
    private Long userId;
    private String nickname;
    private Long viewCount;
    private LocalDateTime createdAt;

    public PostResponseDTO(Long id , String title, String content , Long userId , String nickname , Long viewCount , LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.nickname = nickname;
        this.viewCount = viewCount;
        this.createdAt = createdAt;
    }
}
