package com.kt.totaleyes.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kt.totaleyes.common.SearchVo;
import com.kt.totaleyes.vo.SampleVo;

@Mapper
public interface SampleMapper {
	
	public int getBoardInfoCount(SearchVo searchVo);
	
	public List<SampleVo> getBoardInfoList(SearchVo searchVo);
}
