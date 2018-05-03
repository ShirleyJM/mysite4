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

	public List<GuestbookVo> listAll() {

		return GuestbookDao.listAll();
	}

	public void add(GuestbookVo vo) {
		GuestbookDao.add(vo);

	}

	public void delete(GuestbookVo vo) {
		/* GuestbookDao.delete(vo); */
		GuestbookDao.delete(vo);

	}

	public GuestbookVo write(GuestbookVo guestbookVo) {
		// insert
		/*System.out.println("서비스" + guestbookVo.toString());*/
		int no = GuestbookDao.insert2(guestbookVo);
		/*System.out.println("서비스도착" + guestbookVo.toString());*/
		GuestbookVo gvo = GuestbookDao.selectGuestBook(no);
		System.out.println(gvo.toString());
		// select
		return gvo;
	}
	
	public int delete2(GuestbookVo vo){
		int del = GuestbookDao.delete2(vo);
		if(del>0){
			del= Integer.parseInt(vo.getNo());
			return del;
			
		}else{
			//
			System.out.println("delete실패");
			return 0;
		}
		
		
		
	}
}
