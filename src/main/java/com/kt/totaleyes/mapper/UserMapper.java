package com.kt.totaleyes.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kt.totaleyes.vo.UserVo;

@Mapper
public interface UserMapper {

	public int findByBizNo (String bizNo);
	public int findByBizNoAndApprvlY (String bizNo);
	public int createBiz (UserVo userVo);
	public int createBizUser (UserVo userVo);
	public int createUser(UserVo userVo);
	
}
