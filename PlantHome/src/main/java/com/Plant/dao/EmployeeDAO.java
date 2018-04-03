package com.Plant.dao;

import java.util.List;
import java.util.Map;

import com.Plant.vo.EmployeeVO;

public interface EmployeeDAO {
	public List<EmployeeVO> employeeAll();
	public EmployeeVO employeeCheck(Map<String, Object> map);
}
