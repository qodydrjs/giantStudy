package com.Plant.web;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.Plant.dao.EmployeeDAO;
import com.Plant.dao.ShoppingListDAO;

@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SessionTest {

	@Inject
	private SqlSession sqlsession;
	
	@Inject
	private EmployeeDAO dao;
	
	@Resource(name="ShoppingListDAO")
	private ShoppingListDAO daos;
	
	@Test
	public void test(){
		
		
		daos.shoppingBasketList(10001);
		
		
	}
	
}
