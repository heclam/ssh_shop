package com.luo.shop.order.adminaction;

import java.util.List;

import com.luo.shop.order.service.OrderService;
import com.luo.shop.order.vo.Order;
import com.luo.shop.order.vo.OrderItem;
import com.luo.shop.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminOrderAction extends ActionSupport implements ModelDriven<Order>{
	//模型驱动
	private Order order = new Order();
	//注入OrderService
	private OrderService orderService;
	//接受currentPage
	private Integer currentPage;
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	@Override
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}
	
	//分页显示所有订单
	public String findAll(){
		PageBean<Order> pageBean=orderService.findByPage(currentPage);
		//将返回的pageBean存入值栈中
		ActionContext.getContext().getValueStack().set("pageBean",pageBean);
		return "findAllSuccess";
	}
	
	//后台根据oid查询订单
	public String findOrderItem(){
		List<OrderItem> list = orderService.findOrderItem(order.getOid());
		//将查询出来的订单项存入值栈中
		ActionContext.getContext().getValueStack().set("list",list);
		//页面跳转
		return "findOrderItemSuccess";
	}
	
	//修改订单状态
	public String updateState(){
		//先根据oid查询订单
		order = orderService.findByOid(order.getOid());
		//更改订单状态
		order.setState(3);
		//完成修改
		orderService.update(order);
		return "updateSuccess";
	}
}
