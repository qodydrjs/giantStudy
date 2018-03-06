package com.test.work;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.vo.ProductVO;

@Controller
public class SampleController3 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);
	
	@RequestMapping(value="doD")
	public String doD(Model model) throws Exception{
		
		ProductVO product = new ProductVO("¹è¿ë°Ç", 3.14);
		
		logger.info(product.getName());
		
		model.addAttribute(product);
		
		
		return "ProductDetail";
		
	}
	
}
