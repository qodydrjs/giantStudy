package com.Plant.web;

import java.sql.Connection;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.Plant.dao.EmployeeDAO;

@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SessionTest {

	@Inject
	private SqlSession sqlsession;
	
	@Inject
	private EmployeeDAO dao;
	
	@Test
	public void test(){
		
		
		dao.employeeAll();
		
		
	}
	
}
