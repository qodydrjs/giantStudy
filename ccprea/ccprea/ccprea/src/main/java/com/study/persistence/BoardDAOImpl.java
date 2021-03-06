package com.study.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.domain.BoardListVO;


@Repository(value = "BoardDAOImpl")
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession session;
	
	
	private static String namespace = "com.study.mapper.mapper";


	@Override
	public int listModify(BoardListVO vo) {
		// TODO Auto-generated method stub
		return session.update(namespace+".listModify", vo);
	}


	@Override
	public List<BoardListVO> listAll() {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".listAll");
	}


	@Override
	public BoardListVO list(int no) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".list",no);
	}


	@Override
	public int listCreate(BoardListVO vo) {
		// TODO Auto-generated method stub
		 return session.insert(namespace+".listCreate",vo);
	}


	@Override
	public int listDelete(int no) {
		// TODO Auto-generated method stub
		return session.delete(namespace+".listDelete", no);
	}


	@Override
	public int listTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".listTotalCount");
	}


	@Override
	public List<BoardListVO> listSearch(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".listSearch", map);
	}
	
	
}
