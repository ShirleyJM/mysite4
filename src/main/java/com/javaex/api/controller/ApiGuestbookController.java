package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

//데이터 주고 받는 것만 따로 컨트롤하는 아이
@Controller
@RequestMapping(value="/api/gb")
public class ApiGuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<GuestbookVo> list(){
		System.out.println("ajax-list:guestbook");
		
		List<GuestbookVo> guestbookList = guestbookService.listAll();
		System.out.println(guestbookList.toString());
		
		return guestbookList;
	}
	
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public GuestbookVo add(@ModelAttribute GuestbookVo guestbookVo){
		System.out.println("add");
		System.out.println(guestbookVo.toString());
		
		
		GuestbookVo vo= guestbookService.write(guestbookVo);
		System.out.println("controller:"+vo.toString());
		return vo;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public void delete(@ModelAttribute GuestbookVo guestbookVo){
		
	}
}
