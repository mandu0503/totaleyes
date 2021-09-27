package com.kt.totaleyes.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/agree.do")
	public String agree (Model model) {
		return "user/agree";
	}
	
	@RequestMapping("/register.do")
	public String register (Model model) {
		return "user/register";
	}
	
}
