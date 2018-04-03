package com.project.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.dao.SignBoardDAO;
import com.project.vo.EmployeeVO;
import com.project.vo.SignBoardVO;
import com.project.vo.SignLineVO;
import com.project.vo.SignVO;

@Service
public class SignBoardServiceImpl implements SignBoardService{

	@Inject
	private SignBoardDAO dao;
	
	@Override
	public List<SignBoardVO> list(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.list(map);
	}

	@Override
	public int BoardInsert(SignBoardVO vo) {
		// TODO Auto-generated method stub
		return dao.BoardInsert(vo);
	}

	@Override
	public int BoardCount(int no) {
		// TODO Auto-generated method stub
		return dao.BoardCount(no);
	}

	@Override
	public int signInjsert(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.signInjsert(map);
	}

	@Override
	public SignBoardVO listSeq(int seq) {
		// TODO Auto-generated method stub
		return dao.listSeq(seq);
	}

	@Override
	public List<SignLineVO> signLine(int seq) {
		// TODO Auto-generated method stub
		return dao.signLine(seq);
	}

	@Override
	public int mySignInjsert(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.mySignInjsert(map);
	}

	@Override
	public int BoardUpdate(SignBoardVO vo) {
		// TODO Auto-generated method stub
		return dao.BoardUpdate(vo);
	}

	@Override
	public int signUpdate(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.signUpdate(map);
	}

	@Override
	public int nextSignUpdate(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.nextSignUpdate(map);
	}

	@Override
	public List<SignVO> signlist(int no) {
		// TODO Auto-generated method stub
		return dao.signlist(no);
	}

	@Override
	public int lastSignCount(int no) {
		// TODO Auto-generated method stub
		return dao.lastSignCount(no);
	}

	@Override
	public int nameSearch(String name) {
		// TODO Auto-generated method stub
		return dao.nameSearch(name);
	}

	@Override
	public List<EmployeeVO> emplist(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return dao.emplist(map);
	}

	@Override
	public int emp_insert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.emp_insert(map);
	}

	@Override
	public int emp_delete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.emp_delete(map);
	}

	@Override
	public int emp_update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.emp_update(map);
	}
	
}
