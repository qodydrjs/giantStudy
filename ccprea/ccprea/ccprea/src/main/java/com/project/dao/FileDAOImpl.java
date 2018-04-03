package com.project.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.vo.FileVO;

@Repository(value = "FileDAO")
public class FileDAOImpl implements FileDAO{

	private static final String Namespace = "file_mapper";
	
	@Inject
	private SqlSession session;
	
	@Override
	public int insertFile(FileVO vo) {
		// TODO Auto-generated method stub
		return session.insert(Namespace+".fileInsert", vo);
	}

	@Override
	public List<FileVO> fileList() {
		// TODO Auto-generated method stub
		return session.selectList(Namespace+".fileList");
	}

	
	
}
