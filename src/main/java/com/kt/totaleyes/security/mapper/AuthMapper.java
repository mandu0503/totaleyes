package com.kt.totaleyes.security.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kt.totaleyes.security.vo.AuthVo;

@Mapper
public interface AuthMapper {
	
	public AuthVo getUserById(String userId);
}
