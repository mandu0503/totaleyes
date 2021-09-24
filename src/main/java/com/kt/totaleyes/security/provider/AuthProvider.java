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

import com.kt.totaleyes.security.service.AuthService;
import com.kt.totaleyes.security.vo.AuthVo;

@Component("authProvider")
public class AuthProvider implements AuthenticationProvider{
	
	@Autowired
	private AuthService authService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userId = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		AuthVo user = authService.loadUserByUsername(userId);
		user.setPwd(pwd);
		if(authService.getCheckByPwd(user) == 0) {
			throw new BadCredentialsException("비밀 번호가 틀립니다.");
		}
		
		/* 차후 관리자 3개의 권한을 부여시 수정필요
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        */
        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
	}

	@Override
	 public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
