package com.kimje.springboard.post.service;

import com.kimje.springboard.post.domain.Post;
import com.kimje.springboard.post.dto.PagingResponseDTO;
import com.kimje.springboard.post.dto.PostRequestDTO;
import com.kimje.springboard.post.dto.PostResponseDTO;
import com.kimje.springboard.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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

        return new PagingResponseDTO<>(postList, pageNumber, totalPages);
    }

    public PostResponseDTO getPost(Long postId) {
        return postRepository.findById(postId);
    }

    public void createPost(PostRequestDTO postRequestDTO) {
        Post post = new Post();
        post.setUserId(postRequestDTO.getUserId());
        post.setTitle(postRequestDTO.getTitle());
        post.setContent(post.getContent());

        postRepository.save(post);
    }
}
