package com.kt.totaleyes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kt.totaleyes.message.GenericMessage;
import com.kt.totaleyes.message.ReturnCode;

@RestController
public class RestContoller {
	
	@RequestMapping("/rest/sample.do")
	public @ResponseBody GenericMessage restSample(GenericMessage message
			,@RequestParam(name = "type", defaultValue = "") String type) throws Exception {
				
		message.setReturn(ReturnCode.OK);
	    message.setData("TEST");
	    throw new Exception();
	    //return message;
	}
	
	@RequestMapping("/rest/sample1.do")
	public @ResponseBody String restSample(
			@RequestParam(name = "type", defaultValue = "") String type) {
				
	    return "test";
	}
}
