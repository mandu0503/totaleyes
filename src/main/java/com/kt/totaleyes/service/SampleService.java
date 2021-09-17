package com.kt.totaleyes.service;

import java.util.List;

import com.kt.totaleyes.common.SearchVo;
import com.kt.totaleyes.vo.SampleVo;

public interface SampleService {
	public int getBoardInfoCount(SearchVo searchVo);
	public List<SampleVo> getBoardInfoList(SearchVo searchVo);
}
