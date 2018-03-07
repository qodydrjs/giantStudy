package com.study.persistence;

import java.util.HashMap;
import java.util.List;

import com.study.domain.BoardListVO;


public interface BoardDAO {
	
	public List<BoardListVO> listAll(); //紐⑤뱺 �뜲�씠�꽣 議고쉶
	public BoardListVO list(int no); // �듅�젙 寃뚯떆湲� 議고쉶
	public int listCreate(BoardListVO vo); //寃뚯떆湲� �벑濡�
	public int listDelete(int no);//寃뚯떆湲� �궘�젣
	public int listModify(BoardListVO vo);
	public int listTotalCount();
	public List<BoardListVO> listSearch(HashMap<String, String> map);
	
	
}
