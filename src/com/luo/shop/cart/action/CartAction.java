package com.luo.shop.cart.action;

import org.apache.struts2.ServletActionContext;

import com.luo.shop.cart.vo.Cart;
import com.luo.shop.cart.vo.CartItem;
import com.luo.shop.product.service.ProductService;
import com.luo.shop.product.vo.Product;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport {
	private Integer pid;
	private Integer count;
	//ע��ProductService
	private ProductService productService;
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//����������ӵ����ﳵ��ִ�еķ���
	public String addCart(){
		//�½�һ��������
		CartItem cartItem = new CartItem();
		//���ù����������
		cartItem.setCount(count);
		//����pid������Ʒ
		Product product = productService.findByPid(pid);
		cartItem.setProduct(product);
		//����������ӵ����ﳵ��
			//���ﳵӦ��session�л�ȡ������ÿһ�ζ��½�
		Cart cart = getCart();
		//����cart�������ӷ���
		cart.addCart(cartItem);
		return "addCart";
	
	}
	//������ﳵ
	public String clearCart(){
		//��ȡ���ﳵ
		Cart cart = getCart();
		//���
		cart.clearCart();
		return "clearCart";
	}
	//�Ƴ�������
	public String removeCart(){
		//��ȡ���ﳵ
		Cart cart = getCart();
		//���ù��ﳵ�еķ������й�������Ƴ�
		cart.removeCart(pid);
		return "removeCart";
	}
	public String myCart(){
		return "myCart";
	}
	/**
	 * 
	 * ��ȡ��ǰ�Ĺ��ﳵ�����û�й��ﳵ����һ���µĹ��ﳵ��
	 * @return
	 */
	private Cart getCart() {
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart == null){
			cart = new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		return cart;
	}
}
