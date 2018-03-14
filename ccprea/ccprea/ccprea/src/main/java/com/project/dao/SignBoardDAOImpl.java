package com.project.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.vo.SignBoardVO;
import com.project.vo.SignLineVO;
import com.project.vo.SignVO;
@Repository
public class SignBoardDAOImpl implements SignBoardDAO{
	private static final String namespace = "com.project.mapper.sign_mapper";
	@Inject
	private SqlSession session;
	
	@Override
	public List<SignBoardVO> list(int no) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".list",no);
	}

	@Override
	public int BoardInsert(SignBoardVO  vo) {
		// TODO Auto-generated method stub
		return session.insert(namespace+".boardinsert", vo);
	}

	@Override
	public int BoardCount(int no) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".boardCount", no);
	}

	@Override
	public int signInjsert(SignVO vo) {
		// TODO Auto-generated method stub
		return session.insert(namespace+".signInjsert", vo);
	}

	@Override
	public SignBoardVO listSeq(int seq) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".listSeq", seq);
	}

	@Override
	public List<SignLineVO> signLine(int seq) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".signLine", seq);
	}

}
