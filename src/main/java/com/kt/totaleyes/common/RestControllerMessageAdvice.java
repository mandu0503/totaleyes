package com.kt.totaleyes.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class RestControllerMessageAdvice implements ResponseBodyAdvice<Object> {
	
	private static final Logger logger = LoggerFactory.getLogger(RestControllerMessageAdvice.class);
	private static final String GENERIC_MESSAGE = "_GENERIC_MESSAGE";
    private static final String MESSAGE_RESULT_CODE_HEADER = "__message_result_code__";
    
    @Autowired
    private LocaleAwareMessageService messageService;
    
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> messageConverter,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
    	 GenericMessage message = null;
         if(body instanceof Resource || body instanceof byte[]) {
             return body;
         } else if(body instanceof GenericMessage) {
             message = (GenericMessage) body;
         }else{
             message = (GenericMessage) RequestContextHolder.getRequestAttributes().getAttribute(GENERIC_MESSAGE, RequestAttributes.SCOPE_REQUEST);
             if(message == null) {
                 message = new RestMessage();
             }
             if(body!=null){
                 message.setData(body);
             }
         }

         // 공통 메시지 처리
         if(!((GenericMessageMutator) message).isCustomMessage()){
             ((GenericMessageMutator) message).transformMessage(messageService);
         }

         // 리턴 데이터
         logger.debug("RestControllerMessageAdvice.beforeBodyWrite(): {}", ((RestMessage) message).toString());
         response.getHeaders().add(MESSAGE_RESULT_CODE_HEADER, ((GenericMessageMutator)message).getReturnCode());

         return message;
    }
}
