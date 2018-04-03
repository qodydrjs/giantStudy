package com.Plant.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.Plant.vo.EmployeeVO;

@Repository(value="EmployeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO{

	private static final String NameSpace ="employeeMapper";
	
	@Inject
	private SqlSession sqlsession;
	
	@Override
	public List<EmployeeVO> employeeAll() {
		// TODO Auto-generated method stub
		return sqlsession.selectList(NameSpace+".employeeAll");
	}

	@Override
	public EmployeeVO employeeCheck(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(NameSpace+".employeeCheck", map);
	}

}
