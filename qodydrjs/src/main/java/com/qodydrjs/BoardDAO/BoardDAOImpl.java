package com.qodydrjs.BoardDAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.qodydrjs.BoardVO.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session; 
	
	private static final String namespace ="org.mybatis.board";
	
	@Override
	public List<BoardVO> listAll() {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".listAll");
	}

	
	
}
