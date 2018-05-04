package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.FileVo;

@Repository

public class FileUploadDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<FileVo> list(){
		return sqlSession.selectList("gallery.select");
	}
	public void insert(FileVo vo){
		sqlSession.insert("gallery.insert",vo);
	}
	
	public void delete(FileVo vo){
		sqlSession.delete("gallery.delete",vo);
	}
	


}
