package com.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.vo.SignBoardVO;
import com.project.vo.SignLineVO;
import com.project.vo.SignVO;

public interface SignBoardService {
	public List<SignBoardVO> list(Map<String, String> map);
	public SignBoardVO listSeq(int seq);
	public int BoardInsert(SignBoardVO  vo);
	public int BoardCount(int no);
	public int signInjsert(Map<String, String> map);
	public int mySignInjsert(Map<String, String> map);
	public int BoardUpdate(SignBoardVO vo);
	
	public List<SignLineVO> signLine(int seq);
	public int signUpdate(Map<String, String> map);
	public int nextSignUpdate(Map<String, String> map);
	
	public List<SignVO> signlist(int no);
	public int lastSignCount(int no); 
	
	public int nameSearch(String name);
}
