package com.kt.totaleyes.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kt.totaleyes.common.message.GenericMessage;
import com.kt.totaleyes.common.message.ReturnCode;
import com.kt.totaleyes.security.vo.AuthVo;
import com.kt.totaleyes.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

	@Autowired
	private UserService userService;
	
	/**
	 * 관리자 사용자 승인(대표, 일반)
	 * @param message
	 * @param userId
	 * @return
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/user/apprvl.do")
	public GenericMessage apprvl (GenericMessage message, Authentication authentication, @RequestParam(name = "userId", defaultValue = "") String userId) {
		
		log.debug("** userId:{}", userId);
		
		AuthVo authVo = (AuthVo) authentication.getPrincipal();
		int count = userService.updateApprovalById(userId, authVo.getUserId());
		
		message.setReturn(ReturnCode.OK);
		message.setData(count);
		return message;
	}
	
	
	
}
