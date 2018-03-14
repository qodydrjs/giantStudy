package com.project.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.dao.loginDAO;
import com.project.vo.EmployeeVO;

@Service
public class loginServiceImpl implements loginService{

	@Inject
	private loginDAO dao;
	
	@Override
	public List<EmployeeVO> EmplyeeAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int IdCheck(EmployeeVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int PasswdCheck(EmployeeVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EmployeeVO login(EmployeeVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(vo);
	}

	@Override
	public EmployeeVO EmplyeeInfo(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
