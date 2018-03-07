package com.study.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.study.domain.BoardListVO;
import com.study.persistence.BoardDAO;


@Service(value= "BoardServiceImpl")
public class BoardServiceImpl implements BoardService {

	//@Inject
	@Resource(name="BoardDAOImpl")
	private BoardDAO dao;
	
	@Override
	public int listModify(BoardListVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.listModify(vo);
	}

	@Override
	public List<BoardListVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public BoardListVO list(int no) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(no);
	}

	@Override
	public int listCtrate(BoardListVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCreate(vo);
	}

	@Override
	public int listDelete(int no) throws Exception {
		// TODO Auto-generated method stub
		return dao.listDelete(no);
		
	}

	@Override
	public int listTotalCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.listTotalCount();
	}

	@Override
	public List<BoardListVO> listSearch(HashMap<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearch(map);
	}

}
