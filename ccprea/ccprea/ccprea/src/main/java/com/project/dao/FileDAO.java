package com.project.dao;

import java.util.List;

import com.project.vo.FileVO;

public interface FileDAO {

	public int insertFile(FileVO vo);
	public List<FileVO> fileList();
}
