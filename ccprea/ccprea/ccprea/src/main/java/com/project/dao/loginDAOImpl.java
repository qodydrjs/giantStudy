package com.project.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.vo.EmployeeVO;

@Repository
public class loginDAOImpl implements loginDAO {

	private static final String namespace = "com.project.mapper.mapper";
	
	@Inject
	private SqlSession sqlsession;
	
	@Override
	public List<EmployeeVO> EmplyeeAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int IdCheck(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int PasswdCheck(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EmployeeVO login(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace+".login", vo);
	}

	@Override
	public EmployeeVO EmplyeeInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
