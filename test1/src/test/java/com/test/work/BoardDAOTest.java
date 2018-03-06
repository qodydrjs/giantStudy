package com.test.work;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.boardDAO.BoardDAO;
import com.test.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class BoardDAOTest {

	@Inject
	private BoardDAO dao;
	
	
	@Test
	public void daoTest() {

		List<BoardVO>  vo = dao.listAll();
		
		System.out.println(vo.get(1).getTitle());

	}
	
}
