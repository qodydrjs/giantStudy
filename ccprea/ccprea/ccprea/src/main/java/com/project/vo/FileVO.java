package com.project.vo;

public class FileVO {
	
	
	private int seq;
	private String origName;
	private String sfile;
	private String localfile;
	private int boardNum;
	
	
	@Override
	public String toString() {
		return "FileVo [seq=" + seq + ", origName=" + origName + ", sfile=" + sfile + ", boardNum=" + boardNum + "]";
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getOrigName() {
		return origName;
	}
	public void setOrigName(String origName) {
		this.origName = origName;
	}
	public String getSfile() {
		return sfile;
	}
	public void setSfile(String sfile) {
		this.sfile = sfile;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getLocalfile() {
		return localfile;
	}
	public void setLocalfile(String localfile) {
		this.localfile = localfile;
	}

	
}
