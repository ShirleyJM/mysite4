package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;

	public List<BoardVo> listAll(){
		return sqlSession.selectList("board.selectList");
	}
	
	public void write(BoardVo vo){
		sqlSession.insert("board.insert",vo);
	}
	
	public void modify(){
		sqlSession.update("board.modify");
	}
	public void delete(){
		sqlSession.delete("board.delete");
	}
}
