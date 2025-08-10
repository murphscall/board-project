package com.kimje.springboard.board.service;

import com.kimje.springboard.board.model.Post;
import com.kimje.springboard.board.dto.PagingResponseDTO;
import com.kimje.springboard.board.dto.PostRequestDTO;
import com.kimje.springboard.board.dto.PostResponseDTO;
import com.kimje.springboard.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<PostResponseDTO> getAllPost(){
        return postRepository.findAll();
    }

    public PagingResponseDTO<PostResponseDTO> getPostyByPage(int pageNumber){
        // 모든 게시물 갯수 조회
        int totalPostCount = postRepository.getTotalPostCount();

        // 한 페이지 당 보여줄 게시물 수
        int pageSize = 10;
        // 총 페이지 갯수는 totalPostCount / pageSize 한 값의 올림
        int totalPages = (int) Math.ceil((double) totalPostCount / pageSize);
        // offset 만큼 건너 뛰고 그 다음 게시물 10개
        int offset = (pageNumber - 1) * pageSize;

        Map<String , Object> params = new HashMap<>();
        params.put("limit" , pageSize);
        params.put("offset" , offset);
        List<PostResponseDTO> postList = postRepository.findAllWithPagination(params);

        int pageBlockSize = 5; // 한 번에 보여줄 페이지 번호 개수
        // 페이지 번호를 0부터 시작 하는 인덱스 로 맞추는 로직
        // 0~4 는 1~5 페이지 1 그룹 , 5~9 는 6~10 페이지 2 그룹
        // 예시로 현재 페이지가 7 이라면 7-1 = 6
        // 6 / pageBlockSize = 1.2 -> index = 1
        // (1 * pageBlockSize) + 1 = 6
        int startPage = (int) Math.floor((double)(pageNumber - 1) / pageBlockSize) * pageBlockSize + 1;
        int endPage = Math.min(startPage + pageBlockSize - 1, totalPages);

        return new PagingResponseDTO<>(postList, pageNumber, totalPages , startPage, endPage);
    }

    public PostResponseDTO getPost(Long postId) {
        return postRepository.findById(postId);
    }

    public void createPost(PostRequestDTO postRequestDTO) {
        Post post = new Post();
        post.setUserId(postRequestDTO.getUserId());
        post.setTitle(postRequestDTO.getTitle());
        post.setContent(postRequestDTO.getContent());

        postRepository.save(post);
    }
}
