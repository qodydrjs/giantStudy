package com.project.vo;

import java.util.Date;

public class SignVO {
	private int seq;
	private int empNum;
	private int signState;
	private Date signDate;
	private String signText;
	private int boardNum;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getEmpNum() {
		return empNum;
	}
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}
	public int getSignState() {
		return signState;
	}
	public void setSignState(int signState) {
		this.signState = signState;
	}
	public Date getSignDate() {
		return signDate;
	}
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
	public String getSignText() {
		return signText;
	}
	public void setSignText(String signText) {
		this.signText = signText;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	@Override
	public String toString() {
		return "SignVO [seq=" + seq + ", empNum=" + empNum + ", signState=" + signState + ", signDate=" + signDate
				+ ", signText=" + signText + ", boardNum=" + boardNum + "]";
	}
}
