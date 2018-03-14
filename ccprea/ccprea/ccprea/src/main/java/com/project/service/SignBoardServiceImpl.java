package com.project.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.dao.SignBoardDAO;
import com.project.vo.SignBoardVO;
import com.project.vo.SignLineVO;
import com.project.vo.SignVO;

@Service
public class SignBoardServiceImpl implements SignBoardService{

	@Inject
	private SignBoardDAO dao;
	
	@Override
	public List<SignBoardVO> list(int no) {
		// TODO Auto-generated method stub
		return dao.list(no);
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
	public int signInjsert(SignVO vo) {
		// TODO Auto-generated method stub
		return dao.signInjsert(vo);
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
	
}
