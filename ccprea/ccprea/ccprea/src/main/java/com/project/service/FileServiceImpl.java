package com.project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.project.dao.FileDAO;
import com.project.vo.FileVO;


@Service(value = "FileService")
public class FileServiceImpl implements FileService {

	@Resource(name="FileDAO")
	private FileDAO dao;
	
	@Override
	public int fileInsert(FileVO vo) {
		// TODO Auto-generated method stub
		return dao.insertFile(vo);
	}

	@Override
	public List<FileVO> fileList() {
		// TODO Auto-generated method stub
		return dao.fileList();
	}

}
