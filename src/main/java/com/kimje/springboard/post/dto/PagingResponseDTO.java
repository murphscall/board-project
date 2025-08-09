package com.kimje.springboard.post.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PagingResponseDTO<T> {
    private List<T> content;
    private int pageNumber;  // 현재 페이지 번호
    private int totalPages;  // 전체 페이지 수
    private int startPages;
    private int endPages;
    private boolean isFirst; // 첫 페이지인지 여부
    private boolean isLast;  // 마지막 페이지인지 여부

    public PagingResponseDTO(List<T> content, int pageNumber, int totalPages , int startPages , int endPages) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
        this.isFirst = (pageNumber == 1);
        this.isLast = (pageNumber == totalPages);
        this.startPages = startPages;
        this.endPages = endPages;
    }
}
