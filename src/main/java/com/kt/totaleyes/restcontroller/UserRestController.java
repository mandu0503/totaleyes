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
			@RequestParam(name = "bizNm", defaultValue = "") String bizNm) {
		
		int count = userService.countByBizNo(bizNo);
		
		message.setReturn(ReturnCode.OK);
		message.setData(count);
		
		return message;
	}
	
	/**
	 * 사업자 일련번호 조회
	 * @param message
	 * @param bizNo
	 * @param mstrYn
	 * @return
	 */
	@RequestMapping("/findBizSeq.do")
	public GenericMessage findBizSeq (GenericMessage message, @RequestParam(name = "bizNo", defaultValue = "") String bizNo,
			@RequestParam(name = "bizNm", defaultValue = "") String bizNm) {
		
		Integer bizSeq = userService.findBizSeqByBizNoAndApprvlY(bizNo, bizNm);
		
		message.setReturn(ReturnCode.OK);
		
		if (bizSeq == null) {
			message.setData(-1);
		} else {
			message.setData(bizSeq);
		}
		
		return message;
	}
	
	/**
	 * 사용자 등록
	 * @param message
	 * @param userVo
	 * @return
	 */
	@RequestMapping("/register.do")
	public GenericMessage register (GenericMessage message, UserVo userVo) {
		
		log.debug("** userVo:{}", userVo);
		
		boolean result = userService.createUser(userVo);
		
		message.setReturn(ReturnCode.OK);
		message.setData(result);
		return message;
	}
	
}
