package com.kt.totaleyes.security.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.kt.totaleyes.security.service.UserService;
import com.kt.totaleyes.security.vo.UserVo;

@Component("authProvider")
public class AuthProvider implements AuthenticationProvider{
	
	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userId = authentication.getName();
		String pw = authentication.getCredentials().toString();
		UserVo user = userService.loadUserByUsername(userId);
		
		if (!pw.equals(user.getPassword())) {
            throw new BadCredentialsException("비밀 번호가 틀립니다.");
        }
        
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new UsernamePasswordAuthenticationToken(user, null, grantedAuthorityList);
	}

	@Override
	 public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
