package com.kimje.springboard.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {


	@GetMapping("/users")
	public String UserInfo(){
		return "user/my-page";
	}

	@GetMapping("/users/join")
	public String registerPage(){
		return "user/join";
	}

	@GetMapping("/users/edit")
	public String updatePage(){
		return "user/update";
	}

	@PostMapping("/users")
	public String registerRequest(){
		return "redirect:/login";
	}

	@PutMapping("/users")
	@ResponseBody
	public String updateRequest(){
		return "redirect:/update";
	}

	@DeleteMapping("/users")
	public String deleteRequest(){
		return "user/delete";
	}

}
