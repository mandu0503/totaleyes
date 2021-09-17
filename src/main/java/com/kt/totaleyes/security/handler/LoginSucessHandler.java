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
	 	/* 
        response.setStatus(HttpServletResponse.SC_OK);
        // 성공 시 response를 json형태로 반환
        response.getWriter().print("{\"success\": true}");
        response.getWriter().flush();
        */

	 	/*
		setDefaultTargetUrl("/");
        SavedRequest savedRequest = requestCache.getRequest(request,response);
        if(savedRequest != null){
            // 인증 받기 전 url로 이동하기
            String targetUrl = savedRequest.getRedirectUrl();
            redirectStrategy.sendRedirect(request,response,targetUrl);
        }else{
            // 기본 url로 가도록 함함
           redirectStrategy.sendRedirect(request,response,getDefaultTargetUrl());
        }
	 	*/
		super.onAuthenticationSuccess(request, response, authentication);
    }
}
