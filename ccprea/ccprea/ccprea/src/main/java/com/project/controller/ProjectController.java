package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.service.SignBoardService;
import com.project.service.loginService;
import com.project.vo.EmployeeVO;
import com.project.vo.SignBoardVO;
import com.project.vo.SignLineVO;
import com.project.vo.SignVO;
import com.study.domain.BoardListVO;

@Controller
public class ProjectController {
	
	@Inject
	private loginService loginservice;
	@Inject
	private SignBoardService signBoardService;

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@RequestMapping(value="login" , method=RequestMethod.GET)
	public String loginGet(Model model){
		
		
		return "project/login/login";
	}
	
	@RequestMapping(value="login" , method=RequestMethod.POST)
	public String loginPost(EmployeeVO vo,
						RedirectAttributes rttr,
						Model model,
						HttpServletRequest request) throws Exception{
	
		EmployeeVO loginInfo =  loginservice.login(vo);
		
		
		if(loginInfo == null){
			rttr.addFlashAttribute("msg", "Failed");
			return "redirect:login";
		}else{
			
			System.out.println("이름 :::::::::::; "+loginInfo.getEmpName());
			System.out.println("비밀번호 :::::::::::; "+loginInfo.getPassword());
			
			rttr.addFlashAttribute("msg", "성공");
			
			HttpSession session = request.getSession(true);
			session.setAttribute("empName", loginInfo.getEmpName());
			session.setAttribute("empNum", loginInfo.getEmpNum());
			
			return "redirect:singList";
		}
		
	}
	
	@RequestMapping(value="singList")
	public String singList(Model model, HttpSession session){

		int no = Integer.parseInt(session.getAttribute("empNum").toString() );
		
		List<SignBoardVO> list = signBoardService.list(no);
		
		model.addAttribute("list", list);
		
		return "project/board/signListView";
	}
	
	
	@RequestMapping(value="logout")
	public String logout(HttpSession session){
		
		session.removeAttribute("empName");
		session.removeAttribute("empNum");
		
		return "redirect:login";
	}
	
	@RequestMapping(value="write" , method=RequestMethod.GET)
	public String writeGet(@RequestParam(value="seq",defaultValue="0") int seq,
			Model model,
			HttpSession session){
		
		String sessionNum = session.getAttribute("empNum").toString();
		
		if(seq!=0){
			SignBoardVO list = signBoardService.listSeq(seq);
			model.addAttribute("list", list);
		}
		
		List<SignLineVO> line= signBoardService.signLine(Integer.parseInt(sessionNum));
		
		
		model.addAttribute("line", line);
		
		
		return "project/board/writeView";
	}
	
	@RequestMapping(value="write" , method=RequestMethod.POST)
	public String writePOST(RedirectAttributes rttr,
		HttpServletRequest request,
		SignBoardVO vo,
		HttpSession session){
		
		int check ;
		
		String sessionid = session.getAttribute("empName").toString();
		String requestStr = request.getParameter("empName").toString();
		String sessionNum = session.getAttribute("empNum").toString();
		
		System.out.println(sessionid + " ;;::::::::::::: " + requestStr); 

		if(sessionid.equals(requestStr)){
			
			vo.setNextSign(1); //결제 처음 신청시 다음에 결제해야 할 사람 번호
			check = signBoardService.BoardInsert(vo);
			
			if(vo.getSignState().equals("2")){
				
				int setBoardNum = signBoardService.BoardCount(Integer.parseInt(sessionNum));
				
				SignVO svo = new SignVO();
				svo.setSignState(Integer.parseInt(vo.getSignState()));
				svo.setEmpNum(Integer.parseInt(sessionNum));
				svo.setSignText("결재허가");
				svo.setBoardNum(setBoardNum);
				
				
				signBoardService.signInjsert(svo);
				
			}
			
		}else{
			check = 0;
		}
		
		
		if(check ==1){
			rttr.addFlashAttribute("msg", "SUCCESS");
			return "redirect:singList";
		}else{
			rttr.addFlashAttribute("msg", "FAILED");
			return "redirect:singList";
		}
		
		
		
	}
}
