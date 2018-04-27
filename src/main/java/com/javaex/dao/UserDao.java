package com.javaex.dao;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(UserVo userVo){
		return sqlSession.insert("user.insert", userVo);
	}
	
	public UserVo getUser(String email, String password){
		
		//map을 쓰거나, vo를 만들거나.
		Map<String,String> userMap = new HashMap<String,String>();
		userMap.put("email", email);
		userMap.put("password", password);
		return sqlSession.selectOne("user.selectUserByEmailPw", userMap);
		
	}
	public UserVo modifyform(UserVo userVo){
		
		return sqlSession.selectOne("user.modifyform",userVo);
	}
	public void modify(UserVo vo){
		sqlSession.update("user.modify",vo);
	}
}
