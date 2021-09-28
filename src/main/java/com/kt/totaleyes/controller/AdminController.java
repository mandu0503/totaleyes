package com.kt.totaleyes.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kt.totaleyes.common.SearchVo;
import com.kt.totaleyes.service.UserService;
import com.kt.totaleyes.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/user/apprvl/list.do")
	public String apprvlList (Authentication authentication) {
		return "admin/user/apprvl/list";
	}
	
	
	/**
	 * 사용자 승인 대기 목록
	 * @param authentication
	 * @param model
	 * @param page
	 * @param startRange
	 * @param searchType
	 * @param searchNm
	 * @return
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/user/apprvl/listItem.do")
	public String apprvlListItem (Authentication authentication, Model model
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "") String searchType
			, @RequestParam(required = false, defaultValue = "") String searchNm) {
		
		SearchVo searchVo = new SearchVo();		
		searchVo.setSearchType(searchType);
		searchVo.setSearchNm(searchNm);
		
		int tot = userService.countByApprvlN(searchVo);		
		searchVo.pageInfo(page, tot);
		
		List<UserVo> users = userService.findByApprvlN(searchVo);
		
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("users", users);
		return "admin/user/apprvl/listItem";
	}
	
	
}
