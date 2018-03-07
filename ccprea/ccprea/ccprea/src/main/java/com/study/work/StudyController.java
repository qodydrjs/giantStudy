package com.study.work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggingEvent;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.domain.BoardListVO;
import com.study.domain.Criteria;
import com.study.domain.PageMaker;
import com.study.service.BoardService;

@Controller
public class StudyController {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(StudyController.class);
	
	
	//@Inject
	@Resource(name="BoardServiceImpl")
	private BoardService service;
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET )
	public String read(@ModelAttribute("cri")Criteria cri, 
			Model model,
			HttpServletRequest request) throws Exception{

		List<BoardListVO> list = new ArrayList<BoardListVO>();
		
		
		if(request.getParameter("combobox")!=null){
			
			HashMap<String, String> map = new HashMap<String, String>();
			
			String combobox = request.getParameter("combobox");
			String serch_text = request.getParameter("serch_text");
			String sdate = request.getParameter("sdate");
			String edate = request.getParameter("edate");
			
			map.put("combobox", combobox);
			map.put("serch_text", serch_text);
			map.put("sdate", sdate);
			map.put("edate", edate);
		
			
			list = service.listSearch(map);
			
			model.addAttribute("combobox", combobox);
			model.addAttribute("serch_text", serch_text);
			model.addAttribute("sdate", sdate);
			model.addAttribute("edate", edate);
			
		}else{
			
			
			list = service.listAll();
		}
		//
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listTotalCount());
		model.addAttribute("list", list) ;
		model.addAttribute("pageMaker", pageMaker);
		
		return "board/listAllView";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(@ModelAttribute("cri") Criteria cri
			,int no, Model model) throws Exception {
		
		BoardListVO list = service.list(no);
		
		model.addAttribute("list", list);
		
		return "board/listView";
	}
	
	@RequestMapping(value="/listCreate" , method=RequestMethod.GET)
	public String listCreate(@ModelAttribute("cri")Criteria cri, Model model) {

		return "/board/listView";
	}
	
	@RequestMapping(value="/listCreate" , method=RequestMethod.POST)
	public String listCreatePost(@ModelAttribute BoardListVO vo, RedirectAttributes rttr) throws Exception {


		int chekc = service.listCtrate(vo);
		
		if(chekc ==1){
			rttr.addFlashAttribute("msg", "SUCCESS");
			
			return "redirect:/listAll";
		}else{
			
			rttr.addFlashAttribute("msg", "FAILED");
			
			return "redirect:/listView";
		}
	}
	
	@RequestMapping(value="/listDelete", method=RequestMethod.POST)
	public String listDelete(@RequestParam(value="no", defaultValue="0")int no,
			RedirectAttributes rttr,
			@RequestParam(value="chk", defaultValue="0") List<String> chk )throws Exception {

		
		//일반 삭제
		if(no !=0){
			
			int chekc = service.listDelete(no);
			
			if(chekc ==1){
				rttr.addFlashAttribute("msg", "SUCCESS");
				
				return "redirect:/listAll";
			}else{
			
				rttr.addFlashAttribute("msg", "FAILED");
				
				return "redirect:/listAll";
		}
	
			
		}else{
			
			for(int i = 0 ; i< chk.size(); i++){
				
				service.listDelete(Integer.parseInt(chk.get(i).toString()));
			}
			rttr.addFlashAttribute("msg", "SUCCESS");
			
			return "redirect:/listAll";
		}

		
		
	}
	

	
	@RequestMapping(value="listUpdate",method=RequestMethod.POST)
	public String listUpdatePost(int no,@ModelAttribute BoardListVO vo, RedirectAttributes rttr) throws Exception{
	
		vo.setSeq(no);
		
		int check = service.listModify(vo);
		
		if(check==1) {
			rttr.addFlashAttribute("msg", "SUCCESS");
			
			
		}else {
			rttr.addFlashAttribute("msg", "FAILED");
		}
		
		
		return "redirect:/listAll";
	}
	
	
	
	
	
	
	
	
	
}
