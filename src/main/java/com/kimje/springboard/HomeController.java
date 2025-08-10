package com.kimje.springboard;

import com.kimje.springboard.board.dto.PagingResponseDTO;
import com.kimje.springboard.board.dto.PostResponseDTO;
import com.kimje.springboard.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PostService postService;

    @GetMapping("/")
    public String HomePage(Model model , @RequestParam(value = "page" , defaultValue = "1") int page ) {
        PagingResponseDTO<PostResponseDTO> postList = postService.getPostyByPage(page);
        model.addAttribute("pagingResponse" , postList);
        return "home";
    }


}
