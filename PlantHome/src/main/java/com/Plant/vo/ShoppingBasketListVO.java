package com.Plant.vo;

public class ShoppingBasketListVO {
	private int seq;
	private String goodsName;
	private String goodsInfo;
	private int goodsPrice;
	private String goodsSeller;
	private String goodsImageUrl;
	private String orderNum;
	private int empNum;
	private int goodsSeq;
	private int quantity;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsSeller() {
		return goodsSeller;
	}
	public void setGoodsSeller(String goodsSeller) {
		this.goodsSeller = goodsSeller;
	}
	public String getGoodsImageUrl() {
		return goodsImageUrl;
	}
	public void setGoodsImageUrl(String goodsImageUrl) {
		this.goodsImageUrl = goodsImageUrl;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public int getEmpNum() {
		return empNum;
	}
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}
	public int getGoodsSeq() {
		return goodsSeq;
	}
	public void setGoodsSeq(int goodsSeq) {
		this.goodsSeq = goodsSeq;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ShoppingBasketListVO [seq=" + seq + ", goodsName=" + goodsName + ", goodsInfo=" + goodsInfo
				+ ", goodsPrice=" + goodsPrice + ", goodsSeller=" + goodsSeller + ", goodsImageUrl=" + goodsImageUrl
				+ ", orderNum=" + orderNum + ", empNum=" + empNum + ", goodsSeq=" + goodsSeq + ", quantity=" + quantity
				+ "]";
	}
	
	
	
}
