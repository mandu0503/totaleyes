package com.kt.totaleyes.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kt.totaleyes.common.Const;
import com.kt.totaleyes.mapper.UserMapper;
import com.kt.totaleyes.service.UserService;
import com.kt.totaleyes.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int findByBizNo(String bizNo) {
		// TODO Auto-generated method stub
		return userMapper.findByBizNo(bizNo);
	}

	@Override
	public int findByBizNoAndApprvlY(String bizNo) {
		// TODO Auto-generated method stub
		return userMapper.findByBizNoAndApprvlY(bizNo);
	}


	@Override
	@Transactional
	public boolean createUser(UserVo userVo) {
		// TODO Auto-generated method stub
		
		if (StringUtils.equals(Const.YES, userVo.getMstrYn()) && StringUtils.isNotEmpty(userVo.getBizNo()) 
				&& userMapper.findByBizNo(userVo.getBizNo()) == 0) {
			userMapper.createBiz(userVo);
			userMapper.createBizUser(userVo);
		} else if (StringUtils.equals(Const.NO, userVo.getMstrYn()) && userVo.getBizSeq() != null && userVo.getBizSeq() > 0
				&& userMapper.findByBizNoAndApprvlY(userVo.getBizNm()) == 0) {
			userMapper.createBizUser(userVo);
		} else if (StringUtils.isEmpty(userVo.getMstrYn())) {
			userMapper.createUser(userVo);
		} else {
			return false;
		}

		return true;
	}

}
