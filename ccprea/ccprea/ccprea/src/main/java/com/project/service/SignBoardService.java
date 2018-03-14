package com.project.service;

import java.util.HashMap;
import java.util.List;

import com.project.vo.SignBoardVO;
import com.project.vo.SignLineVO;
import com.project.vo.SignVO;

public interface SignBoardService {
	public List<SignBoardVO> list(int no);
	public SignBoardVO listSeq(int seq);
	public int BoardInsert(SignBoardVO  vo);
	public int BoardCount(int no);
	public int signInjsert(SignVO vo);
	
	public List<SignLineVO> signLine(int seq);
}
