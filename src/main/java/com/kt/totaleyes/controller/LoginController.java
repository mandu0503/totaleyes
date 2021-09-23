package com.kt.totaleyes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/main.do")
	public String home(){
		return "main";
	}
	
	@RequestMapping("/login.do")
	public String login(){
		return "login";
	}
}
