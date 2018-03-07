package com.study.domain;

public class Criteria {

	private int page;
	private int perPageNum;
	
	public Criteria() {
		
		this.setPage(1);
		this.setPerPageNum(10);
		
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public int getPageStart() {
		return (this.page -1) * this.perPageNum;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
	
	
	
}
