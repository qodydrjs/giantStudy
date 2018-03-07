package com.study.service;

import java.util.List;

import com.study.domain.BoardListVO;


public interface BoardService {
	
	public List<BoardListVO> listAll() throws Exception;
	public BoardListVO list(int no) throws Exception;
	public int listCtrate(BoardListVO vo) throws Exception;
	public int listDelete(int no) throws Exception;
	public int listModify(BoardListVO vo) throws Exception;
	public int listTotalCount() throws Exception;
	
}
