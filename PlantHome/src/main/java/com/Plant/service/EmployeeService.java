package com.Plant.service;

import java.util.List;
import java.util.Map;

import com.Plant.vo.EmployeeVO;

public interface EmployeeService {
	
	public List<EmployeeVO> employeeAll();
	public EmployeeVO employeeCheck(Map<String, Object> map);
	
}
