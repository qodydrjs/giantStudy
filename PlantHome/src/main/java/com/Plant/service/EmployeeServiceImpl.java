package com.Plant.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.Plant.dao.EmployeeDAO;
import com.Plant.vo.EmployeeVO;

@Service(value="EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Resource(name="EmployeeDAO")
	private EmployeeDAO dao;
	
	@Override
	public List<EmployeeVO> employeeAll() {
		// TODO Auto-generated method stub
		return dao.employeeAll();
	}

	@Override
	public EmployeeVO employeeCheck(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.employeeCheck(map);
	}

	
	
}
