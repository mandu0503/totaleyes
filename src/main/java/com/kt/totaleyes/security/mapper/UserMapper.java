package com.kt.totaleyes.security.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kt.totaleyes.security.vo.UserVo;

@Mapper
public interface UserMapper {
	
	public UserVo getUserById(String userId);
}
