package com.kt.totaleyes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kt.totaleyes.common.SearchVo;
import com.kt.totaleyes.mapper.SampleMapper;
import com.kt.totaleyes.service.SampleService;
import com.kt.totaleyes.vo.SampleVo;

@Service
public class SampleServiceImpl implements SampleService {
	
	@Autowired
	private SampleMapper sampleMapper;
	
	
	public int getBoardInfoCount(SearchVo searchVo) {
		return sampleMapper.getBoardInfoCount(searchVo);
	}
	
	public List<SampleVo> getBoardInfoList(SearchVo searchVo) {
		return sampleMapper.getBoardInfoList(searchVo);
	}
}
