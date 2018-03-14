package com.project.vo;

import java.util.Date;

public class SignBoardVO {
	private int seq;
	private String empNum;
	private String signSubject;
	private String signContent;
	private Date regDate;
	private Date signDate;
	private String signPerson;
	private String signState;
	private int nextSign;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getSignSubject() {
		return signSubject;
	}
	public void setSignSubject(String signSubject) {
		this.signSubject = signSubject;
	}
	public String getSignContent() {
		return signContent;
	}
	public void setSignContent(String signContent) {
		this.signContent = signContent;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getSignDate() {
		return signDate;
	}
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
	public String getSignPerson() {
		return signPerson;
	}
	public void setSignPerson(String signPerson) {
		this.signPerson = signPerson;
	}
	public String getSignState() {
		return signState;
	}
	public void setSignState(String signState) {
		this.signState = signState;
	}
	@Override
	public String toString() {
		return "SignBoardVO [seq=" + seq + ", emp_num=" + ", signSubject=" + signSubject + ", signContent="
				+ signContent + ", regDate=" + regDate + ", signDate=" + signDate + ", signPerson=" + signPerson
				+ ", signState=" + signState + "]";
	}
	public String getEmpNum() {
		return empNum;
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}
	public int getNextSign() {
		return nextSign;
	}
	public void setNextSign(int nextSign) {
		this.nextSign = nextSign;
	}

	
	
	
}
