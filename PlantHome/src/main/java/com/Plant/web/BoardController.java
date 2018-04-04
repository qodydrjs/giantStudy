package com.Plant.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Plant.service.ShoppingListService;
import com.Plant.vo.ShoppingBasketListVO;
import com.Plant.vo.ShoppingBasketVO;
import com.Plant.vo.ShoppingListVO;

@Controller
@RequestMapping("/boards")
public class BoardController {

	@Resource(name="ShoppingListService")
	private ShoppingListService shoppingService;
	
	
	@RequestMapping("/boardList")
	public String boardList(HttpSession session
							,Model model){
		
		List<ShoppingListVO> list= shoppingService.shoppingListAll();
	
		model.addAttribute("list", list);
		
		return "/board/boardListView";
	}
	
	@RequestMapping("/insertMyShoppingBasket")
	public String insertMyShoppingBasket(@RequestParam(value="seq") List<String> basketList
										,HttpSession session){

		int emp_num = Integer.parseInt(session.getAttribute("id").toString());
		//String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		int index = 1;
		
		for(String v : basketList){
			
			ShoppingBasketVO vo1 = new ShoppingBasketVO();
					
			vo1.setEmpNum(emp_num);
			vo1.setSeq(timeStamp);
			vo1.setQuantity(1);
			
			vo1.setGoodsSeq(Integer.parseInt(v));
			map.put("list"+index++, vo1);
			
		}
		
		for(int i=1; i <= map.size(); i++){
			
			Map<String,Object> trmap = new HashMap<String, Object>();
			
			trmap.put("list", map.get("list"+i));
			
			shoppingService.insert_myshoppingBasket(trmap);
			
		}

		
		
		return "/board/SUCCESS";
	}
	
	
	@RequestMapping(value="myshoppingBasketList")
	public String myshoppingBasketList(HttpSession session
									  ,Model model){
		
		int empNum = Integer.parseInt(session.getValue("id").toString());
		
		List<ShoppingBasketListVO> list = shoppingService.shoppingBasketList(empNum);
		
		model.addAttribute("list", list);
		
		return "/board/myshoppingBasketListView";
	}
	
}
