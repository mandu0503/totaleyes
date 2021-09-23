package com.kt.totaleyes.service;

import com.kt.totaleyes.vo.UserVo;

public interface UserService {

	public int findByBizNo (String bizNo);
	public int findByBizNoAndApprvlY (String bizNo);
	public int createBiz (UserVo userVo);
	public int createBizUser (UserVo userVo);
	public int createUser(UserVo userVo);
	
}
