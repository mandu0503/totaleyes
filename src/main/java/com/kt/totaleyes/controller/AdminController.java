package com.kt.totaleyes.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kt.totaleyes.security.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/test")
	public String test (Authentication authentication, Model model) {
		log.info("++++admin");
		log.debug("++ authentication : {}", authentication);
		UserVo userVo = (UserVo)authentication.getPrincipal();
		
		log.debug("++ userVo: {}", userVo.toString());
		return "admin/test";
	}
	
}
