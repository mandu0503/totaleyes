package com.kt.totaleyes.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.kt.totaleyes.common.message.ReturnCode;

@Component
public class LoginAccessDeniedHandler implements AccessDeniedHandler {
	
	@Autowired
	private MessageSourceAccessor messageSourceAccessor;
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
			response.setStatus(HttpServletResponse.SC_OK);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			String result = "{\"message\": \""+ messageSourceAccessor.getMessage(ReturnCode.DENIED.getCode()) +"\", \"returnCode\": \"" + ReturnCode.DENIED.getCode() + "\"}";
			
			response.getWriter().print(result);
			response.getWriter().flush();
		}else {
			request.getRequestDispatcher("/denied.do").forward(request, response);
		}
	}

}
