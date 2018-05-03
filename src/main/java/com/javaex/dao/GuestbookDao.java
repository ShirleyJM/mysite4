package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestbookVo> listAll(){
		return sqlSession.selectList("guestbook.selectList");
	}
	public void add(GuestbookVo vo){
		sqlSession.insert("guestbook.insert",vo);	
	}
	
	public void delete(GuestbookVo vo){
		 sqlSession.delete("guestbook.delete",vo);
	}

	
	
	
	
	public int insert2(GuestbookVo guestbookVo){
		System.out.println("다오"+guestbookVo.toString());
		sqlSession.insert("guestbook.insert2",guestbookVo);
		String no = guestbookVo.getNo();
		return Integer.parseInt(no);
	}
	
	public GuestbookVo selectGuestBook(int no){
		return sqlSession.selectOne("guestbook.selectGuestBook",no);
	}
	
	public int delete2(GuestbookVo vo){
		return sqlSession.delete("guestbook.delete2",vo);
		
		
	}

}
