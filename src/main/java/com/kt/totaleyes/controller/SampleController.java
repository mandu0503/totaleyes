package com.kt.totaleyes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kt.totaleyes.common.SearchVo;
import com.kt.totaleyes.service.SampleService;
import com.kt.totaleyes.vo.SampleVo;

@Controller
public class SampleController {
	
	@Autowired
	private SampleService sampleService;
	
	@RequestMapping("/sample")
	public String sample (Model model
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int startRange) {
		/*
		int tot = sampleService.getBoardInfoCount();
		Pagenation pagenation = new Pagenation();
		pagenation.pageInfo(page, startRange, tot);
		List<SampleVo> sampleVoList = sampleService.getBoardInfoList(pagenation);
		model.addAttribute("pagenation", pagenation);
		model.addAttribute("sampleVoList", sampleVoList);
		*/
		return "sample/sample";
	}
	
	@RequestMapping("/getSampleList")
	public String getSampleList (Model model
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int startRange
			, @RequestParam(required = false, defaultValue = "") String searchType
			, @RequestParam(required = false, defaultValue = "") String searchNm) {
		
		SearchVo searchVo = new SearchVo();		
		searchVo.setSearchType(searchType);
		searchVo.setSearchNm(searchNm);
		
		int tot = sampleService.getBoardInfoCount(searchVo);		
		searchVo.pageInfo(page, startRange, tot);
		
		List<SampleVo> sampleVoList = sampleService.getBoardInfoList(searchVo);
		
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("sampleVoList", sampleVoList);
		return "sample/getSampleList";
	}
}
