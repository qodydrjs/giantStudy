package com.Plant.vo;

import java.util.Date;

public class EmployeeVO {

	private int empNum;
	private String empName;
	private Date birthDay;
	private String address;
	private Date entryDay;
	private Date leaveDay;
	private String password;
	private int rankSeq;
	private int departmentNum;
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
	public int getRankSeq() {
		return rankSeq;
	}
	public void setRankSeq(int rankSeq) {
		this.rankSeq = rankSeq;
	}
	public int getDepartmentNum() {
		return departmentNum;
	}
	public void setDepartmentNum(int departmentNum) {
		this.departmentNum = departmentNum;
	}
	@Override
	public String toString() {
		return "EmployeeVO [empNum=" + empNum + ", empName=" + empName + ", birthDay=" + birthDay + ", address="
				+ address + ", entryDay=" + entryDay + ", leaveDay=" + leaveDay + ", password=" + password
				+ ", rankSeq=" + rankSeq + ", departmentNum=" + departmentNum + "]";
	}
	
	
	
	
}
