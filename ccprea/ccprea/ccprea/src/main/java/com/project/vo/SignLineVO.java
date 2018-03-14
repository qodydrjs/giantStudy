package com.project.vo;

public class SignLineVO {

	private String EMP_NAME;
	private String RANK_NAME;
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
	@Override
	public String toString() {
		return "SignLineVO [EMP_NAME=" + EMP_NAME + ", RANK_NAME=" + RANK_NAME + "]";
	}
	
}
