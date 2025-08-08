package com.kimje.springboard.post.repository;

import com.kimje.springboard.post.domain.Post;
import com.kimje.springboard.post.dto.PostResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostRepository {

    PostResponseDTO findById(Long id);

    List<PostResponseDTO> findAll();

    void save(Post post);
}
