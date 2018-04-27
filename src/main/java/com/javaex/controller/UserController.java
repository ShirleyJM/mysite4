package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/joinform", method = RequestMethod.GET)
	public String joinform() {
		System.out.println("joinform");
		// WEB-INF/views 지워도 됨
		return "user/joinform";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(@ModelAttribute UserVo userVo) {

		System.out.println("join");
		System.out.println(userVo.toString());
		userService.join(userVo);
		return "user/joinsuccess";
	}

	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public String loginform() {
		System.out.println("loginform");
		return "user/loginform";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {

		UserVo authUser = userService.login(email, password);
		System.out.println(authUser.toString());

		if (authUser != null) {
			session.setAttribute("authUser", authUser);
			return "main/index";

		} else
			return "redirect:/user/loginform?result=fail";
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.removeAttribute("authUser");
		return "main/index";
	}
	
	@RequestMapping(value="/modifyform", method=RequestMethod.GET)
	public String modifyform(HttpSession session,Model model){
	       
	       UserVo vo = (UserVo)session.getAttribute("authUser");
	       
	       
	       UserVo uvo = userService.modifyform(vo);
	       model.addAttribute("modifyuser",uvo);
		return "user/modifyform";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modify(@ModelAttribute UserVo userVo,HttpSession session){
		
		userService.modify(userVo);
		System.out.println("2");
		UserVo vo = (UserVo)session.getAttribute("authUser");
		System.out.println("3");
		vo.setName(userVo.getName());
		System.out.println("4");
		return "main/index";
	}
	
}
