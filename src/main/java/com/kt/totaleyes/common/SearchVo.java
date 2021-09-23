package com.kt.totaleyes.common;

import com.kt.totaleyes.common.page.Pagenation;

public class SearchVo extends Pagenation{

	private static final long serialVersionUID = 4260260117430736501L;
	
	//검색조건
	private String searchType;
	//검색명
	private String searchNm;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchNm() {
		return searchNm;
	}
	public void setSearchNm(String searchNm) {
		this.searchNm = searchNm;
	}
		
}
