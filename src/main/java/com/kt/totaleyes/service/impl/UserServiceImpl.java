package com.kt.totaleyes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public int createBiz(UserVo userVo) {
		// TODO Auto-generated method stub
		return userMapper.createBiz(userVo);
	}

	@Override
	public int createBizUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return userMapper.createBizUser(userVo);
	}

	@Override
	public int createUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return userMapper.createUser(userVo);
	}

}
