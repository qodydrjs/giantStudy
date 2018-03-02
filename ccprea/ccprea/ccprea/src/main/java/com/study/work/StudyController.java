package com.study.work;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.domain.BoardListVO;
import com.study.service.BoardService;

@Controller
public class StudyController {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(StudyController.class);
	
	
	//@Inject
	@Resource(name="BoardServiceImpl")
	private BoardService service;
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET )
	public String read( Model model) throws Exception{
		
		
		List<BoardListVO> list = new ArrayList<BoardListVO>();
		list = service.listAll();
		
	 model.addAttribute("list", list);
		
		
		return "board/listAllView";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(int no, Model model) throws Exception {
		
		
		logger.info("파라메터값" + no);
		
		BoardListVO list = service.list(no);
		
		model.addAttribute("list", list);
		
		return "board/listView";
	}
	
	@RequestMapping(value="/listCreate" , method=RequestMethod.GET)
	public String listCreate(Model model) {

		return "/board/listCreateView";
	}
	
	@RequestMapping(value="/listCreate" , method=RequestMethod.POST)
	public String listCreatePost(@ModelAttribute BoardListVO vo, RedirectAttributes rttr) throws Exception {


		int chekc = service.listCtrate(vo);
		
		if(chekc ==1){
			rttr.addFlashAttribute("msg", "SUCCESS");
			
			return "redirect:/listAll";
		}else{
			
			rttr.addFlashAttribute("msg", "FAILED");
			
			return "redirect:/listCreate";
		}
	}
	
	@RequestMapping(value="/listDelete", method=RequestMethod.POST)
	public String listDelete(int no, RedirectAttributes rttr)throws Exception {
		
		int chekc = service.listDelete(no);
		
		if(chekc ==1){
			rttr.addFlashAttribute("msg", "SUCCESS");
			
			return "redirect:/listAll";
		}else{
			
			rttr.addFlashAttribute("msg", "FAILED");
			
			return "redirect:/listAll";
		}
		
		
	}
	
	
	@RequestMapping(value="/listUpdate", method=RequestMethod.GET)
	public String listUpdateGet(@ModelAttribute BoardListVO vo, Model model) throws Exception {
		
		
		return "/board/listUpdateView";
	}
	
	@RequestMapping(value="listUpdate", method=RequestMethod.POST)
	public String listUpdatePost(@ModelAttribute BoardListVO vo, Model model) throws Exception{
		
		
		return "redirect:/listAll";
	}
	
	
	
	
	
	
	
	
}
