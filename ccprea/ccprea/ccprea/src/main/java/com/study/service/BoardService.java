package com.study.service;

import java.util.List;

import com.study.domain.BoardListVO;


public interface BoardService {
	
	public List<BoardListVO> listAll() throws Exception;
	public BoardListVO list(int no) throws Exception;
	public void listCtrate(BoardListVO vo) throws Exception;
	public void listDelete(int no) throws Exception;
}
