package com.test.boardDAO;

import java.util.List;

import com.test.vo.BoardVO;

public interface BoardDAO {
	public List<BoardVO> listAll(); //게시물 전체 조회
	public BoardVO list(int no); //특정 게시물 조회
	public int listModify(int no); //게시물 수정
	public int listDelete(int no); //게시물 삭제
	public int listWrite(BoardVO vo); //게시물 작성
}
