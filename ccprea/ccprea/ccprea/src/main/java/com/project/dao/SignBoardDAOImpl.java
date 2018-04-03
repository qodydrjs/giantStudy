package com.project.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.vo.EmployeeVO;
import com.project.vo.SignBoardVO;
import com.project.vo.SignLineVO;
import com.project.vo.SignVO;
@Repository
public class SignBoardDAOImpl implements SignBoardDAO{
	private static final String namespace = "com.project.mapper.sign_mapper";
	@Inject
	private SqlSession session;
	
	@Override
	public List<SignBoardVO> list(Map<String, String> map) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".list",map);
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
	public int signInjsert(Map<String, String> map) {
		// TODO Auto-generated method stub
		return session.insert(namespace+".signInjsert", map);
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

	@Override
	public int mySignInjsert(Map<String, String> map) {
		// TODO Auto-generated method stub
		return session.insert(namespace+".mySignInjsert", map);
	}

	@Override
	public int BoardUpdate(SignBoardVO vo) {
		// TODO Auto-generated method stub
		return session.update(namespace+".boardUpdate", vo);
	}

	@Override
	public int signUpdate(Map<String, String> map) {
		// TODO Auto-generated method stub
		return session.update(namespace+".signUpdate", map);
	}

	@Override
	public int nextSignUpdate(Map<String, String> map) {
		// TODO Auto-generated method stub
		return session.update(namespace+".nextSignUpdate",map);
	}

	@Override
	public List<SignVO> signlist(int no) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".signList", no);
	}

	@Override
	public int lastSignCount(int no) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".lastSignCount",no);
	}

	@Override
	public int nameSearch(String name) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".nameSearch", name);
	}

	@Override
	public List<EmployeeVO> emplist(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".emplist",map);
	}

	@Override
	public int emp_insert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return session.insert(namespace+".emp_insert",map);
	}

	@Override
	public int emp_delete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return session.delete(namespace+".emp_delete",map);
	}

	@Override
	public int emp_update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return session.update(namespace+".emp_update",map);
	}


}
