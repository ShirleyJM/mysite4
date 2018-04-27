package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestbookService gbService;
	@RequestMapping(value="/guestbook", method=RequestMethod.GET)
	public String guestbook(){
		return "guestbook/list";
	}
	
	

}
