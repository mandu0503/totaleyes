package com.kt.totaleyes.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kt.totaleyes.security.mapper.AuthMapper;
import com.kt.totaleyes.security.vo.AuthVo;

@Service
public class UserService implements UserDetailsService{
	@Autowired
	private AuthMapper authMapper;
	
	@Override
	public AuthVo loadUserByUsername(String userId) throws UsernameNotFoundException {
		AuthVo user = authMapper.getUserById(userId);
        if(user==null) {
            throw new UsernameNotFoundException("회원정보가 없습니다.");
        }
        return user;
	}

}
