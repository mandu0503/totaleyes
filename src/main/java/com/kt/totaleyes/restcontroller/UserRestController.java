package com.kt.totaleyes.restcontroller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kt.totaleyes.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserRestController {

	
	@RequestMapping("/register.do")
	public String register (Model model, UserVo userVo) {
		
		log.debug("++ userVo", userVo);
		return "user/register";
	}
	
	
	
}
