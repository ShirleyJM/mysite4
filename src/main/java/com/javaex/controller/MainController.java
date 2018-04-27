package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {
	//index.jsp를 화면에 보이게 하는 작업 하려고 함
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(){
		System.out.println("main");
		return "main/index";
	}
}