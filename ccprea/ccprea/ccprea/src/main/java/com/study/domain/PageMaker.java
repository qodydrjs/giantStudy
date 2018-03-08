package com.study.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int queryPageStart;
	private int queryPageEnd;
	
	public int getQueryPageStart() {
		return queryPageStart;
	}

	public void setQueryPageStart(int queryPageStart) {
		this.queryPageStart = queryPageStart;
	}

	public int getQueryPageEnd() {
		return queryPageEnd;
	}

	public void setQueryPageEnd(int queryPageEnd) {
		this.queryPageEnd = queryPageEnd;
	}


	private int displayPaheNum=5;
	
	private Criteria cri;
	
	public PageMaker(){
		
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
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

	public int getDisplayPaheNum() {
		return displayPaheNum;
	}

	public void setDisplayPaheNum(int displayPaheNum) {
		this.displayPaheNum = displayPaheNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
		calcData();
	}
	
	private void calcData() {
		
		
		queryPageEnd = (int) (cri.getPage() *displayPaheNum);
		queryPageStart =(queryPageEnd - displayPaheNum) +1;
		
		
		startPage = (int) Math.ceil(cri.getPage() / (double) cri.getPerPageNum())*cri.getPerPageNum()-cri.getPerPageNum()+1;
		endPage =  startPage + cri.getPerPageNum()-1;
		
//		startPage = (int) Math.ceil(cri.getPage() / (double) cri.getPerPageNum());
//		endPage = startPage + cri.getPerPageNum()-1;
		
		
		
		totalCount = (int) Math.ceil(totalCount / (double)displayPaheNum) ;
		
		if(endPage>totalCount){
			endPage=totalCount;
		}
		
		prev = startPage == 1 ? false : true;
		next = endPage == totalCount ? false : true;
		
//		queryPageStart = (cri.getPage() * cri.getPerPageNum()) - cri.getPerPageNum() + 1 ;
//		queryPageEnd = (cri.getPage() * cri.getPerPageNum());
		
		
	}
	
	
	public String makeQuery(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum",cri.getPerPageNum())
				.build();
		
		return uriComponents.toUriString();
	}
}
