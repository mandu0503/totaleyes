package com.kt.totaleyes.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kt.totaleyes.common.message.GenericMessage;
import com.kt.totaleyes.common.message.ReturnCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	public static final String DEFAULT_ERROR_VIEW = "error";
	
	@Autowired
	private MessageSourceAccessor messageSourceAccessor;
	
	@ExceptionHandler(value = Exception.class) 
	public String defaultErrorHandler(HttpServletRequest req, Exception ex, Model model) throws Exception {
		log.error(ex.getMessage());
		
		if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null) 
			throw ex;
		
		if("XMLHttpRequest".equals(req.getHeader("X-Requested-With"))) {
			String code = GenericMessage.NG;
			
			if ( ex instanceof Exception ){
	            code = ReturnCode.NG.getCode();
	        }
			ReturnCode.NG.getCode();
			model.addAttribute("returnCode", code);
			model.addAttribute("message", messageSourceAccessor.getMessage(code));
			return "jsonView";
		} else {
			return DEFAULT_ERROR_VIEW;
		}		
	}
}
