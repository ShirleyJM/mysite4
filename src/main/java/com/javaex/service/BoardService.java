package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao BoardDao;
	
	public List<BoardVo> listAll(){
		
		return BoardDao.listAll();
	}
	
/*	public void write(BoardVo vo){
		BoardDao.write(vo);
	}
	*/
/*	public void modify(){
		BoardDao.modify();
		
	}*/
}
