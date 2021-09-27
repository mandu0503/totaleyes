package com.kt.totaleyes.restcontroller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kt.totaleyes.common.Const;
import com.kt.totaleyes.common.message.GenericMessage;
import com.kt.totaleyes.common.message.ReturnCode;
import com.kt.totaleyes.service.UserService;
import com.kt.totaleyes.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	/**
	 * 사용자 등록
	 * @param message
	 * @param userVo
	 * @return
	 */
	@RequestMapping("/register.do")
	public GenericMessage register (GenericMessage message, UserVo userVo) {
		
		log.debug("** userVo:{}", userVo);
		
		userService.createUser(userVo);
		
		message.setReturn(ReturnCode.OK);
		return message;
	}
	
	/**
	 * 사용자 id 중복 체크
	 * @param message
	 * @param userId
	 * @return
	 */
	@RequestMapping("/checkId.do")
	public GenericMessage checkId (GenericMessage message, @RequestParam(name = "userId", defaultValue = "") String userId) {
		
		log.debug("** userId:{}", userId);
		
		int count = userService.countById(userId);
		
		message.setReturn(ReturnCode.OK);
		message.setData(count);
		return message;
	}
	
	/**
	 * 사업자 번호 중복 체크
	 * @param message
	 * @param bizNo
	 * @param mstrYn
	 * @return
	 */
	@RequestMapping("/checkBizNo.do")
	public GenericMessage checkBizNo (GenericMessage message, @RequestParam(name = "bizNo", defaultValue = "") String bizNo,
			@RequestParam(name = "mstrYn", defaultValue = "") String mstrYn) {
		
		int count = -1;
		
		if (StringUtils.equals(Const.YES, mstrYn)) {
			count = userService.countByBizNo(bizNo);
		} else if (StringUtils.equals(Const.NO, mstrYn)) {
			count = userService.countByBizNoAndApprvlY(bizNo);
		}
		
		message.setReturn(ReturnCode.OK);
		message.setData(count);
		
		return message;
	}
	
}
