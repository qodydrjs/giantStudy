package com.project.dao;

import java.util.List;

import com.project.vo.EmployeeVO;

public interface loginDAO {
	public List<EmployeeVO> EmplyeeAll();
	public int IdCheck(EmployeeVO vo);
	public int PasswdCheck(EmployeeVO vo);
	public EmployeeVO login(EmployeeVO vo);
	public EmployeeVO EmplyeeInfo(String id);
}
