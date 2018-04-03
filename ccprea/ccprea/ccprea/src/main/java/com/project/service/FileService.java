package com.project.service;

import java.util.List;

import com.project.vo.FileVO;

public interface FileService {

	public int fileInsert(FileVO vo);
	public List<FileVO> fileList();
}
