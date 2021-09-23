package com.kt.totaleyes.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/inspector")
public class InspectorController {

	@PreAuthorize("hasRole('INSPECTOR')")
	@RequestMapping("/test")
	public String test (Model model) {
		log.info("++++inspector test");
		return "inspector/test";
	}
}
