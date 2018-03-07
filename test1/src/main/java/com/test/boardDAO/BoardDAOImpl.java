package com.test.boardDAO;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.test.vo.BoardVO;

@Repository(value="BoardDAO")
public class BoardDAOImpl implements BoardDAO{
		
	@Inject
	private SqlSession session;
	
	private static final String namespace="org.zerock.mapper.MemberMapper"; 

	@Override
	public int listWrite(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> listAll() {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".listALL");
	}

	@Override
	public BoardVO list(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int listModify(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int listDelete(int no) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
