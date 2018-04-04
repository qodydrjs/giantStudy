package com.Plant.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.Plant.vo.ShoppingBasketListVO;
import com.Plant.vo.ShoppingListVO;

@Repository("ShoppingListDAO")
public class ShoppingListDAOImpl implements ShoppingListDAO{

	@Inject
	private SqlSession session;
	
	private static final String NAMESPACE = "shoppingMapper";
	
	@Override
	public List<ShoppingListVO> shoppingListAll() {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".shoppingListAll");
	}

	@Override
	public List<ShoppingBasketListVO> shoppingBasketList(int empNum) {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".myshoppingBasketList", empNum);
	}

	@Override
	public int insert_myshoppingBasket(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return session.insert(NAMESPACE+".insert_myshoppingBasket", map);
	}
	
	

}
