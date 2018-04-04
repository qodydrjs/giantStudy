package com.Plant.vo;

public class ShoppingBasketVO {

	private String seq;
	private int empNum;
	private int goodsSeq;
	private int quantity;
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
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
		return "ShoppingBasketVO [seq=" + seq + ", empNum=" + empNum + ", goodsSeq=" + goodsSeq + ", quantity="
				+ quantity + "]";
	}
	
}
