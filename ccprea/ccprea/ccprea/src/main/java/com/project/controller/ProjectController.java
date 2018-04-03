package com.project.controller;

import javax.activation.CommandMap;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.runners.Parameterized.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.service.FileService;
import com.project.service.SignBoardService;
import com.project.service.loginService;
import com.project.vo.EmployeeVO;
import com.project.vo.FileVO;
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
	
	@Resource(name="FileService")
	private FileService fileService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	public static String getUuid() { 
		return UUID.randomUUID().toString().replaceAll("-", ""); 
	}

	
	@RequestMapping(value="download")
	public String download(@RequestParam(value="path") String path
						  ,@RequestParam(value="fileName") String fileName
						  ,ModelMap model){
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("path", path);
		map.put("fileName", fileName);
		
		model.addAllAttributes(map);
		return "Download";
	}
	
	
	@RequestMapping(value="login" , method=RequestMethod.GET)
	public String loginGet(Model model){
		
		return "project/login/login";
	}
	
	@RequestMapping(value = "uploadList")
	public String uploadList(Model model){
		
		
	 List<FileVO> list =fileService.fileList();
	
	 model.addAttribute("list", list);
		
		return "project/board/uploadList";
		
	}
	
	@RequestMapping(value="uploadOk")
	public String uploadOk( HttpServletRequest req, HttpServletResponse rep) throws IllegalStateException, IOException{
		
		//파일이 저장될 path 설정 
		String path = "C:/D/giantStudy/ccprea/ccprea/ccprea/src/main/webapp/resources/image/"; 
		Map returnObject = new HashMap();
		
		try { 
			// MultipartHttpServletRequest 생성 
				MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) req; 
				Iterator iter = mhsr.getFileNames(); 
				MultipartFile mfile = null; 
				String fieldName = ""; 
				List resultList = new ArrayList(); 
			// 디레토리가 없다면 생성 
				File dir = new File(path); 
				if(!dir.isDirectory()){ 
					dir.mkdirs(); 
				}
			// 값이 나올때까지 
			while (iter.hasNext()){ 
				fieldName = iter.next().toString(); 
				// 내용을 가져와서 
				mfile = mhsr.getFile(fieldName); 
				String origName; 
				//origName = new String(mfile.getOriginalFilename().getBytes("8859_1"), "utf-8"); 
				origName = mfile.getOriginalFilename().toString();
				//한글꺠짐 방지 
				// 파일명이 없다면 
				if ("".equals(origName)){ 
						continue;
					} 
				// 파일 명 변경(uuid로 암호화) 
				String ext = origName.substring(origName.lastIndexOf('.')); 
				// 확장자 
				String saveFileName = getUuid() + ext; 
				// 설정한 path에 파일저장 
				File serverFile = new File(path + File.separator + saveFileName); 
				mfile.transferTo(serverFile); 
				Map file = new HashMap(); 
				String sfile = "/resources/image/" + saveFileName;
				file.put("origName", origName); 
				file.put("sfile", sfile); 
				file.put("localfile", serverFile.getPath()); 
				resultList.add(file); 
			} 
//			returnObject.put("files", resultList); 
//			returnObject.put("params", mhsr.getParameterMap()); 
			
			//System.out.println(resultList.iterator().next().toString());

			for(int i=0; i < resultList.size(); i++){
				Map maplist = (HashMap)resultList.get(i);
				
				FileVO vo = new FileVO();
				vo.setOrigName(maplist.get("origName").toString());
				vo.setSfile(maplist.get("sfile").toString());
				vo.setLocalfile(maplist.get("localfile").toString());
				vo.setBoardNum(1);
				fileService.fileInsert(vo);
			}

		} 
		catch (UnsupportedEncodingException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
			}
		catch (IllegalStateException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
			} 
		catch (IOException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
			} 

		return "redirect:upload";
		
	}
	
	
	@RequestMapping(value="upload")
	public String upload(){
		
		
		return "project/board/fileUpload";
		
	}
	
	
	@RequestMapping(value="exceldown")
	public String exceldown(){
		
		
		
		return "project/board/excel";
	}
	
	@RequestMapping(value="micrud")
	public void micrud(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//////////////Map
		Map<String, Object> map;
		
		///////////miplatform Input Data`s
		VariableList in_v1 = new VariableList();
		DatasetList in_dl1 = new DatasetList();
		
		VariableList out_v1 = new VariableList();
		///////////XML Passing
		PlatformRequest pReq = new PlatformRequest(request,"utf-8");
		
		pReq.receiveData();
		in_v1 = pReq.getVariableList();
		in_dl1 = pReq.getDatasetList();
		Dataset ds = in_dl1.getDataset("ds_emp");
		
		
		for(int i =0; i < ds.getRowCount() ; i++){
			
			
			String row_state = ds.getRowStatus(i);
			
			if(row_state == "insert"){
				
				map = new HashMap<String, Object>();
				map.put("EMP_NUM", ds.getColumn(i,"EMP_NUM").toString());
				map.put("EMP_NAME", ds.getColumn(i,"EMP_NAME").toString());
				map.put("BIRTH_DAY", ds.getColumn(i,"BIRTH_DAY").getDate());
				map.put("ADDRESS", ds.getColumn(i,"ADDRESS").toString());
				map.put("ENTRY_DAY", ds.getColumn(i,"ENTRY_DAY").toString());
				map.put("LEAVE_DAY", ds.getColumn(i,"LEAVE_DAY").toString());
				map.put("PASSWORD", ds.getColumn(i,"PASSWORD").toString());
				map.put("RANK_SEQ", ds.getColumn(i,"RANK_SEQ").toString());
				map.put("DEPARTMENT_NUM", ds.getColumn(i,"DEPARTMENT_NUM").toString());
				signBoardService.emp_insert(map);
				map = null;
			}else if(row_state =="update"){
				
				map = new HashMap<String, Object>();
				map.put("EMP_NUM", ds.getColumn(i,"EMP_NUM").toString());
				map.put("EMP_NAME", ds.getColumn(i,"EMP_NAME").toString());
				map.put("BIRTH_DAY", ds.getColumn(i,"BIRTH_DAY").getDate());
				map.put("ADDRESS", ds.getColumn(i,"ADDRESS").toString());
				map.put("ENTRY_DAY", ds.getColumn(i,"ENTRY_DAY").toString());
				map.put("LEAVE_DAY", ds.getColumn(i,"LEAVE_DAY").toString());
				map.put("PASSWORD", ds.getColumn(i,"PASSWORD").toString());
				map.put("RANK_SEQ", ds.getColumn(i,"RANK_SEQ").toString());
				map.put("DEPARTMENT_NUM", ds.getColumn(i,"DEPARTMENT_NUM").toString());
				signBoardService.emp_update(map);
				map = null;
				
			}
		}
		
		
		for(int y = 0;  y < ds.getDeleteRowCount() ; y++){
			
			map = new HashMap<String, Object>();
			map.put("EMP_NUM", ds.getDeleteColumn(y, "EMP_NUM").toString());
			signBoardService.emp_delete(map);
			map = null;
			
		}
		
		
		out_v1.addStr("ErrorCode", "0");
		out_v1.addStr("ErrorMsg","SUCC");
		
//		PlatformResponse pRes = new PlatformResponse(response, PlatformRequest.XML, "euc-kr");
//		pRes.sendData(out_v1);
		
	}
	
	
	@RequestMapping(value="miview")
	public void mi(HttpServletResponse response, HttpServletRequest request ) throws Exception{
		
		
		VariableList v1 = new VariableList();
		DatasetList d1 = new DatasetList();
		
		VariableList in_vl= new VariableList();
		
		PlatformRequest pReq = new PlatformRequest(request,"utf-8");
		pReq.receiveData();
		in_vl = pReq.getVariableList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(in_vl.size() > 0){
		map.put("str_search", in_vl.get("str_search").getValue().toString());
		map.put("str_content", in_vl.get("str_content").getValue().toString());
		}
		
		try{
			
		Dataset ds = new Dataset("emp");
		ds.addColumn("EMP_NUM", ColumnInfo.CY_COLINFO_INT, 20);
		ds.addColumn("EMP_NAME", ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("BIRTH_DAY", ColumnInfo.CY_COLINFO_DATE, 20);
		ds.addColumn("ADDRESS", ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("ENTRY_DAY", ColumnInfo.CY_COLINFO_DATE, 20);
		ds.addColumn("LEAVE_DAY", ColumnInfo.CY_COLINFO_DATE, 20);
		ds.addColumn("PASSWORD", ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("RANK_SEQ", ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("DEPARTMENT_NUM", ColumnInfo.CY_COLINFO_INT, 20);
		
		
		List<EmployeeVO> list = signBoardService.emplist(map);
		
		
		
		for(int i = 0 ;  i <= list.size()-1 ; i++ ){
			int row = ds.appendRow();
			ds.setColumn(row, "EMP_NUM", list.get(i).getEmpNum());
			ds.setColumn(row, "EMP_NAME", list.get(i).getEmpName());
			ds.setColumn(row, "BIRTH_DAY", list.get(i).getBirthDay());
			ds.setColumn(row, "ADDRESS", list.get(i).getAddress());
			ds.setColumn(row, "ENTRY_DAY", list.get(i).getEntryDay());
			ds.setColumn(row, "LEAVE_DAY", list.get(i).getLeaveDay());
			ds.setColumn(row, "PASSWORD", list.get(i).getPassword());
			ds.setColumn(row, "RANK_SEQ", list.get(i).getRankSeq());
			ds.setColumn(row, "DEPARTMENT_NUM", 1);
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
		List<EmployeeVO> emplist = signBoardService.emplist(null);
		
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
