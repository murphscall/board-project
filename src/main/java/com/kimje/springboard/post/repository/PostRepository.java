package com.kimje.springboard.post.repository;

import com.kimje.springboard.post.domain.Post;
import com.kimje.springboard.post.dto.PostResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PostRepository {

    PostResponseDTO findById(Long id);

    List<PostResponseDTO> findAll();

    void save(Post post);

    List<PostResponseDTO> findAllWithPagination(Map<String, Object> params);

    int getTotalPostCount();
}
