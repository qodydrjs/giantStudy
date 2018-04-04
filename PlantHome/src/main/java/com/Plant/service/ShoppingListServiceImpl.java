package com.Plant.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.Plant.dao.ShoppingListDAO;
import com.Plant.vo.ShoppingBasketListVO;
import com.Plant.vo.ShoppingListVO;

@Service(value="ShoppingListService")
public class ShoppingListServiceImpl implements ShoppingListService {

	@Resource(name="ShoppingListDAO")
	private ShoppingListDAO dao;
	
	@Override
	public List<ShoppingListVO> shoppingListAll() {
		// TODO Auto-generated method stub
		return dao.shoppingListAll();
	}

	@Override
	public List<ShoppingBasketListVO> shoppingBasketList(int empNum) {
		// TODO Auto-generated method stub
		return dao.shoppingBasketList(empNum);
	}

	@Override
	public int insert_myshoppingBasket(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.insert_myshoppingBasket(map);
	}

	
	
}
