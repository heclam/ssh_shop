package com.luo.shop.cart.vo;


import com.luo.shop.product.vo.Product;

public class CartItem {
	private Product product;//����������Ʒ��Ϣ
	private int count;   	//����ĳ����Ʒ������
	private double subtotal; //����ĳ����Ʒ��С��
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
	//С���Զ�����
	public double getSubtotal() {
		return product.getShop_price()*count;
	}
	
	
}
