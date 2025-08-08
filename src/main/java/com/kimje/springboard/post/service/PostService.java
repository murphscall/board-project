package com.kimje.springboard.post.service;

import com.kimje.springboard.post.domain.Post;
import com.kimje.springboard.post.dto.PostRequestDTO;
import com.kimje.springboard.post.dto.PostResponseDTO;
import com.kimje.springboard.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<PostResponseDTO> getAllPost(){
        return postRepository.findAll();
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
