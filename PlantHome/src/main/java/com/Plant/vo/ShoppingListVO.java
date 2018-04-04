package com.Plant.vo;

public class ShoppingListVO {

	private int seq;
	private String goodsName;
	private String goodsInfo;
	private int goodsQuantity;
	private int goodsPrice;
	private String goodsSeller;
	private String goodsImageUrl;
	
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
	public int getGoodsQuantity() {
		return goodsQuantity;
	}
	public void setGoodsQuantity(int goodsQuantity) {
		this.goodsQuantity = goodsQuantity;
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
	@Override
	public String toString() {
		return "ShoppingListVO [seq=" + seq + ", goodsName=" + goodsName + ", goodsInfo=" + goodsInfo
				+ ", goodsQuantity=" + goodsQuantity + ", goodsPrice=" + goodsPrice + ", goodsSeller=" + goodsSeller
				+ "]";
	}
	public String getGoodsImageUrl() {
		return goodsImageUrl;
	}
	public void setGoodsImageUrl(String goodsImageUrl) {
		this.goodsImageUrl = goodsImageUrl;
	}
	
	
	
}
