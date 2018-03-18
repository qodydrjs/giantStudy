package com.project.vo;

import java.util.Date;

public class EmployeeVO {
	private int seq;
	private int empNum;
	private String empName;
	private Date birthDay;
	private String address;
	private Date entryDay;
	private Date leaveDay;
	private String password;
	private String rankSeq;
	
	
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
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getEntryDay() {
		return entryDay;
	}
	public void setEntryDay(Date entryDay) {
		this.entryDay = entryDay;
	}
	public Date getLeaveDay() {
		return leaveDay;
	}
	public void setLeaveDay(Date leaveDay) {
		this.leaveDay = leaveDay;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRankSeq() {
		return rankSeq;
	}
	public void setRankSeq(String rankSeq) {
		this.rankSeq = rankSeq;
	}

	
	@Override
	public String toString() {
		return "EmployeeVO [seq=" + seq + ", empNum=" + empNum + ", empName=" + empName + ", birthDay=" + birthDay
				+ ", address=" + address + ", entryDay=" + entryDay + ", leaveDay=" + leaveDay + ", password="
				+ password + ", rankSeq=" + rankSeq + "]";
	}
}
