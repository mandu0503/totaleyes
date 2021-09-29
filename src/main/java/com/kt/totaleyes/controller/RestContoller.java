package com.kt.totaleyes.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kt.totaleyes.common.message.GenericMessage;
import com.kt.totaleyes.common.message.ReturnCode;

@RestController
public class RestContoller {
	
	@Value("${spring.servlet.multipart.location}")
	private String filePath;
	
	@RequestMapping("/rest/sample.do")
	public @ResponseBody GenericMessage restSample(GenericMessage message
			,@RequestParam(name = "type", defaultValue = "") String type) throws Exception {
				
		message.setReturn(ReturnCode.OK);
	    message.setData("TEST");
	    //throw new Exception();
	    return message;
	}
	
	@RequestMapping("/rest/sample1.do")
	public @ResponseBody String restSample(
			@RequestParam(name = "type", defaultValue = "") String type) {
				
	    return "test";
	}
	
	@RequestMapping("/rest/fileupload.do")
	public @ResponseBody GenericMessage uploadFileMulti(
			GenericMessage message,
            @RequestParam("extraField") String extraField,
            @RequestParam("customField") String customField,
            @RequestParam("uploadfiles") MultipartFile[] uploadfiles) {

        try {
        	for (MultipartFile file : uploadfiles) {
                if (file.isEmpty()) {
                    continue;
                }
                byte[] bytes = file.getBytes();
                Path path = Paths.get(filePath + file.getOriginalFilename());
                Files.write(path, bytes);
            }
        } catch (IOException e) {
        	message.setReturn(ReturnCode.NG);
        	return message;
        }
        message.setReturn(ReturnCode.OK);
	    return message;

		
	}
}
