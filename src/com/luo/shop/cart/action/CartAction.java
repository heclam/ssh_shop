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
	//注入ProductService
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
	//将购物项添加到购物车：执行的方法
	public String addCart(){
		//新建一个购物项
		CartItem cartItem = new CartItem();
		//设置购物项的数量
		cartItem.setCount(count);
		//根据pid查找商品
		Product product = productService.findByPid(pid);
		cartItem.setProduct(product);
		//将购物项添加到购物车中
			//购物车应从session中获取而不是每一次都新建
		Cart cart = getCart();
		//调用cart里面的添加方法
		cart.addCart(cartItem);
		return "addCart";
	
	}
	//清除购物车
	public String clearCart(){
		//获取购物车
		Cart cart = getCart();
		//清除
		cart.clearCart();
		return "clearCart";
	}
	//移除购物项
	public String removeCart(){
		//获取购物车
		Cart cart = getCart();
		//调用购物车中的方法进行购物项的移除
		cart.removeCart(pid);
		return "removeCart";
	}
	public String myCart(){
		return "myCart";
	}
	/**
	 * 
	 * 获取当前的购物车（如何没有购物车创建一个新的购物车）
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
