package com.kt.totaleyes.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginSucessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	public LoginSucessHandler(String defaultTargetUrl) {
        setDefaultTargetUrl(defaultTargetUrl);
    }
		
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
		// 이전 페이지상관없이 기본 url 로 이동
		getRedirectStrategy().sendRedirect(request, response, getDefaultTargetUrl());
    }
}
