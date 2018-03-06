package com.qodydrjs.web;

import java.sql.Connection;

import javax.sql.DataSource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class dataSource {

	@Inject
 	private DataSource ds;
	
	@Inject
	private SqlSessionFactory sqlSession;
	
	@org.junit.Test
	public void Test() {
		
		try(SqlSession con = sqlSession.openSession()){
			
			System.out.println(con);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	
}
