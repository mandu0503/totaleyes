package com.kt.totaleyes.common.page;

import java.io.Serializable;

public class Pagenation implements Serializable{
	
	private static final long serialVersionUID = -9064263767184442180L;
	
	//초기값으로 목록개수를 10으로 셋팅
	private int listSize = 10;                
	//초기값으로 페이지범위를 10으로 셋팅
	private int rangeSize = 10;    
	//현재 페이지
	private int page;
	//총카운트
	private int totCnt;
	private int pageCnt;
	private int startPage;
	private int startList;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int prevPage;
	private int nextPage;
	
	public int getRangeSize() {
		return rangeSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	
	public int getTotCnt() {
		return totCnt;
	}

	public void setTotCnt(int totCnt) {
		this.totCnt = totCnt;
	}
	
	public int getStartList() {
		return startList;
	}
	public void pageInfo(int page, int totCnt) {
		this.page = page;
		this.totCnt = totCnt;
		
		//전체 페이지수 
		this.pageCnt = (int) Math.ceil((float)totCnt/listSize);
				
		//끝 페이지
		this.endPage = ((int) Math.ceil((float)page/this.rangeSize)) * this.rangeSize;
		//시작 페이지
		this.startPage = this.endPage - (this.rangeSize - 1);
		
		//게시판 시작번호
		this.startList = (page - 1) * listSize;
		
		//이전 버튼 상태
		this.prev = this.startPage == 1 ? false : true;
		
		//다음 버튼 상태
		this.next = endPage > pageCnt ? false : true;
		if (this.endPage > this.pageCnt) {
			this.endPage = this.pageCnt;
			this.next = false;
		}
		
		this.prevPage = this.startPage - this.rangeSize;
		this.nextPage = this.endPage + 1;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

}
