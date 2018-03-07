package com.qodydrjs.BoardDAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionFactory;

import com.qodydrjs.BoardVO.BoardVO;

public interface BoardDAO {
	

	public List<BoardVO> listAll();
	
}
