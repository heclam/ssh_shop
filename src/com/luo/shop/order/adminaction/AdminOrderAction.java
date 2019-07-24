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
	//ģ������
	private Order order = new Order();
	//ע��OrderService
	private OrderService orderService;
	//����currentPage
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
	
	//��ҳ��ʾ���ж���
	public String findAll(){
		PageBean<Order> pageBean=orderService.findByPage(currentPage);
		//�����ص�pageBean����ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean",pageBean);
		return "findAllSuccess";
	}
	
	//��̨����oid��ѯ����
	public String findOrderItem(){
		List<OrderItem> list = orderService.findOrderItem(order.getOid());
		//����ѯ�����Ķ��������ֵջ��
		ActionContext.getContext().getValueStack().set("list",list);
		//ҳ����ת
		return "findOrderItemSuccess";
	}
	
	//�޸Ķ���״̬
	public String updateState(){
		//�ȸ���oid��ѯ����
		order = orderService.findByOid(order.getOid());
		//���Ķ���״̬
		order.setState(3);
		//����޸�
		orderService.update(order);
		return "updateSuccess";
	}
}
