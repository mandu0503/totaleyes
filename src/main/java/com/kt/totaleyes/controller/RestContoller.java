package com.kt.totaleyes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kt.totaleyes.common.GenericMessage;
import com.kt.totaleyes.common.ReturnCode;

@RestController
public class RestContoller {
	
	@RequestMapping("/rest/sample.do")
	public @ResponseBody GenericMessage restSample(GenericMessage message
			,@RequestParam(name = "type", defaultValue = "") String type) {
				
		message.setReturn(ReturnCode.OK);
	    message.setData("TEST");

	    return message;
	}
	
	@RequestMapping("/rest/sample1.do")
	public @ResponseBody String restSample(
			@RequestParam(name = "type", defaultValue = "") String type) {
				
	    return "test";
	}
}
