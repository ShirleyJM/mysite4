package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
	@Autowired
	private GuestbookService GuestbookService ;
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public String guestbook(Model model){
		
		List<GuestbookVo> list = GuestbookService.listAll();
		model.addAttribute("list",list );
		
		return "guestbook/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@ModelAttribute GuestbookVo vo){
		GuestbookService.add(vo);
		return "redirect:/guestbook/listAll";
		
	}
	
	@RequestMapping(value="/deleteform",method=RequestMethod.GET)
	public String deleteform(){
		return "guestbook/deleteform";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@ModelAttribute GuestbookVo vo){
		System.out.println("삭제");
		GuestbookService.delete(vo);
		return "redirect:/guestbook/listAll";
	}

}
