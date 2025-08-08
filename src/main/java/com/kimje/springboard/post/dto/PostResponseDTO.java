package com.kimje.springboard.post.dto;


import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
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

}
