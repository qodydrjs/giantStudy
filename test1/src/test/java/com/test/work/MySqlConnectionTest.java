package com.test.work;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySqlConnectionTest {

	private static final String Driver="com.mysql.cj.jdbc.Driver";
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/book_ex?useSSL=false&serverTimezone=Asia/Seoul";
	
	private static final String USER = "zerock";
	
	private static final String PW ="zerock";
	
	
	@Test
	public void MySqlConn() throws Exception {
		
		Class.forName(Driver);
		
		try(Connection con = DriverManager.getConnection(URL,USER,PW)){
			
			System.out.println(con);
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		
	}
	
	
}
