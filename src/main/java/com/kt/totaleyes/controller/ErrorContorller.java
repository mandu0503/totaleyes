package com.kt.totaleyes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorContorller {
		
	@RequestMapping("/denied.do")
	public String denied (Model model) {		
		return "error/denied";
	}
	
	@RequestMapping("/error.do")
	public String sample (Model model) {		
		return "error/error";
	}
}
