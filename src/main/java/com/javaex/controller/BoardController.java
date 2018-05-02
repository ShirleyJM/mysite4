package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService BoardService;
	//리스트 보여줌//글목록
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public String board(Model model){
		
		List<BoardVo> list= BoardService.listAll();
		model.addAttribute("list",list);
		return "board/list";
	}
/*
	//write
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(@ModelAttribute BoardVo vo){
		BoardService.write(vo);
		return "redirect:/board/listAll";
	}*/
/*	//modify 글수정
	public String modify(){
		BoardService.modify();
		return "board/modify";
	}*/
	//delete
	
	//찾기. search
	
	//취소  listAll
}
