package com.kimje.springboard.board.repository;

import com.kimje.springboard.board.model.Post;
import com.kimje.springboard.board.dto.PostResponseDTO;
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
