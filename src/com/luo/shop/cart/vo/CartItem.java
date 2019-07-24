package com.luo.shop.cart.vo;


import com.luo.shop.product.vo.Product;

public class CartItem {
	private Product product;//购买项中商品信息
	private int count;   	//购买某种商品的数量
	private double subtotal; //购买某种商品的小计
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	//小计自动计算
	public double getSubtotal() {
		return product.getShop_price()*count;
	}
	
	
}
