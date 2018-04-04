package com.Plant.service;

import java.util.List;
import java.util.Map;

import com.Plant.vo.ShoppingBasketListVO;
import com.Plant.vo.ShoppingListVO;

public interface ShoppingListService {
	public List<ShoppingListVO> shoppingListAll();
	public List<ShoppingBasketListVO> shoppingBasketList(int empNum);
	public int insert_myshoppingBasket(Map<String, Object> map);
}
