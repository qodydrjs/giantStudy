package com.project.vo;

import java.util.Date;

public class SignVO {
	private String SIGN_RQUEST;
	private int EMP_NUM;
	private Date SIGN_DATE;
	private String SIGN_TEXT;
	private int BOARD_NUM;
	private String SIGN_YN;
	private String EMP_NAME;
	private String RANK_NAME;
	public String getSIGN_RQUEST() {
		return SIGN_RQUEST;
	}
	public String getEMP_NAME() {
		return EMP_NAME;
	}
	public void setEMP_NAME(String eMP_NAME) {
		EMP_NAME = eMP_NAME;
	}
	public String getRANK_NAME() {
		return RANK_NAME;
	}
	public void setRANK_NAME(String rANK_NAME) {
		RANK_NAME = rANK_NAME;
	}
	public void setSIGN_RQUEST(String sIGN_RQUEST) {
		SIGN_RQUEST = sIGN_RQUEST;
	}
	public int getEMP_NUM() {
		return EMP_NUM;
	}
	public void setEMP_NUM(int eMP_NUM) {
		EMP_NUM = eMP_NUM;
	}
	public Date getSIGN_DATE() {
		return SIGN_DATE;
	}
	public void setSIGN_DATE(Date sIGN_DATE) {
		SIGN_DATE = sIGN_DATE;
	}
	public String getSIGN_TEXT() {
		return SIGN_TEXT;
	}
	public void setSIGN_TEXT(String sIGN_TEXT) {
		SIGN_TEXT = sIGN_TEXT;
	}
	public int getBOARD_NUM() {
		return BOARD_NUM;
	}
	public void setBOARD_NUM(int bOARD_NUM) {
		BOARD_NUM = bOARD_NUM;
	}
	public String getSIGN_YN() {
		return SIGN_YN;
	}
	public void setSIGN_YN(String sIGN_YN) {
		SIGN_YN = sIGN_YN;
	}
	@Override
	public String toString() {
		return "SignVO [SIGN_RQUEST=" + SIGN_RQUEST + ", EMP_NUM=" + EMP_NUM + ", SIGN_DATE=" + SIGN_DATE
				+ ", SIGN_TEXT=" + SIGN_TEXT + ", BOARD_NUM=" + BOARD_NUM + ", SIGN_YN=" + SIGN_YN + "]";
	}
	
	
}