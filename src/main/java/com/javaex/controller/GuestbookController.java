package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {

	@Autowired
	private GuestbookService GuestbookService;

	@RequestMapping(value = "/list-ajax", method = RequestMethod.GET)
	public String ajaxList() {
		System.out.println("list-ajax 도착");
		return "guestbook/ajax-list";
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String guestbook(Model model) {

		List<GuestbookVo> list = GuestbookService.listAll();
		model.addAttribute("list", list);

		return "guestbook/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(@ModelAttribute GuestbookVo vo) {
		GuestbookService.add(vo);
		return "redirect:/guestbook/listAll";

	}

	@RequestMapping(value = "/deleteform", method = RequestMethod.GET)
	public String deleteform() {
		return "guestbook/deleteform";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute GuestbookVo vo) {
		System.out.println(vo.getNo() + vo.getPassword());
		System.out.println("삭제");
		GuestbookService.delete(vo);
		return "redirect:/guestbook/listAll";
	}

	@RequestMapping(value="/write",method=RequestMethod.POST)
	public GuestbookVo write(GuestbookVo guestbookVo) {
		//insert
		GuestbookService.write(guestbookVo);
		//select
		return guestbookVo;
		
	}
}
