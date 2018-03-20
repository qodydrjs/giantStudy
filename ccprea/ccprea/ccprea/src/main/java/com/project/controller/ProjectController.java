package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


import java.util.*;
import java.sql.*;
import java.io.*;

import com.tobesoft.platform.*;
import com.tobesoft.platform.data.*;

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
	
	
	@RequestMapping(value="miview")
	public void mi(HttpServletResponse response ){
		
		 VariableList v1 = new VariableList();
		 DatasetList d1 = new DatasetList();
		
		try{
			
		Dataset ds = new Dataset("b_sign");
		ds.addColumn("EMP_NUM", ColumnInfo.CY_COLINFO_INT, 20);
		ds.addColumn("EMP_NAME", ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("BIRTH_DAY", ColumnInfo.CY_COLINFO_DATE, 20);
		ds.addColumn("ADDRESS", ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("ENTRY_DAY", ColumnInfo.CY_COLINFO_DATE, 20);
		ds.addColumn("LEAVE_DAY", ColumnInfo.CY_COLINFO_DATE, 20);
		ds.addColumn("PASSWORD", ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("RANK_SEQ", ColumnInfo.CY_COLINFO_INT, 20);
		ds.addColumn("DEPARTMENT_NUM", ColumnInfo.CY_COLINFO_INT, 20);
		
		
		List<EmployeeVO> list = signBoardService.emplist();
		
		while(list.size()){
			int row = ds.appendRow();
			ds.setColumn(row, "EMP_NUM", rsGet(rs,"EMP_NUM"));
			ds.setColumn(row, "EMP_NAME", rsGet(rs,"EMP_NAME"));
			ds.setColumn(row, "BIRTH_DAY", rsGet(rs,"BIRTH_DAY"));
			ds.setColumn(row, "ADDRESS", rsGet(rs,"ADDRESS"));
			ds.setColumn(row, "ENTRY_DAY", rsGet(rs,"ENTRY_DAY"));
			ds.setColumn(row, "LEAVE_DAY", rsGet(rs,"LEAVE_DAY"));
			ds.setColumn(row, "PASSWORD", rsGet(rs,"PASSWORD"));
			ds.setColumn(row, "RANK_SEQ", rsGet(rs,"RANK_SEQ"));
			ds.setColumn(row, "DEPARTMENT_NUM", rsGet(rs,"DEPARTMENT_NUM"));
		}
		
		d1.addDataset(ds);
		
		v1.addStr("ErrorCode", "0");
		v1.addStr("ErrorMsg", "SUCC");
		
		}catch(Exception ex){
			v1.addStr("ErrorCode", "-1");
			v1.addStr("ErrorMsg", ex.getMessage());
		}
		
		
		PlatformResponse pRes = new PlatformResponse(response, PlatformRequest.XML, "euc-kr");
		pRes.sendData(v1,d1);

	}
	
	@RequestMapping(value ="SessionError")
	public String SessionError(RedirectAttributes rttr){
		
		
		//rttr.addFlashAttribute("msg", "SessionError");
		
		return "redirect:login";
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
			
			rttr.addFlashAttribute("msg", "성공");
			
			HttpSession session = request.getSession(true);
			session.setAttribute("empName", loginInfo.getEmpName());
			session.setAttribute("empNum", loginInfo.getEmpNum());
			session.setAttribute("rankName", loginInfo.getRankSeq());
			session.setAttribute("rankSeq", loginInfo.getRankSeq());
			
			return "redirect:singList";
		}
		
	}
	
	@RequestMapping(value="singList")
	public String singList(Model model, 
							HttpSession session,
							HttpServletRequest request){
		
		
		Map<String, String> map = new HashMap<String, String>();
		//////////////////////

			String search_box = request.getParameter("search_box") == null ? "" : request.getParameter("search_box");

			String search_text = request.getParameter("search_text") == null ? "" : request.getParameter("search_text");
			
			String sdate = request.getParameter("sdate") == null ? "" : request.getParameter("sdate");
			
			String edate = request.getParameter("edate") == null ? "" : request.getParameter("edate");
			
			String sign_box = request.getParameter("sign_box") == null ? "" : request.getParameter("sign_box");
			
			map.put("search_box", search_box);
			map.put("search_text", search_text);
			map.put("sdate", sdate);
			map.put("edate", edate);
			map.put("sign_box", sign_box);
			map.put("empNum", session.getAttribute("empNum").toString());
			
	
		
		///////////////////////
		//int no = Integer.parseInt(session.getAttribute("empNum").toString() );
		
		List<SignBoardVO> list = signBoardService.list(map);
		List<EmployeeVO> emplist = signBoardService.emplist();
		
		model.addAttribute("list", list);
		model.addAttribute("emplist", emplist);
		
		model.addAttribute("search_box", search_box);
		model.addAttribute("search_text", search_text);
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("sign_box", sign_box);
		
		
		return "project/board/signListView";
	}
	
	
	@RequestMapping(value="logout")
	public String logout(HttpSession session){	
		//session.removeAttribute("empName");
		//session.removeAttribute("empNum");
		session.invalidate();
		
		return "redirect:login";
	}
	
	@RequestMapping(value="write" , method=RequestMethod.GET)
	public String writeGet(@RequestParam(value="no",defaultValue="0") int no,
			Model model,
			HttpSession session){
		
		String sessionNum = session.getAttribute("empNum").toString();
		
		
		if(no!=0){
			SignBoardVO list = signBoardService.listSeq(no); //게시글 가져오기
			model.addAttribute("list", list);
		}
		
		List<SignLineVO> line= signBoardService.signLine(Integer.parseInt(sessionNum)); //결제라인 
		model.addAttribute("line", line);
		
		List<SignVO> signlist = signBoardService.signlist(no);//결재여부
		model.addAttribute("signlist", signlist);
		
		
		return "project/board/writeView";
	}
	
	@RequestMapping(value="writeSignBoard" , method=RequestMethod.POST)
	public String writePOST(RedirectAttributes rttr,
		HttpServletRequest request,
		SignBoardVO vo,
		HttpSession session){
		
		//vo.seq 가 0 이면 게시글 작성 아니면 업데이트
		
		
		int check  = 1;
		
		String sessionid = session.getAttribute("empName").toString();
		String requestStr = request.getParameter("empName");
		String sessionNum = session.getAttribute("empNum").toString();
		String h_listsyate = request.getParameter("h_listsyate");

		if(sessionid.equals(requestStr)){ //나의 결제 작성

			if(vo.getSignState().equals("2")){ //결재
				
				if(h_listsyate.equals("임시저장")){ //임시저장글을 결재 할때
					vo.setSignState("5");
					vo.setEmpNum("");
					signBoardService.BoardUpdate(vo);
					
					///결재 라인 생성
					int setBoardNum = signBoardService.BoardCount(Integer.parseInt(sessionNum));
					Map<String, String> map = new HashMap<String, String>();
					map.put("boardNum", String.valueOf(setBoardNum));
					map.put("empNum", sessionNum);
					signBoardService.signInjsert(map);
				
					//나의 결재 라인 생성
					signBoardService.mySignInjsert(map);
				}else{ // 결재 할때
				////게시글작성
					vo.setNextSign(1); //결제 처음 신청시 다음에 결제해야 할 사람 번호 사용안함
					vo.setSignState("5");
					check = signBoardService.BoardInsert(vo);
					
					
					
					///결재 라인 생성
					int setBoardNum = signBoardService.BoardCount(Integer.parseInt(sessionNum));
					Map<String, String> map = new HashMap<String, String>();
					map.put("boardNum", String.valueOf(setBoardNum));
					map.put("empNum", sessionNum);
					
					signBoardService.signInjsert(map);
					
					///
					
					//나의 결재 라인 생성
					signBoardService.mySignInjsert(map);
				}
				
				
			}else if(vo.getSignState().equals("1")){ //임시저장
				
				//if(vo.getSeq()==0){ 
					vo.setNextSign(1); //결제 처음 신청시 다음에 결제해야 할 사람 번호 사용안함
					vo.setSignState("1");
					check = signBoardService.BoardInsert(vo);
					
				//}
			}
			
		}else{ //반려 및 결재
			
		     if(vo.getSignState().equals("2")){
				//결재 SignBoardVO vo
		    	 
		    	 //SIGN_BOARD 업데이트
		    	 SignBoardVO vo1 = vo;
		    	 vo1.setEmpNum(sessionNum);
		    	 int lastsign = signBoardService.lastSignCount(Integer.parseInt(sessionNum));
		    	 if(lastsign == 1){
		    		 vo1.setSignState("4");
		    	 }else{
		    		 vo1.setSignState("2");
		    	 }
		    	 signBoardService.BoardUpdate(vo1);
		    	 
		    	 //SIGN 업데이트 
		    	 Map<String, String> signmap = new HashMap<String, String>();
		    	 
		    	 signmap.put("signState", "Y");
		    	 signmap.put("empNum", sessionNum );
		    	 signmap.put("boardNum", String.valueOf( vo.getSeq() ));
		    	 signBoardService.signUpdate(signmap);
		    	 
		    	 //SIGN 다음 결제자 지정
		    	 Map<String, String> nsignmap = new HashMap<String, String>();
		    	 nsignmap.put("empNum", sessionNum );
		    	 nsignmap.put("boardNum", String.valueOf( vo.getSeq() ));
		    	 signBoardService.nextSignUpdate(signmap);
		    	 
		    	 
			}else if(vo.getSignState().equals("3")){
				
				//반려
				
				//SIGN_BOARD 업데이트
		    	 SignBoardVO vo1 = vo;
		    	 vo1.setEmpNum(sessionNum);
		    	 vo1.setSignState("3");
		    	 signBoardService.BoardUpdate(vo1);
		    	 
		    	 //SIGN 업데이트 
		    	 Map<String, String> signmap = new HashMap<String, String>();
		    	 
		    	 signmap.put("signState", "N");
		    	 signmap.put("empNum", sessionNum );
		    	 signmap.put("boardNum", String.valueOf( vo.getSeq() ));
		    	 signBoardService.signUpdate(signmap);
			}
			
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
