package com.kimje.springboard;

import com.kimje.springboard.post.domain.Post;
import com.kimje.springboard.post.dto.PostResponseDTO;
import com.kimje.springboard.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PostService postService;

    @GetMapping("/")
    public String HomePage(Model model) {
        List<PostResponseDTO> postList = postService.getAllPost();
        model.addAttribute("posts" , postList);
        return "home";
    }
}
