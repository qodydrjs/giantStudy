package com.Plant.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Plant.service.EmployeeService;
import com.Plant.vo.EmployeeVO;

@Controller
@RequestMapping(value="/loginc")
public class MemberController {

	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MemberController.class);
	
	@Resource(name="EmployeeService")
	private EmployeeService service;
	
	@RequestMapping("/logins")
	public String login(){	
		logger.info(":::::::::::::::::::Logins");
		
		return "login/loginView";
	}
	
	@RequestMapping(value="loginCheck", method = RequestMethod.POST)
	public String loginCheck(HttpSession session
							,@RequestParam(value="id" ,defaultValue="0") int id
							,@RequestParam(value="password", defaultValue="0")String password
							,RedirectAttributes rttr){
		
		
		logger.info(":::::::::::::::::::loginCheck");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", id);
		map.put("password", password);
		
		EmployeeVO vo = service.employeeCheck(map);
		
		
		if(vo == null){
			rttr.addFlashAttribute("msg", "Failed");
		}
		
		rttr.addFlashAttribute("msg", "SUCSSES");
		
		session.setAttribute("id", vo.getEmpNum());
		
		
		
		return "redirect:/boards/boardList";
	}
	

	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		
		
		session.invalidate();
		
		return "redirect:/loginc/logins";
	}
	
}
