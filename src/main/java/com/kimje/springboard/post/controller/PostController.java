package com.kimje.springboard.post.controller;

import com.kimje.springboard.post.dto.PostRequestDTO;
import com.kimje.springboard.post.dto.PostResponseDTO;
import com.kimje.springboard.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public String getAllPosts(Model model) {
        List<PostResponseDTO> postList = postService.getAllPost();
        model.addAttribute("posts" , postList);
        return "home";
    }
    @GetMapping("/{postId}")
    public String getPost(Model model , @PathVariable Long postId) {
        PostResponseDTO post = postService.getPost(postId);
        model.addAttribute("post" , post);
        return "post/detail";
    }

    @GetMapping("/new")
    public String newPostForm() {
        return "post/newPost"; // templates/posts/post-form.html 을 렌더링
    }

    @PostMapping
    public String createPost(@ModelAttribute PostRequestDTO postRequestDTO) {
        postService.createPost(postRequestDTO);
        return "redirect:/";
    }


}
