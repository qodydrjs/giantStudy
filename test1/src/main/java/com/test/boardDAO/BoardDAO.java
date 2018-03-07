package com.test.boardDAO;

import java.util.List;

import com.test.vo.BoardVO;

public interface BoardDAO {
	public List<BoardVO> listAll(); //�Խù� ��ü ��ȸ
	public BoardVO list(int no); //Ư�� �Խù� ��ȸ
	public int listModify(int no); //�Խù� ����
	public int listDelete(int no); //�Խù� ����
	public int listWrite(BoardVO vo); //�Խù� �ۼ�
}
