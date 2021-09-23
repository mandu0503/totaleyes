package com.kt.totaleyes.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.kt.totaleyes.common.GenericMessage;
import com.kt.totaleyes.common.GenericMessageMutator;
import com.kt.totaleyes.common.LocaleAwareMessageService;
import com.kt.totaleyes.common.RestMessage;
import com.kt.totaleyes.common.ReturnCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalException {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);
	private static final String MESSAGE_RESULT_CODE_HEADER = "__message_result_code__";
	
	@Autowired
    private LocaleAwareMessageService messageService;
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<RestMessage> handleOtherExceptions(Exception ex, WebRequest request) {
		
		String code = GenericMessage.NG;
        if ( logger.isDebugEnabled() ) {
            logger.debug("RestControllerMessageAdvice.handleOtherExceptions(): {}", ex.getMessage());
        }
        
//        if ( ex instanceof AICentroBaseException ) {
//            code = ((AICentroBaseException)ex).getCode().getCode();
//        } else if ( ex instanceof InvalidFormatException ) {
//            code = ReturnCode.INVALID_PARAMETER_TYPE_OR_VALUE.getCode();
//        } else if ( ex instanceof FileNotFoundException ) {
//            code = ReturnCode.STORE_FILE_NOT_FOUND.getCode();
//        } else if ( ex instanceof Exception ){
//            code = ReturnCode.NG.getCode(); //Integer.toString(ex.hashCode());
//        }
       
        code = ReturnCode.NG.getCode();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestMessage message = new RestMessage();
        message.setReturn(code);

        // 공통 메시지 처리
        if(!((GenericMessageMutator) message).isCustomMessage()){
            try {
                ((GenericMessageMutator) message).transformMessage(messageService);
            } catch ( NoSuchMessageException e ) {
                logger.error(e.getMessage());
                message.setReturn(GenericMessage.NG);
                message.setMessage(ex.getMessage());
            }
        }
        if ( logger.isDebugEnabled() ) {
            message.setMessage(message.getMessage() + " [" + ex.getMessage() + "]");
        }
        headers.add(MESSAGE_RESULT_CODE_HEADER, message.getReturnCode());
		return new ResponseEntity<>(message, headers, HttpStatus.OK);
	}

}
