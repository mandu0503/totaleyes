package com.kt.totaleyes.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kt.totaleyes.security.mapper.UserMapper;
import com.kt.totaleyes.security.vo.UserVo;

@Service
public class UserService implements UserDetailsService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserVo loadUserByUsername(String userId) throws UsernameNotFoundException {
		UserVo user = userMapper.getUserById(userId);
        if(user==null) {
            throw new UsernameNotFoundException("회원정보가 없습니다.");
        }
        return user;
	}

}
