package com.Plant.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="login")
public class MemberController {

	@RequestMapping("logins")
	public String login(){	
		return "login/loginView";
	}
	
	@RequestMapping(value="loginCheck", method = RequestMethod.POST)
	public String loginCheck(HttpSession session){
		
		
		
		
		return "";
	}
	
}
