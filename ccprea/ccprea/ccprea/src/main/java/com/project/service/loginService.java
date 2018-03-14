package com.project.service;

import java.util.List;

import com.project.vo.EmployeeVO;

public interface loginService {

	public List<EmployeeVO> EmplyeeAll() throws Exception;
	public int IdCheck(EmployeeVO vo) throws Exception;
	public int PasswdCheck(EmployeeVO vo) throws Exception;
	public EmployeeVO login(EmployeeVO vo) throws Exception;
	public EmployeeVO EmplyeeInfo(String id) throws Exception;
}
