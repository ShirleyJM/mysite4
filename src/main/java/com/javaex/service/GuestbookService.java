package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDao GuestbookDao;
	
	public List<GuestbookVo> listAll(){
		
		return GuestbookDao.listAll();
	}
	
	public void add(GuestbookVo vo){
			GuestbookDao.add(vo);
			
	}
	
	
	
	public void delete(GuestbookVo vo){
		/*GuestbookDao.delete(vo);*/
		 		 GuestbookDao.delete(vo);

		
	}
}
